package aoc2024

import org.scalatest.funsuite.AnyFunSuite

class Day02Suite extends AnyFunSuite:
    val sample = """
    7 6 4 2 1
    1 2 7 8 9
    9 7 6 2 1
    1 3 2 4 5
    8 6 4 4 1
    1 3 6 7 9
    2 6 1
    57 56 57 59 60 63 64 65
    91 92 95 93 94
    16 13 15 13 12 11 9 6
    40 41 43 44 47 46 47 49
    1 1 4 5 7 8
    """.stripMargin.trim

    test("Part 1 should handle sample input correctly") {
        assert(Day02.part1(sample) == 2)
    }


    test("Part 2 should handle sample input correctly") {
        assert(Day02.part2(sample) == 10)
    }