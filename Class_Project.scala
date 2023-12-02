//import scala.io.Source._
//
//object Class_Project {
//
//  def countLetters(line: String): Map[Char, Int] = {
//    val letterCount = collection.mutable.Map[Char, Int]().withDefaultValue(0)
//    for (char <- line.filter(_.isLetter)) {
//      val uppercaseChar = char.toUpper // Convert to uppercase
//      letterCount(uppercaseChar) += 1
//    }
//    letterCount.toMap
//  }
//
//  def countLettersInFile(filename: String): Map[Char, Int] = {
//    val lines = fromFile(filename).getLines()
//    val letterCountsInLine = lines.flatMap(countLetters).toList
//    letterCountsInLine.groupBy(_._1).map { case (k, v) => k -> v.map(_._2).sum }
//  }
//
//  def main(args: Array[String]): Unit = {
//    val letterCounts = countLettersInFile("sample.txt")
//    letterCounts.foreach { case (letter, count) =>
//      println(s"'$letter': $count.")
//    }
//  }
//}

//
//import scala.io.Source
//
//object Class_Project {
//
//  def countLetters(line: String): Map[Char, Int] =
//    line.filter(_.isLetter).groupBy(_.toUpper).view.mapValues(_.length).toMap
//
//  def countLettersInFile(filename: String): Map[Char, Int] =
//    Source.fromFile(filename).getLines().flatMap(countLetters).toSeq
//      .groupMap(_._1)(_._2).view.mapValues(_.sum).toMap
//
//  def totalLettersInFile(filename: String): Int =
//    Source.fromFile(filename).getLines().flatMap(_.filter(_.isLetter)).length
//
//  def mostCommonLetter(letterCounts: Map[Char, Int]): Option[Char] =
//    if (letterCounts.nonEmpty) Some(letterCounts.maxBy(_._2)._1) else None
//
//  def main(args: Array[String]): Unit = {
//    val filename = "sample.txt"
//
//    val letterCounts = countLettersInFile(filename)
//
//    letterCounts.foreach { case (letter, count) =>
//      println(s"'$letter': $count.")
//    }
//
//    val totalLetters = totalLettersInFile(filename)
//    println(s"Total number of letters in the file: $totalLetters")
//
//    val mostCommon = mostCommonLetter(letterCounts)
//    mostCommon.foreach(letter => println(s"The most common letter is '$letter'"))
//  }
//}

//
//import scala.io.Source
//
//object Class_Project {
//
//  def countLetters(line: String): Map[Char, Int] =
//    line.filter(_.isLetter).groupBy(_.toUpper).map { case (char, chars) => char -> chars.length }
//
//  def countLettersInFile(filename: String): Map[Char, Int] =
//    Source.fromFile(filename)
//      .getLines()
//      .flatMap(countLetters)
//      .toSeq // Convert Iterator to Seq
//      .groupBy(_._1)
//      .map { case (char, counts) => char -> counts.map(_._2).sum }
//
//  def main(args: Array[String]): Unit = {
//    val letterCounts = countLettersInFile("sample.txt")
//    letterCounts.foreach { case (letter, count) =>
//      print(s"'$letter': $count.")
//    }
//  }
//}



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


//import scala.io.Source
//object Class_Project {
//  def Alph_counts(input: String): Map[Char, Int] =
//    input.filter(_.isLetter)
//      .groupBy(_.toUpper)
//      .map { case (char, chars) => char -> chars.length }
//  def Alph_countsInFile(filename: String): Map[Char, Int] =
//    Source.fromFile(filename)
//      .getLines()
//      .flatMap(Alph_counts)
//      .toSeq
//      .groupBy(_._1)
//      .map { case (char, counts) => char -> counts.map(_._2).sum }
//  def displayAlph_counts(alph_counts: Map[Char, Int]): Unit =
//    alph_counts.foreach { case (letter, count) =>
//      print(s"'$letter': $count. ")
//    }
//  def main(args: Array[String]): Unit = {
//    val filename = "sample.txt"
//    val alph_counts = Alph_countsInFile(filename)
//
//    displayAlph_counts(alph_counts)
//
//  }
//}

