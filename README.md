# 2018-04-26 Kotlin Präsentation JUG Görlitz

This repository contains all resources for the presentation of [Kotlin](https://kotlinlang.org/) held on 26.04.2018 at [JUG Görlitz](http://www.jug-gr.de/).

## Folder-Structure

* **reveal**: the slides itself
  * presentation were in german, so are the slides
  * content is written in Markdown, use [reveal-md](https://github.com/webpro/reveal-md) to view them: `reveal-md kotlin.md`
  * teaser-gifs are dynamically loaded from giphy, find referenced movies/tv-series within the sources as comments (use strg+u when browsing the slides)
* **gh-pages**: statically generated reveal-slides (view them [here]( http://gaerfield.github.io/2018-04-26_Kotlin_jug-gr/))
  * gh-pages/kotlin: the kotlin-presentation
  * gh-pages/raffle: the raffle-slides
  * gh-pages/index.html: entry-page with links to this repo and the slides
* **planetexpress**: Multi-Gradle-Project containing source-code-examples that were used in the slides, as well as some experiments (of course its using Kotlin-Build-Scripts)
  * **ship**:
    * type: Java
    * purpose: provides Java-code for testing calls from Kotlin to Java
  * **leela**:
    * type: Kotlin
    * depends on: ship
    * purpose:
      * does calls to Java (project ship)
      * provides Kotlin-code for testing calls to Kotlin from within other Java and Kotlin-Projects
      * contains all sources used in the slides
  * **bender**:
    * type: Java
    * depends on: leela
    * purpose: calling code Kotlin-code
  * **fry**:
    * type: Kotlin
    * depends on: leela
    * purpose: test visibility of classes/functions marked as `internal`
