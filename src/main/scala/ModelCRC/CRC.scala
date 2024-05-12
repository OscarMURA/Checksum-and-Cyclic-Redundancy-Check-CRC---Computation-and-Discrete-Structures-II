package ModelCRC

class CRC extends ICRC{

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

}
