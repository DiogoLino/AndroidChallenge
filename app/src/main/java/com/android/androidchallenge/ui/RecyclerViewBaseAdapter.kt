package com.android.androidchallenge.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

abstract class RecyclerViewBaseAdapter<I, C : Context, VH : RecyclerViewBaseAdapter.RecyclerViewBaseViewHolder<I, C>>(
    protected val context: C,
    val items: List<I>
) : RecyclerView.Adapter<VH>() {

    abstract fun getItemLayoutResId(): Int
    abstract fun createViewHolder(context: C, view: View): VH

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(context).inflate(getItemLayoutResId(), parent, false)
        return createViewHolder(context, v)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(items[position], position)
    }

    abstract class RecyclerViewBaseViewHolder<in I, C : Context>(val context: C, override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {

        abstract fun bind(item: I, position: Int)
    }
}
