package com.example.testcombine.data.apisimulation

import kotlin.random.Random

class ApiSimulation {
    companion object {
        private val eventItems = mutableListOf<Product>()
        private val category = mutableListOf<ProductCategories>()
        private val allItems = mutableListOf<Product>()

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
            repeat(25) {
                allItems.add(
                    Product(
                        id = it,
                        name = "Spesialis Kitchen Set Anti Rayap Anti Air",
                        description = "SOLUSI KITCHEN SET ANTI RAYAP ANTI AIR.\n" +
                                "\n" +
                                "Multiplek atau kayu solid memang paling kuat dikelasnya utk buat kitchen set, tapi apakah ada jaminan tidak keropos dan anti air ?\n" +
                                "\n" +
                                "Kami punya solusinya material anti rayap dan anti air. khusus untuk bahan anti rayap ini kebanyakan customer kami didaerah Kelapa Gading yang dahulunya merupakan daerah rawa sehingga menjadi koloni rayap.\n" +
                                "\n" +
                                "Lia Interior\n" +
                                "Berlokasi di Jakarta Menerima Pesanan pembuatan furniture interior yang menyesuiakan desain dan ruangan Rumah, Apartemen, Kantor, DLL\n" +
                                "( Kitchen set, Kamar set, Tv Cabinet, Wardrobe, Apartemen Set, Meja kantor, Partisi, DLL )\n" +
                                "\n" +
                                "Kami juga biasa mengerjakan ukiran classic maupun ukiran khas jepara, bidang pengerjaannya meliputi : Pintu, Kusen, Jendela, Architrave, dan lain sebagainya.\n" +
                                "\n" +
                                "Didukung oleh Tenaga Ahli dan peralatan yang modern serta bahan yang berkwalitas sehingga dapat menghasilkan Produk yang baik .\n" +
                                "\n" +
                                "Menggunakan Material : Anti Rayap & Anti Air.\n" +
                                "\n" +
                                "Juga menyediakan material dari Multipleks.\n" +
                                "\n" +
                                "Rp. 2.800.000/M dengan bahan Anti Rayap Anti Air\n" +
                                "\n" +
                                "Finishing : Taco Shett, Deco Sheet, Taco HPL , Cat Melamik, Cat Duco.\n" +
                                "\n" +
                                "Aksesories by Request.\n" +
                                "\n" +
                                "Tema : Minimalis, Klasik Modern, dll.\n" +
                                "\n" +
                                "Waktu pekerjaan Berkisar antara 2 - 30 hari kerja per Item pekerjaan (tergantung model dan luas yg dikerjakan)\n" +
                                "\n" +
                                "Semua Produk yang dikerjakan, kami memberikan GARANSI\n" +
                                "\n" +
                                "Gratis Konsultasi, design 3D, pemasangan.\n" +
                                "\n" +
                                "Cara pemesanan ;\n" +
                                "\n" +
                                "- WA/Call/email - kirim details - perkiraan harga - survei - gambar - tanda jadi - proses pengerjaan - kirim dan pasang.\n" +
                                "\n" +
                                "call/wa : 081314698568\n" +
                                "\n" +
                                "\n" +
                                "#kitchensetmurah #homedesign #buatkitchenset #interiordesign #designinterior #kitchensetminimalis #paketinterior #bikinkitchenset #ichigohomedesign #kitchenset #ichigo_idea #buatlemari #bikinlemari #wardrobe #furniture #furnituremurah #scandinavian #interiorjakarta #furniturejakarta #interiorapartemen",
                        category = category[0].name,
                        date = "2023-05-22",
                        eventPrice = Random.nextInt(5000000, 6500000),
                        isEvent = true,
                        price = 7000000,
                        eventValue = "Rumah Kekinian",
                        images = listOf(ProductImage("R.drawable.bg_compose_background"))
                    )
                )
                allItems.add(
                    Product(
                        id = it,
                        name = "VGA Asus ROG Strix RTX 3090 OC",
                        description = "For sell\n" +
                                "VGA gurih no minus\n" +
                                "pembelian february 2022 jarang d pake karna uda up ke 4090\n" +
                                "lengkap fullset beserta notapembelian",
                        category = category[1].name,
                        date = "2023-05-22",
                        eventPrice = null,
                        isEvent = false,
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

        fun apiGetAllItems() : List<Product> {
            return allItems
        }

        fun apiGetItemDetail(id: Int): Product {
            return eventItems[id]
        }

    }
}