package aoc2024

object Day01:
  def parse(input :String): List[List[Int]] =
    input.split("\n").map(_.split(" ").filter(_ != "").map(_.toInt).toList).toList.transpose.map(_.sorted)

  def part1(input: String): Int = 
        val sorted = parse(input)
        (sorted(0) zip sorted(1)).map(x => (x._1 - x._2).abs).sum

  def part2(input: String): Int = 
        val sorted = parse(input)
        val count_dict = sorted(1).groupBy(l => l).map(t => (t._1, t._2.length))
        sorted(0).map(x => x * count_dict.getOrElse(x,0)).sum

  def main(args: Array[String]): Unit = 
        val data = io.Source.fromResource("aoc2024/day01.txt").mkString
        println(data)
        println(part1(data))
        println(part2(data))

