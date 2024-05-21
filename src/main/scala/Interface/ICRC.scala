package Interface

trait ICRC{

  def residue(dividend: String, polinomio: String): String

  def xor(a: String, b: String): String

  def verifyMessage(message: String, polinomio: String, remainder: String): Boolean

  def getMessage(message: String, polinomio: String, remainder: String): String

}
