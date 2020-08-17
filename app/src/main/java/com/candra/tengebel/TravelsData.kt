package com.candra.tengebel

object TravelsData {

    private val travelNames = arrayOf(
        "Aloon - Aloon",
        "Cumbri",
        "Tegalsari",
        "Telaga Ngebel",
        "Gunung Masjid",
        "Pringgitan",
        "Sunggah",
        "Selorejo",
        "Tumpak Pare",
        "Klentheng"
    )

    private val travelAddresses = arrayOf(
        "Mangkujayan, Kec. Ponorogo",
        "Ds. Pager Ukir, Kec. Sampung",
        "Ds. Tegalsari, Kec. Jetis",
        "Ds. Ngebel, Kec. Ngebel",
        "Pandak, Balong",
        "Wates, Slahung",
        "Selur, Ngrayun",
        "Ds. Ngebel, Kec. Ngebel",
        "Cepoko, Ngrayun",
        "Tumpuk, Sawoo"
    )

    private val travelInfos = arrayOf(
        "Aloon-Aloon merupakan sebuah tempat yang digunakan untuk menghelat acara acara besar Ponorogo, seperti agenda tahun yaiut Festival Reog Nasional",
        "Sebuah bukit yang berada di perbatasan Ponorogo dan Wonogiri yang kerap di kunjungi oleh banyak orang untuk melihat sunrise serta suasana yang masih asri",
        "Masjid ini sering dikunjungi banyak orang untuk wisata religi, tidak hanya masyarakat sekitar tapi ada juga yang berasal dari luar kota",
        "Telaga Ngebel merupakan sebuah telaga yang memiliki suasana yang masih alami dan asri. Maka dari itu, banyak orang yang datang untuk ngopi dan menikmati pemandangan telaga",
        "Gunung Masjid kerap kali dikunjungi oleh orang-orang, karena dari puncak gunung ini akan terhampar pemandangan yang begitu menakjubkan",
        "Bukit ini sering kali digunakan untuk camping oleh wisatawan, karena saat malam dari atas bukit ini Kota Ponorogo akan terlihat begitu indah",
        "Air terjun ini bergitu besar dan tinggi, sehingga menarik banyak wisatawan untuk datang. Selain itu lingkungan yang masih terjaga membuat wisatawan semakin betah",
        "Ada surga yang tersembunyi di dekat Telaga Ngebel, yaitu salah satunya adalah Air Terjun Selorejo",
        "Bukit dengan hamparan yang begitu luas dan lapang, serta kumpulan pohon pinus yang sering dicari oleh penggemar fotografi",
        "Air terjun ini berada di ujung selatan Ponorogo, meskipun jarak yang begitu jauh tapi akan terbayarkan oleh pemandangan Air Terjun Klenthtng ini"
    )

    private val travelImages = intArrayOf(
        R.drawable.aloon,
        R.drawable.cumbri,
        R.drawable.masjid,
        R.drawable.ngebel,
        R.drawable.gnmasjid,
        R.drawable.pringgitan,
        R.drawable.sunggah,
        R.drawable.selorejo,
        R.drawable.tumpakpare,
        R.drawable.klentheng
    )

    val listData: ArrayList<Travel>
        get() {
            val list = arrayListOf<Travel>()
            for (position in travelNames.indices) {
                val travel = Travel()
                travel.name = travelNames[position]
                travel.address = travelAddresses[position]
                travel.info = travelInfos[position]
                travel.photo = travelImages[position]
                list.add(travel)
            }

            return list
        }

}