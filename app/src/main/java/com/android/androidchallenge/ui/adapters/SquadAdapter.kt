package com.android.androidchallenge.ui.adapters

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.android.androidchallenge.R
import com.android.androidchallenge.utils.STANDARD
import com.android.androidchallenge.views.CircleImageView
import com.android.imageloader.ImageLoader
import com.android.presentation.contacts.UiHero

class SquadAdapter(
    context: Context,
    items: List<UiHero>,
    val imageLoader: ImageLoader,
    private val onItemClickedAction: ((UiHero) -> Unit)? = null
) : RecyclerViewBaseAdapter<UiHero, Context, SquadAdapter.SquadViewHolder>(context, items) {


    override fun getItemLayoutResId(): Int = R.layout.squad_item_view

    override fun createViewHolder(context: Context, view: View) =
        SquadViewHolder(context, view)

    override fun getItemCount(): Int = items.count()

    inner class SquadViewHolder(context: Context, view: View) :
        RecyclerViewBaseAdapter.RecyclerViewBaseViewHolder<UiHero, Context>(
            context,
            view
        ) {

        private val name = itemView.findViewById<TextView>(R.id.name)
        private val avatar = itemView.findViewById<CircleImageView>(R.id.avatar)
        private val rootView = itemView.findViewById<LinearLayout>(R.id.root_view)

        override fun bind(item: UiHero, position: Int) {
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