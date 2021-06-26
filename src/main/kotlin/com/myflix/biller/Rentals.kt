package com.myflix.biller

class Rentals : ArrayList<Rental>() {

    fun totalFrequentRenterPoints(): Int = this.sumBy { it.frequentRenterPoints() }

    fun totalAmount(): Double = this.sumByDouble { it.amount() }
}