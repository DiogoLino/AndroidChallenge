package com.android.androidchallenge.ui.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.androidchallenge.R
import com.android.androidchallenge.utils.STANDARD
import com.android.androidchallenge.utils.inflater
import com.android.androidchallenge.views.CircleImageView
import com.android.imageloader.ImageLoader
import com.android.presentation.contacts.UiHero

class HeroesAdapter(
    private val imageLoader: ImageLoader,
    private val onItemClickedAction: ((UiHero) -> Unit)? = null
) : RecyclerView.Adapter<HeroesAdapter.HeroesViewHolder>() {

    private var heroes = ArrayList<UiHero>()

    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) {
        holder.bind(heroes[position])
    }

    override fun getItemCount(): Int = heroes.count() - 1

    fun addHeroes(heroList: List<UiHero>) {
        heroes.addAll(heroList)
        notifyDataSetChanged()
    }

    fun refreshAdapter(){
        heroes.clear()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesViewHolder {
        val view = parent.inflater.inflate(R.layout.heroes_item_view, parent, false)
        return HeroesViewHolder(view)
    }

    inner class HeroesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val name = itemView.findViewById<TextView>(R.id.name)
        private val avatar = itemView.findViewById<CircleImageView>(R.id.avatar)
        private val rootView = itemView.findViewById<LinearLayout>(R.id.root_view)

        fun bind(item: UiHero) {
            name.text = item.name

            imageLoader.load(
                item.getThumbnail(STANDARD),
                avatar,
                R.drawable.user_avatar_placeholder
            )
            rootView.setOnClickListener { onItemClickedAction(item) }
        }

        private fun onItemClickedAction(item: UiHero) {
            onItemClickedAction?.invoke(item)
        }
    }
}
