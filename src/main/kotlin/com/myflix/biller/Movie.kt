package com.myflix.biller

class Movie(val title: String, var movieType: MovieType) {
    constructor(title: String, priceCode: Int) : this(title, movieTypeFrom(priceCode))

    var priceCode: Int
        get() = movieType.priceCode
        set(value) {
            movieType = movieTypeFrom(value)
        }

    fun amountFor(daysRented: Int): Double {
        return movieType.amountFor(daysRented)
    }

    fun frequentRenterPointsFor(daysRented: Int): Int {
        return movieType.frequentRenterPointsFor(daysRented)
    }

    companion object {
        const val CHILDRENS = 2
        const val REGULAR = 0
        const val NEW_RELEASE = 1

        private fun movieTypeFrom(priceCode: Int) = when (priceCode) {
            REGULAR -> RegularMovieType(priceCode)
            NEW_RELEASE -> NewReleaseMovieType(priceCode)
            CHILDRENS -> ChildrenMovieType(priceCode)
            else -> UndefinedMovieType(priceCode)
        }
    }
}


fun main() {
    val movie = Movie("", Movie.REGULAR)
    movie.priceCode = 1
}