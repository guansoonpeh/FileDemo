package com.example.filedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.filedemo.databinding.ActivityMainBinding
import java.io.File
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Click View > Tool Windows >
        //search for project package's name
        // the file will be created under file folder

        val file =  File(applicationContext.filesDir, "myFile.txt")

        binding.btnSave.setOnClickListener(){

            val buff = file.bufferedWriter()
            buff.write("Testing 123")
            buff.write("Testing 456")
            buff.close()
        }

        binding.btnLoad.setOnClickListener(){

            var str:String =""

            val buff = file.bufferedReader()
            buff.forEachLine { lines->
                str += lines.toString()
            }

            binding.textView.text = str
        }
   }
}