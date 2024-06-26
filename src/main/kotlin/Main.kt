package com.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    GlobalScope.launch {
        delay(1000)
        println("Hello Coroutine!")
    }

    println("Hello World!")

    Thread.sleep(2000)
}