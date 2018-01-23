
// This example code take from Martin Odersky's Scala course on Coursera Lecture 2.1 - Summing with Higher Order Functions

// First define some simple functions we can use
def cube(x: Int): Int = x * x * x
def factorial(x: Int): Int = if (x == 0) 1 else x * factorial(x-1)
def id(x: Int): Int = x

// The sum of all integers from a to b
def sumInts(a: Int, b: Int): Int =  
  if (a > b) 0 else a + sumInts(a + 1, b)

// The sum of all cubes from a to b
def sumCubes(a: Int, b: Int): Int =  
  if (a > b) 0 else cube(a) + sumCubes(a + 1, b)
  
// The sum of all factorials from a to b
def sumFactorials(a: Int, b: Int): Int =  
  if (a > b) 0 else factorial(a) + sumFactorials(a + 1, b)
  
  
// Can we factor out the common code into 1 single method?  Sure.
def sum(f: Int => Int, a: Int, b: Int): Int = 
  if (a > b) 0 else f(a) + sum(f, a + 1, b)

// Then we can rewrite the above 3 summations methods thusly
def sumInts2(a: Int, b: Int):  Int = sum(id, a, b)
def sumCubes2(a: Int, b: Int): Int = sum(cube, a, b)
def sumFactorials2(a: Int, b: Int): Int = sum(factorial, a, b)

sumInts(1,4)        // returns Int = 10
sumInts2(1,4)       // same

sumCubes(1,3)       // returns Int = 36
sumCubes2(1,3)      // same

sumFactorials(1,4)  // returns Int = 33
sumFactorials2(1,4) // same

// summation with anonymous functions
def sumInts3(a: Int, b: Int):  Int = sum(x => x, a, b)
def sumCubes3(a: Int, b: Int): Int = sum(x => x * x * x, a, b)
