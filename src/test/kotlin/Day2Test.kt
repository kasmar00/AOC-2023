import org.junit.jupiter.api.Test
import java.io.FileNotFoundException
import kotlin.test.assertEquals

class Day2Test {
    private val solverPart1 = Day2.Part1()
    private val solverPart2 = Day2.Part2()
    private val input = this.javaClass.getResource("/day2/input.txt")?.readText() ?: throw FileNotFoundException()

    @Test
    fun `should solve example part1`() {
        val input = """
            Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
            Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
            Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
            Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
            Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
        """.trimIndent()

        val result = solverPart1.solve(input)

        assertEquals(8, result)
    }

    @Test
    fun `should solve my example part1`() {
        val input = """
            Game 1: 1 red, 14 blue, 13 green
        """.trimIndent()

        val result = solverPart1.solve(input)

        assertEquals(1, result)
    }

    @Test
    fun `should solve for input part1`(): Unit {
        val result = solverPart1.solve(input)

        println(result)
        assertEquals(2683, result)
    }

    @Test
    fun `should solve example part2`() {
        val input = """
            Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
            Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
            Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
            Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
            Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
        """.trimIndent()

        val result = solverPart2.solve(input)

        assertEquals(2286, result)
    }

    @Test
    fun `should solve for input part2`(): Unit {
        val result = solverPart2.solve(input)

        println(result)
        assertEquals(49710, result)
    }

}