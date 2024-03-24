package com.coroutines

import kotlinx.coroutines.*

/*
    A dispatcher decides which thread or thread pool a coroutine runs on.
    If we want to be very specific about where a certain coroutine should run,
    we can configure dispatcher for that coroutine.

    Different dispatchers are available for different tasks such as :
    1. network communications
    2. data processing
    2. ui interactions
*/
fun main() {
    println("This is how you can print thread name --> ${Thread.currentThread().name}")
    cpuIntensiveProcessingDispatcher()
    ioProcessingDispatcher()
    unconfinedDispatcher()
    customDispatcher()
//    uiProcessingDispatcher()
}

fun cpuIntensiveProcessingDispatcher() {
   runBlocking {
       launch(context = Dispatchers.Default) {
           println("Default dispatcher is used for CPU intensive processing")
       }
   }
}

fun ioProcessingDispatcher() {
    runBlocking {
        launch(context = Dispatchers.IO) {
            println("IO dispatcher is used to IO operations such as network communications or reading/writing files")
        }
    }
}

fun unconfinedDispatcher() {
    runBlocking {
        launch(context = Dispatchers.Default) {
            launch(context = Dispatchers.Unconfined) {
                println("Calls this coroutine in the parent dispatcher i.e. Default in this case")
            }
        }
    }
}

@OptIn(ExperimentalCoroutinesApi::class, DelicateCoroutinesApi::class)
fun customDispatcher() {
    runBlocking {
        launch(context = newSingleThreadContext("custom_thread")) {
            println("This coroutine runs on a custom thread --> $coroutineContext")
        }
    }
}

// only works with android. some android modules need to be imported for
// this to work
fun uiProcessingDispatcher() {
    runBlocking {
        launch(context = Dispatchers.Main) {
            println("UI processing (Android)")
        }
    }
}