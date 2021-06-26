package com.myflix.biller

class HtmlStatement(
    private val customerName: String,
    private val rentals: Rentals
) {
    fun html(): String {
        var result = "<h3>Rental Record for $customerName</h3></br>"
        result += "<p>"
        rentals.forEach { rental ->
            result += "${rental.movie.title}: <b>${rental.amount()}</b></br>"
        }
        result += "</p>"
        result += "<p>Amount owed is <b>${rentals.totalAmount()}</b></p>"
        result += "You earned ${rentals.totalFrequentRenterPoints()} frequent renter points"
        return result
    }

}