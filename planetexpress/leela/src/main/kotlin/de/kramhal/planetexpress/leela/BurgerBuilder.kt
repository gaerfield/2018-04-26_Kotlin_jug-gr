package de.kramhal.planetexpress.leela

open class TextIngredient(val ascii: String) {
    open fun render(builder: StringBuilder) = builder.append(ascii)
}

class Tomato : TextIngredient("""
|    |°0oo___0°°__o0o___o00°°_oo0o0_0°°o_|
""".trimMargin())
class Cheese : TextIngredient("""
|     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
""".trimMargin())
class Ketchup : TextIngredient("""
|     |_~`-`.__.`-~`._.~`-`~.-~.__.~`-`_|
""".trimMargin())
class MeatOption(ascii: String) : TextIngredient(ascii)
class Ham : TextIngredient("""
|    /                                   \
|    \___________________________________/
""".trimMargin()) {
    private val ingredients = arrayListOf<MeatOption>()
    private fun add(ingredient: MeatOption) : MeatOption {
        ingredients.add(ingredient)
        return ingredient
    }

    fun extraCross() = add(MeatOption("     __##-##**_#_#__**+*##-*--###++##__#"))
    override fun render(builder: StringBuilder) : StringBuilder {
        ingredients.forEach { it.render(builder).also { builder.append("\n") } }
        return super.render(builder)
    }
}

class UpperBun : TextIngredient("""
|            _....----'''----...._
|         .-'  o    o    o    o   '-.
|        /  o    o    o         o    \
|     __/__o___o_ _ o___ _ o_ o_ _ _o_\__
    """.trimMargin())
class LowerBun : TextIngredient("""
|      \                               /
|       \                             /
|        `-._______________________.-'
    """.trimMargin())

class AsciiBurger {
    val ingredients = arrayListOf<TextIngredient>()

    private fun <T: TextIngredient> add(ingredient: T) : T {
        ingredients.add(ingredient)
        return ingredient
    }

    fun tomato() = add(Tomato())
    fun ham() = add(Ham())
//    fun ham(init: Ham.() -> Unit) : Ham {
//        val ham = Ham()
//        add(ham)
//        ham.init()
//        return ham
//    }
    fun cheese() = add(Cheese())
    fun ketchup() = add(Ketchup())

    fun cook() : String {
        val stringBuilder = StringBuilder()
        UpperBun().render(stringBuilder).append("\n")
        ingredients.forEach { it.render(stringBuilder).append("\n") }
        LowerBun().render(stringBuilder).append("\n")
        return stringBuilder.toString()
    }
}

fun burger(init: AsciiBurger.() -> Unit): AsciiBurger {
    val burger = AsciiBurger()
    burger.init()
    return burger
}

fun main(args: Array<String>) {
    val myBurger = burger {
        tomato()
        (0..3).forEach {
            ham()
            cheese()
        }
        ketchup()
    }
    println(myBurger.cook())
}