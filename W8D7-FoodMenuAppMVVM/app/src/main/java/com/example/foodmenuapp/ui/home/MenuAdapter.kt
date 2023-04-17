package com.example.foodmenuapp.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.foodmenuapp.model.MenuModel
import com.example.foodmenuapp.R
import com.example.foodmenuapp.databinding.ItemMenuBinding
import com.example.foodmenuapp.databinding.ItemMenuHeaderBinding

class MenuAdapter(
    private val menuList: List<MenuModel>,
    menuItemClickListener: MenuItemClickListener
) : RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

     val menuItemClickListener: MenuItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = when (viewType) {
            TYPE_HEADER -> R.layout.item_menu_header
            TYPE_MENU_ITEM -> R.layout.item_menu
            else -> throw java.lang.IllegalArgumentException("Wrong view type")
        }
        return ViewHolder(LayoutInflater.from(parent.context).inflate(layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
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
        fun bind(menuModel: MenuModel) {
            when (menuModel) {
                is MenuModel.Header -> {
                    val bindingMenuHeader = ItemMenuHeaderBinding.bind(itemView)
                    bindingMenuHeader.textViewHeader.text = menuModel.menuTitle
                }
                is MenuModel.MenuItems -> {
                    val bindingMenuItem = ItemMenuBinding.bind(itemView)
                    with(bindingMenuItem) {
                        textViewMenuTitle.text = menuModel.menuName
                        textviewMenuDesc.text = menuModel.menuDesc
                        textViewAmount.text = menuModel.amount
                        imageViewProductImage.setImageResource(menuModel.imageResource)
                        imageViewPlus.setOnClickListener {
                            menuItemClickListener.onItemClicked(menuModel)
                        }
                        itemMenu.setOnClickListener {
                            menuItemClickListener.onItemClickedNavigate(menuModel)
                        }
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
        fun onItemClickedNavigate(menuModel: MenuModel.MenuItems)
    }
}