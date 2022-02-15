package com.pigin.xfitmobileapp

import android.content.Intent
import android.graphics.Color
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.pigin.xfitmobileapp.databinding.ActivityHomeScreenBinding
import com.pigin.xfitmobileapp.databinding.ActivityLoginScreenBinding

class LoginScreen : AppCompatActivity() {
    lateinit var loginBindingClass: ActivityLoginScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        loginBindingClass = ActivityLoginScreenBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(loginBindingClass.root)

        loginBindingClass.nextButton.setOnClickListener {
            onClickLogin()
        }
    }
    private fun onClickLogin() {
        val randomIntent = Intent(this, HomeScreen::class.java)

        val loginIn = loginBindingClass.loginArea.text.toString()
        val passwordIn = loginBindingClass.passwordArea.text.toString()

        if (loginIn != "" && passwordIn != "") {
            if (loginIn == Constance.MY_LOGIN && passwordIn == Constance.MY_PASSWORD) {
                loginBindingClass.infoText.text = "Данные введены верно"
                startActivity(randomIntent)                     // Запуск второго окна
            } else {
                loginBindingClass.infoText.text = "Неверный логин или пароль"
            }
        } else {
            loginBindingClass.infoText.text = "Поля пусты"
        }
    }
}

object Constance { // Хранилище констант пароля и логина для приложения
    const val MY_LOGIN = "89041234567"
    const val MY_PASSWORD = "admin"
}