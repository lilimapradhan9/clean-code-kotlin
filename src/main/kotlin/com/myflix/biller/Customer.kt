package com.myflix.biller

class Customer(private val name: String) {
    private val rentals: MutableList<Rental> = ArrayList()
    fun addRental(arg: Rental) {
        rentals.add(arg)
    }

    fun statement(): String {
        var result = "Rental Record for $name\n"

        rentals.forEach { rental ->
            result += "	${rental.movie.title}\t${rental.amount()}\n"
        }

        result += "Amount owed is ${totalAmount()}\n"
        result += "You earned ${totalFrequentRenterPoints()} frequent renter points\n"
        return result
    }

    fun htmlStatement(): String {
        var result = "<h3>Rental Record for $name</h3></br>"
        result += "<p>"
        rentals.forEach { rental ->
            result += "${rental.movie.title}: <b>${rental.amount()}</b></br>"
        }
        result += "</p>"
        result += "<p>Amount owed is <b>${totalAmount()}</b></p>"
        result += "You earned ${totalFrequentRenterPoints()} frequent renter points"
        return result
    }

    private fun totalFrequentRenterPoints(): Int = rentals.sumBy { it.frequentRenterPoints() }

    private fun totalAmount(): Double = rentals.sumByDouble { it.amount() }
}