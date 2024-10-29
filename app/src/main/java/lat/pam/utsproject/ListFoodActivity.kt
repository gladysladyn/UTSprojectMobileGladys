package lat.pam.utsproject

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFoodActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FoodAdapter
    private lateinit var foodList: List<Food>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_food)


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Menyiapkan data makanan
        foodList = listOf(
            Food("Nasi Goreng", "Nasi nasi berbumbu yang digoreng hingga menghasilkan cita rasa gurih dan nikmat.", R.drawable.nasigoreng),
            Food("Mie Goreng", "Mie berbumbu kecap dan bawang, disajikan dengan sayuran, telur, dan daging untuk rasa gurih.", R.drawable.mie_goreng),
            Food("Black Salad", "Salad segar yang dibuat secara langsung", R.drawable.black_salad),
            Food("Cireng", "Camilan dari tepung tapioka yang digoreng, biasanya diisi dengan bumbu atau saus sambal.", R.drawable.cireng),
            Food("Batagor", "Batagor asli enak dari Bandung", R.drawable.batagor),
            Food("Cheesecake", "Kue lembut berbahan dasar keju cream, gula, dan biskuit.", R.drawable.cheesecake),
            Food("Donut", "Donut dilapisi dengan pilihan gula, cokelat, cheese krim atau selai.", R.drawable.donut),
            Food("Cappucino", "Kopi cappucino asli yang dibuat dari Kopi Arabica", R.drawable.cappuchino),
            Food("Kopi Hitam", "Minuman dari biji kopi yang diseduh tanpa tambahan susu atau gula, rasanya pahit dan aroma kuat.", R.drawable.kopi_hitam),
            Food("Sparkling Tea", "Minuman teh berkarbonasi yang menyegarkan, biasanya memiliki rasa buah atau herbal.", R.drawable.sparkling_tea)
        )

        adapter = FoodAdapter(foodList)
        recyclerView.adapter = adapter


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}