package com.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
    A job is returned by the launch method.
    Job has methods with which the coroutine lifecycle can be manipulated.
    - cancel() : cancels a coroutine
    - join() : joins a coroutine to the main thread.

    There can be a hierarchy of jobs. i.e. a job having more jobs as children
    and those children can have children too.

    If a job is cancelled, all its parents and children will be cancelled too.
*/

fun main() {
    runBlocking {
        val job1 = launch {
            delay(2000)
            println("job1 launched")

            val job2 = launch {
                delay(3000)
                println("job2 launched")
            }
        }

        job1.ensureActive()

        job1.invokeOnCompletion {
            println("job1 is completed")
        }

        delay(700) // play with delay and observe the behaviour
        println("cancelling job1")
        job1.cancel()
    }
}