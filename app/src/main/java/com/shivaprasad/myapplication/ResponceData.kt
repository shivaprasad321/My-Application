package com.shivaprasad.myapplication

class ResponceData() {

    data class Responce(var resultCount: Int, var results: ArrayList<ResponceArray>)

   data class ResponceArray(var artistName:String, var collectionName:String, var trackName:String, var collectionPrice:String, var releaseDate:String, var artworkUrl100: String, var slected : Boolean):Cloneable{
       override fun equals(obj: Any?): Boolean {
           if (this === obj) return true
           if (obj == null) return false
           val other: ResponceArray = obj as ResponceArray
           if (!trackName.equals(other.trackName)) return false
           return true

       }

       override fun clone(): Any {
           return super.clone()
       }
   }
}