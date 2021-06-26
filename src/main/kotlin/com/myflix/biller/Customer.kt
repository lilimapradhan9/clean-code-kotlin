package com.myflix.biller

class Customer(private val name: String) {
    private val rentals: Rentals = Rentals()
    fun addRental(arg: Rental) {
        rentals.add(arg)
    }

    fun statement(): String {
        return TextStatement(name, rentals).text()
    }

    fun htmlStatement(): String {
        return HtmlStatement(name, rentals).html()
    }
}