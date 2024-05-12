package ModelCheckSum

trait IChecksum {

  def createBlocks(data: List[Byte], blockSize: Int): List[List[Byte]]
  def chunckData(data: List[Byte], blockSize: Int): List[Byte]
  def concatenateSingleByte(data: List[List[Byte]]): List[Byte]
  def singleMessageDoubleChecksum(message: List[Byte], modulus: Int, k: Int, blockSize: Int): Byte

}
