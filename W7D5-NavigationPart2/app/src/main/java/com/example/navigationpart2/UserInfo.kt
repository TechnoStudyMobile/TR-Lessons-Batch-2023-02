package com.example.navigationpart2

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserInfo(val userName: String, val userEmail: String) : Parcelable
