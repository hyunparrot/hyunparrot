package com.example.coursework

import android.os.Bundle
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.text.LoginFilter.UsernameFilterGMail
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import java.sql.RowId
import kotlin.math.sign

class SignUpActivity : AppCompatActivity() {

    private lateinit var signName: EditText
    private lateinit var signPassword: EditText
    private lateinit var signId: EditText
    private lateinit var signShowId: TextView
    private lateinit var signShowPassword: TextView
    private lateinit var signShowName: TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        signId = findViewById(R.id.signId)
        signPassword = findViewById(R.id.signPassword)
        signName = findViewById(R.id.signName)
        signShowPassword = findViewById(R.id.signShowPassword)
        signShowId = findViewById(R.id.signShowId)
        signShowName = findViewById(R.id.signShowName)


        val btnSignUp2: Button = findViewById(R.id.btnSignUp2)
        btnSignUp2.setOnClickListener {
            signup()


        val btnSignUp2: Button = findViewById(R.id.btnSignUp2)
        btnSignUp2.setOnClickListener {
            startActivity(Intent(this@SignUpActivity, SignInActivity::class.java))
        }
        }
    }


private fun signup() {
    val signname: String = signName.text.toString()
    val signpassword: String = signPassword.text.toString()
    val signid: String = signId.text.toString()

    if (TextUtils.isEmpty(signname) || TextUtils.isEmpty(signpassword) || TextUtils.isEmpty(signid)) {
       Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()

    } else {
        val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
        intent.putExtra("signname", signname)

        startActivity(intent)


        Toast.makeText(this, "회원가입 성공", Toast.LENGTH_SHORT).show()
        finish()

    }
    }
}
