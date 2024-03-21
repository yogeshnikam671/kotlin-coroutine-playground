package com.coroutines

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

/*
    Every coroutine has a context associated to it.
    Context has -
    1. Dispatcher - this decides which thread the coroutine is run on.
    2. Job - this is a handle on the coroutine lifecycle
*/
fun main() {
    runBlocking {
        launch(context = CoroutineName("contextName")) {
            println("the context is ${coroutineContext[CoroutineName.Key]}")
        }
    }
}