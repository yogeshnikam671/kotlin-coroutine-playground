package com.coroutines

import kotlinx.coroutines.*

fun main() {
    println("Execution started...")
    runBlocking {
        launch {
            delay(1000L)
            println("Coroutine from runBlocking scope")
        }

        GlobalScope.launch {
            delay(1500L)
            println("Coroutine from global scope")
        }

        coroutineScope {
            delay(2000L)
            println("Coroutine from coroutine scope")
        }
    }
    println("Execution finished...")
}