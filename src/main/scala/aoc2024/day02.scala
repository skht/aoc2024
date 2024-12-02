package aoc2024

object Day02:

  def predicate(x:Int) = x > -1 || x < -3

  def evaluate_line(line: List[Int]) = 
                    line.sliding(2).map(x => x(0) - x(1)).filter(predicate(_)).isEmpty match 
                        case true => 1
                        case false => 0

  def parse(input :String): List[List[Int]] =
    input.split("\n").map(_.strip.split(" ").map(_.toInt).toList).toList

  def part1(input: String): Int = 
      parse(input)
            .map( line => if(line.head - line.tail.head > 0) line.reverse else line )
            .map( evaluate_line(_))
            .sum
      
  def part2(input: String): Int = 
      parse(input)
            .map( line => if(line.sliding(2).map(x => x(0) - x(1)).toList.sum > 0) line.reverse else line )
            .map( line => evaluate_line(line) match
                  case 1 => 1
                  case _ => {
                        var wrong_index = line.sliding(2).map(x => x(0) - x(1)).zipWithIndex.find(x => predicate(x._1)).get._2
                        var updated_line = line.take(wrong_index) ::: line.slice(wrong_index + 1, line.length)
                        var result = evaluate_line(updated_line)
                        println(s" ## Line $line is wrong, issue found on index $wrong_index, reporcessing with line $updated_line instead with final result ${result}")
                        if(result == 0) {
                           wrong_index = line.sliding(2).map(x => x(0) - x(1)).zipWithIndex.find(x => predicate(x._1)).get._2
                           updated_line = line.take(wrong_index+1) ::: line.slice(wrong_index + 2, line.length)
                           result = evaluate_line(updated_line)
                           println(s" ## Line $line is wrong, issue found on index $wrong_index, reporcessing with line $updated_line instead with final result ${result}")
                        }
                        result
                  }
            )
            .sum

            
  
  def main(args: Array[String]): Unit = 
        println("Start")
        val data = io.Source.fromResource("aoc2024/day02.txt").mkString
        //println(data)
        println("Results")
        println(part1(data))
        println(part2(data))  



        // 731 to high
        // 331 to low
        // 301 to log
        // 345
        // 397 wrong