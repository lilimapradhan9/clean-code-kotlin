package com.myflix.biller

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class CustomerTest {

    @Test
    fun test() {
        1 + 1 shouldBe 2
    }

    @Test
    fun `should return statement`() {
        val customer = Customer("John")
        customer.addRental(Rental(Movie("Tenet", Movie.NEW_RELEASE), 4))
        customer.addRental(Rental(Movie("Harry Potter", Movie.CHILDRENS), 2))
        customer.addRental(Rental(Movie("Interstellar", Movie.REGULAR), 3))

        val actualStatement = customer.statement()

        actualStatement shouldBe "Rental Record for John\n" +
                "\tTenet\t12.0\n" +
                "\tHarry Potter\t1.5\n" +
                "\tInterstellar\t3.5\n" +
                "Amount owed is 17.0\n" +
                "You earned 4 frequent renter points\n"
    }

    @Test
    fun `should return html statement`() {
        val customer = Customer("John")
        customer.addRental(Rental(Movie("Tenet", Movie.NEW_RELEASE), 4))
        customer.addRental(Rental(Movie("Harry Potter", Movie.CHILDRENS), 2))
        customer.addRental(Rental(Movie("Interstellar", Movie.REGULAR), 3))

        val actualHtmlStatement = customer.htmlStatement()

        actualHtmlStatement shouldBe "<h3>Rental Record for John</h3></br>" +
                "<p>" +
                "Tenet: <b>12.0</b></br>" +
                "Harry Potter: <b>1.5</b></br>" +
                "Interstellar: <b>3.5</b></br>" +
                "</p>" +
                "<p>Amount owed is <b>17.0</b></p>" +
                "You earned 4 frequent renter points"
    }
}