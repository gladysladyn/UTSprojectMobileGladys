package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)

        val foodName = intent.getStringExtra("foodName")
        val etFoodName = findViewById<TextView>(R.id.etFoodName)
        etFoodName.text = foodName ?: ""

        // Tombol Order
        val btnOrder = findViewById<Button>(R.id.btnOrder)
        btnOrder.setOnClickListener {
            // Ambil data dari inputan
            val servings = findViewById<EditText>(R.id.etServings).text.toString()
            val name = findViewById<EditText>(R.id.etName).text.toString()
            val notes = findViewById<EditText>(R.id.etNotes).text.toString()

            // Buat Intent dan kirim data ke ConfirmationActivity
            val intent = Intent(this, ConfirmationActivity::class.java)
            intent.putExtra("foodName", foodName)
            intent.putExtra("servings", servings)
            intent.putExtra("name", name)
            intent.putExtra("notes", notes)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
