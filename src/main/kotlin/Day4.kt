import kotlin.math.pow

abstract class Day4 {

    fun solve(input: String): Int =
        solve(input.trim().split("\n"))

    abstract fun solve(full: List<String>): Int

    class Part1 : Day4() {

        override fun solve(full: List<String>): Int =
            full.map { parse(it) }
                .map { game ->
                    matching(game.winning, game.have).also { println(it) }
                }.sumOf { power(it).also { println(it) } }
    }

    class Part2 : Day4() {
        override fun solve(full: List<String>): Int {
            val games = full.map { parse(it) }
//            val scores = games.map { game -> matching(game.winning, game.have) }
            return games.mapIndexed { id, game ->
                score(id, game, games)
            }.sum()
        }

        private fun score(id: Int, thisGame: Game, games: List<Game>): Int {
            val thisGameMatching = matching(thisGame.winning, thisGame.have)
            if (thisGameMatching == 0) {
                return 1
            }

            return games.subList(id + 1, id + thisGameMatching+1).mapIndexed { subId, game ->
                score(subId + id + 1, game, games)
            }.sum()+1
        }

    }

    fun matching(winning: List<Int>, have: List<Int>) =
        have.toSet().let { have ->
            winning.filter { have.contains(it) }
        }.count()

    fun power(int: Int) =
        2.0.pow(int - 1).toInt()

    fun parse(line: String) =
        line.split(":").let {
//    val gameId = it.first().split(" ").last().toInt()
            it.last().split("|").let {
                Game(stringToListOfInts(it.first()), stringToListOfInts(it.last()))
            }
        }


    private fun stringToListOfInts(string: String) =
        string.replace("  ", " ")
            .trim()
            .split(" ")
            .map { it.toInt() }

    data class Game(val winning: List<Int>, val have: List<Int>)
}
