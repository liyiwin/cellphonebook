package com.example.cellphonebook

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cellphonebook.DataService.list
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private  var myadapter = MyAdapter(list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.apply {

            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter=myadapter

        }


        btn_add.setOnClickListener { startActivityForResult(Intent(this,Main2Activity::class.java),1) }
    }






    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        data?.extras?.let {

            if (requestCode==1 && resultCode== Activity.RESULT_OK ){

               list.add(Contact(it.getString("name"),it.getString("phone")))

                myadapter.notifyDataSetChanged()

            }

        }

    }

}
