package com.example.planets.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Planets(
    val id: Int?,
    val name: String?,
    val galaxy: String?,
    val distance: String?,
    val gravity: String?,
    val description: String?
) : Parcelable

