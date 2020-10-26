package com.android.androidchallenge.ui.adapters

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.android.androidchallenge.R
import com.android.androidchallenge.ui.RecyclerViewBaseAdapter
import com.android.repository.contacts.models.Hero

class HeroesAdapter(
    context: Context,
    items: List<Hero>,
    private val onItemClickedAction: ((Hero) -> Unit)? = null
) : RecyclerViewBaseAdapter<Hero, Context, HeroesAdapter.HeroesViewHolder>(context, items) {

    override fun getItemLayoutResId(): Int = R.layout.heroes_item_view

    override fun createViewHolder(context: Context, view: View) =
        HeroesViewHolder(context, view)

    inner class HeroesViewHolder(context: Context, view: View) :
        RecyclerViewBaseAdapter.RecyclerViewBaseViewHolder<Hero, Context>(
            context,
            view
        ) {

        private val name = itemView.findViewById<TextView>(R.id.name)
        private val avatar = itemView.findViewById<ConstraintLayout>(R.id.root_view)
        private val rootView = itemView.findViewById<ConstraintLayout>(R.id.root_view)

        override fun bind(item: Hero, position: Int) {
            name.text = item.name
            // avatar.setImageResource(item.iconRes)
            rootView.setOnClickListener { onItemClickedAction(item) }
        }

        private fun onItemClickedAction(item: Hero) {
            onItemClickedAction?.invoke(item)
        }

    }
}