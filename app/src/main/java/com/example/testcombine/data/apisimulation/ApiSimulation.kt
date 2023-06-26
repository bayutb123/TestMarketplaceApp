package com.example.testcombine.data.apisimulation

import kotlin.random.Random

class ApiSimulation {
    companion object {
        private val eventItems = mutableListOf<Product>()
        private val category = mutableListOf<ProductCategories>()
        init {
            category.add(
                ProductCategories(1, "Rumah tangga")
            )
            category.add(
                ProductCategories(2, "Elektronik")
            )
            repeat(30) {
                eventItems.add(
                    Product(
                        id = it,
                        name = "VGA Asus ROG Strix RTX 3090 OC",
                        description = "For sell\n" +
                                "VGA gurih no minus\n" +
                                "pembelian february 2022 jarang d pake karna uda up ke 4090\n" +
                                "lengkap fullset beserta notapembelian",
                        category = category[1].name,
                        date = "2023-05-22",
                        eventPrice = Random.nextInt(14000000, 15000000),
                        isEvent = true,
                        price = 17000000,
                        eventValue = "Minggu Gaming",
                        images = listOf(ProductImage("R.drawable.bg_compose_background"))
                    )
                )
            }
        }
        fun apiGetEventItems(): List<Product> {
            return eventItems
        }
        fun apiGetItemDetail(id: Int) : Product {
            return eventItems[id]
        }
    }
}