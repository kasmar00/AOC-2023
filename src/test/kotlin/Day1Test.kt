import org.junit.jupiter.api.Test
import java.io.FileNotFoundException
import kotlin.test.assertEquals

class Day1Test {

    private val solver = Day1()
    private val input = this.javaClass.getResource("/day1/input.txt")?.readText() ?: throw FileNotFoundException()

    @Test
    fun `should calculate correctly for example`() {

        val example = """
            1abc2
            pqr3stu8vwx
            a1b2c3d4e5f
            treb7uchet
        """.trimIndent()

        val result = solver.answer(example) { solver.calculateCalibrationValue(it) }

        assertEquals(142, result)
    }

    @Test
    fun `calculate for puzzle`() {
        val result = Day1().answer(input) { Day1().calculateCalibrationValue(it) }

        println(result)
    }

    @Test
    fun `should calculate correctly for example part 2`() {

        val example = """
            two1nine
            eightwothree
            abcone2threexyz
            xtwone3four
            4nineeightseven2
            zoneight234
            7pqrstsixteen
        """.trimIndent()

        val result = solver.answer(example) { solver.calculateCalibrationPart2(it) }

        assertEquals(281, result)
    }

    @Test
    fun `should calculate correctly part 2`() {
        val example = """
            oneight
            sevenine
        """.trimIndent()

        val result = solver.answer(example) { solver.calculateCalibrationPart2(it) }

        assertEquals(18 + 79, result)
    }

    @Test
    fun `calculate for puzzle part 2`() {
        val result = Day1().answer(input) { Day1().calculateCalibrationPart2(it) }

        assertEquals(54676, result)
        println(result)
    }

}

