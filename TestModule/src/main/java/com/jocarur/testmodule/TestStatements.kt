package com.jocarur.testmodule

fun main(){
    print(sum(12, 15))
    println(sumV1(12, 15))
//    testLoop()
//    testWhen()
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
         * And you can use the reverse with !in holy cow
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

/**
 * It's a short function
 * This is a lambda and the way we would write the function
 */
val sum: (Int, Int) -> Int = { a, b -> a + b }

fun sumV1(a: Int, b: Int): Int = a + b