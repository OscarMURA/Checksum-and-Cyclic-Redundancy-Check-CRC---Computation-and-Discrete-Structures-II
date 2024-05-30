package ModelCheckSum

import scala.annotation.tailrec
import Interface.*

class CheckSum  extends IChecksum{

  private var timeStarNS: Long=0
  private var timeEndNS: Long=0
  private var timeStarMS: Long=0
  private var timeEndMS: Long=0

  def calculateTime(data: List[Byte],k:Int): Unit = {
    val checksum = singleMessageDoubleChecksum(data, 256, k, k)
    timeEndNS = System.nanoTime()
    timeEndMS = System.currentTimeMillis()
  }

  def singleMessageDoubleChecksum(message: List[Byte], modulus: Int, k: Int, blockSize: Int): Byte = {
    if (modulus <= 0) throw new IllegalArgumentException("Modulus must be a positive integer")
    if (blockSize <= 0) throw new IllegalArgumentException("Block size must be a positive integer")
    val dataBlocks = createBlocks(message, blockSize)
    timeStarMS = System.currentTimeMillis()
    timeStarNS = System.nanoTime()
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

  def getTimeMS(): Long = timeEndMS - timeStarMS
  def getTimeNS(): Long = timeEndNS - timeStarNS

}
