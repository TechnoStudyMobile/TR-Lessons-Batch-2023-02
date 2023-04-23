package com.example.jsondemo.data.heroes

data class HeroesResponse(
    val active: Boolean,
    val formed: Int,
    val homeTown: String,
    val members: List<Member>,
    val secretBase: String,
    val squadName: String
)