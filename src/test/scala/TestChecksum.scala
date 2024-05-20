import munit.*
import ModelCheckSum.CheckSum

class TestChecksum extends FunSuite {
  
  test("Positive test: Checksum calculation for a valid message") {
    val message = List[Byte](72, 101, 108, 108, 111) // "Hello" in ASCII
    val modulus = 256
    val k = 8
    val blockSize = 2
    val expectedChecksum: Byte = 72
    val actualChecksum = CheckSum().singleMessageDoubleChecksum(message, modulus, k, blockSize)
    assertEquals(actualChecksum, expectedChecksum)
  }

  test("Positive test: Checksum calculation for a message with different characters") {
    val message = List[Byte](84, 101, 115, 116, 105, 110, 103) // "Testing" in ASCII
    val modulus = 256
    val k = 8
    val blockSize = 2
    val expectedChecksum: Byte = 19
    val actualChecksum = CheckSum().singleMessageDoubleChecksum(message, modulus, k, blockSize)
    assertEquals(actualChecksum, expectedChecksum)
  }

  test("Positive test: Checksum calculation for a longer message") {
    val message = "This is a longer message to test the checksum function".getBytes().toList
    val modulus = 256
    val k = 8
    val blockSize = 10
    val expectedChecksum: Byte = -20 // Value calculated from the actual function
    val actualChecksum = CheckSum().singleMessageDoubleChecksum(message, modulus, k, blockSize)
    assertEquals(actualChecksum, expectedChecksum)
  }

  test("Positive test: Checksum calculation for a small message") {
    val message = List[Byte](72, 105) // "Hi" in ASCII
    val modulus = 256
    val k = 8
    val blockSize = 1
    val expectedChecksum: Byte = -90 // Value calculated from the actual function
    val actualChecksum = CheckSum().singleMessageDoubleChecksum(message, modulus, k, blockSize)
    assertEquals(actualChecksum, expectedChecksum)
  }

  test("Positive test: Checksum calculation for an empty message") {
    val message = List[Byte]()
    val modulus = 256
    val k = 8
    val blockSize = 1
    val expectedChecksum: Byte = 0
    val actualChecksum = CheckSum().singleMessageDoubleChecksum(message, modulus, k, blockSize)
    assertEquals(actualChecksum, expectedChecksum)
  }

  test("Negative test: Checksum calculation with invalid modulus (zero)") {
    val message = "Test".getBytes().toList
    val modulus = 0
    val k = 8
    val blockSize = 2
    intercept[IllegalArgumentException] {
      CheckSum().singleMessageDoubleChecksum(message, modulus, k, blockSize)
    }
  }

  test("Negative test: Checksum calculation with invalid block size (zero)") {
    val message = "Test".getBytes().toList
    val modulus = 256
    val k = 8
    val blockSize = 0
    intercept[IllegalArgumentException] {
      CheckSum().singleMessageDoubleChecksum(message, modulus, k, blockSize)
    }
  }

  test("Negative test: Checksum calculation with negative modulus") {
    val message = "Test".getBytes().toList
    val modulus = -256
    val k = 8
    val blockSize = 2
    intercept[IllegalArgumentException] {
      CheckSum().singleMessageDoubleChecksum(message, modulus, k, blockSize)
    }
  }

  test("Negative test: Checksum calculation with negative block size") {
    val message = "Test".getBytes().toList
    val modulus = 256
    val k = 8
    val blockSize = -2
    intercept[IllegalArgumentException] {
      CheckSum().singleMessageDoubleChecksum(message, modulus, k, blockSize)
    }
  }

  test("Negative test: Checksum calculation with block size greater than message length") {
    val message = "Test".getBytes().toList
    val modulus = 256
    val k = 8
    val blockSize = 10
    intercept[IllegalArgumentException] {
      CheckSum().singleMessageDoubleChecksum(message, modulus, k, blockSize)
    }
  }


  test("Positive Test 1: Create blocks with blockSize 2") {
    val data = List[Byte](1, 2, 3, 4, 5, 6)
    val blockSize = 2
    val expectedBlocks = List(List[Byte](1, 2), List[Byte](3, 4), List[Byte](5, 6))
    assertEquals(CheckSum().createBlocks(data, blockSize), expectedBlocks)
  }

  test("Positive Test 2: Create blocks with blockSize 3") {
    val data = List[Byte](1, 2, 3, 4, 5, 6)
    val blockSize = 3
    val expectedBlocks = List(List[Byte](1, 2, 3), List[Byte](4, 5, 6))
    assertEquals(CheckSum().createBlocks(data, blockSize), expectedBlocks)
  }

  test("Positive Test 3: Create blocks with empty data") {
    val data = List[Byte]()
    val blockSize = 2
    val expectedBlocks = List[List[Byte]]() // Empty list of blocks
    assertEquals(CheckSum().createBlocks(data, blockSize), expectedBlocks)
  }

  test("Positive Test 4: Create blocks with blockSize larger than data size") {
    val data = List[Byte](1, 2, 3)
    val blockSize = 5
    val expectedBlocks = List(List[Byte](1, 2, 3)) // Entire data in one block
    assertEquals(CheckSum().createBlocks(data, blockSize), expectedBlocks)
  }
  
}