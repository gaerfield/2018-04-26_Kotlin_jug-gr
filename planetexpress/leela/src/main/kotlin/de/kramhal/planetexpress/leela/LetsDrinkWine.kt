package de.kramhal.planetexpress.leela

import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.future.future

/**
 * Coroutines: https://github.com/Kotlin/kotlin-coroutines/blob/master/kotlin-coroutines-informal.md
 */
class LetsDrinkWine
{
    private suspend fun drinkWine( number: Int = 0 ): Int {
        println("The older the wine is, the gooder it is.")
        delay(3000)
        println("Aaaah, that was nice.")
        return number
    }

    fun launch(){
        // launch, runBlocking, async
        var job = launch { drinkWine() }
        Thread.sleep(6000)
    }

    fun blocking(){
        runBlocking { drinkWine() }
    }

    fun async(){
        // Schleife?
        val whileWineDrinking = (1 .. 100).map { async { drinkWine(it) } }
        runBlocking { println(whileWineDrinking.sumBy { it.await() }) }
    }

    fun future(){
        val future = future { drinkWine(123456) }
        future.join()
        println(future.get())
    }

    fun differentThreads() = runBlocking {
    val jobs = arrayListOf<Job>()
    // not confined -- will work with main thread
    jobs += launch(Unconfined) {
        println("      'Unconfined': thread ${Thread.currentThread().name}")
    }
    // context of the parent, runBlocking coroutine
    jobs += launch(coroutineContext) {
        println("'coroutineContext': thread ${Thread.currentThread().name}")
    }
    // will get dispatched to ForkJoinPool.commonPool (or equivalent)
    jobs += launch(CommonPool) {
        println("      'CommonPool': thread ${Thread.currentThread().name}")
    }
    // will get its own new thread
    jobs += launch(newSingleThreadContext("MyOwnThread")) {
        println("          'newSTC': thread ${Thread.currentThread().name}")
    }
    jobs.forEach { it.join() }
}
}

fun main(args: Array<String>) {
//    LetsDrinkWine().blocking()
//    LetsDrinkWine().launch()
//    LetsDrinkWine().async()
//    LetsDrinkWine().future()
    LetsDrinkWine().differentThreads()
}
