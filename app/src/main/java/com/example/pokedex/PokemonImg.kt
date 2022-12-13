package com.example.pokedex

import android.os.Parcel
import android.os.Parcelable

data class PokemonImg(val url: String?) : Parcelable
{
    constructor(parcel: Parcel) : this(parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PokemonImg> {
        override fun createFromParcel(parcel: Parcel): PokemonImg {
            return PokemonImg(parcel)
        }

        override fun newArray(size: Int): Array<PokemonImg?> {
            return arrayOfNulls(size)
        }
    }

}
