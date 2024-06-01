import munit.*
import ModelCRC.CRC

class TestCRC extends FunSuite {

  test("normalCaseResidue1") {
    val result = CRC().residue("1110010101", "1101")
    assertEquals(result, "110")
  }

  test("normalCaseResidue2") {
    val result = CRC().residue("11010011101100", "1011")
    assertEquals(result, "100")
  }

  test("residue16BitPolynomial") {
    val result = CRC().residue("1110010101010101", "1101111100000111")
    assertEquals(result, "011111011111111")
  }

  test("residue32BitPolynomial") {
    val result = CRC().residue("1110010101010101010101010101", "11011111000000011110000011111111")
    assertEquals(result, "0001011010001111111111100011101")
  }

  test("residueLargerInputs") {
    val result = CRC().residue("1110010101010101010101010101", "11011111")
    assertEquals(result, "0010101")
  }


  test("residueNonZeroRemainder") {
    val result = CRC().residue("1110010101", "1101")
    assertNotEquals(result, "")
  }


  test("verifyMessageNoErrors") {
    val result = CRC().verifyMessage("11010011101100", "1011", "100")
    assertEquals(result, true)
  }

  test("verifyMessageNoErrors2") {
    val result = CRC().verifyMessage("1110010101", "1101", "110")
    assertEquals(result, true)
  }


  test("verifyMessageWithErrors") {
    val result = CRC().verifyMessage("1110010101", "1101", "001")
    assertEquals(result, false)
  }

  test("normalCaseXOR1") {
    val result = CRC().xor("1101", "0010")
    assertEquals(result, "1111")
  }

  test("normalCaseXOR2") {
    val result = CRC().xor("1010101010", "0101010101")
    assertEquals(result, "1111111111")
  }

  test("normalCaseXOR3") {
    val result = CRC().xor("11110000", "00001111")
    assertEquals(result, "11111111")
  }

  test("normalCaseXOR4") {
    val result = CRC().xor("11101000", "00010111")
    assertEquals(result, "11111111")
  }

  test("normalCaseXOR5") {
    val result = CRC().xor("11110000", "11001100")
    assertEquals(result, "00111100")
  }

  test("normalCaseXOR6") {
    val result = CRC().xor("110111", "110011")
    assertEquals(result, "000100")
  }

  test("normalCaseXOR7") {
    val result = CRC().xor("101010100110", "100110101010")
    assertEquals(result, "001100001100")
  }

  test("xorEmpty") {
    val result = CRC().xor("", "")
    assertEquals(result, "")
  }

  test("xorLengthOneOnlyOnes") {
    val result = CRC().xor("1", "1")
    assertEquals(result, "0")
  }

  test("xorLengthOneOnlyZeros") {
    val result = CRC().xor("0", "0")
    assertEquals(result, "0")
  }

  test("xorLengthOneMix") {
    val result1 = CRC().xor("1", "0")
    val result2 = CRC().xor("0", "1")
    assertEquals(result1, "1")
    assertEquals(result2, "1")
  }

  test("xorAllZeros1") {
    val result = CRC().xor("0000000000", "0000000000")
    assertEquals(result, "0000000000")
  }

  test("xorAllZeros2") {
    val result = CRC().xor("000000000000", "000000000000")
    assertEquals(result, "000000000000")
  }

  test("xorAllOnes1") {
    val result = CRC().xor("11111", "11111")
    assertEquals(result, "00000")
  }

  test("xorAllOnes2") {
    val result = CRC().xor("1111111", "1111111")
    assertEquals(result, "0000000")
  }

  test("getMessages") {
    val result = CRC().getMessage("11010011101100", "1011", "100")
    assertEquals(result, "11010011101100")
  }

  test("getMessageDifferentInputs") {
      val result = CRC().getMessage("1110010101", "1101", "110")
    assertEquals(result, "1110010101")
  }

  test("getMessageInvalidRemainder") {
    val result = CRC().getMessage("1110010101", "1101", "111")
    assertEquals(result, "1110010101")
  }

  test("verifyMessageEmptyMessage") {
    val result = CRC().verifyMessage("", "1101", "000")
    assertEquals(result, true)
  }

  test("verifyMessageDifferentCombinations") {
    val result1 = CRC().verifyMessage("110101", "1011", "000")
    val result2 = CRC().verifyMessage("1110010101", "1101", "110")
    val result3 = CRC().verifyMessage("1010101010", "10011", "0000")
    assertEquals(result1, false)
    assertEquals(result2, true)
    assertEquals(result3, false)
  }

  test("normalStringToByteString and byteStringToNormalString with regular string") {
    val originalString = "Hello, World!"
    val byteString = CRC().normalStringToByteString(originalString)
    val resultString = CRC().byteStringToNormalString(byteString)
    assertEquals(resultString, originalString)
  }

  test("normalStringToByteString and byteStringToNormalString with empty string") {
    val originalString = ""
    val byteString = CRC().normalStringToByteString(originalString)
    val resultString = CRC().byteStringToNormalString(byteString)
    assertEquals(resultString, originalString)
  }

  test("normalStringToByteString and byteStringToNormalString with long string") {
    val originalString = "a" * 1000
    val byteString = CRC().normalStringToByteString(originalString)
    val resultString = CRC().byteStringToNormalString(byteString)
    assertEquals(resultString, originalString)
  }

}
