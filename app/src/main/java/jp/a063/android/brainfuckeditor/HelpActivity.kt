package jp.a063.android.brainfuckeditor

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import kotlinx.android.synthetic.main.activity_help.*

class HelpActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)

        ButtonHelp.setOnClickListener {
            //finish()
        }
        ButtonHome.setOnClickListener {
            finish()
            /*
            intent= Intent()
            intent.setClassName("jp.a063.android.brainfuckeditor","jp.a063.android.brainfuckeditor.HomeActivity")
            startActivity(intent)
            */
        }
    }

}
