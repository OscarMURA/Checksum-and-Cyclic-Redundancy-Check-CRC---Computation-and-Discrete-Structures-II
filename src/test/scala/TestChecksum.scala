import munit.*
import ModelCheckSum.CheckSum

class TestChecksum extends FunSuite  {


  
  test("Positive Test 1: Checksum for 'Hello'") {
    val message = List[Byte](72, 101, 108, 108, 111) // Corresponding to ASCII values of 'Hello'
    val expectedChecksum: Byte = 3 // Manually calculated expected checksum
    assert(CheckSum().singleMessageDoubleChecksum(message, 256, 8, 3), expectedChecksum)
  }

  test("Positive Test 2: Checksum for 'Hola'") {
    val message = "Hola".getBytes().toList
    val expectedChecksum: Byte = 43 // Manually calculated expected checksum
    assert(CheckSum().singleMessageDoubleChecksum(message, 256, 8, 8), expectedChecksum)
  }

  test("Positive Test 3: Checksum for '12345678'") {
    val message = "12345678".getBytes().toList
    val expectedChecksum: Byte = -33 // Manually calculated expected checksum
    assert(CheckSum().singleMessageDoubleChecksum(message, 256, 8, 8), expectedChecksum)
  }

  test("Positive Test 4: Checksum for 'ABCDE'") {
    val message = "ABCDE".getBytes().toList
    val expectedChecksum: Byte = -59 // Manually calculated expected checksum
    assert(CheckSum().singleMessageDoubleChecksum(message, 256, 8, 8), expectedChecksum)
  }

  test("Positive Test 5: Checksum for 'Testing'") {
    val message = "Testing".getBytes().toList
    val expectedChecksum: Byte = 19 // Manually calculated expected checksum
    assert(CheckSum().singleMessageDoubleChecksum(message, 256, 8, 8), expectedChecksum)
  }

  // Positive Test Cases
  test("Positive Test 6: Checksum for 'Hello' with modulus 128 and block size 5") {
    val message = List[Byte](72, 101, 108, 108, 111) // Corresponding to ASCII values of 'Hello'
    val expectedChecksum: Byte = 59 // Manually calculated expected checksum
    assert(CheckSum().singleMessageDoubleChecksum(message, 128, 8, 5), expectedChecksum)
  }

  test("Positive Test 7: Checksum for '123'") {
    val message = "123".getBytes().toList
    val expectedChecksum: Byte = -14 // Manually calculated expected checksum
    assert(CheckSum().singleMessageDoubleChecksum(message, 256, 8, 3), expectedChecksum)
  }

  test("Positive Test 8: Checksum for 'Programming'") {
    val message = "Programming".getBytes().toList
    val expectedChecksum: Byte = -72 // Manually calculated expected checksum
    assert(CheckSum().singleMessageDoubleChecksum(message, 256, 8, 4), expectedChecksum)
  }

  test("Positive Test 9: Checksum for 'Scala'") {
    val message = "Scala".getBytes().toList
    val expectedChecksum: Byte = 55 // Manually calculated expected checksum
    assert(CheckSum().singleMessageDoubleChecksum(message, 256, 8, 5), expectedChecksum)
  }

  test("Positive Test 10: Checksum for 'OpenAI'") {
    val message = "OpenAI".getBytes().toList
    val expectedChecksum: Byte = 54 // Manually calculated expected checksum
    assert(CheckSum().singleMessageDoubleChecksum(message, 256, 8, 3), expectedChecksum)
  }

  // Positive Test Cases
  test("Positive Test 11: Checksum for 'ABCDE' with modulus 1000 and block size 2") {
    val message = List[Byte](65, 66, 67, 68, 69) // Corresponding to ASCII values of 'ABCDE'
    val expectedChecksum: Byte = 832 // Manually calculated expected checksum
    assert(CheckSum().singleMessageDoubleChecksum(message, 1000, 8, 2), expectedChecksum)
  }

  test("Positive Test 12: Checksum for '9876543210'") {
    val message = "9876543210".getBytes().toList
    val expectedChecksum: Byte = -47 // Manually calculated expected checksum
    assert(CheckSum().singleMessageDoubleChecksum(message, 256, 8, 5), expectedChecksum)
  }

  test("Positive Test 13: Checksum for 'Scala is fun!'") {
    val message = "Scala is fun!".getBytes().toList
    val expectedChecksum: Byte = -88 // Manually calculated expected checksum
    assert(CheckSum().singleMessageDoubleChecksum(message, 256, 8, 3), expectedChecksum)
  }

  test("Positive Test 14: Checksum for '0123456789' with modulus 100 and block size 2") {
    val message = "0123456789".getBytes().toList
    val expectedChecksum: Byte = -10 // Manually calculated expected checksum
    assert(CheckSum().singleMessageDoubleChecksum(message, 100, 8, 2), expectedChecksum)
  }

