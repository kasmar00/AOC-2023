import java.lang.IllegalStateException

class Day1 {


    fun calculateCalibrationValue(line: String): Int {
        val digits = line.filter { it.isDigit() }
        return digits.first().digitToInt() * 10 + digits.last().digitToInt()
    }

    fun answer(file: String, processor: (String) -> Int): Int =
        answer(file.trim().split("\n"), processor)

    private fun answer(file: List<String>, processor: (String) -> Int): Int =
        file
            .parallelStream()
            .map { processor(it) }
            .toList().sum()

    fun calculateCalibrationPart2(line: String): Int {
        fun String.substitution() = this.replace(Regex("(one|two|three|four|five|six|seven|eight|nine)")) { it ->
            when (it.value) {
                "one" -> "1"
                "two" -> "2"
                "three" -> "3"
                "four" -> "4"
                "five" -> "5"
                "six" -> "6"
                "seven" -> "7"
                "eight" -> "8"
                "nine" -> "9"
                else -> throw IllegalStateException("Unsupported digit: ${it.value}")
            } + it.value.drop(1)
        }

        val replaced = line.substitution().substitution()
        return calculateCalibrationValue(replaced)
    }
}