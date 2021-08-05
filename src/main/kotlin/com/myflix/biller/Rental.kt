package com.myflix.biller

class Rental(val movie: Movie, val daysRented: Int) {

    fun amount(): Double {
        return movie.amountFor(this.daysRented)
    }

    fun frequentRenterPoints(): Int {
        return movie.frequentRenterPointsFor(this.daysRented)
    }
}