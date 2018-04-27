import de.kramhal.planetexpress.leela.Leela

import org.junit.jupiter.api.Test

internal class LeelaTest {

    @Test
    fun testFlyCrew() {
        Leela().letsFlyToThe("moon")
    }

    @Test
    fun testBeer() {
        Leela().letsDrinkABeer()
    }
}