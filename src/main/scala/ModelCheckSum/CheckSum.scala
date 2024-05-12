package ModelCheckSum

import scala.annotation.tailrec

class CheckSum  extends IChecksum{
  def singleMessageDoubleChecksum(message: List[Byte], modulus: Int, k: Int, blockSize: Int): Byte = {

    val dataBlocks = createBlocks(message, blockSize)

    @tailrec
    def singleMessageBlockCheckSum(dataBlocks: List[List[Byte]], modulus: Int, k: Int, sumA: Byte, sumB: Byte): Byte = {

      dataBlocks match {
        case Nil =>
          println("VALOR QUE IMPRIME: " + sumB)
          sumB
        case head :: tail =>
          println("VALOR INICIO SUMA A: " + sumA)
          println("VALOR INICIO SUMA B: " + sumB)
          val tempCurrentValue = head.sum.toByte //se usa este en lugar de hacer llamado a la funcion concatenar
          println("VALOR TEMPORAL" + tempCurrentValue)
          val tempSumA = (sumA + tempCurrentValue) % modulus
          println("VALOR TEMPORAL SUMA A : " + tempSumA)
          if ((tempSumA + sumB) > modulus) {
            val tempSumB = ((tempSumA + sumB) << k) % modulus
            println("VALOR TEMPORAL SUMA B: " + tempSumB)
            singleMessageBlockCheckSum(tail, modulus, k, tempSumA.toByte, tempSumB.toByte)
          } else {
            val tempSumB = (tempSumA + sumB) % modulus
            println("VALOR TEMPORAL SUMA B: " + tempSumB)
            singleMessageBlockCheckSum(tail, modulus, k, tempSumA.toByte, tempSumB.toByte)
          }


      }
    }

    singleMessageBlockCheckSum(dataBlocks, modulus, k, 0, 0)
  }


  def chunckData(data: List[Byte], blockSize: Int): List[Byte] = {
    val dataBlocks = createBlocks(data, blockSize)
    return concatenateSingleByte(dataBlocks)
  }


  def createBlocks(data: List[Byte], blockSize: Int): List[List[Byte]] = {
    def createBlocksIntern(data: List[Byte], blockSize: Int, currentBlock: List[Byte]): List[List[Byte]] = {
      data match {
        case Nil => Nil
        case _ =>
          val (block, remaining) = data.splitAt(blockSize)
          block :: createBlocksIntern(remaining, blockSize, List[Byte]())
      }
    }

    createBlocksIntern(data, blockSize, List[Byte]())
  }
  def concatenateSingleByte(data: List[List[Byte]]): List[Byte] = {
    data.map(_.sum.toByte)
  }
}
