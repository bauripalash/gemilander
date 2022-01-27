package `in`.palashbauri.gemilander

open class GemParser (text : String) {

    var source : List<String> = text.lines()
    var current_line : Int = 0
    var output_list : MutableList<String> = mutableListOf()

    fun parser(){
        var in_preftext : Boolean = false
        var pref_text_alt : String = ""
        var pref_text : MutableList<String> = mutableListOf()
        source.forEach{
            if (!in_preftext) {
                var _line: String = it.trim()
                if (_line.startsWith("# ")) {
                    var s = _line.removePrefix("# ")

                    println("<h1>$s</h1>")
                } else if (_line.startsWith("## ")) {
                    var s = _line.removePrefix("## ")
                    println("<h2>$s</h2>")
                } else if (_line.startsWith("### ")) {
                    var s = _line.removePrefix("### ")
                    println("<h3>$s</h3>")
                } else if (_line.startsWith("* ")) {
                    var s = _line.removePrefix("* ")
                    println("<li>$s</li>")
                } else if (_line.startsWith("> ")){

                    var s = _line.removePrefix("> ")
                    println("<blockquote>$s</blockquote>")

                } else if (_line.startsWith("=> ")){
                    var items = _line.removePrefix("=> ").split(" ")

                    var link = ""
                    var text : String? = ""

                    if (items.size > 0){
                        link = items[0]
                    }
                    if (items.size > 1){

                        text = items.drop(1).joinToString(" ")

                    }

//                    if (!text.isNullOrBlank()) {
//                        println("has text")
//                    }

                    println("link=> $link | text => $text")
                }

                else if (_line.startsWith("```")){
                    in_preftext = true
                    var s = _line.removePrefix("```")
                    if (s.length > 0 && s != "\n"){
                        pref_text_alt = s
                    }

                }else{
                    if (_line == "\n"){
                        println("<br/>")
                    }else{
                        println("$_line")
                    }
                }
            }else{
                var _temp = it.trimStart()
                if (_temp.startsWith("```")){
                    println("PREFTEXT | alt => $pref_text_alt | text => ${pref_text.joinToString(" ")}")
                    in_preftext = false
                    pref_text_alt = ""
                    pref_text = mutableListOf()
                } else {
                    pref_text.add(it)
                    pref_text.add("\n")

                }

            }


        }
    }

}