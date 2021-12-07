package main.kotlin

import java.io.File

private val regex = Regex("^([0-9][0-9]?)-([0-9][0-9]?) ([a-z]): ([a-z]*)")

fun main() {
    val lines = File("src/main/input/day2.txt").readLines()

    partOne(lines)
    partTwo(lines)
}

private fun partOne(lines: List<String>) {
    val result = lines.count { line ->
        val (rangeMin, rangeMax, policy, password) = regex.find(line)?.destructured ?: return@count false
        return@count IntRange(rangeMin.toInt(), rangeMax.toInt()).contains(password.count { policy.contains(it) })
    }
    println("Result part 1 $result")
}

private fun partTwo(lines: List<String>) {
    val result = lines.count { line ->
        val (firstPosition, secondPosition, policy, password) = regex.find(line)?.destructured ?: return@count false
        val policyChar = policy.single()
        val firstItemToCheck = password[firstPosition.toInt() - 1]
        val secondItemToCheck = password[secondPosition.toInt() - 1]
        return@count firstItemToCheck == policyChar && secondItemToCheck != policyChar
                || firstItemToCheck != policyChar && secondItemToCheck == policyChar
    }
    println("Result part 2 $result")
}