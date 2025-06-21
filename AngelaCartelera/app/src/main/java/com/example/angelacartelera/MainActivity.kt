package com.example.angelacartelera

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.angelacartelera.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        // Creamos una lista de peliculas
       var movies:List<Movie> = listOf(
           Movie("My Hero Academia: You're Next",
               "https://www.lahiguera.net/cinemania/pelicula/11383/my_hero_academia_youre_next-cartel-12003m.jpg",
               "¿Podrán Deku y el resto de la clase 1-A del instituto U.A. proteger el mundo acabando con Dark Might, el hombre que pretende ser el nuevo Símbolo de la Paz?."),
           Movie("Vaiana 2", "https://www.lahiguera.net/cinemania/pelicula/11087/vaiana_2-cartel-12127.jpg", " reúne a Vaiana y Maui tres años después en un nuevo y apasionante viaje junto a una insólita tripulación."),
           Movie("Robot salvaje","https://www.lahiguera.net/cinemania/pelicula/11113/robot_salvaje-cartel-11937.jpg","El épico viaje de un robot -la unidad 7134 de Roz, \"Roz\" para abreviar- que naufraga en una isla deshabitada y debe aprender a adaptarse al duro entorno, entablando gradualmente relaciones con los animales de la isla y convirtiéndose en padre adoptivo de un gosling huérfano."),
           Movie("Capitana Marvel","https://www.lahiguera.net/cinemania/pelicula/8507/capitana_marvel-cartel-8721m.jpg","Situada en el año 1995, la historia sigue a Carol Danvers, una piloto de la Fuerza Aérea de Estados Unidos, que se convierte en la Capitana Marvel después de que la Tierra haya quedado atrapada en el centro de un conflicto intergaláctico entre dos razas alienígenas.")
       )

        // Le asignamos el Adapter al RecyclerView
        binding.recycler.adapter = MoviesAdapter(movies){ movie ->
            //Toast.makeText(this, movie.title, Toast.LENGTH_LONG).show() // + Toast que mostrará un mensaje de información con el título del item pulsado
            navigateTo(movie) // llamamos al intent desde el adapter
        }
    }

    // intent
    private fun navigateTo(movie: Movie){
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_MOVIE, movie)
        startActivity(intent)
    }
}

