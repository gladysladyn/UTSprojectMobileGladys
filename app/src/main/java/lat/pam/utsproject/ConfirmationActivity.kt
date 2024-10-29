package lat.pam.utsproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConfirmationActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "StringFormatInvalid")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirmation)

        // Ambil data dari Intent
        val foodName = intent.getStringExtra("foodName")
        val servings = intent.getStringExtra("servings")
        val name = intent.getStringExtra("name")
        val notes = intent.getStringExtra("notes")

        // Tampilkan data pada TextView
        findViewById<TextView>(R.id.etFoodName).text = getString(R.string.confirm_food_name, foodName)
        findViewById<TextView>(R.id.etServings).text = getString(R.string.confirm_servings, servings)
        findViewById<TextView>(R.id.etName).text = getString(R.string.confirm_ordering_name, name)
        findViewById<TextView>(R.id.etNotes).text = getString(R.string.confirm_add_notes, notes)

        // Handle tombol Back to Menu
        findViewById<Button>(R.id.backtoMenu).setOnClickListener {
            // Membuat intent ke ListFoodActivity
            val intent = Intent(this, ListFoodActivity::class.java)
            startActivity(intent)
            finish() // Opsional, untuk menutup ConfirmationActivity agar tidak kembali ke sini saat user menekan tombol back
        }

        // Window Insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
