import java.lang.Integer.max
import java.lang.Integer.min

open class Day3 {

    class Part1 : Day3() {
        fun solve(input: String): Int {
            val split = input.trim().split("\n")
            return solve(split)
            /*
            split.forEachIndexed { lineNumber, line ->
                var currentNumber = 0
                var startOfCurrentNumber = -1
                var endOfCurrentNumber = -1
                line.forEachIndexed { charIndex, char ->
                    if (char.isDigit()) {
                        if (currentNumber == 0) {
                            startOfCurrentNumber = charIndex
                        }
                        currentNumber = currentNumber * 10 + char.digitToInt()

                    } else {
                        endOfCurrentNumber = charIndex - 1
                        if (currentNumber != 0 && checkForAdjacentSymbols(
                                split,
                                lineNumber,
                                startOfCurrentNumber,
                                endOfCurrentNumber
                            )
                        ) {
                            println(currentNumber)
                            println()
                            answer += currentNumber
                        }
                        currentNumber = 0
                        endOfCurrentNumber = -1
                        startOfCurrentNumber = -1
                    }
                }

//                if (currentNumber!=0 && checkForAdjacentSymbols(split, lineNumber, startOfCurrentNumber, endOfCurrentNumber))
            }
            return answer

             */
        }

        private fun solve(full: List<String>): Int =
            full.map { parse(it) }
                .mapIndexed { lineNumber, numbers ->
                    numbers.filter { checkForAdjacentSymbols2(full, lineNumber, it.position) }
                        .map { it.value }
                        .toList().sum()
                }.sum()
    }

    /*
        fun checkForAdjacentSymbols(text: List<String>, lineNumber: Int, startOfNumber: Int, endOfNumber: Int): Boolean =
            checkForAdjacentSymbols(text, lineNumber, startOfNumber..endOfNumber)
    */

    fun checkForAdjacentSymbols(text: List<String>, lineNumber: Int, range: IntRange): Boolean {
        for (char in range.first - 1..range.last + 1) {
            for (line in lineNumber - 1..lineNumber + 1) {
                if (line >= 0 && char >= 0 && line < text.size && char < text[0].length)
                    text[line][char].let { char ->
                        if (!char.isDigit() && char != '.')
                            return true.also {
                                val range = max(range.first - 1, 0)..min(range.last + 1, text[0].length)
                                runCatching {
                                    println(
                                        "char: $char\n"
                                                + "prev: ${text[lineNumber - 1].subSequence(range)}\n"
                                                + "curr: ${text[lineNumber].subSequence(range)}\n"
                                                + "next: ${text[lineNumber + 1].subSequence(range)}"
                                    )
                                }
                            }
                    }
            }
        }
        return false
    }

    fun checkForAdjacentSymbols2(text: List<String>, lineNumber: Int, range: IntRange): Boolean {
        for (line in lineNumber - 1..lineNumber + 1) {
            for (char in range.first - 1..range.last + 1) {
                checkIfSymbol(text, line, char).let {
                    if (it) return true.also {
//                        val range = max(range.first - 1, 0)..min(range.last + 1, text[0].length)
//                        runCatching {
//                            println(
//                                "Check for: linenum: $lineNumber, range: $range\n"
//                                        + "prev: ${text[lineNumber - 1].subSequence(range)}\n"
//                                        + "curr: ${text[lineNumber].subSequence(range)}\n"
//                                        + "next: ${text[lineNumber + 1].subSequence(range)}"
//                            )
//                        }
                    }
                }
            }
        }

        val range = max(range.first - 1, 0)..min(range.last + 1, text[0].length)
        runCatching {
            println(
                "Check for: linenum: $lineNumber, range: $range\n"
                        + "prev: ${text[lineNumber - 1].subSequence(range)}\n"
                        + "curr: ${text[lineNumber].subSequence(range)}\n"
                        + "next: ${text[lineNumber + 1].subSequence(range)}"
            )
        }
        return false
    }

    private fun checkIfSymbol(text: List<String>, lineNumber: Int, charNumber: Int) =
        if (lineNumber >= 0 && charNumber >= 0 && lineNumber < text.size && charNumber < text[0].length)
            text[lineNumber][charNumber].let {
                it != '.' && !it.isDigit()
            }
        else false


    fun parse(line: String) =
        Regex("[1-9]\\d*")
            .findAll(line)
            .map { Number(it.value.toInt(), it.range) }

    data class Number(val value: Int, val position: IntRange)
}
//better solution: https://www.reddit.com/r/adventofcode/comments/189p6qt/comment/kbuc033/?utm_source=share&utm_medium=web3x&utm_name=web3xcss&utm_term=1&utm_content=share_button
