package com.example.cellphonebook

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cellphonebook.DataService.list
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

       btn_send.setOnClickListener{
            when{
                ed_name.length()<1 -> Toast.makeText(this,"請輸入姓名",Toast.LENGTH_LONG).show()

                ed_phone.length()<1 ->Toast.makeText(this,"請輸入電話",Toast.LENGTH_LONG).show()

                else->{

                    val b =Bundle()

                    b.putString("name",ed_name.text.toString())
                    b.putString("phone",ed_phone.text.toString())


                    setResult(Activity.RESULT_OK,Intent().putExtras(b))

                    finish()


                }
            }
       }
    }
}
