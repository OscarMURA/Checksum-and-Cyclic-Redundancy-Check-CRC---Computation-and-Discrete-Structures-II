package Interface

trait EDC {
  def getTimeMS(): Long
  def getTimeNS(): Long
  def calculateTime(message: Any): Unit
}

