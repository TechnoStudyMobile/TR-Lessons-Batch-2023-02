package com.example.foodmenuapp

import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(
    private val menuList: List<MenuModel>,
    menuItemClickListener: MenuItemClickListener
) : RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

     val menuItemClickListener: MenuItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuAdapter.ViewHolder {
        val layout = when (viewType) {
            TYPE_HEADER -> R.layout.item_menu_header
            TYPE_MENU_ITEM -> R.layout.item_menu
            else -> throw java.lang.IllegalArgumentException("Wrong view type")
        }
        return ViewHolder(LayoutInflater.from(parent.context).inflate(layout, parent, false))
    }

    override fun onBindViewHolder(holder: MenuAdapter.ViewHolder, position: Int) {
        holder.bind(menuList[position])
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    override fun getItemViewType(position: Int) = when (menuList[position]) {
        is MenuModel.Header -> TYPE_HEADER
        is MenuModel.MenuItems -> TYPE_MENU_ITEM
    }

    init {
        this.menuItemClickListener = menuItemClickListener
    }


    // interface e ulaşmak için class ı inner class yaptık
   inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val menuName = itemView.findViewById<TextView>(R.id.textViewMenuTitle)
        private val menuDesc = itemView.findViewById<TextView>(R.id.textviewMenuDesc)
        private val menuAmount = itemView.findViewById<TextView>(R.id.textViewAmount)
        private val menuImage = itemView.findViewById<ImageView>(R.id.imageViewProductImage)
        private val addCart = itemView.findViewById<ImageView>(R.id.imageViewPlus)

        private val menuHeaderTitle = itemView.findViewById<TextView>(R.id.textViewHeader)

        fun bind(menuModel: MenuModel) {
            when (menuModel) {
                is MenuModel.Header -> {
                    menuHeaderTitle.text = menuModel.menuTitle
                }
                is MenuModel.MenuItems -> {
                    menuName.text = menuModel.menuName
                    menuDesc.text = menuModel.menuDesc
                    menuAmount.text = menuModel.amount
                    menuImage.setImageResource(menuModel.imageResource)
                    addCart.setOnClickListener {
                        menuItemClickListener.onItemClicked(menuModel)
                    }
                }
            }
        }
    }

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_MENU_ITEM = 1
    }

    interface MenuItemClickListener {
        fun onItemClicked(menuModel: MenuModel.MenuItems)
    }
}