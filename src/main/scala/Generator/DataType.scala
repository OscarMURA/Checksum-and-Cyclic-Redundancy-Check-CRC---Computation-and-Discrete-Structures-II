package Generator

enum DataType(val minSize: Int, val maxSize: Int) {
  case TOY extends DataType(1, 99)
  case SMALL extends DataType(100, 9999)
  case MEDIUM extends DataType(10000, 999999)
  case BIG extends DataType(1000000, 2000000)
}

object DataType {
  def minValue: Int = values.map(_.minSize).min
  def maxValue: Int = values.map(_.maxSize).max
}