package com.example.miawmind.model

import android.content.Context
import com.example.miawmind.R

object InventoryDataSource {

    fun getItems(context: Context): List<InventoryItem> {
        return listOf(
            // Alimento
            InventoryItem(6, context.getString(R.string.product_food_kibble_name), 5, 50, 1),
            InventoryItem(8, context.getString(R.string.product_food_salmon_name), 3, 150, 1),
            InventoryItem(9, context.getString(R.string.product_food_catnip_name), 8, 80, 1),
            InventoryItem(10, context.getString(R.string.product_food_churu_name), 6, 120, 1),

            // Juguetes
            InventoryItem(11, context.getString(R.string.product_toy_mouse_name), 4, 60, 2),
            InventoryItem(12, context.getString(R.string.product_toy_ball_name), 7, 40, 2),
            InventoryItem(13, context.getString(R.string.product_toy_scratcher_name), 1, 200, 2),
            InventoryItem(14, context.getString(R.string.product_toy_feather_name), 3, 90, 2),

            // Salud
            InventoryItem(15, context.getString(R.string.product_health_vaccine_name), 1, 300, 3),
            InventoryItem(16, context.getString(R.string.product_health_med_name), 2, 200, 3),
            InventoryItem(17, context.getString(R.string.product_health_shampoo_name), 4, 80, 3),
            InventoryItem(18, context.getString(R.string.product_health_perfume_name), 5, 70, 3),
            InventoryItem(19, context.getString(R.string.product_health_brush_name), 3, 60, 3),

            // Hogar
            InventoryItem(20, context.getString(R.string.product_home_bed_name), 1, 180, 4),
            InventoryItem(21, context.getString(R.string.product_home_plate_name), 4, 50, 4),
            InventoryItem(22, context.getString(R.string.product_home_house_name), 1, 300, 4),
            InventoryItem(23, context.getString(R.string.product_home_plant_name), 2, 70, 4)
        )
    }

    fun getItemsOfCategory(context: Context, categoryId: Int): List<InventoryItem> {
        return getItems(context).filter { item ->
            item.categoryId == categoryId
        }
    }
}
