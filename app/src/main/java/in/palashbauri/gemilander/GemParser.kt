package `in`.palashbauri.gemilander

open class GemParser(text: String) {

    private var source: List<String> = text.lines()
    private var outputList: MutableList<String> = mutableListOf()

    private fun parser() {
        var isInsidePrefText = false
        var prefTextAlt = ""
        var prefText: MutableList<String> = mutableListOf()
        source.forEach {
            if (!isInsidePrefText) {
                val currentLine: String = it.trim()
                if (currentLine.startsWith("# ")) {
                    val s = currentLine.removePrefix("# ")
                    outputList.add("<h1>$s</h1>")
                    //println("<h1>$s</h1>")
                } else if (currentLine.startsWith("## ")) {
                    val s = currentLine.removePrefix("## ")
                    outputList.add("<h2>$s</h2>")
                    //println("<h2>$s</h2>")
                } else if (currentLine.startsWith("### ")) {
                    val s = currentLine.removePrefix("### ")
                    outputList.add("<h3>$s</h3>")
                } else if (currentLine.startsWith("* ")) {
                    val s = currentLine.removePrefix("* ")
                    outputList.add("<li>$s</li>")
                } else if (currentLine.startsWith("> ")) {

                    val s = currentLine.removePrefix("> ")
                    outputList.add("<blockquote>$s</blockquote>")

                } else if (currentLine.startsWith("=> ")) {
                    val items = currentLine.removePrefix("=> ").split(" ")

                    var link = ""
                    var text: String? = ""

                    if (items.isNotEmpty()) {
                        link = items[0]
                    }
                    if (items.size > 1) {

                        text = items.drop(1).joinToString(" ")

                    }

                    if (text.isNullOrEmpty()) {
                        outputList.add("<a href=\"$link\">$link</a><br/>")
                    } else {
                        outputList.add("<a href=\"$link\">$text</a></br>")
                    }
                } else if (currentLine.startsWith("```")) {
                    isInsidePrefText = true
                    val s = currentLine.removePrefix("```")
                    if (s.isNotEmpty() && s != "\n") {
                        prefTextAlt = s
                    }

                } else {
                    if (currentLine == "\n") {
                        outputList.add("<br/>")
                    } else {
                        outputList.add(currentLine)
                    }
                }
            } else {
                val temp = it.trimStart()
                if (temp.startsWith("```")) {
                    if (prefTextAlt.isNullOrEmpty()) {
                        outputList.add("<pre><code>${prefText.joinToString("")}</code></pre>")
                    } else {
                        outputList.add("<pre class=\"$prefTextAlt\"><code>${prefText.joinToString("")}</code></pre>")
                    }
                    isInsidePrefText = false
                    prefTextAlt = ""
                    prefText = mutableListOf()
                } else {
                    prefText.add(it)
                    prefText.add("\n")

                }

            }


        }
    }

    open fun getOutput(): MutableList<String> {
        this.parser()
        return this.outputList
    }

}