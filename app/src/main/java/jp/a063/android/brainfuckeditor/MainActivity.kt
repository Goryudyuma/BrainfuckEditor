package jp.a063.android.brainfuckeditor

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //CodingArea.setKeyListener(null);
        //CodingArea.setSelection(1)
        CodingArea.setRawInputType(InputType.TYPE_CLASS_TEXT)
        CodingArea.setTextIsSelectable(true)

        ButtonHelp.setOnClickListener {

            intent= Intent()
            intent.setClassName("jp.a063.android.brainfuckeditor","jp.a063.android.brainfuckeditor.HelpActivity")
            startActivity(intent)

        }
        ButtonHome.setOnClickListener {
            /*
            intent= Intent()
            intent.setClassName("jp.a063.android.brainfuckeditor","jp.a063.android.brainfuckeditor.HomeActivity")
            startActivity(intent)
            */
        }
    }
}
