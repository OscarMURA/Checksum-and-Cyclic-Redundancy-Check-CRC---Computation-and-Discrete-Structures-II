package Generator

enum DataType(val minSize: Int, val maxSize: Int) {
  case TOY extends DataType(1, 13)
  case SMALL extends DataType(13, 1250)
  case MEDIUM extends DataType(1250, 125000)
  case BIG extends DataType(125000, 500000)
}

object DataType {
  def minValue: Int = values.map(_.minSize).min
  def maxValue: Int = values.map(_.maxSize).max
}