package de.kramhal.planetexpress.leela

/** Chocolaine: as good as good 'ol fashioned coke */
class Chocolaine(makeItIrresistible : Boolean, val blendedByMilk: Double = 0.3) {
    var label = "Chocolaine".also(::println)
    var extendedlabel = "$label - ${blendedByMilk*100}% milk".also(::println)
    val ingredients : MutableMap<String, Double> = mutableMapOf()

    init {
        println("Get to Work")
        ingredients["milk"] = blendedByMilk
        if (makeItIrresistible) {
            // secret ingr. is cocaine (plz dont tell)
            ingredients["secret"] = 0.01
            ingredients["choco"] = 1.0-blendedByMilk-0.01
        } else
            ingredients["choco"] = 1.0-blendedByMilk
    }
    constructor(label : String) : this(false, 0.5) {
        println("secondary constructor")
        this.label = label
    }

    init { println("init#2") }

    fun info() = println("$label = $ingredients")
}

fun String?.isEmpty() = (this == null || this.trim() == "" )

fun main(args: Array<String>) {
    val bla : String? = null
    println(bla.isEmpty())
//    Chocolaine(true).info()
//    Chocolaine("Milka").info()
}

