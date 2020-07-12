package com.aungpyaesone.padc_x_rx_travel_app_aps.dummydatas

import com.aungpyaesone.padc_x_travel_app_aps.data.vos.CountryVO
import com.aungpyaesone.padc_x_travel_app_aps.data.vos.PopularTourVO

fun getDummyCountries() : List<CountryVO>{
    val countryOne = CountryVO()
    countryOne.name = "Country One"
    countryOne.description = ""
    countryOne.description = ""
    countryOne.average_rating = 0.5
    countryOne.location = ""
    countryOne.photos = arrayListOf()
    countryOne.scores_and_reviews = arrayListOf()


    val countryTwo = CountryVO()
    countryTwo.name = ""
    countryTwo.description = ""
    countryTwo.description = ""
    countryTwo.average_rating = 0.5
    countryTwo.location = ""
    countryTwo.photos = arrayListOf()
    countryTwo.scores_and_reviews = arrayListOf()

    val countryThree = CountryVO()
    countryThree.name = ""
    countryThree.description = ""
    countryThree.description = ""
    countryThree.average_rating = 0.5
    countryThree.location = ""
    countryThree.photos = arrayListOf()
    countryThree.scores_and_reviews = arrayListOf()

    val countryFour = CountryVO()
    countryFour.name = ""
    countryFour.description = ""
    countryFour.description = ""
    countryFour.average_rating = 0.5
    countryFour.location = ""
    countryFour.photos = arrayListOf()
    countryFour.scores_and_reviews = arrayListOf()

    val countryFive = CountryVO()
    countryFive.name = ""
    countryFive.description = ""
    countryFive.description = ""
    countryFive.average_rating = 0.5
    countryFive.location = ""
    countryFive.photos = arrayListOf()
    countryFive.scores_and_reviews = arrayListOf()

    return arrayListOf(countryOne,countryTwo,countryThree,countryFour,countryFive)

}

fun getDummyPopularCountries() : List<PopularTourVO>{
    val pcountryOne = PopularTourVO()
    pcountryOne.name = ""
    pcountryOne.description = ""
    pcountryOne.description = ""
    pcountryOne.average_rating = 0.5
    pcountryOne.location = ""
    pcountryOne.photos = arrayListOf()
    pcountryOne.scores_and_reviews = arrayListOf()


    val pcountryTwo = PopularTourVO()
    pcountryTwo.name = ""
    pcountryTwo.description = ""
    pcountryTwo.description = ""
    pcountryTwo.average_rating = 0.5
    pcountryTwo.location = ""
    pcountryTwo.photos = arrayListOf()
    pcountryTwo.scores_and_reviews = arrayListOf()

    val pcountryThree = PopularTourVO()
    pcountryThree.name = ""
    pcountryThree.description = ""
    pcountryThree.description = ""
    pcountryThree.average_rating = 0.5
    pcountryThree.location = ""
    pcountryThree.photos = arrayListOf()
    pcountryThree.scores_and_reviews = arrayListOf()

    val pcountryFour = PopularTourVO()
    pcountryFour.name = ""
    pcountryFour.description = ""
    pcountryFour.description = ""
    pcountryFour.average_rating = 0.5
    pcountryFour.location = ""
    pcountryFour.photos = arrayListOf()
    pcountryFour.scores_and_reviews = arrayListOf()

    val pcountryFive = PopularTourVO()
    pcountryFive.name = ""
    pcountryFive.description = ""
    pcountryFive.description = ""
    pcountryFive.average_rating = 0.5
    pcountryFive.location = ""
    pcountryFive.photos = arrayListOf()
    pcountryFive.scores_and_reviews = arrayListOf()

    return arrayListOf<PopularTourVO>(pcountryOne,pcountryTwo,pcountryThree,pcountryFour,pcountryFive)
}
