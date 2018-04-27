package de.kramhal.planetexpress.leela

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

private fun anyoneElse(lambda : () -> Unit) = lambda()
private fun buildSomeLambda(a: Int, b: Int) : () -> Int = {a+b}
private fun lock(l : Lock, lambda : () -> Any) : () -> Any = {
    l.lock()
    try {
        lambda()
    } finally {
        l.unlock()
    }
}

inline fun <T> lock2(lock: Lock, body: () -> T): T {
    lock.lock()
    try {
        return body()
    } finally {
        lock.unlock()
    }
}

fun main(args: Array<String>) {
    anyoneElse { println(5+4) }
    println(buildSomeLambda(5,4))
    val myLock = ReentrantLock()
    lock(myLock) {println(4+4)}()

    higherOrderFunctionTakingFoo {
        functionInFoo()
        higherOrderFunctionTakingBar {
            functionInFoo()
            functionInBar()
        }
    }
}

class Foo
class Bar

fun Foo.functionInFoo(): Unit = println("functionInFoo")
fun Bar.functionInBar(): Unit = println("functionInBar")

inline fun higherOrderFunctionTakingFoo(body: (Foo).() -> Unit) = body(Foo())
inline fun higherOrderFunctionTakingBar(body: (Bar).() -> Unit) = body(Bar())

