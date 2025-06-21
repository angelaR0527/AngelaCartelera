package com.example.angelacartelera

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.angelacartelera.databinding.ItemMovieBinding

// Creación adapter que asocia los datos de la lista de películas a la interfaz diseñada
class MoviesAdapter(private val movies:List<Movie>, private val movieClickedListener: (Movie)-> Unit) /* creamos la lista de las películas y escuchador funcion landa*/
    : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() /* implementamos el recycler */{

        // viewHolder el parámetro que recibe es un ItemMovieBinding y creamos función bind
        class ViewHolder (private val binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(movie: Movie){
            // enlazamos la vista con el textView de la peli con el dato del titulo recogido de la lista de la peli
            binding.NameMovie.text = movie.title
            // = con la imagen
            Glide.with(binding.root.context).load(movie.cover).into(binding.CoverMovie)
        }
    }

    // Crea y luego inicializa la ViewHolder y su View asociada (sin vincular datos)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    // funcion landa
    override fun getItemCount()= movies.size

    // Asocia viewHolder a los datos
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
        holder.itemView.setOnClickListener{
            movieClickedListener(movie)
        }
    }
}