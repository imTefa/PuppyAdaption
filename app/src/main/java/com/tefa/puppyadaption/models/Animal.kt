package com.tefa.puppyadaption.models

import com.tefa.puppyadaption.R


 fun generatePuppies(): List<Animal> {
    return listOf(
        Animal(
            name = "Archie",
            imgRes = R.drawable.p1,
            age = "8 Months"
        ),
        Animal(
            name = "Bee",
            imgRes = R.drawable.p2,
            age = "1 Year"
        ),
        Animal(
            name = "Clover",
            imgRes = R.drawable.p3,
            age = "3 Years"
        ),
        Animal(
            name = "Cuppy",
            imgRes = R.drawable.p4,
            age = "2 Years"
        ),
        Animal(
            name = "Ellie",
            imgRes = R.drawable.p5,
            age = "4 Years"
        ),
        Animal(
            name = "Snickers",
            imgRes = R.drawable.p6,
            age = "3 Month"
        ),
        Animal(
            name = "Waffle",
            imgRes = R.drawable.p7,
            age = "9 Month"
        ),
        Animal(
            name = "Lovey",
            imgRes = R.drawable.p8,
            age = "2 Years"
        )
    )
}

fun generateCats(): List<Animal> {
    return listOf(
        Animal(
            name = "Willow",
            imgRes = R.drawable.c1,
            age = "8 Months",
            type = Type.CAT
        ),
        Animal(
            name = "Millie",
            imgRes = R.drawable.c2,
            age = "1 Year",
            type = Type.CAT
        ),
        Animal(
            name = "Tiger",
            imgRes = R.drawable.c3,
            age = "3 Years",
            type = Type.CAT
        ),
        Animal(
            name = "Loki",
            imgRes = R.drawable.c4,
            age = "2 Years",
            type = Type.CAT
        ),
        Animal(
            name = "Princess",
            imgRes = R.drawable.c5,
            age = "4 Years",
            type = Type.CAT
        ),
        Animal(
            name = "Simba",
            imgRes = R.drawable.c6,
            age = "3 Month",
            type = Type.CAT
        ),
        Animal(
            name = "Lucy",
            imgRes = R.drawable.c7,
            age = "9 Month",
            type = Type.CAT
        ),
        Animal(
            name = "Bella",
            imgRes = R.drawable.c8,
            age = "2 Years",
            type = Type.CAT
        )
    )
}


data class Animal(
    val name: String,
    val imgRes: Int,
    val description: String = "",
    val age: String,
    val type: Type = Type.PUPPY
)

enum class Type {
    PUPPY, CAT
}