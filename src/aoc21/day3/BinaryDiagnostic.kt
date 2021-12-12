package aoc21.day3

import java.io.File
import kotlin.math.ceil


val onesCount = generateSequence { 0 }.take(getLines().first().length).toMutableList()

const val FILE_PATH = "src/aoc21/day3/input.txt"

fun getLines() = File(FILE_PATH).readLines()

fun getPowerConsumption(): Int {

    val halfOfTotalLines = ceil(getLines().size / 2.0).toInt()

    fun countOnesInEachColumn() {
        getLines().forEach { line ->
            line.forEachIndexed { index, c ->
                if (c == '1') onesCount[index]++
            }
        }
    }

    countOnesInEachColumn()

    val gamma = onesCount.map { if (it >= halfOfTotalLines) 1 else 0 }.joinToString(separator = "").toInt(2)
    val epsilon = onesCount.map { if (it < halfOfTotalLines) 1 else 0 }.joinToString(separator = "").toInt(2)

    return gamma * epsilon
}

fun main() {
    println(getPowerConsumption())
}

