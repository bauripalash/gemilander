package `in`.palashbauri.gemilander

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.view.View
import android.widget.ImageButton
import android.widget.EditText
import android.webkit.WebViewClient
import android.webkit.WebView
import android.widget.Toast
import gemilander.R


class MainActivity : AppCompatActivity() {
    lateinit var home_button : ImageButton
    lateinit var menu_button : ImageButton
    lateinit var search_box : EditText
    lateinit var output_box : WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        home_button = findViewById(R.id.home_button)
        menu_button = findViewById(R.id.menu_button)
        search_box = findViewById(R.id.search_box)
        output_box = findViewById(R.id.output_box)
        output_box.webViewClient = WebViewClient()

        home_button.setOnClickListener{ sayhello() }
    }

    @SuppressLint("SetTextI18n")
    private fun sayhello() {
        var inp : String = """
            # header 1
            ## header 2
            ### header 3
            * list
            * another list
            * another another list
            => https://google.com first link
            => https://helloworld.com
            => https://hello.com palash
            ```java
            int hello 
            papp
            ```
            
            ```
            hello
            ```
            
        
        this is a plain text
            this is also a plaintext
        
            
        """.trimIndent()
        val x : GemParser = GemParser(inp)
        val output = x.getOutput()
        output_box.loadData(output.joinToString("<br/>") , "text/html" , "utf-8")
        //output_box.loadData("<strong>$n</strong>" , "text/html" , "utf-8")
        //url_box.setText("Hello World")
        //output_box.loadData()
        Toast.makeText(this@MainActivity , "Should Print" , Toast.LENGTH_SHORT).show()
        //output_box.loadUrl("https://google.com")

    }
}