package com.myflix.biller

class UndefinedMovieType(override val priceCode: Int) : MovieType{
    override fun amountFor(daysRented: Int): Double {
        return 0.0
    }

    override fun frequentRenterPointsFor(daysRented: Int): Int {
        return 1
    }
}
