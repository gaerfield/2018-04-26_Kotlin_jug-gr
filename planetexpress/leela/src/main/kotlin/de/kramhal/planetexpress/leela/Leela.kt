package de.kramhal.planetexpress.leela

import de.kramhal.planetexpress.ship.PlanetExpressShip

/**
 * Interop mit Java
 */
class Leela {
    internal val backupBeer = Beer()
    private var i=0;
    var age = 20

    private val ship = PlanetExpressShip()

    fun adaptSpeed() { ship.speed = 20 }

    fun letsFlyToThe(toPlanet: String): Boolean {
        if((i++)<10) {
            println("Noooope")
            return false
        }
        println("When I do, will you finally shut uuuuuuup!")
        ship.flyTo(toPlanet)
        return true
    }

    fun letsDrinkABeer(){
        println("Thank God, I still have a beer.")
        backupBeer.drink()
        println("drinking ...")
        println("Aaaah, that was nice.")
    }

}

//fun String.martin() = "$this - falsche Martin"

fun main(args: Array<String>) {
    "Strffewf".martin()
}

fun echo(smth:String) = println(smth)