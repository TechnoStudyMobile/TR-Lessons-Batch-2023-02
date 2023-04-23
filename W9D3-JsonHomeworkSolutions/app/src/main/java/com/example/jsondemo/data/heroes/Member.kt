package com.example.jsondemo.data.heroes

data class Member(
    val age: Int,
    val name: String,
    val powers: List<String>,
    val secretIdentity: String
)