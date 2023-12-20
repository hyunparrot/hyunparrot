package com.example.coursework

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.LoginFilter.UsernameFilterGMail
import android.text.TextUtils
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.example.coursework.R.id.ShowId
import com.example.coursework.R.id.ShowPassword
import com.example.coursework.R.id.UserName
import com.example.coursework.R.id.UserPassword
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.sql.RowId
import android.content.Context
import android.widget.EditText
import android.widget.TextView


class SignInActivity : AppCompatActivity() {

    private lateinit var UserName: EditText
    private lateinit var UserPassword: EditText
    private lateinit var ShowId: TextView
    private lateinit var ShowPassword: TextView
    //TextView와 TextView 차이점

    //TextView는 단순한 텍스트를 표시하는 데 사용되고

    // TextInputLayout은 사용자로부터의 입력을 받기 위한
    // 디자인적인 목적을 가진 입력 컨테이너이다

    //일반적으로 EditText를 포함하면서 사용된다.

    //사용자가 로그인 화면에서 아이디와 비밀번호를 입력하는 데 사용하는 UI 요소

    //변수를 lateinit var로 선언하는 이유는 이 변수들이 나중에 초기화될 것이기 때문

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        UserName = findViewById(R.id.UserName)
        UserPassword = findViewById(R.id.UserPassword)
        ShowId = findViewById(R.id.ShowId)
        ShowPassword = findViewById(R.id.ShowPassword)

        val btnLogin: Button = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            // 로그인 버튼 클릭 시 HomeActivity로 이동
            val intent = Intent(this@SignInActivity, HomeActivity::class.java)
            startActivity(intent)
            login()
        }

        val btnSignUp: Button = findViewById(R.id.btnSignUp)
        btnSignUp.setOnClickListener {
            startActivity(Intent(this@SignInActivity, SignUpActivity::class.java))
            //여기가 회원가입 하는곳으로 이동하는 첫번째 코드

            //이 코드는 SignInActivity에서 SignUpActivity로 전환하는 역할을 한다.

            // 이 코드는 주로 로그인 화면에서 회원가입 화면으로 이동하고자 할 때 사용된다.
        }
    }


    private fun login() {
        val username: String = UserName.text.toString()
        val userpassword: String = UserPassword.text.toString()


        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(userpassword)) {
            Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            // 컨텍스트를 사용하여 토스트를 생성하고 표시
            //fun showToast(context: Context, message: String) {

               // Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            //}

           // 위 코드에서 context는 현재 화면의 컨텍스트를 나타낸다.

            // 하지만 context를 사용하려면 val context: Context = this 를 해줘야 하지만,

            // context 자리에 this를 넣어주면 자동으로 context 생성이됨.

           // message는 표시할 메시지 내용

           //Toast.LENGTH_SHORT은 토스트가 화면에 표시되는 지속 시간을 나타낸다.

           // Toast.LENGTH_SHORT은 약 2초 동안 표시

           //Toast.LENGTH_LONG은 약 3.5초 동안 표시


            // 로그인 버튼을 누르면 HomeActivity가 실행됩니다. (Extra로 아이디를 넘겨줍니다.)

            //해당 코드는 사용자가 제공한 아이디(username) 또는 비밀번호(password)가 비어있는지를 확인하는 조건문

            // 여기서 사용된 TextUtils.isEmpty(...)는 안드로이드에서 제공되는 유틸리티 메서드로, 문자열이 비어있는지 여부를 검사하는 데 사용된다.

            // TextUtils.isEmpty(username): 사용자가 제공한 아이디(username)가 비어있는지 여부를 검사합니다.

            // TextUtils.isEmpty(password): 사용자가 제공한 비밀번호(password)가 비어있는지 여부를 검사합니다.

            // || 연산자를 사용하여 두 조건 중 하나라도 참이면 (아이디가 비어있거나 비밀번호가 비어있으면), 조건문은 참이 된다.

            // 이것은 사용자가 아이디 또는 비밀번호 중 하나라도 입력하지 않았을 경우를 나타낸다.

        } else {
            val intent = Intent(this@SignInActivity, HomeActivity::class.java)
            intent.putExtra("username", username)
            Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
            //intent.putExtra("username", username): putExtra 메서드를 사용하여

            // "username"이라는 키와 함께 사용자의 아이디(username)를 Intent에 추가

            // 이렇게 함으로써 액티비티에서 이 정보를 활용할 수 있다.

            //이 코드는 로그인이 성공했을 때 사용자의 아이디를 HomeActivity로 전달하면서 HomeActivity를 실행하는 역할을 한다.

            startActivity(intent)

            //startActivity(intent): 액티비티 전환을 수행한다. Intent에 설정된 정보를 가지고 HomeActivity로 전환된다.

        }
    }
}

