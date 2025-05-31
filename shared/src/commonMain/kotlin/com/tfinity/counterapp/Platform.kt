package com.tfinity.counterapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform