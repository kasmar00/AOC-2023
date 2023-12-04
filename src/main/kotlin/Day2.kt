import java.lang.Integer.max

abstract class Day2 {

    fun solve(input: String) =
        solve(
            input.trim().split("\n")
        )

    @JvmName("solve1")
    fun solve(input: List<String>) =
        solve(input.map { parse(it) })

    protected abstract fun solve(input: List<Game>): Int

    class Part1 : Day2() {

        private val allowedColorCounts = mapOf(
            "red" to 12,
            "green" to 13,
            "blue" to 14
        )

        override fun solve(input: List<Game>): Int =
            input
                .filter { isGamePossible(it) }
                .map { it.gameId }
                .toList()
                .sum()

        private fun isGamePossible(game: Game): Boolean =
            game.reveals.all { isRevealPossible(it) }
                .also { println("$it for $game") }

        private fun isRevealPossible(reveal: Map<String, Int>): Boolean =
            reveal.entries.all { it.value <= (allowedColorCounts[it.key] ?: Int.MIN_VALUE) }
                .also { println("$it for $reveal") }
    }

    class Part2 : Day2() {
        override fun solve(input: List<Game>) =
            input
                .map { power(it) }
                .toList()
                .sum()

        private fun power(game: Game): Int {
            val minimums = mutableMapOf<String, Int>()
            game.reveals
                .forEach { reveal ->
                    reveal.entries.forEach {
                        minimums[it.key] = max(minimums[it.key] ?: 0, it.value)
                    }
                }
            return minimums.values.fold(1){a,b -> a*b}
        }

    }

    private fun parse(line: String): Game {
        with(line.split(":")) {
            val gameId = this[0].split(" ")[1].toInt()
            val reveals = this[1].split(";").map { parseReveal(it) }
            return Game(gameId, reveals)
        }
    }

    private fun parseReveal(reveal: String) =
        reveal.split(",")
            .map { it.trim().split(" ") }
            .associate { it[1] to it[0].toInt() }

    data class Game(val gameId: Int, val reveals: List<Map<String, Int>>)
}
