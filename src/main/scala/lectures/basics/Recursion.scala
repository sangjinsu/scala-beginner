package lectures.basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - first need factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computing factorial of " + n)

      result
    }

  //  println(factorial(10))
  //  println(factorial(5000))


  def anotherFactorial(n: Int): BigInt = {

    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator)

    factHelper(n, 1)
  }

  def anotherFactorialB(n: Int): BigInt =
    (2 to n).foldLeft(BigInt(1))(_ * _)



  println(anotherFactorial(5000))
  println(anotherFactorialB(10000))


  def isPrime(n: Int): Boolean =
    if (n <= 1) false
    else !(2 to Math.sqrt(n).toInt).exists(n % _ == 0)

  println(isPrime(17))

}
