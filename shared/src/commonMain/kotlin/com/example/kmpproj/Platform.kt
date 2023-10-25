package com.example.kmpproj

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform