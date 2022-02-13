package dmitriy.ten.testtask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var firstTaskBtn = findViewById<Button>(R.id.btn_first_task)
        var secondTaskBtn = findViewById<Button>(R.id.btn_second_task)

        firstTaskBtn.setOnClickListener {
            startActivity(Intent(this, VKActivity::class.java))
        }

        secondTaskBtn.setOnClickListener {
            startActivity(Intent(this, RandomGif::class.java))
        }
    }
}