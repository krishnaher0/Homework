package com.example.homework

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.homework.databinding.ActivitySignUpBinding

class SignupActivity : AppCompatActivity() {
    lateinit var activitySignupBinding:ActivitySignUpBinding
    private var email = "username"
    private var password = "password"
    private var fileName ="sharedPref"
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        activitySignupBinding =ActivitySignUpBinding.inflate(layoutInflater)
        var view = activitySignupBinding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        activitySignupBinding.register.setOnClickListener {
            sharedPreferences = getSharedPreferences(fileName, MODE_PRIVATE)
            sharedPreferences.getString(email,"")
            sharedPreferences.getString(password,"")
            var fetchedEmail = activitySignupBinding.emailEdit.text.toString()
            var fetchedPassword = activitySignupBinding.passwordEdit.text.toString()
            var editor =sharedPreferences.edit()
            if(activitySignupBinding.checkBox.isChecked){
                editor.putString(email,fetchedEmail)
                editor.putString(password,fetchedPassword)
                editor.apply()
            }
            Toast.makeText(this,"Account created successfully",Toast.LENGTH_LONG).show()
        }
        activitySignupBinding.login.setOnClickListener {

            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
