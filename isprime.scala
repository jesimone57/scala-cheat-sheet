// Example usage:  
//
// val primes1To100 = for (i <- 2 to 100 if isPrime(i) == true) yield(i)
// primes1To100  // Vector(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97)
// primes1To100.length  // Int = 24
//

def isPrime(n: Int): Boolean = {
  import scala.math
  val oddDivisors = for (i <- 3 to n if i <= Math.sqrt(n)) yield(i)
  val divisors = Vector(2) ++ oddDivisors
  val divisableBy = for (d <- divisors) yield n>d && n%d == 0
  ! divisableBy.reduceLeft((a:Boolean, b:Boolean) => a || b)
}
