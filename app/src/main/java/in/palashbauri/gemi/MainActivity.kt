package `in`.palashbauri.gemi

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.view.View
import android.widget.ImageButton
import android.widget.EditText
import android.webkit.WebViewClient
import android.webkit.WebView
import `in`.palashbauri.gemi.GemParser
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    lateinit var home_button : ImageButton
    lateinit var menu_button : ImageButton
    lateinit var url_box : EditText
    lateinit var output_box : WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        home_button = findViewById(R.id.home_button)
        menu_button = findViewById(R.id.menu_button)
        url_box = findViewById(R.id.url_box)
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
            
        """.trimIndent()
        var x : GemParser = GemParser(inp)
        x.parser()
        //output_box.loadData("<strong>$n</strong>" , "text/html" , "utf-8")
        //url_box.setText("Hello World")
        //output_box.loadData()
        Toast.makeText(this@MainActivity , "Should Print" , Toast.LENGTH_SHORT).show()
        //output_box.loadUrl("https://google.com")

    }
}