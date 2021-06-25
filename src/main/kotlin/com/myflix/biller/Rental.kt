package com.myflix.biller

class Rental(val movie: Movie, val daysRented: Int) {

    fun amount(): Double {
        var amount = 0.0
        when (movie.priceCode) {
            Movie.REGULAR -> {
                amount += 2.0
                if (daysRented > 2) amount += (daysRented - 2) * 1.5
            }
            Movie.NEW_RELEASE -> amount += daysRented * 3
            Movie.CHILDRENS -> {
                amount += 1.5
                if (daysRented > 3) amount += (daysRented - 3) * 1.5
            }
        }
        return amount
    }

    fun frequentRenterPoints(): Int {
        // add bonus for a two day new release rental
        return if (movie.priceCode == Movie.NEW_RELEASE && daysRented > 1)
            2
        else
            1
    }
}