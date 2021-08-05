package com.myflix.biller

class ChildrenMovieType(override val priceCode: Int) : MovieType {
    override fun amountFor(daysRented: Int): Double {
        var amount = 0.0
        amount += 1.5
        if (daysRented > 3) amount += (daysRented - 3) * 1.5
        return amount
    }

    override fun frequentRenterPointsFor(daysRented: Int): Int {
        return 1
    }
}