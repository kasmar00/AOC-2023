import org.junit.jupiter.api.Test
import java.io.FileNotFoundException
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class Day3Test {
    private val solverPart1 = Day3.Part1()
    //    private val solverPart2 = Day2.Part2()
    private val input = this.javaClass.getResource("/day3/input.txt")?.readText() ?: throw FileNotFoundException()

    @Test
    fun `should solve example part1`() {
        val input = """
            467..114..
            ...*......
            ..35..633.
            ......#...
            617*......
            .....+.58.
            ..592.....
            ......755.
            ...${'$'}.*....
            .664.598..
        """.trimIndent()

        val result = solverPart1.solve(input)

        assertEquals(4361, result)
    }

    @Test
    fun `should solve my example part1`() {
        val input = """
            123...456
            ......%..
        """.trimIndent()

        val result = solverPart1.solve(input)

        assertEquals(456, result)
    }

    @Test
    fun `should solve reddit example part1`() {
//        source: https://www.reddit.com/r/adventofcode/comments/189q9wv/2023_day_3_another_sample_grid_to_use/
        val input = """
            ............
            12.......*..
            +.........34
            .......-12..
            ..78........
            ..*....60...
            78.........9
            .5.....23..*
            8...90*12...
            ............
            2.2......12.
            .*.........*
            1.1..503+.56
            ............
        """.trimIndent()

        val result = solverPart1.solve(input)

        assertEquals(925, result)
    }

    @Test
    fun `should solve for input part1`() {
        val result = solverPart1.solve(input)

        println(result)
//        assertEquals(552671, result)
        assert(552671 > result)
        assert(549292 < result)
        assertNotEquals(550918, result)
    }
}