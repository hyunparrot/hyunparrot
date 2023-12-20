package com.example.coursework

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.service.voice.VoiceInteractionSession.ActivityId
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class HomeActivity : AppCompatActivity() {
    private lateinit var myId: TextView
    private lateinit var myMbti: TextView
    private lateinit var myName: TextView
    private lateinit var myOld: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        myId = findViewById(R.id.myId)
        myMbti = findViewById(R.id.myMbti)
        myName = findViewById(R.id.myName)
        myOld = findViewById(R.id.myOld)

        val username = intent.getStringExtra("username")
        // Intent에서 extra 데이터 가져오기
        val myId: TextView = findViewById(R.id.myId)
        // 가져온 데이터를 화면에 표시
        myId.text = username

            val btnoff: Button = findViewById(R.id.btnOff)
            btnoff.setOnClickListener {
                //클릭이 됐을때
                val intent = Intent(this@HomeActivity, SignInActivity::class.java)
                startActivity(intent)

            }
        }
    }

















