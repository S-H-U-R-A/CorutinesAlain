package com.example.coroutines

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


val cities = listOf<String>("Bucaramanga", "Bogota", "Cali", "Medellin", "Cucuta")

fun main() {
    basicChanel()
}

//Chanel: Transferir un flujo de valores entre corrutinas

fun basicChanel() {
    runBlocking {



        val channel = Channel<String>()

        val ciudades: ReceiveChannel<String> = produce {
            cities.forEach {
                send(it)
            }
        }

        launch {
            /*cities.forEach {
                channel.send(it)
            }*/

        }

        /*repeat(5){
            println( channel.receive() )
        }*/

        /*for (value in channel){
            println(value)
        }

        channel.consumeEach {
            println(it)
        }

        channel.close()*/

        ciudades.consumeEach {
            println(it)
        }


    }
}
