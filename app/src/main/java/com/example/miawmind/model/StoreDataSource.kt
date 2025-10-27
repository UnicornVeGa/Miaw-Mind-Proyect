package com.example.miawmind.model

import android.content.Context
import com.example.miawmind.R

object StoreDataSource {

    fun getCategories(context: Context): List<StoreCategory> {
        return listOf(
            StoreCategory(0, context.getString(R.string.category_cats)),
            StoreCategory(1, context.getString(R.string.category_food)),
            StoreCategory(2, context.getString(R.string.category_toys)),
            StoreCategory(3, context.getString(R.string.category_health)),
            StoreCategory(4, context.getString(R.string.category_home))
        )
    }

    fun getProducts(context: Context): List<Product> {
        return listOf(
            // Gatitos
            Product(0, context.getString(R.string.product_cat_brown_name), context.getString(R.string.product_cat_brown_desc), 200, 0),
            Product(1, context.getString(R.string.product_cat_persian_name), context.getString(R.string.product_cat_persian_desc), 400, 0),
            Product(2, context.getString(R.string.product_cat_egyptian_name), context.getString(R.string.product_cat_egyptian_desc), 450, 0),
            Product(3, context.getString(R.string.product_cat_orange_name), context.getString(R.string.product_cat_orange_desc), 250, 0),
            Product(4, context.getString(R.string.product_cat_black_name), context.getString(R.string.product_cat_black_desc), 300, 0),
            Product(5, context.getString(R.string.product_cat_siamese_name), context.getString(R.string.product_cat_siamese_desc), 500, 0),

            // Alimento
            Product(6, context.getString(R.string.product_food_kibble_name), context.getString(R.string.product_food_kibble_desc), 50, 1),
            Product(7, context.getString(R.string.product_food_premium_name), context.getString(R.string.product_food_premium_desc), 100, 1),
            Product(8, context.getString(R.string.product_food_salmon_name), context.getString(R.string.product_food_salmon_desc), 150, 1),
            Product(9, context.getString(R.string.product_food_catnip_name), context.getString(R.string.product_food_catnip_desc), 80, 1),
            Product(10, context.getString(R.string.product_food_churu_name), context.getString(R.string.product_food_churu_desc), 120, 1),

            // Juguetes
            Product(11, context.getString(R.string.product_toy_mouse_name), context.getString(R.string.product_toy_mouse_desc), 60, 2),
            Product(12, context.getString(R.string.product_toy_ball_name), context.getString(R.string.product_toy_ball_desc), 40, 2),
            Product(13, context.getString(R.string.product_toy_scratcher_name), context.getString(R.string.product_toy_scratcher_desc), 200, 2),
            Product(14, context.getString(R.string.product_toy_feather_name), context.getString(R.string.product_toy_feather_desc), 90, 2),

            // Salud
            Product(15, context.getString(R.string.product_health_vaccine_name), context.getString(R.string.product_health_vaccine_desc), 300, 3),
            Product(16, context.getString(R.string.product_health_med_name), context.getString(R.string.product_health_med_desc), 200, 3),
            Product(17, context.getString(R.string.product_health_shampoo_name), context.getString(R.string.product_health_shampoo_desc), 80, 3),
            Product(18, context.getString(R.string.product_health_perfume_name), context.getString(R.string.product_health_perfume_desc), 70, 3),
            Product(19, context.getString(R.string.product_health_brush_name), context.getString(R.string.product_health_brush_desc), 60, 3),

            // Hogar
            Product(20, context.getString(R.string.product_home_bed_name), context.getString(R.string.product_home_bed_desc), 180, 4),
            Product(21, context.getString(R.string.product_home_plate_name), context.getString(R.string.product_home_plate_desc), 50, 4),
            Product(22, context.getString(R.string.product_home_house_name), context.getString(R.string.product_home_house_desc), 300, 4),
            Product(23, context.getString(R.string.product_home_plant_name), context.getString(R.string.product_home_plant_desc), 70, 4),
            Product(24, context.getString(R.string.product_home_wallpaper_name), context.getString(R.string.product_home_wallpaper_desc), 40, 4)
        )
    }

    fun getProductsOfCategory(context: Context, categoryId: Int): List<Product> {
        return getProducts(context).filter { it.categoryId == categoryId }
    }
}
