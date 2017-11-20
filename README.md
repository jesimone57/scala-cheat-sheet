# Scala Cheat Sheet

[Scala Standard Library](http://www.scala-lang.org/api/current/)

[Scala Language Specification](https://www.scala-lang.org/files/archive/spec/2.11/)

Examples drawn from 

[https://www.tutorialspoint.com/scala/](https://www.tutorialspoint.com/scala/)

### Overview
* Everything is an object.  Scala is object oriented.
* Every function returns a value and every value is an object, therefore every function is an object.  Scala is Functional.
* Statically typed (Int, Boolean, Float, etc.)
* Runs on the JVM
* Can execute Java code
* Can do concurrent and synchronized processing


### Scala variables
<pre>
var x = 5		// Default is an Int Type
var z = 2.0		// Default for a number with a decimal point is Double

var y: Int = 6		// Explicit typing to an Int
var a: Double = 2.0	// Explicit typing to a Double
var a: Double = 2 	// same
var a: = 2D		// Double
var a: = 2d		// Double

var w: Int = 2.3	// error:  tyoe mismatch
</pre>

### Scala constants.  An immutable variable is defined with val:
<pre>
val x = 5
val y: Int = 6           // Explicit typing to an Int
val w: Int = 2.3	 // error:  tyoe mismatch
val z = 2.0              // implicitly a Double
val a: Double = 2.0      // Explicitly a Double

a = 5.0                  //  error: reassignment to val
</pre>

Scala encourages us to use immutable objects:
* Code free of side-effects is easier to reason about
* Pure functions can be tested easily
* Immutable objects won’t lead to concurrency issues



###  Checking The Scala Version
<pre>

</pre>


### Datatypes

* Byte	- 8 bit signed value. Range from -128 to 127
<pre>
val b: Byte = 127	// ok
val b: Byte = 0x7c	// ok. b = 124
val b: Byte = 128	// error: type mismatch;
val b: Byte = 0xdc	// error: type mismatch;
</pre>

* Short	- 16 bit signed value. Range -32768 to 32767
<pre>
val s: Short = 12	// ok
val s: Short = 32768    //  error: type mismatch;
</pre>

* Int	- 32 bit signed value. Range -2147483648 to 2147483647
<pre>
var x = 1		// implicit Int
var x: Int = 1
var x: Int = 0xff 	// the value 255 in hex
</pre>

* Long	- 64 bit signed value. -9223372036854775808 to 9223372036854775807
<pre>
var a = 1L
var a1: Long = 1
</pre>

* Float	- 32 bit IEEE 754 single-precision float
<pre>
var f: Float = 3.14159f	 	
var f2: Float = 3.14159F
var f3: Float = 3.1111111111111111111111111111111111 	// error: type mismatch;
</pre>

* Double - 64 bit IEEE 754 double-precision float
<pre>
var d = 1.0	// default implicit is a Double
var d2 = 2D	// a Double
var d3 = 3d	// a double
var e: Double = 1.0 
var a: Double = 1.0e100	   
</pre>

* Char	- 16 bit unsigned Unicode character. Range from U+0000 to U+FFFF
<pre>
val a: Char = 'a'
val newline: Char = '\n'
val tab: Char = '\t'
val quote: Char = '\"'
var aunicode: Char = '\u0061'		// unicode 'a'
</pre>

* String   -  A sequence of Chars in double quotes
<pre>
var s: String = "This string contains a \" character."	// ok

var a: String = 'asdf'	//  error: unclosed character literal
</pre>

* Boolean	- Either the literal true or the literal false
<pre>
var b1 = true  	// implicit type
var b: Boolean = true
var c: Boolean = false
</pre>

* Unit	- Corresponds to no value. Like the Java void primitive.
<pre>
def sayHello(): Unit = println("Hello!")    // no value returned.
def sayHello2: Unit = println("Hello!")     // same.  Note: A method without parameters can be written without parens.
</pre>

* Null	- null or empty reference <p>
Null is a subtype of all reference types (i.e. any subtype of AnyRef). 
It has a single value identified by the keyword literal null. 
Null is provided mostly for interoperability with other JVM languages and should almost never be used in Scala code.
</p>

* Nothing - The subtype of every other type; includes no values  <p>
Nothing is - together with Null - at the bottom of Scala's type hierarchy.  Nothing is a subtype of every other type (including Null); there exist no instances of this type. Although type Nothing is uninhabited, it is nevertheless useful in several ways.  A usage for Nothing is the return type for methods which never return normally. One example is method error in sys, which always throws an exception.</p>

* Any - The supertype of any type; any object is of type Any <p>
Class Any is the root of the Scala class hierarchy. Every class in a Scala execution environment inherits directly or indirectly from this class. Class Any has two direct subclasses: AnyRef and AnyVal.</p>

* AnyRef - The supertype of any reference type <p>
AnyRef is the root class of all reference types.</p>



### Multiple Assignment

<pre>
val (a, b) = (1, 2)	// called an extractor of a pattern-match-expression

val text = "some text goes here"
val (first, rest) = if (text.contains("z")) text.splitAt(4) else text.splitAt(7)  	// first: String = some te
// rest: String = xt goes here
</pre>

### Scala Collections
Colections can be mutable or immutable. Immutable is the default.

* List
* Map 
* Set
* Seq
* SortedSeq
* SortedMap

### Operators
Operators are methods with one parameter used in (dot-less)
operator notation.  Consider the following:
<pre>
"a,b,c" split ","	// split takes 1 parameter and is used dotless ... res22: Array[String] = Array(a, b, c)

"a,b,c".split( ",")	// split called as a function. Still takes 1 parameter and a dot is used. ... res22: Array[String] = Array(a, b, c)
</pre>


### Functions
* The type should be given for public or non-trivial methods.
* Note:  you should always define a return type
* A method without parameters can be written without parens. Note: No-parens style only for side-effect-free methods

<pre>

def message = "Hello World!"

message		// returns  String = Hello World!

def factorial(x: BigInt): BigInt = if (x==0) 1 else x*factorial(x-1)

factorial(6)	// res12: BigInt = 720

// almost any name can be used as a function name.  Consider the following valid function
 def *?!(s: String): String = s.reverse

*?!( "asdf")	// res21: String = fdsa
</pre>


### Numbers
* numbers may be: Int, Long, Float or Double.  The default is Double.


### Strings 

<pre>
</pre>

### String Methods

<pre>
</pre>

### Lists

<pre>
val list = List(1,2,3)
</pre>

### Maps

<pre>
val map = Map("a" -> 1, "b" -> 2)	// creates scala.collection.immutable.Map[String,Int] = Map(a -> 1, b -> 2)
val map = Map(234 -> 1, "b" -> 2)	// creates scala.collection.immutable.Map[Any,Int] = Map(234 -> 1, b -> 2)
</pre>

### Range
<pre>
val x = Range(1,5)		// x: scala.collection.immutable.Range = Range(1, 2, 3, 4)
var numbers = 1 to 10		// numbers: scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

// using a range
numbers.filter{_ > 5}		// res4: scala.collection.immutable.IndexedSeq[Int] = Vector(6, 7, 8, 9, 10)
numbers filter{_ > 5}		// same
</pre>


### Set

<pre>
var set = Set(1,2,2,3,4,5,1,2)	// dupes removed ... set: scala.collection.immutable.Set[Int] = Set(5, 1, 2, 3, 4)	
</pre>


### Collection methods
[Methods on Collection Classes](https://alvinalexander.com/scala/scala-collections-classes-methods-organized-category)

<pre>
var numbers = 1 to 3		// numbers: scala.collection.immutable.Range.Inclusive = Range(1, 2, 3)

numbers map(x => x + 1)		// lamda style.  res31: scala.collection.immutable.IndexedSeq[Int] = Vector(2, 3, 4)
numbers map(_ + 1)		// scala style.  same.

numbers filter (_ < 3)		// scala.collection.immutable.IndexedSeq[Int] = Vector(1, 2)

numbers sortWith ((x, y) => x > y) // scala.collection.immutable.IndexedSeq[Int] = Vector(3, 2, 1)
numbers map (_ + 1) sortWith (_ > _) 	// scala.collection.immutable.IndexedSeq[Int] = Vector(4, 3, 2)
</pre>
	
### Data Type Conversion

<pre>
</pre>

### Operator Precedence

<pre>
</pre>

### If statement

<pre>
var x = 10

if (x < 20) {
  println("This is if statement")
}

if (x == 10){
  println("x is 10")
} else {
  println("x is not 10")
}
</pre>

### Multiline If

<pre>
var x = 10

if (x == 10) {
  println("x is 10")
} else if (x > 10 && x <= 20) {
  println("x is between 10 and 20")
} else if (x > 20 && x <= 1000) {
  println("x is between 20 and 1000")
} else {
  println("x is greater than 1000 or less than 10")
}
</pre>

### Looping For and While
[For Loop Examples and Syntax](https://alvinalexander.com/scala/scala-for-loop-examples-syntax-yield-foreach)

<pre>
val names = Seq("chris", "ed", "maurice")
val nums = Seq(1, 2, 3)
val letters = Seq('a', 'b', 'c')

for (n <- names) println(n)
for (n <- names) println(n.capitalize)    
for (n <- names) {
    // imagine this requires several lines
    println(n.capitalize)
}

for (i <- 1 to 3) println(i)    // generator in for loop


val res = for {
    n <- nums
    c <- letters
} yield (n, c)     // Seq[(Int, Char)] = List((1,a), (1,b), (1,c), (2,a), (2,b), (2,c), (3,a), (3,b), (3,c))


for (i <- 1 to 10 if i < 4) println(i)    // generator with one guard
for (i <- 1 to 10 if i > 3 if i < 6 if i % 2 == 0) println(i)     // ... with multiple guards

val names2 = for (e <- names) yield e.capitalize   // yield creates a new data structure

val out = for (e <- names) yield e.capitalize
val out = names map(_.capitalize)


val nameMap = Map("firstName" -> "Ed", "lastName" -> "Chigliak")
val result = for ((k,v) <- nameMap) yield {
    s"key: $k, value: $v"
}    //  List(key: firstName, value: Ed, key: lastName, value: Chigliak)


names.foreach(println)
names.foreach(e => println(e.toUpperCase))
names.foreach {
    // imagine this requires multiple lines
    e => println(e.toUpperCase)
}

// Example to find all the possible divisors of 1001 (excluding 2)
import scala.math
val divisors = for (i <- 3 to 1001 if i < Math.sqrt(1001)) yield(i)
// Vector(3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31)
</pre>	
	
### Classes
* Classes have public visibility by default

<pre>
// define
class Person(val name: String, val age: Int)

// use
val person = new Person("John Smith", 15)
person.name
person.age
</pre>

### Private, Protected and Public class members
* Unlike private and protected members, it is not required to specify Public keyword for Public members.

### Import Libraries
[Scala math package API docs](http://www.scala-lang.org/api/2.11.8/index.html#scala.math.package)
<pre>
import scala.math

Math.sqrt(25.0)		// returns ... res14: Double = 5.0
Math.PI 		// returns ... res18: Double = 3.141592653589793
Math.tan(Math.PI * 2)	// returns ... res19: Double = -2.4492935982947064E-16
</pre>
