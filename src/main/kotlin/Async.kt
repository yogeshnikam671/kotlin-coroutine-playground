package com.coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

/*
    async is exactly the same as that of launch.
    the only difference is async can return a value back to the scope.
*/
fun main() {
    runBlocking {
        val firstDeferred = async { return@async firstValue() }
        val secondDeferred = async { secondValue() } // same as that of above

        println("waiting for values...")

        val firstValue = firstDeferred.await()
        val secondValue = secondDeferred.await()
        // the await method does block the execution of the program,
        // but it does not block the thread underneath.

        println("The values --> $firstValue,$secondValue")
    }
}

suspend fun firstValue(): Int {
    delay(1000L)
    return Random.nextInt(100)
}

suspend fun secondValue(): Int {
    delay(2000L)
    return Random.nextInt(1000)
}
