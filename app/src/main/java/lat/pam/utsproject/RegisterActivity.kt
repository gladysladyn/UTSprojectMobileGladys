package lat.pam.utsproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val usernameInput = findViewById<EditText>(R.id.RegisterUsername)
        val passwordInput = findViewById<EditText>(R.id.RegisterPassword)

        findViewById<Button>(R.id.RegisterSubmit).setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                // Simpan data ke SharedPreferences
                val sharedPref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
                with(sharedPref.edit()) {
                    putString("username", username)
                    putString("password", password)
                    apply()
                }

                // Tampilkan notifikasi registrasi berhasil
                Toast.makeText(this, "Registrasi Berhasil", Toast.LENGTH_SHORT).show()

                // Pindah ke MainActivity
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                // Jika input kosong
                Toast.makeText(this, "Silakan isi semua kolom", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