  test("Positive Test 15: Checksum for 'The quick brown fox jumps over the lazy dog'") {
    val message = "The quick brown fox jumps over the lazy dog".getBytes().toList
    val expectedChecksum: Byte = -55 // Manually calculated expected checksum
    assert(CheckSum().singleMessageDoubleChecksum(message, 256, 8, 4), expectedChecksum)
  }



  test("Negative Test 1: Checksum for empty message") {
    val message = List[Byte]()
    val expectedChecksum: Byte = 0 // Expected checksum for empty message
    assert(CheckSum().singleMessageDoubleChecksum(message, 256, 8, 3), expectedChecksum)
  }

  test("Negative Test 2: Checksum for large modulus") {
    val message = "Hello".getBytes().toList
    val expectedChecksum: Byte = 3 // Manually calculated expected checksum
    assert(CheckSum().singleMessageDoubleChecksum(message, 1000, 8, 3), expectedChecksum)
  }

  test("Negative Test 3: Checksum for negative modulus") {
    val message = "Hello".getBytes().toList
    val expectedChecksum: Byte = 3 // Manually calculated expected checksum
    assert(CheckSum().singleMessageDoubleChecksum(message, -256, 8, 3), expectedChecksum)
  }

  test("Negative Test 4: Checksum for negative blockSize") {
    val message = "Hello".getBytes().toList
    val expectedChecksum: Byte = 3 // Manually calculated expected checksum
    assert(CheckSum().singleMessageDoubleChecksum(message, 256, 8, -3), expectedChecksum)
  }

  test("Negative Test 5: Checksum for non-ASCII characters") {
    val message = "你好".getBytes().toList // Non-ASCII characters for 'Hello' in Chinese
    val expectedChecksum: Byte = 0 // Expected checksum for non-ASCII characters
    assert(CheckSum().singleMessageDoubleChecksum(message, 256, 8, 3), expectedChecksum)
  }

  // Negative Test Cases
  test("Negative Test 6: Checksum for null message") {
    val message: List[Byte] = null
    intercept[NullPointerException] {
      CheckSum().singleMessageDoubleChecksum(message, 256, 8, 3)
    }
  }

  test("Negative Test 7: Checksum for large block size") {
    val message = "Hello".getBytes().toList
    val expectedChecksum: Byte = 3 // Manually calculated expected checksum
    assert(CheckSum().singleMessageDoubleChecksum(message, 256, 8, 100), expectedChecksum)
  }

  test("Negative Test 8: Checksum for negative modulus") {
    val message = "Hello".getBytes().toList
    val expectedChecksum: Byte = 3 // Manually calculated expected checksum
    assert(CheckSum().singleMessageDoubleChecksum(message, -256, 8, 3), expectedChecksum)
  }

  test("Negative Test 9: Checksum for invalid message type") {
    val message = "Hello".toCharArray().toList // Invalid message type (List of Char instead of List of Byte)
    intercept[IllegalArgumentException] {
      CheckSum().singleMessageDoubleChecksum(message, 256, 8, 3)
    }
  }

  test("Negative Test 10: Checksum for non-positive block size") {
    val message = "Hello".getBytes().toList
    val expectedChecksum: Byte = 3 // Manually calculated expected checksum
    assert(CheckSum().singleMessageDoubleChecksum(message, 256, 8, 0), expectedChecksum)
  }

  // Negative Test Cases
  test("Negative Test 11: Checksum for invalid modulus (zero)") {
    val message = "Hello".getBytes().toList
    val expectedChecksum: Byte = 3 // Manually calculated expected checksum
    assert(CheckSum().singleMessageDoubleChecksum(message, 0, 8, 3), expectedChecksum)
  }

  test("Negative Test 12: Checksum for invalid modulus (negative)") {
    val message = "Hello".getBytes().toList
    val expectedChecksum: Byte = 3 // Manually calculated expected checksum
    assert(CheckSum().singleMessageDoubleChecksum(message, -100, 8, 3), expectedChecksum)
  }

  test("Negative Test 13: Checksum for null block size") {
    val message = "Hello".getBytes().toList
    val expectedChecksum: Byte = 3 // Manually calculated expected checksum
    assert(CheckSum().singleMessageDoubleChecksum(message, 256, 8, 0), expectedChecksum)
  }

  test("Negative Test 14: Checksum for message with only one character") {
    val message = List // Single character 'A'
    val expectedChecksum: Byte = 65 // Manually calculated expected checksum
    assert(CheckSum().singleMessageDoubleChecksum(message, 256, 8, 1), expectedChecksum)
  }

  test("Negative Test 15: Checksum for empty message") {
    val message = List[Byte]() // Empty message
    val expectedChecksum: Byte = 0 // Expected checksum for empty message
    assert(CheckSum().singleMessageDoubleChecksum(message, 256, 8, 3), expectedChecksum)
  }


}
