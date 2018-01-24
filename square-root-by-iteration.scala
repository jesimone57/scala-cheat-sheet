// Calculate the square root of a number using Newton's method
//   1. start with an initial guess of 1
//   2. if we are close enough to the answer, then stop and return the guess as "good enough"
//   3. else improve the guess until we converge on the answer

def abs(x: Double): Double = if (x<0) -x else x

def isGoodEnough(guess: Double, x: Double): Boolean = if (abs(guess * guess - x)/x < 0.0000001) true else false

def improve(guess: Double, x: Double): Double =  (x/guess + guess)/2

def sqrtIter(guess: Double, x: Double): Double = {
  println(s"guess is $guess")
  if (isGoodEnough(guess, x)) guess else sqrtIter(improve(guess, x), x)
}

def sqrt(x: Double) = sqrtIter(1.0, x)

sqrt(2)
sqrt(4)
sqrt(9)
sqrt(1e-20)
sqrt(1e60)

