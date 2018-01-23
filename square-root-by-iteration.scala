def abs(x: Double): Double = if (x<0) -x else x

def isGoodEnough(guess: Double, x: Double): Boolean = if (abs(guess * guess - x) < 0.0000001) true else false

def improve(guess: Double, x: Double): Double =  (x/guess + guess)/2

def sqrtIter(guess: Double, x: Double): Double = {
  println(s"guess is $guess")
  if (isGoodEnough(guess, x)) guess else sqrtIter(improve(guess, x), x)
}

sqrtIter(1, 2)
