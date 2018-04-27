package de.kramhal.planetexpress.leela

import java.io.File

/** https://kotlinlang.org/docs/reference/extensions.html */
fun String.extend() = "$this - extended"
fun String.martin() = "$this - martin"

operator fun String.rem(file : String) : Int {
    File(file).writeText(this);
    return 0
}

data class Artist(val name: String)
data class Track(val name: String, val artist: Artist, val length: Int)
data class Album(val name: String, val tracks: List<Track>)

fun main(args: Array<String>) {
    "Beliebiger Text" % "Datei.txt"

    val bjoernsAlbums : List<Album> = arrayListOf()
    var britneySongs : List<Track> = bjoernsAlbums.flatMap {
        it.tracks.filter { it.artist.name == "Britney Spears" } }
}

