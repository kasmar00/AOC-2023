import org.junit.jupiter.api.Test
import java.io.FileNotFoundException
import kotlin.test.assertEquals

class Day4Test {
    private val solverPart1 = Day4.Part1()
    private val solverPart2 = Day4.Part2()
    private val input = this.javaClass.getResource("/day4/input.txt")?.readText() ?: throw FileNotFoundException()

    @Test
    fun `should solve example part1`() {
        val input = """
            Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
            Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19
            Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1
            Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83
            Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36
            Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11
        """.trimIndent()

        val result = solverPart1.solve(input)

        assertEquals(13, result)
    }

    @Test
    fun `should solve for input part1`() {
        val result = solverPart1.solve(input)

        assertEquals(23847, result)
    }

    @Test
    fun `should solve example part2`() {
        val input = """
            Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
            Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19
            Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1
            Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83
            Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36
            Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11
        """.trimIndent()

        val result = solverPart2.solve(input)

        assertEquals(30, result)
    }

    @Test
    fun `should solve my example part2`() {
        val input = """
            Card 1: 1 2 | 1 2
            Card 2: 1 2 | 3 4
            Card 3: 1 2 | 3 4
        """.trimIndent()

        val result = solverPart2.solve(input)

        assertEquals(5, result)
    }

    @Test
    fun `should solve for input part2`() {
        val result = solverPart2.solve(input)

        assertEquals(8570000, result)
    }
}