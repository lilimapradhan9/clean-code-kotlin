package com.myflix.biller

class RegularMovieType(override val priceCode: Int) : MovieType{
    override fun amountFor(daysRented: Int): Double {
        var amount = 0.0
        amount += 2.0
        if (daysRented > 2) amount += (daysRented - 2) * 1.5
        return amount
    }

    override fun frequentRenterPointsFor(daysRented: Int): Int {
        return 1
    }
}