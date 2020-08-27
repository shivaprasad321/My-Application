package com.shivaprasad.myapplication.data.model

import java.io.Serializable

class ResponceData() {

    data class Responce(var resultCount: Int, var results: ArrayList<ResponceArray>)
    data class ResponceArray (var artistName:String?, var collectionName:String?, var trackName:String?, var collectionPrice:String?, var releaseDate:String?, var artworkUrl100: String?, var slected : Boolean?):Serializable{

        fun copy() =
            ResponceArray(
                this.artistName,
                this.collectionName,
                this.trackName,
                this.collectionPrice,
                this.releaseDate,
                this.artworkUrl100,
                this.slected
            )


    }



}