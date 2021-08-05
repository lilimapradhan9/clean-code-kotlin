package com.myflix.biller

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class RentalTest {
    @Test
    fun `return amount for Children Movie`() {
        val rental = Rental(Movie("Ice Age", Movie.CHILDRENS), 4)

        val amount = rental.amount()

        amount shouldBe 3.0
    }

    @Test
    fun `return amount for Regular Movie`() {
        val rental = Rental(Movie("Iron Man", Movie.REGULAR), 4)

        val amount = rental.amount()

        amount shouldBe 5.0
    }

    @Test
    fun `return amount for New Release Movie`() {
        val rental = Rental(Movie("Tenet", Movie.NEW_RELEASE), 4)

        val amount = rental.amount()

        amount shouldBe 12.0
    }

    @Test
    fun `return amount for Unknown Movie`() {
        val rental = Rental(Movie("Tenet", 6), 4)

        val amount = rental.amount()

        amount shouldBe 0.0
    }

    @Test
    fun `return frequentRenterPoints for Children Movie`() {
        val rental = Rental(Movie("Ice Age", Movie.CHILDRENS), 4)

        val amount = rental.frequentRenterPoints()

        amount shouldBe 1
    }

    @Test
    fun `return frequentRenterPoints for Regular Movie`() {
        val rental = Rental(Movie("Iron Man", Movie.REGULAR), 4)

        val amount = rental.frequentRenterPoints()

        amount shouldBe 1
    }

    @Test
    fun `return frequentRenterPoints for New Release Movie`() {
        val rental = Rental(Movie("Tenet", Movie.NEW_RELEASE), 4)

        val amount = rental.frequentRenterPoints()

        amount shouldBe 2
    }

    @Test
    fun `return frequentRenterPoints for Unknown Movie`() {
        val rental = Rental(Movie("Tenet", 6), 4)

        val amount = rental.frequentRenterPoints()

        amount shouldBe 1
    }
}