package ModelCheckSum

import scala.annotation.tailrec


class CheckSum  extends IChecksum{

  private var timeMS: Long =0
  private var timeNS: Long = 0
  def calculateCheckum(data: List[Byte]): Unit = {
    val start = System.currentTimeMillis()
    val startNS = System.nanoTime()
    val checksum = singleMessageDoubleChecksum(data, 256, 8, 8)
    val endNS = System.nanoTime()
    val end = System.currentTimeMillis()
    timeMS = end - start
    timeNS = endNS - startNS
  }

  def singleMessageDoubleChecksum(message: List[Byte], modulus: Int, k: Int, blockjSize: Int): Byte = {
    //if (modulus <= 0) throw new IllegalArgumentException("Modulus must be a positive integer")
    //if (blockSize <= 0) throw new IllegalArgumentException("Block size must be a positive integer")
    //if(blockSize>message.length)throw new IllegalArgumentException("Block Size Partition must be less than the message lenght")
    val dataBlocks = createBlocks(message, blockjSize)
    @tailrec
    def singleMessageBlockCheckSum(dataBlocks: List[List[Byte]], modulus: Int, k: Int, sumA: Byte, sumB: Byte): Byte = {

      dataBlocks match {
        case Nil => sumB
        case head :: tail =>
          val tempCurrentValue = head.sum.toByte //se usa este en lugar de hacer llamado a la funcion concatenar
          val tempSumA = (sumA + tempCurrentValue) % modulus
          if ((tempSumA + sumB) > modulus) {
            val tempSumB = ((tempSumA + sumB) << k) % modulus
            singleMessageBlockCheckSum(tail, modulus, k, tempSumA.toByte, tempSumB.toByte)
          } else {
            val tempSumB = (tempSumA + sumB) % modulus
            singleMessageBlockCheckSum(tail, modulus, k, tempSumA.toByte, tempSumB.toByte)
          }


      }
    }
    singleMessageBlockCheckSum(dataBlocks, modulus, k, 0, 0)
  }

  /**
   * Genera bloques de un tamaño especificado a partir de una lista de bytes.
   *
   * @param bytes La lista de bytes que se va a agrupar en bloques.
   * @param scale  El tamaño de cada bloque.
   * @return Una lista de bloques, donde cada bloque tiene el tamaño especificado.
   */
  def createBlocks(data: List[Byte], blockSize: Int): List[List[Byte]] = {
    @tailrec
    def group(data: List[Byte], scale: Int, cumulative: List[List[Byte]]): List[List[Byte]] = {
      if (data.isEmpty) cumulative
      else {
        val (grouped, remaining) = data.splitAt(scale)
        group(remaining, scale, cumulative :+ grouped)
      }
    }
    group(data, blockSize, Nil)
  }

  def getTimeMS(): Long = timeMS
  def getTimeNS(): Long = timeNS

}
