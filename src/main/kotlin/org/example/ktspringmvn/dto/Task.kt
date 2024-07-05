package org.example.ktspringmvn.dto

data class Task(
    val id: String? = null,
    val title: String,
    val description: String,
    val status: String
)
