package com.coroutines

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
    We can spawn a lot of coroutines without any negative
    impact on the machine performance.
    They are very lightweight!!
    You can run the following program to validate this.
    The program is creating over 10,00,000 coroutines!!
*/
fun main() {
   runBlocking {
       repeat(1_000_000) { num ->
           launch {
               print("$num ")
           }
       }
   }
}