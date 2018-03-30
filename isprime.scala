// Example usage:  
//
// val primes0To100 = for (i <- 0 to 100 if isPrime(i) == true) yield(i)
// primes0To100  // Vector(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97)
// primes0To100.length  // Int = 25
//
// Note: negative numbers are rejected

def isPrime(n: Int): Boolean = {
  import scala.math
  val oddDivisors = for (i <- 3 to n by 2 if i <= Math.sqrt(n)) yield(i)
  val divisors = Vector(2) ++ oddDivisors
  val divisableBy = for (d <- divisors if n>1) yield n>d && n%d == 0
  if (divisableBy.isEmpty) false else ! divisableBy.reduceLeft(_ || _)
}
