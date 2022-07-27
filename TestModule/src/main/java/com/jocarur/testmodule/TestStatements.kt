package com.jocarur.testmodule

fun main(){
    testLoop()
    testWhen()
}

fun testLoop() {
    for (i in 1..1000) {
        if (i % 3 == 0)
            println(i)
        else println("---")
    }
}

fun testWhen() {
    when (0) {
        /**
         * Omg you can use in to define ranges in the code
         * And you can use the reverse holy cow with !in
         * Well that makes sense it's a bool
         */
        in 1..49 -> {
            print("you is poor")
        }
        in 50..100 -> {
            print("you is kinda ok")
        }
        else -> {
            print("you is ok")
        }
    }
}