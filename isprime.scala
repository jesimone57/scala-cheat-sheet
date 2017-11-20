// Example usage:  
// for (i <- 101 to 201 by 2) print(s"$i "+isPrime(i)+"\t")
//
// Output:
// 101 true        103 true        105 false       107 true        109 true        111 false       113 true        115 false       
// 117 false       119 false       121 true        123 false       125 false       127 true        129 false
// 131 true        133 false       135 false       137 true        139 true        141 false       143 false       145 false       
// 147 false       149 true        151 true        153 false       155 false       157 true        159 false
// 161 false       163 true        165 false       167 true        169 true        171 false       173 true        175 false       
// 177 false       179 true        181 true        183 false       185 false       187 false       189 false
// 191 true        193 true        195 false       197 true        199 true        201 false

def isPrime(n: Int): Boolean = {
  import scala.math
  val divisors = for (i <- 3 to n if i < Math.sqrt(n)) yield(i)
  val divisableBy = for (d <- divisors) yield n % d == 0
  ! divisableBy.reduceLeft((a:Boolean, b:Boolean) => a || b)
}
