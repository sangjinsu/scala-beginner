package lectures.basics

object Functions extends App {
  def aFunction(a: String, b: Int): String = a + " " + b

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())

  def aReapeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aReapeatedFunction(aString, n - 1)
  }

  println(aReapeatedFunction("hello", 3))

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n-1)
  }

  def aGreeting(name: String, age: Int): String = s"Hi, my name is $name, and I am $age years old."
  println(aGreeting("David", 42))

  def aFactorial(n: Int): Int =
    if (n <= 1) 1
    else n * aFactorial(n-1)

  println(aFactorial(5))

  def fibonacci(n: Int): Int =
    if (n <= 2) 1
    else fibonacci(n-1) + fibonacci(n-2)

  def isPrime(n: Int): Boolean = {
    def isPrimeUtil(t: Int): Boolean =
      if (t <= 1) true
      else (n % t != 0) && isPrimeUtil(t - 1)

    isPrimeUtil(n / 2)
  }

  println(s"Is 37 prime? ${isPrime(37)}")
  println(s"Is 2003 prime? ${isPrime(2003)}")
  println(s"Is 481 (37 * 13) prime? ${isPrime(37 * 13)}")

  // A higher-order function example: applies a function n times
  def nTimes(f: Int => Int, n: Int): Int => Int = {
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimes(f, n - 1)(f(x))
  }

  val plusOne = (x: Int) => x + 1
  val add10 = nTimes(plusOne, 10)
  println(s"Applying plusOne 10 times to 1: ${add10(1)}")

}
