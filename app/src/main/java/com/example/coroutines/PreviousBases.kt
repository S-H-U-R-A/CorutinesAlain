package com.example.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread
import kotlin.random.Random

fun main() {

    //lamba()

    threads()

    couroutinesVSThreads()

}

fun couroutinesVSThreads() {
    runBlocking {
        (1..1_000_000).forEach {
            launch {
                delay(someTime())
                print("*")
            }
        }
    }
}


fun threads() {

    // println( multiThread(2 ,3))

    multiThreadLambda(2,8){ x,y ->
        println("Thread+Lamba: ${ x*y }")
    }


}

/*fun multiThread(x: Int, y: Int): Int {
    var resultado: Int = 0

    *//*El codigo dentro de thread se ejecuta en otro hilo*//*
    thread {
        Thread.sleep( someTime() )
        resultado = x*y
    }

    Thread.sleep(2_100)

    return resultado
}*/

fun multiThreadLambda(x: Int, y: Int, block: (Int, Int) -> Unit) {

    /*El codigo dentro de thread se ejecuta en otro hilo*/
    thread {
        Thread.sleep( someTime() )
        block(x,y)
    }

}

fun someTime() = Random.nextLong(500, 2_000 )

/*fun lamba() {
    multiLamba(2,5){ x,y ->
       println(x*y)
    }
}*/

/*fun multiLamba(x:Int, y:Int, block: (Int, Int) -> Unit) = block(x,y)*/
