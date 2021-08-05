package com.myflix.biller

interface MovieType {
    val priceCode: Int

    fun amountFor(daysRented: Int): Double
    fun frequentRenterPointsFor(daysRented: Int): Int
}