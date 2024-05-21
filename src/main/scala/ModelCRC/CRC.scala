package ModelCRC
import Interface.ICRC

class CRC extends ICRC{

  private var timeMS: Long = 0
  private var timeNS: Long = 0
  
  def calculateTime(message:String): Unit = {
    val messageByteString = normalStringToByteString(message)
    val startMS = System.currentTimeMillis()
    val startNS = System.nanoTime()
    val polinomio = "1001"
    val remainder = residue(message, polinomio)
    val endNS = System.nanoTime()
    val endMS = System.currentTimeMillis()
    timeMS = endMS - startMS
    timeNS = endNS - startNS
  }
  def normalStringToByteString(normalString: String): String = {
    @scala.annotation.tailrec
    def convert(bytes: Array[Byte], index: Int, result: String): String = {
      if (index >= bytes.length)
        result
      else
        convert(bytes, index + 1, result + bytes(index).toChar)
    }
    val bytes = normalString.getBytes("UTF-8")
    convert(bytes, 0, "")
  }
  
  def byteStringToNormalString(byteString: String): String = {
    @scala.annotation.tailrec
    def convert(chars: List[Char], result: String): String = chars match {
      case Nil => result
      case head :: tail => convert(tail, result + head)
    }

    convert(byteString.toList, "")
  }
  
  def residue(dividend: String, polinomio: String): String = {
    def auxBinaryModulo2(remainder: String, divisor: String): String = {
      if (remainder.length < polinomio.length) {
        remainder
      } else {
        val newRemainder = if (remainder.head == '1') xor(remainder.take(polinomio.length), divisor) + remainder.drop(polinomio.length) else remainder.drop(1)
        auxBinaryModulo2(newRemainder, divisor)
      }
    }

    val paddedDividend = dividend + "0" * (polinomio.length - 1)
    auxBinaryModulo2(paddedDividend, polinomio)
  }

  def xor(a: String, b: String): String = {
    a.zip(b).map { case (bitA, bitB) => if (bitA == bitB) '0' else '1' }.mkString
  }


  def verifyMessage(message: String, polinomio: String, remainder: String): Boolean = {
    val newMessage = message + remainder
    val newRemainder = residue(newMessage, polinomio)
    newRemainder.forall(_ == '0')
  }

  def getMessage(message: String, polinomio: String, remainder: String): String = {
    val newMessage = message + remainder
    val newRemainder = residue(newMessage, polinomio)
    newMessage.dropRight(newRemainder.length)
  }

  def getTimeMS(): Long = timeMS
  def getTimeNS(): Long = timeNS

}

object CRC extends CRC

