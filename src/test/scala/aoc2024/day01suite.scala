package aoc2024

import org.scalatest.funsuite.AnyFunSuite

class Day01Suite extends AnyFunSuite:
    val sample = """
    3   4
    4   3
    2   5
    1   3
    3   9
    3   3
    """.stripMargin.trim

    test("Part 1 should handle sample input correctly") {
        assert(Day01.part1(sample) == 11)
    }


    test("Part 2 should handle sample input correctly") {
        assert(Day01.part2(sample) == 31)
    }