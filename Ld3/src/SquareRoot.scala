

object SquareRoot extends App{
  def square(x: Double) = x * x
  def improve(x: Double, y: Double) = (y + x/y) / 2
  def isGoodEnough(x: Double, y: Double): Boolean = Math.abs(square(y) - x) > 0.001
  def sqrtIter(x: Double, y: Double): Double = 
    if
      (isGoodEnough(x, y)) sqrtIter(x, improve(x, y))
    else
      y
  def sqrt(x: Double) = sqrtIter(x, 1)

  println("1.Value of Square Root: " + sqrt(144))
  println("2.Value of Square Root: " + sqrt(12))
  println("3.Value of Square Root: " + sqrt(16))
}
