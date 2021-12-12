package aoc21.day2

import java.io.File

const val FILE_PATH = "src/aoc21/day2/input.txt"

fun getCommands() = File(FILE_PATH).readLines().map { parseCommand(it) }

fun parseCommand(command: String): Pair<String, Int> =
    command.split(" ").let { (commandString, magnitudeString) ->
        commandString to magnitudeString.toInt()
    }

fun determineFinalPosition(): Int {
    var horizontalPosition = 0
    var depth = 0
    getCommands().forEach { (command, magnitude) ->
        when (command) {
            "up" -> depth -= magnitude
            "down" -> depth += magnitude
            "forward" -> horizontalPosition += magnitude
        }
    }
    return horizontalPosition * depth
}

fun determineFinalPositionWithAim(): Int {
    var horizontalPosition = 0
    var aim = 0
    var depth = 0
    getCommands().forEach { (command, magnitude) ->
        when (command) {
            "up" -> aim -= magnitude
            "down" -> aim += magnitude
            "forward" -> {
                horizontalPosition += magnitude
                depth += aim * magnitude
            }
        }
    }
    return horizontalPosition * depth
}

fun main(){
    println("======== Part 1 ========")
    println(determineFinalPosition())
    println("======== Part 2 ========")
    println(determineFinalPositionWithAim())

}
