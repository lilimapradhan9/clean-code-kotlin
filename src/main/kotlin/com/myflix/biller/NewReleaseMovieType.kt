package com.myflix.biller

class NewReleaseMovieType(override val priceCode: Int) : MovieType {
    override fun amountFor(daysRented: Int): Double {
        var amount = 0.0
        amount += daysRented * 3
        return amount
    }

    override fun frequentRenterPointsFor(daysRented: Int): Int {
        // add bonus for a two day new release rental
        return if (daysRented > 1) 2 else 1
    }
}