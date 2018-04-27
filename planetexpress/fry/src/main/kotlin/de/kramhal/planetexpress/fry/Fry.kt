package de.kramhal.planetexpress.fry

import de.kramhal.planetexpress.leela.Leela
import de.kramhal.planetexpress.leela.extend

class Fry {

    fun iWannaFlyToTheMoon() {
        val hejLeela = Leela()
        while(!hejLeela.letsFlyToThe("moon"));
        println("Whoooohooo")

        hejLeela.letsDrinkABeer()
        hejLeela.age=25
        //hejLeela.letsDrinkABeer()

    }

    fun extendSomeString(){
        println("Haha".extend())
    }

}

fun main(args: Array<String>) {
    Fry().iWannaFlyToTheMoon()
    Fry().extendSomeString()
}