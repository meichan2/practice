import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView;

class MainActivity : AppCompatActivity() {
    lateinit var mAdView : AdView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cc1=findViewById<EditText>(R.id.red)
        val cc2=findViewById<EditText>(R.id.bl)
        val cc3=findViewById<EditText>(R.id.green)
        val red=cdLisner()
        cc1.setOnClickListener(red)
        cc2.setOnClickListener(red)
        cc3.setOnClickListener(red)
    }
    private inner class cdLisner:View.OnClickListener{
        override fun onClick(v: View?) {
            var test_a=findViewById<TextView>(R.id.red).text.toString()
            var test_b=findViewById<TextView>(R.id.green).text.toString()
            var test_c=findViewById<TextView>(R.id.bl).text.toString()
            val output_R=findViewById<TextView>(R.id.red)
            val output_G=findViewById<TextView>(R.id.green)
            val output_B=findViewById<TextView>(R.id.bl)
            if(test_a==""){
                test_a="0"
                output_R.text="0"
            }
            if(test_b==""){
                test_b="0"
                output_G.text="0"
            }
            if(test_c==""){
                test_c="0"
                output_B.text="0"
            }
            if(test_a.toInt()>255){
                test_a="255"
            }
            if(test_b.toInt()>255){
                test_b="255"
            }
            if(test_c.toInt()>255){
                test_c="255"
            }
            val input_a=test_a.toInt()
            val input_b=test_b.toInt()
            val input_c=test_c.toInt()
            val output_a=findViewById<TextView>(R.id.ccd)
            val output_c=findViewById<TextView>(R.id.sy)
            val output_b=findViewById<LinearLayout>(R.id.bag)
            val a=input_a*65536+input_b*256+input_c
            val c=a.toString(16)
            val d=(input_a+input_b+input_c)/3
            if (input_a<16){
                if(input_a==0){
                    if(input_b<16){
                        if(input_b==0){
                            if(input_c<16){
                                output_a.text="00000"+c
                            }else{
                                output_a.text="0000"+c
                            }
                        }else{
                            output_a.text="000"+c
                        }
                    }else{
                        output_a.text="00"+c
                    }
                }else{
                    output_a.text="0"+c
                }
            }else{
                output_a.text=c
            }
            if(d<130){
                output_a.setTextColor(Color.WHITE)
                output_c.setTextColor(Color.WHITE)
            }else{
                output_a.setTextColor(Color.BLACK)
                output_c.setTextColor(Color.BLACK)
            }
            output_b.setBackgroundColor(a)
        }
    }
}
