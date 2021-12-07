package main.kotlin

import java.io.File

fun main() {
    val lines = File("src/main/input/day1.txt").readLines()
    val expenses = lines.map(String::toInt)

    partOne(expenses)
    partTwo(expenses)
}

private fun partOne(expenses: List<Int>) {
    expenses.forEach { expense1 ->
        expenses.forEach { expense2 ->
            if (expense1 + expense2 == 2020) {
                println("Result part 1 " + expense1 * expense2)
                return
            }
        }
    }
    println("No result found")
}

private fun partTwo(expenses: List<Int>) {
    expenses.forEach { expense1 ->
        expenses.forEach { expense2 ->
            expenses.forEach { expense3 ->
                if (expense1 + expense2 + expense3 == 2020) {
                    println("Result part 1 " + expense1 * expense2 * expense3)
                    return
                }
            }
        }
    }
    println("No result found")
}