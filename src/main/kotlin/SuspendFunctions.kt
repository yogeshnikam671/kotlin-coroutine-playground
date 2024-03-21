package com.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
    If we had to update this variable in different thread/s and access
    the updated value properly in the main thread, we should use the
    synchronized method so that the resource can be accessed and updated
    by only one thread at a time.

    With coroutines, we do not have to worry about synchronization of the
    shared resource like the following variable.
    The code example demonstrates the simplicity of it.
*/
var functionCalls = 0

fun main() {
    GlobalScope.launch { first() }
    GlobalScope.launch { second() }
    Thread.sleep(1000)
    println("functionCalls --> $functionCalls")
    // Even though both threads are getting executed at once,
    // the value of functionCalls is getting updated properly
    // i.e. if we had not synchronized it, we would have gotten 1 as
    // well in java multithreaded program
}

/*
    only suspend functions can be called from within a coroutine scope
*/
suspend fun first() {
    delay(500L)
    println("first method")
    functionCalls++
}

suspend fun second() {
    delay(500L)
    println("second method")
    functionCalls++
}