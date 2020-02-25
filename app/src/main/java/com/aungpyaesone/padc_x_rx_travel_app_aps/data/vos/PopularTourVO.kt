package com.aungpyaesone.padc_x_travel_app_aps.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.aungpyaesone.padc_x_rx_travel_app_aps.persistence.PhotoTypeConverter
import com.aungpyaesone.padc_x_rx_travel_app_aps.persistence.ScoreAndReviewTypeConverter
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular_tour")
@TypeConverters(ScoreAndReviewTypeConverter::class, PhotoTypeConverter::class)
data class PopularTourVO(
    @PrimaryKey
    @SerializedName("name")var name:String ="",
    @SerializedName("description")var description:String ="",
    @SerializedName("location")var location:String ="",
    @SerializedName("average_rating")var average_rating:Double =0.0,

    @SerializedName("scores_and_reviews")var scores_and_reviews:ArrayList<ScoreandReviewVO> = arrayListOf(),
    @SerializedName("photos")var photos:ArrayList<String> = arrayListOf()
)
