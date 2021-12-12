package aoc21.day1

import java.io.File

const val FILE_PATH = "src/aoc21/day1/input.txt"

fun getDepths() = File(FILE_PATH).readLines().map { it.toInt() }

var totalIncrements = 0

fun main() {
    val list = getDepths()
    list.forEachIndexed { index, i ->
        if (index != 0 && list[index - 1] < i)
            totalIncrements++
    }

    val sequence = list.asSequence()
    // alternate approach
    val incrementCountWithStepOne = sequence.windowed(2, 1) { (first, second) ->
        first < second
    }.count { it }

    println("======== Part 1 ========")
    println(totalIncrements)
    println("alternate approach with sequences and windows")
    println(incrementCountWithStepOne)


    val incrementWithStepThree = sequence
        .windowed(3, 1) { (first, second, third) ->
            first + second + third
        }.windowed(2, 1) { (firstWindowSum, secondWindowSum) ->
            firstWindowSum < secondWindowSum
        }.count { it }

    println("======== Part 2 ========")
    print(incrementWithStepThree)
}