import scala.io.Source

object Class_Project {

  def count_alphabets(line: String): Map[Char, Int] =
    line.filter(_.isLetter).groupBy(_.toUpper).view.mapValues(_.length).toMap

  def count_alphabetsInFile(filename: String): Map[Char, Int] =
    Source.fromFile(filename).getLines().flatMap(count_alphabets).toSeq
      .groupMap(_._1)(_._2).view.mapValues(_.sum).toMap

  def total_alphabetsInFile(filename: String): Int =
    Source.fromFile(filename).getLines().flatMap(_.filter(_.isLetter)).length

  def mostCommonAlphabets(count_alphabets: Map[Char, Int]): Option[Char] =
    if (count_alphabets.nonEmpty) Some(count_alphabets.maxBy(_._2)._1) else None

  def main(args: Array[String]): Unit = {
    val filename = "sample.txt"

    val count_alphabets = count_alphabetsInFile(filename)

    count_alphabets.foreach { case (alphabets, count) =>
      print(s"'$alphabets': $count. ")
    }

    val totalLetters = total_alphabetsInFile(filename)
    println(s"Total number of Alphabets in the file: $totalLetters")

    val mostCommon = mostCommonAlphabets(count_alphabets)
    mostCommon.foreach(letter => println(s"The most common Alphabets is '$letter'"))
  }
}

