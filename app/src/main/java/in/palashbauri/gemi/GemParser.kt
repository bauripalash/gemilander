package `in`.palashbauri.gemi

open class GemParser (text : String) {

    var source : List<String> = text.lines()
    var current_line : Int = 0
    var output_list : MutableList<String> = mutableListOf()

    fun parser(){
        var in_preftext : Boolean = false
        source.forEach{
            if (!in_preftext) {
                var _line: String = it.trim()
                if (_line.startsWith("# ")) {
                    var s = _line.removePrefix("# ")
                    println("<h1>$s</h1>")
                } else if (_line.startsWith("## ")) {
                    var s = _line.removePrefix("## ")
                    println("<h2>$s</h2>")
                } else if (_line.startsWith("### ")){
                    var s = _line.removePrefix("### ")
                    println("<h3>$s</h3>")
                } else if (_line.startsWith("* ")){
                    var s = _line.removePrefix("* ")
                    println("<li>$s</li>")
                } else if (_line.startsWith("=> ")){
                    println("link")
                }
            }


        }
    }

}