package de.kramhal.planetexpress.leela

import java.io.IOException

internal class Beer{
    companion object {
        var empty = false
    }

    fun drink() = if (!empty) empty =true else throw IOException("What the fuck, my beer?!")
}