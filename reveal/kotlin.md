---
title: Kotlin
separator: <!--s-->
verticalSeparator: <!--v-->
theme: solarized
highlight-theme: monokai
css: custom.css
revealOptions:
  controls: false
  slideNumber: false
  transition: 'slide'
  backgroundTransition: 'fade'
---

<!-- Alle gennanten Personen sind frei erfunden, und jegliche Ähnlichkeit mit lebenden oder realen Personen sind rein zufällig. -->
# Kotlin

<!--s-->
<!-- .slide: data-background="https://media.giphy.com/media/eekKdgXhvESIM/giphy.gif"-->
# Commercials

<!--v-->
# Eudemonia Solutions AG
* [Eudemonia Solutions AG](https://www.eudemonia-solutions.de/) 2002 gegründet
* Haupsitz Düsseldorf, zweite Betriebsstätte Magdeburg
* Informationssysteme für den Finanzsektor
* agile Entwicklung hauptsächlich im JaveEE-Umfeld

<!--s-->
# Was ist Kotlin?

<!--v-->
## Kotlin ist
* eine Programmiersprache
* objektorientiert
* funktional

<!--v-->
## Kotlin ist
Interoperabel mit Java
* Mischsprachige Java+Kotlin-Projekte
* Aufruf von Java-Libraries aus Kotlin-Code heraus
* Aufruf von Kotlin-Libraries aus Java-Code heraus

<!--v-->
## Kotlin ist
production-ready
* Entwickler: JetBrains
* in Entwicklung seit 2010
* Version 1.0 seit 2016
* unter Apache2 - Lizenz

<!--v-->
## Kotlin
läuft auf
* JVM
* Android (denn Bytecode ist Java6-kompatibel)
* im Browser (Compile nach JavaScript)
* **native** (über LLVM-Backend)

<!--v-->
## Warum ...
... noch eine JVM-Sprache?
* Syntax ist Java um 10 Jahre vorraus
* Code ist präziser, kompakter, einfacher!
* entwickelt mit Fokus für industriellen Einsatz:
  * Stabilität
  * Performance
  * Interoperabelität

<!--v-->
## Kotlin kann ...
* Extension functions <span class="fragment" data-fragment-index="2">(geklaut aus C#)</span>
* Builder <span class="fragment" data-fragment-index="3">(geklaut aus Groovy)</span>
* Operator Overloading <span class="fragment" data-fragment-index="4">(geklaut aus C)</span>
* Lambdas <span class="fragment" data-fragment-index="5">(Python, C#, LISP, Perl, ...)</span>
* Delegation <span class="fragment" data-fragment-index="6">(wahrscheinlich auch geklaut)</span>
* default non-null und Nullable-Operator '`?`'
* implizite Typisierung
* data classes (value types)
* Semikolons sind optional <!-- .element: class="fragment" data-fragment-index="8" -->
* Coroutines, Inline Functions, usw. ... <!-- .element: class="fragment" data-fragment-index="7" -->

<!--s-->
<!-- .slide: data-background="https://media.giphy.com/media/zXmbOaTpbY6mA/giphy.gif"-->
<!-- Matrix -->
# `c0d3 p0rn`

<!--s-->
<!-- .slide: data-background="https://media.giphy.com/media/4uFHKBxeuecP6/giphy.gif"-->
<!-- Star Wars irgendwas -->
## Basics

<!--v-->
## Hello World
```java
fun main(args : Array<String>) {
  println("Hello World")
}
```

<!--v-->
## Hello World
```java
fun main(args : Array<String>) {
  println("""|-| 3 |_ |_ 0 - \\/\\/ 0 |2 |_ |)""")
}
```
=> `|-| 3 |_|_ 0 - \\/\\/ 0 |2 |_ |)`

<!--v-->
## Hello World
```java
"\\d{2}\\.\\d{2}\\.\\d{4}"
"""\d{2}\.\d{2}\.\d{4}"""
```

<!--v-->
## Variablen-Definition
```
val zahl = 1 //immutable
zahl = 2 // B00M (Compile-Error)
var andereZahl = 3
andereZahl = 4 // ok
```

<!--v-->
## String Templates
```
val x=5
val y=3
println("$x+$y=${x+y}")
```
5+3=8

<!--v-->
## Methoden
```
fun add(x : Int, y : Int) : Int {
  return x+y
}
```
```
fun add(x : Int, y : Int) : Int = x+y
```
<!-- .element: class="fragment" -->
```
fun add(x : Int, y : Int) = x+y
```
<!-- .element: class="fragment" -->

<!--s-->
<!-- .slide: data-background="https://media.giphy.com/media/7Hiszs0NkF5te/giphy.gif"-->
<!-- Fight Club -->
## Named Parameters

<!--v-->
## Übrigens
Alle gennanten Personen und Orte sind frei erfunden, und jegliche Ähnlichkeit mit lebenden oder realen Personen sind rein zufällig.

<!--v-->
## Named Parameters
```
fun printGörliwoodMayor(name : String, age : Int = 0,
                   salary : Double = 0.0) =
        println("$name is $age and earns $salary GU (Goldunzen)")
```

```
printGörliwoodMayor("Demiani", 47, 3000.00)
```

<!-- .element: class="fragment" -->
Demiani is 47 and earns 3000.0 GU (Goldunzen) <!-- .element: class="fragment" -->
```
printGörliwoodMayor(3000.00, "Demiani", 47)
```
<!-- .element: class="fragment" -->
B00M <!-- .element: class="fragment" -->

```
printGörliwoodMayor(age = 47, name = "Demiani", salary = 3000.0)
```
<!-- .element: class="fragment" -->

<!--v-->
## Named Parameters
```
fun printGörliwoodMayor(name : String, age : Int = 0,
                   salary : Double = 0.0) =
        println("$name is $age and earns $salary GU (Goldunzen)")
```
```
printGörliwoodMayor(name ="Georg Snay", age = 45)
```
"Georg Snay is 32 and earns 0.0 GU (Goldunzen)" <!-- .element: class="fragment" -->
```
printGörliwoodMayor(9000.0)
```
<!-- .element: class="fragment" -->
B00M <!-- .element: class="fragment" -->

<!--s-->
<!-- .slide: data-background="https://media.giphy.com/media/rIq6ASPIqo2k0/giphy.gif"-->
<!-- Star Trek -->
## data class

<!--v-->
## data class
```
data class Hacker(var name: String, val email: String,
   val company: String)
val marle = Hacker("Marlene", "marle@jug-gr.de", "JUG-Gr")
println(marle.name) // prints "Marlene"
```
* POJO-One-Liner
* enthält: getters, setters, equals(), hashCode(), toString() und copy()

```
marle.email = marle@zgorzelec.de
```
<!-- .element: class="fragment" -->
B00M
<!-- .element: class="fragment" -->
```
marle.copy(email = "marle@zgorzelec.de")
```
<!-- .element: class="fragment" -->
OK
<!-- .element: class="fragment" -->

<!--s-->
<!-- .slide: data-background="https://media.giphy.com/media/2l95D5QEQSACI/giphy.gif"-->
<!-- wahrscheinlich Godzilla? -->
## Destructuring

<!--v-->
## Destructuring
```
data class Hacker(var name: String, val email: String,
   val company: String)

val marle = Hacker("Marlene", "marle@zgorzelec.de", "JUG-Gr")
val (name, email, company) = marle
println(name)
```
<span class="fragment">"Marlene"</span>
<span class="fragment"> WHAAAAA...? </span>

```java
val (email, company, name) = marle
println(name)
```
<!-- .element: class="fragment" -->
<span class="fragment">"JUG-Gr"</span>
<span class="fragment"> WHAAAAA...?</span>

<!--v-->
## Destructuring
```
data class Hacker(var name: String, val email: String,
                  val company: String)
val (name, email, company) = marle
// ist äquivalent mit
val name = marle.component1()
val email = marle.component2()
val company = marle.component3()
```
```java
val (name, company) = marle
```
<!-- .element: class="fragment" -->
OK
<!-- .element: class="fragment" -->
```java
val (email, company, name, var4) = marle
```
<!-- .element: class="fragment" -->
B00M
<!-- .element: class="fragment" -->

<!--v-->
## Destructuring
```
public Tuple<String, Boolean> login() {...}

Tuple<String, Boolean> ret = login();
String leftKeineAhnung = ret.getLeft();
Boolean rightPffWerWeiß = ret.getRight();
```
<span class="fragment">Ich **hasse** Tupel-Datentypen </span>
```
data class User(val name: String, val loginSuccessful: Boolean)
fun login() : User {...}
val (name, loggedIn) = login()
```
<!-- .element: class="fragment" -->


<!--s-->
<!-- .slide: data-background="https://media.giphy.com/media/UC2YONbKL9ZwA/giphy.gif"-->
## Klassen

<!--v-->
## primary constructors
```
class Chocolaine(
  makeItIrresistible : Boolean, val blendedByMilk: Double = 0.3)
```
```
class Chocolaine public @Inject constructor(
  makeItIrresistible : Boolean, val blendedByMilk: Double = 0.3)
```
<!-- .element: class="fragment" -->
```
val schokki = Chocolaine(true)
if(schokki.makeItIrresistible)
  println(schokki.blendedByMilk)
```
<!-- .element: class="fragment" -->
B00M - Aber warum? <!-- .element: class="fragment" -->

<!--v-->
## secondary constructors
```
class Chocolaine(
  makeItIrresistible : Boolean, val blendedByMilk: Double = 0.3) {
    var label = "Chocolaine"
    val ingredients : MutableMap<String, Double> = mutableMapOf()

    constructor(label : String) : this(false, 0.5) {
        this.label = label
    }
    fun info() = println("$label = $ingredients")
}
```
```
Chocolaine(true).info()
Chocolaine("DieLilaKuh").info()
```
<!-- .element: class="fragment" -->
```
Chocolaine = {milk=0.3, chocolate=0.69, secret=0.01}
DieLilaKuh = {milk=0.5, chocolate=0.7}
```
<!-- .element: class="fragment" -->

<!--v-->
## init-Blöcke
```
/** Chocolaine: as good as good 'ol fashioned coke */
class Chocolaine(
  makeItIrresistible : Boolean, val blendedByMilk: Double = 0.3) {
    var label = "Chocolaine"
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
    } /* ... */
```

<!--v-->
## init-Blöcke
```
class Chocolaine(
  makeItIrresistible : Boolean, val blendedByMilk: Double = 0.3) {
    var label = "Chocolaine".also(::println)
    val ingredients : MutableMap<String, Double> = mutableMapOf()

    init { println("Get to Work") /* ... */ }
    constructor(label : String) : this(false, 0.5) {
      println("2nd constructor") /* ... */}
    var extendedlabel =
      "$label - ${blendedByMilk*100}% milk".also(::println)
    init { println("init#2") }
    fun info() = println("$label = $ingredients")
}
Chocolaine("Milka").info()
```
```
Chocolaine
Get to Work
Chocolaine - 50.0% milk
init#2
secondary constructor
Milka = {milk=0.5, choco=0.5}
```
<!-- .element: class="fragment" -->

<!--s-->
<!-- .slide: data-background="https://media.giphy.com/media/3o6Mbc2vQcJfLyMNy0/giphy.gif"-->
<!-- Simpsons -->
## smart-casts

<!--v-->
## Typprüfung
```
if(obj is String)
  println(obj)
if(obj !is String)
  println("kein String")
```
'`is`' ist der '`instanceof`'-Operator Kotlins

<!--v-->
## smart-casts
```
fun demo(x : Any) {
    if (x is String)
        println(x.length)
}
```
smart-cast in einen String
```
if(x !is String)
  return
println(x.length)
```
<!-- .element: class="fragment" data-fragment-index="1" -->
ebenfalls smart-cast in einen String
<!-- .element: class="fragment" data-fragment-index="1" -->
```
if(x !is String || x.length == 0) {...}
if(x is String && x.length > 0) {...}
```
<!-- .element: class="fragment" data-fragment-index="2" -->
rechtseitiger smart-cast in 'if()'-Blöcken
<!-- .element: class="fragment" data-fragment-index="2" -->

<!--v-->
## when
```
when(x) {
  is String -> print("ist ein String")
  is Int -> print("ist Zahl")
  else -> print("keine Ahnung")
}
```
'when' ersetzt den 'switch'-Operator
<!-- .element: class="fragment" -->
```
when (x) {
    in 1..10 -> print("...")
    in isValidNumber(x) -> print("...")
    else -> print("...")
}
```
<!-- .element: class="fragment" -->

<!--v-->
## explizite casts
```
val x = y as String
```
unsafe cast: wirft evtl. eine Exception (bspw. when y '`null`' ist)
```
val x = y as? String
```
safe cast: x ist null, falls y kein String ist

<!--s-->
<!-- .slide: data-background="https://media.giphy.com/media/l2JdYkTPVG9gRbvhK/giphy.gif"-->
<!-- schon wieder Simpsons -->
## Nullables

<!--v-->
## Nullables
```
Optional<Integer> result = findMaxAgeInMillis(emptyCollection);
```
* Optionals sind Kompromiss zum Null-Handling
* in Kotlin stattdessen sprachinhärente Variante '`?`'

<!--v-->
## Nullables
```
val result? = findMaxAgeInMillis(emptyCollection);
```
* Kotlin ausgelegt auf die Eliminierung von NPE's
* mögl. Ursachen sind nur:
  * expliziter Aufruf von '`throw NullPointerException()`'
  * Nutzung des '`!!`'-Operators
  * externer Java-Code wirft eine NPE
  * Dateninkonsistenzen während der Initialisierung

<!--v-->
## Nullables
```
val b : String = null
```
B00M <!-- .element: class="fragment" -->
```
val b : String? = null
val c : String = b
```
<!-- .element: class="fragment" -->
B00M: c ist nicht nullable <!-- .element: class="fragment" -->
```
fun findMaxAgeInMillis(set : Set<Integer>?) : Integer? {...}
var c : Integer = findMaxAgeInMillis(Collections.emptySet())
```
<!-- .element: class="fragment" -->
B00M
<!-- .element: class="fragment" -->

<!--v-->
## dereferenzieren von Nullables
```
var manuel :String? = "trinkt Bier"
var laenge = manuel.length
```
B00M: "Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type String?"
<!-- .element: class="fragment" -->
```
var laenge = if (manuel != null) manuel.length else -1
```
<!-- .element: class="fragment" -->
OK <!-- .element: class="fragment" -->
```
var laenge : Int? = manuel?.length // länge oder null
```
<!-- .element: class="fragment" -->
OK <!-- .element: class="fragment" -->

<!--v-->
## dereferenzieren von Nullables

```
var manuel :String? = "trinkt Bier"
var laenge : Int = manuel?.length ?: -1 // länge oder -1
```
<!-- .element: class="fragment" -->
OK ('?:' Elvis-Operator) <!-- .element: class="fragment" -->

```
manuel = null
var laenge = manuel!!.length
```
<!-- .element: class="fragment" -->
OK (wirft aber garantiert eine NPE) <!-- .element: class="fragment" -->
```
var grandPaOfJesus : String? = jesus?.papa?.papa?.name
```
<!-- .element: class="fragment" -->
OK (grandPaOfJesus ist null) <!-- .element: class="fragment" -->

<!--s-->
<!-- .slide: data-background="https://media.giphy.com/media/F7enXW5ijlgC4/giphy.gif"-->
<!-- Ghost in the Shell (Movie 1995) -->
## Extension Functions

<!--v-->
## Extension Functions
Erweiterung bestehender Klassen ohne die Notwendigkeit einer Vererbung oder des Decorator-Patterns.

<!--v-->
## Extension Functions
```
class Tobi {
    fun wife() = "Saskia"
}

fun Tobi.firma() = "Eudemonia Solutions AG"

val tobi = Tobi()
println(tobi.firma())
```
"Eudemonia Solutions AG"
<!-- .element: class="fragment" -->
```
fun Tobi.wife() = this.firma() // ätsch!
println(tobi.wife())
```
<!-- .element: class="fragment" -->
"Saskia"
<!-- .element: class="fragment" -->
<span class="fragment">WHAAAAA ...!?</span>
<p class="fragment">Bei gleicher Signatur gewinnt immer der Member!</p>

<!--v-->
## Warum Method-Extensions?
```
class StringUtils {
    fun isEmpty(s : String?) = s==null || s.trim() == ""
}
fun String?.isEmpty() = (this == null || this.trim() == "" )
```
Code-Completion direkt am Typ
<!-- .element: class="fragment" -->
```
fun Any?.toString() : String =
  if (this == null) "null" else toString()
```
<!-- .element: class="fragment" -->
<span class="fragment">rekursiver Aufruf von toString()?</span>
<p class="fragment">Nein, denn smart-cast von 'Any?' auf 'Any'</p>

<!--s-->
<!-- .slide: data-background="https://media.giphy.com/media/l2Je4zlfxF6z0IWZi/giphy.gif"-->
<!-- immer diese Simpsons -->
## Operator Overloading

<!--v-->
## Operator Overloading
```
data class Point(val x : Int,val y : Int)
operator fun Point.inc() = Point(x+1,y+1)
operator fun Point.dec() = Point(x-1,y-1)

fun main(args: Array<String>) {
    var p = Point(3,4)
    println("$p inc = ${++p}")
    println("$p dec = ${--p}")
}
```
Point(x=3, y=4) inc = Point(x=4, y=5) <br/>
Point(x=4, y=5) dec = Point(x=3, y=4)

* [Operator Overloading Doc](https://kotlinlang.org/docs/reference/operator-overloading.html)

<!--v-->
## Beispiel: Sets
```
val tobiMag = setOf("Kuchen","Kotlin","Parkour")
val saskiaMag = setOf("Basteln","Tokio Hotel","Kuchen")
```
```
println(tobiMag + saskiaMag)
```
<!-- .element: class="fragment" -->
[Kuchen, Kotlin, Parkour, Basteln, Tokio Hotel]
<!-- .element: class="fragment" -->
```
println(tobiMag - saskiaMag)
```
<!-- .element: class="fragment" -->
[Kotlin, Parkour]
<!-- .element: class="fragment" -->
```
println( (tobiMag+saskiaMag)-(saskiaMag-tobiMag)-(tobiMag-saskiaMag) )
```
<!-- .element: class="fragment" -->
[Kuchen]
<!-- .element: class="fragment" -->

<!--v-->
## Beispiel: '..' Bereichsdefinition
```
data class Point(val x : Int,val y : Int)
```
```
for(point in Point(1,2)..Point(4,5))
  println(point)
```
<!-- .element: class="fragment" data-fragment-index="1" -->
```
(Point(1,2)..Point(4,5)).forEach { println(it) }
```
<!-- .element: class="fragment" data-fragment-index="1" -->
Iteration über ein Punktebereich
<!-- .element: class="fragment" data-fragment-index="1" -->
```
operator fun Point.rangeTo(other: Point) = TwoDim(this, other)
class TwoDim(val start: Point, val end: Point): Iterable<Point>{
    override fun iterator(): Iterator<Point>=PointIterator(this)
}
class PointIterator(val field: TwoDim) : Iterator<Point> { ... }
```
<!-- .element: class="fragment" data-fragment-index="2" -->

<!--v-->
## Operator Overloading
```
operator fun String.compareTo(file : String) : Int {
    File(file).writeText(this);
    return 0
}
```
```
"Beliebiger Text" > "Dateiname.txt"
```
<!-- .element: class="fragment" -->
liefert false
<!-- .element: class="fragment" -->
```
operator fun String.rem(file : String) : Int { ... }
"Beliebiger Text" % "Dateiname.txt"
```
<!-- .element: class="fragment" -->
lääääääääuft
<!-- .element: class="fragment" -->
<!--s-->
<!-- .slide: data-background="https://media.giphy.com/media/Z47Ar9QWXkQg/giphy.gif"-->
<!-- nu ist aber langsam Schluss mit Simpsons! -->
## Lambdas

<!--v-->
## Lambdas

```
val orderByGuest = mapOf<String, String>(
  "Marle" to "Radler", "Manuel" to "RichtigesBier",
  "Tobi" to "Chardonnay")
orderByGuest.forEach { guest, order -> println("$guest=$order") }
```
* '{[Parameter] -> [Anweisungsrumpf]}'
```
orderByGuest.forEach { println("${it.key}=${it.value}") }
```
* Impliziter Name 'it' für Einzelparameter
```
orderByGuest.forEach { _, order -> println("$order") }
```
* unnötige Parameter durch Unterstrich '`_`' markieren

<!--v-->
## Lambdas
```
data class Artist(val name: String)
data class Track(val name: String, val artist: Artist,
  val length: Int)
data class Album(val name: String, val tracks: List<Track>)
```
```
var megaHitsLenghts : Map<String,Int> = ronnysAlbums.
  filter { it.name.matches(Regex(".*MegaHits.*")) }.
  map { it.name to it.tracks.map(Track::length).sum() }.
  toMap()
```
<!-- .element: class="fragment" -->
```
var britneySongs : List<Track> = ronnysAlbums.flatMap {
  it.tracks.filter { it.artist.name == "Britney Spears" } }
```
<!-- .element: class="fragment" -->

<!--v-->
## higher order functions
```
private fun anyoneElse(lambda : () -> Unit) = lambda()
private fun buildSomeLambda(a: Int, b: Int) : () -> Int = {a+b}
private fun lock(l : Lock, lambda : () -> Any) : () -> Any = {
    l.lock()
    try { return lambda.invoke() }
    finally { l.unlock() }
}

anyoneElse { println("${6+5}") }
println( buildSomeLambda(6,5).invoke() )
val myLock : Lock = ReentrantLock()
println( lock(myLock) { 6+5 }() )
println( lock(myLock, { 6+5 }).invoke() )
```

<!--v-->
## inline functions
```
inline fun <T> lock2(lock: Lock, body: () -> T): T {
    lock.lock()
    try { return body() }
    finally { lock.unlock() }
}
```
* Einbettung der Lambda-Funktion selbst **und** der übergebenen Lambdas beim Aufrufer
* kompilierter Code wächst, aber Laufzeit-Overhead verringert sich

<!--v-->
## inline functions
```
fun containsZeros(list:List<Int>) {
   ints.forEach{ if(it == 0) return true; }
   return false;
}
```
* early returns gehen nur bei inline-functions

<!--s-->
<!-- .slide: data-background="https://media.giphy.com/media/cwGbD7OgvM8uI/giphy.gif"-->
<!-- Despicable Me (1? 2? keine Ahnung) -->
## Delegated Properties

<!--v-->
## Delegated Properties
Häufig verwendete Fälle in eine Library auslagern, z.B.:
* lazy-Initialisierung
* Listener
* Variablen in einer Map statt im Property speichern
```
val/var <property name>: <Type> by <delegate>
```
<!-- .element: class="fragment" -->
<span class="fragment">**delegate**, denn: 'get()' und 'set()' werden delegiert zur Methode 'getValue()' bzw. 'setValue()'</span>

<!--v-->
## Lazy ohne lazy
```
var value: String? = null
val lazy: String
  get() {
    if (value == null)
      value = initializer()
    return value!!
  }
```

<!--v-->
## Lazy mit lazy
```
val value by lazy(initializer())
```
```
class PropertyNeedsLazyInit(doesLazyInit : () -> String) {
    val value by lazy(doesLazyInit)
}

val pnli = PropertyNeedsLazyInit(
  {print("Blubb macht der "); "Fisch"})
println("Klasse initialisiert")
println(pnli.value)
println(pnli.value)
```
<!-- .element: class="fragment" -->
<p class="fragment">
Klasse initialisiert <br/>
Blubb macht der Fisch <br/>
Fisch
</p>

<!--s-->
<!-- .slide: data-background="https://media.giphy.com/media/BhOACNoy9yyju/giphy.gif"-->
<!-- Black Books -->
## Coroutines

<!--v-->
## Coroutines
* experimentelles Feature ("kotlinx-coroutines-core")
* lang laufende Funktionen pausieren, statt Thread blockieren
* keyword "`suspend`" zum kennzeichnen langlaufender Funktionen
* pausierbare Funktionen können nur von Koroutinen gestartet werden
* library entscheidet über pausieren/fortführen von Koroutinen

<!--v-->
## Coroutines

* Koroutinen benötigen keine Threads (OS-unabhängig, keine Kontext-Switches)
* "`suspend`"-Funktionen werden durch Kotlin-Compiler in state-machine überführt
* Zustand einer schlafenden Funktion (alle Variablen, Referenzen etc.) wird gespeichert und bei Fortführung wiederhergestellt
* [kotlin - coroutines](https://kotlinlang.org/docs/reference/coroutines.html)

<!--v-->
## Coroutines
```
suspend fun drinkWine( number: Int = 0 ): Int {
  delay(3000) // Thread.sleep() ohne Blockierung des Threads
  return number
}

runBlocking { drinkWine() }
```
* oder "`launch`", "`async`"
* oder [Integration](https://github.com/Kotlin/kotlinx.coroutines/tree/master/integration) mit:
   * JDK8 (future)
   * Java NIO
   * guava (ListenableFuture)
   * Quasar

<!--s-->
<!-- .slide: data-background="https://media.giphy.com/media/nsLp2d1wMNH0s/giphy.gif"-->
<!-- Black Books -->
## Builder

<!--v-->
## Builder
```
html {
  head {
    title {+"XML encoding with Kotlin"}
  }
  body {
    h1 {+"XML encoding with Kotlin"}
    p  {+"used as an alternative markup to XML"}
    a(href = "http://kotlinlang.org") {+"Kotlin"}
    // generated content
    p {
        for (arg in args)
            +arg
    }
  }
}
```

<!--s-->
<!-- .slide: data-background="https://media.giphy.com/media/CVQfAUMEiDJqo/giphy.gif"-->
<!-- Twin Peaks -->
## Unterschiede zu Java

<!--v-->
## was es nicht gibt

* statische Attribute/Methoden
* nicht-private Felder
* ternäre Operator "a ? b : c"

<!--v-->
## was anders ist

* Null-Referenzen durch das Typsystem gesteuert
* keine raw types (int, boolean, char, ...)
* keine [checked exceptions](http://radio-weblogs.com/0122027/stories/2003/04/01/JavasCheckedExceptionsWereAMistake.html)
* Umgang mit [generischen Typen](https://kotlinlang.org/docs/reference/generics.html#use-site-variance-type-projections)

<!--v-->
## was neu ist I

* Lambdas + Inline functions
* Extension functions
* Null-safety
* Smart casts
* String templates
* Properties
* Coroutines
* Operator overloading und Range expressions
* Data classes
* implizite Typen
* kein Semikolon

<!--v-->
## was neu ist II

* Primary und secondary constructors
* delegation
* Singletons
* seperate Interfaces für read-only und mutable Collections
* internal Sichbarkeit
* Declaration-site variance & Type projections
* Companion objects
* typealias
* infix-Notation

<!--s-->
# Kotlin lernen
<!-- .slide: data-background="https://media.giphy.com/media/VgY4dDdN1W3NS/giphy.gif"-->
<!-- Friends!!! -->

<!--v-->
# Links
* [Kotlin Dokumentation](https://kotlinlang.org/docs/reference/basic-syntax.html)
* Kotlin-Koans 42 Übungen
  * [online ausprobieren](https://try.kotlinlang.org/#/Kotlin%20Koans/Introduction/Hello,%20world!/Task.kt)
  * [github](https://github.com/Kotlin/kotlin-koans)

<!--s-->
## Fragen?
<!-- .slide: data-background="https://media.giphy.com/media/AU8qGDWpDkCUE/giphy.gif"-->
<!-- Columbo -->
Bitte nur welche, die ich auch beantworten kann!<!-- .element: class="fragment" -->
