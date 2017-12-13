# Scala Cheat Sheet

[Scala Standard Library](http://www.scala-lang.org/api/current/)

[Scala Language Specification 2.12](https://www.scala-lang.org/files/archive/spec/2.12/)

[Scala Reference Documentation](https://docs.scala-lang.org/)

[Scala Style Guide](https://docs.scala-lang.org/style/)

Examples drawn from [https://www.tutorialspoint.com/scala/](https://www.tutorialspoint.com/scala/)

### Overview
* The name Scala stands for "Scalable Language".
* Everything is an object.  Scala is object oriented.
* Every function returns a value and every value is an object, therefore every function is an object.  Scala is Functional.
* Statically typed (Int, Boolean, Float, etc.)
* Runs on the JVM
* Interoperates seamlessly with all Java libraries.
* Can execute Java code
* Can do concurrent and synchronized processing
* There are no static methods in Scala.  Note:  static methods makes code confusing and hard to test.

### Everything is an Object in Scala
* there are no such thing as primitives in Scala as there are in Java, thus everything is an object
<pre>
println(1.toString)     // String = 1       
</pre>

### Syntax of Arrows in Scala
1. -> is used for maps:  var map = Map("a" -> 1, "b" -> 2, "c" -> 3)
2. <- is used as a _for_ loop index:  for (i <- 1 to 3) println(i)
3. => is used in lamba expressions:  list.foreach {e => println(e) }

### Scala variables
<pre>
var x = 5               // Default is an Int Type
var z = 2.0             // Default for a number with a decimal point is Double

var y: Int = 6          // Explicit typing to an Int
var a: Double = 2.0     // Explicit typing to a Double
var a: Double = 2       // same
var a: = 2D             // Double
var a: = 2d             // Double

var w: Int = 2.3        // error:  type mismatch
</pre>

### Scala constants.  An immutable variable is defined with val:
<pre>
val x = 5
val y: Int = 6          // Explicit typing to an Int
val w: Int = 2.3        // error:  tyoe mismatch
val z = 2.0             // implicitly a Double
val a: Double = 2.0     // Explicitly a Double

a = 5.0                 //  error: reassignment to val
</pre>

Scala encourages us to use immutable objects:
* Code is free from side-effects and is easier to reason about
* Pure functions can be tested easily
* Immutable objects won’t lead to concurrency issues



### Checking the Scala Version
<pre>
val version = util.Properties.versionNumberString     	// returns version: String = 2.11.8
</pre>


### Datatypes

* Byte	- 8 bit signed value. Range from -128 to 127
<pre>
val b: Byte = 127           // ok
val b: Byte = 0x7c          // ok. b = 124
val b: Byte = 128           // error: type mismatch;
val b: Byte = 0xdc          // error: type mismatch;

var i: Byte = _             // default initial value:  Byte = 0
</pre>

* Short	- 16 bit signed value. Range -32768 to 32767
<pre>
val s: Short = 12           // ok
val s: Short = 32768        //  error: type mismatch;
</pre>

* Int	- 32 bit signed value. Range -2147483648 to 2147483647
<pre>
var x = 1                   // implicit Int
var x: Int = 1
var x: Int = 0xff           // the value 255 in hex

var i: Int = _              // default initial value:  Int = 0 
</pre>

* Long	- 64 bit signed value. -9223372036854775808 to 9223372036854775807
<pre>
var a = 1L
var a1: Long = 1
</pre>

* Float	- 32 bit IEEE 754 single-precision float<p>
Double is inferred unless the declared variable is Float or an f or F suffix is used.</p>
<pre>
var f: Float = 3.14159f	 	
var f2: Float = 3.14159F
var f3: Float = 3.1111111111111111111111111111111111 	// error: type mismatch;

var i: Float = _            // default initial value:  Float = 0.0 
</pre>

* Double - 64 bit IEEE 754 double-precision float
<pre>
var d = 1.0                 // default implicit is a Double
var d2 = 2D                 // a Double
var d3 = 3d                 // a double
var e: Double = 1.0 
var a: Double = 1.0e100	 

var i: Double = _           // default initial value:  Double = 0.0 
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

var a: String = 'asdf'	  //  error: unclosed character literal

var i: String = _         // default initial value:  String = null 
</pre>

* Boolean	- Either the literal true or the literal false
<pre>
var b1 = true  	// implicit type
var b: Boolean = true
var c: Boolean = false

var b: Boolean = _        // default initial value:  Boolean = false
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


### Pattern Matching
More powerful version of a Java switch statement

<pre>
import scala.util.Random

val x: Int = Random.nextInt(10)

x match {
  case 0 => "zero"
  case 1 => "one"
  case 2 => "two"
  case _ => "many"
}

// another example using a regular expression
import scala.util.matching.Regex

val numberPattern: Regex = "[0-9]".r

numberPattern.findFirstMatchIn("awesomepassword") match {
  case Some(_) => println("Password OK")
  case None => println("Password must contain a number")
}
</pre>


### Multiple Assignment

<pre>
val (a, b) = (1, 2)	// called an extractor of a pattern-match-expression

val text = "some text goes here"
val (first, rest) = if (text.contains("z")) text.splitAt(4) else text.splitAt(7)  	// first: String = some te
// rest: String = xt goes here
</pre>

### Scala Collections
Colections can be mutable or immutable. Immutable is the default.

* Tuple
* List
* Vector
* Array
* Map 
* Set
* Seq
* SortedSeq
* SortedMap

### Operators
Operators are methods with one parameter used in (dot-less)
operator notation.  Consider the following:
<pre>
// split takes 1 parameter and is used dotless
"a,b,c" split ","             // Array[String] = Array(a, b, c)

// split called as a function. Still takes 1 parameter and a dot is used.
"a,b,c".split( ",")           // Array[String] = Array(a, b, c)
</pre>


### Methods

* The type should be given for public or non-trivial methods.
* Note:  you should always define a return type
* A method without parameters can be written without parens. Note: No-parens style only for side-effect-free methods

<pre>
def message = "Hello World!"
message               // returns  String = Hello World!

def factorial(x: BigInt): BigInt = if (x==0) 1 else x*factorial(x-1)
factorial(6)          // res12: BigInt = 720

// almost any name can be used as a function name.  Consider the following valid function
def *?!(s: String): String = s.reverse
*?!( "asdf")          // res21: String = fdsa

def isUpcase2(s:String): Boolean = s == s.toUpperCase       // isUpcase2: (s: String)Boolean
isUpcase2("ASD")      // Boolean = true
isUpCase2("aSD")      // Boolean = false
</pre>

### Functions
* A function may be defined using a lamda expression
<pre>
(s:String) => s.toUpperCase         // String => String = &lt;function1&gt;

val anyTrue = (a:Boolean, b:Boolean) => a || b
val allTrue = (a:Boolean, b:Boolean) => a && b

val isUpCase = (s:String) => s == s.toUpperCase     // isUpCase: String => Boolean = &lt;function1&gt;
isUpCase("ASD")         // Boolean = true
isUpCase("aSD")         // Boolean = false
</pre>

### Function Values
* Scala provides a number of different syntactic options for declaring function values. For example, the following declarations are exactly equivalent:
<pre>
val f1 = ((a: Int, b: Int) => a + b)
val f2 = (a: Int, b: Int) => a + b
val f3 = (_: Int) + (_: Int)
val f4: (Int, Int) => Int = (_ + _)
</pre>
* Of these styles, the first and the last are to be preferred at all times. 

### Numbers
* numbers may be: Short, Int, Long, Float or Double.  The default is Double.


### Strings 
Like arrays, strings are not directly sequences, but they can be converted to them, and they also support all sequence operations on strings. Here are some examples of operations you can invoke on strings.

<pre>
val str = "hello"
str.length                              // Int = 5
str.reverse                             // String = olleh
str.map(_.toUpper)                      // String = HELLO
str drop 3                              // String = lo
str take(2)                             // String = he
str slice (1, 4)                        // String = ell
"              hello      ".trim        // String = hello
str.replaceAll("l", "X")                // String = heXXo
str split("l")                          // Array[String] = Array(he, "", o)
str.toArray                             // Array[Char] = Array(h, e, l, l, o)
</pre>

### Tuples

<pre>
var x = Tuple3(1, 2, 3)                 // x: (Int, Int, Int) = (1,2,3)
var x = (1, 2, 3)                       // same

// define
val tup = (1.0, 2, 3, "frank")          // tup: (Int, Int, Int, String) = (1,2,3,frank)

// access
tup._1                                  // Double = 1.0
tup._4                                  // String = frank

val listOfTuples = List(("a", "b", "c"), ("one", "two", "three"), ("tom", "dick", "harry"))
listOfTuples.zipWithIndex foreach { case(e, i) => println(i + ": " + e) }
// returns ...
// 0: (a,b,c)
// 1: (one,two,three)
// 2: (tom,dick,harry)
</pre>

### Lists

<pre>
val list = List(1,2,3)          // List[Int] = List(1, 2, 3)
list.sum                        // Int = 6

var list = List("jack", 1, 3.0, Set(1,2,3))       // List[Any] = List(jack, 1, 3.0, Set(1, 2, 3))
list(0)               // Any = jack
list(1)               // Any = 1
list(2)               // Any = 3.0
list(3)               // Any = Set(1, 2, 3)
list(2).toString.toFloat.toInt + 12   // Int = 15

// for mutable lists use ListBuffer
import scala.collection.mutable.ListBuffer

var fruits = ListBuffer[String]()
fruits += "Apple"     // ListBuffer(Apple)
fruits += "Banana"    // ListBuffer(Apple, Banana)
fruits += "Orange"    // ListBuffer(Apple, Banana, Orange)
</pre>


### Maps

<pre>
val map = Map("a" -> 1, "b" -> 2)   // Map[String,Int] = Map(a -> 1, b -> 2)
val map = Map(234 -> 1, "b" -> 2)   // Map[Any,Int] = Map(234 -> 1, b -> 2)

// adding to a map
var map = Map(234 -> 1, "b" -> 2)
map += ("a" -> 728)
</pre>


### Ranges
* The Range class represents integer values in range \[start;end) with non-zero step value step. It's a special case of an indexed sequence. For example:

<pre>
val r1 = 0 until 10               // Range(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
val r2 = r1.start until r1.end by r1.step + 1     //  Range(0, 2, 4, 6, 8)
val x = Range(1, 5)               // Range(1, 2, 3, 4)

val odds = Range(1, 10, 2)        // Range(1, 3, 5, 7, 9)
val odds = 1 to 10 by 2           // exactly same
odds.end                          // Int 10
odds.last                         // Int 9

val evens = Range(0, 10, 2)       // Range(0, 2, 4, 6, 8)
var evens = 0 to 10 by 2          // exactly same
for (i <- evens) println(i)       // prints 0 2 4 6 and 8
evens.start                       // Int = 0
evens.end                         // Int = 10
evens.step                        // Int = 2

var numbers = 1 to 10             // Range(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

// using a range
numbers.filter{_ > 5}             // Vector(6, 7, 8, 9, 10)
numbers filter{_ > 5}             // same
numbers.filter{_ % 2 == 0}        // IndexedSeq[Int] = Vector(2, 4, 6, 8, 10)

numbers.filter(e => e > 5)        // Vector(6, 7, 8, 9, 10)
numbers filter(e => e > 5)        // same using no dot
numbers filter{e => e > 5}        // same using curly braces
numbers filter{_ > 5}             // same using anonymous var _
numbers filter(_ > 5)             // same with parens
</pre>


### Sets

<pre>
var i: Set[Int] = Set(1,2,3)      // Set[Int] = Set(1, 2, 3)
Set(1,2) subsetOf i               // Boolean = true

var set = Set(1,2,2,3,4,5,1,2)    // dupes removed ... Set(5, 1, 2, 3, 4)

set += 100                        // Set[Int] = Set(5, 1, 2, 3, 4, 100)
set -= 5                          // Set[Int] = Set(1, 2, 3, 4, 100)
set += (10,11)                    // Set[Int] = Set(10, 1, 2, 3, 11, 4, 100)
set -= (1,2,3,4)                  // Set[Int] = Set(10, 11, 100)
set.sum                           // Int = 121

// is element in set?
set(100                           // Boolean = true
set contains 100                  // same as above

set(20)                           // Boolean = false

// add another set
set ++ Set(20,30,40)              // Set[Int] = Set(10, 20, 11, 40, 30, 100)
</pre>


### Collection methods
[Methods on Collection Classes](https://alvinalexander.com/scala/scala-collections-classes-methods-organized-category)

<pre>
var numbers = 1 to 3      // scala.collection.immutable.Range.Inclusive = Range(1, 2, 3)

// lamda style 
numbers map(x => x + 1)   // scala.collection.immutable.IndexedSeq[Int] = Vector(2, 3, 4)
numbers map(_ + 1)        // scala style.  same.

numbers filter (_ < 3)		// scala.collection.immutable.IndexedSeq[Int] = Vector(1, 2)

numbers sortWith ((x, y) => x > y) // scala.collection.immutable.IndexedSeq[Int] = Vector(3, 2, 1)
numbers map (_ + 1) sortWith (_ > _) 	// scala.collection.immutable.IndexedSeq[Int] = Vector(4, 3, 2)
</pre>


### Data Type Conversion

<pre>
15.toFloat          // Float = 15.0
15.0.toInt          // Int = 15
15f.toDouble        // Double = 15.0
15L.toShort         // Short = 15
15.123d.toLong			// Long = 15
"15.2".toFloat			// Float = 15.2
(1 to 3).toSet			// Set[Int] = Set(1, 2, 3)
(1 to 3).toList			// List[Int] = List(1, 2, 3)
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

// Example to find all the possible divisors of n (excluding 2)
import scala.math
val n = 101
val divisors = for (i <- 3 to n by 2 if i < Math.sqrt(n)) yield(i)	// Vector(3, 5, 7, 9)

// which of the above divisors evenly divides into 1001
val divisableBy = for (e <- divisors) yield 1001 % e == 0

// is this number prime?
val isPrime =  ! divisableBy.reduceLeft((a:Boolean, b:Boolean) => a || b)
</pre>	


### Classes
* Classes have public visibility by default

<pre>
// define
class Person(var name: String, var age: Int)

// use
val person = new Person("John Smith", 15)

// getters
person.name
person.age

// setters
person.name = "Fred Brown"
person.age = 23

// another way to define a class.  This one has a default constructor. Note: the default constructor is all of the expressions in the 
// class outside of the methods.  These are automatically collected into a default constructor.
class Person() {
  println("creating instance of Person ...")
  var name = ""  // code you put into the class becomes part of the "primary" constructor
  var age = 0    // ditto
  
  // auxilliary constructor.  Must call this
  def this(name: String) = {
    this
  }
}
</pre>

### Creating Singletons in Scala
* A singletion is an oject which can only have one instance.  No other instances are allowed
* In Scala we use the object key word to define a singleton.  It is part of the language specification.
* In Scala if both a class and an object have the the same name, they are called companions and must reside in the same file.
<pre>
// singleton definition
object Car {
  def f() = {
    println("in f")
  }
}

// usage
Car.f       // prints "in f"
</pre>

### Emumerations
* Enumerations are a language feature specially useful for modeling a finite set of entities.
* Scala, as many other languages, provides a native way to represent enumerations
* For a more thorough examination of the subject see [Enumerations](http://pedrorijo.com/blog/scala-enums/)
* The recommendation from the above blog post is to use the [enumeratum](https://github.com/lloydmeta/enumeratum) library see 

<pre>
object Weekday extends Enumeration {
  val Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday = Value
}

Weekday.withName("Monday")        // Weekday.Value = Monday
Weekday.withName("Mondai")        // NoSuchElementException: No value found for 'Mondai'

Weekday.values // Weekday.ValueSet = Weekday.ValueSet(Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday)
</pre>


### Scala written in Imperative Style 
<pre>
// definition
def total(list: List[Int]) = {
  var sum = 0
  for (i <- list) {
    sum += i
  }
  sum
}

// usage
total(List(1,2,3,4,5))        // Int = 15
</pre>

### Scala written in Functional Style 
* We want to promote immutability
* Assignmentless programming
* Functions don't have side-effects
<pre>
def total1(list:  List[Int]) = {
  var sum = 0
  list.foreach { e => sum += e}
  sum
}

total1(List(1,2,3,4,5))        // Int = 15

def total2(list:  List[Int]) = {
  var sum = 0
  list.foreach { sum += _ }
  sum
}

total2(List(1,2,3,4,5))        // Int = 15

def total3(list:  List[Int], selector: Int => Boolean) = {
  var sum = 0
  list.foreach { e => if (selector(e)) sum += e }
  sum
}

total3(List(1,2,3,4,5),  { e=> true})         // all values ... Int = 15
total3(List(1,2,3,4,5),  { e=> e%2 == 0})     // even values ... Int = 6
total3(List(1,2,3,4,5),  { e=> e > 3})        // values > 3 ... Int 9
total3(List(1,2,3,4,5),  { _ <= 3})           // values <= 3 ... Int 6

def total4(list: List[Int]) = { 
  list.foldLeft(0) {
    (carryOver, e) => carryOver + e
  }
}

total4(List(1,2,3,4,5))      // Int = 15
</pre>

### Traits
* Traits can be used in several ways which are show below.  First, they can extends a class.  Secondly, they can be mixed in with a class definition using the with keyword.  Lastly, they can be mixed in to an object definition using the with keyword.
<pre>
trait Friend {
  val name:  String
  def listen = println("I am "+name+" your friend")
}

// first, a class can be extended by a trait
class Human(val name: String) extends Friend

val peter = new Human("Peter")
peter.listen        // I am Peter your friend

// secondly, a class can mixin a trait
class Dog(override val name: String) extends Animal(name) with Friend

val rover = new Dog("Rover")
rover.listen      // I am Rover your friend

// lastly, an object can mixin a trait.   Note: No trait
class Cat(override val name: String) extends Animal(name)

// mixin trait with the object definition
val fluffy = new Cat("Fluffy") with Friend
fluffy.listen     // I am Fluffy your friend
</pre>

### Private, Protected and Public class members
* Unlike private and protected members, it is not required to specify Public keyword for Public members.

### Import Libraries
[Scala math package API docs](http://www.scala-lang.org/api/2.11.8/index.html#scala.math.package)
<pre>
import scala.math

Math.sqrt(25.0)         // Double = 5.0
Math.PI                 // Double = 3.141592653589793
Math.tan(Math.PI * 2)   // Double = -2.4492935982947064E-16  ... almost 0
</pre>

### Defining a Custom Type Alias
* Scala allows a type alias definition for custom types we wish to give name to.
<pre>
// suppose we have a custom type which is a List of Int and Double pairs (tuples)
val list = List( (0 ,0.0), (1, 1.1), (2, 2.2))    //  List[(Int, Double)] = List((0,0.0), (1,1.1), (2,2.2)) 

// we can define a custom type thusly
type MyNumberPairs = List[(Int, Double)]          // defined type alias MyNumberPairs

// usage
val x: MyNumberPairs = List( (0 ,0.0), (1, 1.1), (2, 2.2))  //  MyNumberPairs = List((0,0.0), (1,1.1), (2,2.2))
val x: MyNumberPairs = List( (0 , 0))                       // ok.     x: MyNumberPairs = List((0,0.0))
val x: MyNumberPairs = List( (0.1, 0))                      // will be an error.  error: type mismatch;
</pre>

### Exception Handling
<pre>
import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException

try {
   val f = new FileReader("input.txt")
} catch {

   case ex: FileNotFoundException => {
      println("Missing file exception")
   }

   case ex: IOException => {
      println("IO Exception")
   }
}
</pre>
