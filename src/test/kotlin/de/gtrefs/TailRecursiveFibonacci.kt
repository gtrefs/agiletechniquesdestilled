package de.gtrefs

fun fib(index: Int): Int {
    tailrec fun op(index: Int, previousHead: Int, head: Int): Int =
            if (index <= 0)
                head
            else
                op(index - 1, previousHead + head, previousHead)

    return op(index, 1, 1)
}

fun main() {
    println(
            "${fib(0)}, ${fib(1)}, ${fib(2)}, ${fib(3)}"
    )
}