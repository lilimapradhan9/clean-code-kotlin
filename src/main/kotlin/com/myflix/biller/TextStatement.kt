package com.myflix.biller

class TextStatement(
    private val customerName: String,
    private val rentals: Rentals
) {
    fun text(): String {
        var result = "Rental Record for $customerName\n"
        rentals.forEach { rental ->
            result += "	${rental.movie.title}\t${rental.amount()}\n"
        }

        result += "Amount owed is ${rentals.totalAmount()}\n"
        result += "You earned ${rentals.totalFrequentRenterPoints()} frequent renter points\n"
        return result
    }
}