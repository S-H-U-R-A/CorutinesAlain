package com.example.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() {

    globalScope()

    /*Solo es para ver los mensajes*/
    readLine()
}


fun getDataByFlow(): Flow<String> {
    return flowOf("5", "5")
}

fun globalScope() {
    GlobalScope.launch {
        startMsg()

        println("Mi corrutina")

        endMsg()


    }


    runBlocking{

        val data = async{
            startMsg()

            println("Mi corrutina Async")

            endMsg()


        }




    }

}

fun startMsg(){
    println( "Comenzando corrutina -${ Thread.currentThread().name }-" )
}

fun endMsg(){
    println( "Corrutina -${ Thread.currentThread().name }- finalizada." )
}
