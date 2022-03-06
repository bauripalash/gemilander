package `in`.palashbauri.gemilander

import org.junit.Test

import org.junit.Assert.*
import `in`.palashbauri.gemilander.GeminiNetwork

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
       /* val y : String = """
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
        
            
        """
        val x = GemParser(y)
        val output = x.getOutput()
        output.forEach{
            println("=>> $it")
        }*/
        val x = GeminiNetwork()
        x.send()

        assertEquals(4, 2 + 2)
    }
}