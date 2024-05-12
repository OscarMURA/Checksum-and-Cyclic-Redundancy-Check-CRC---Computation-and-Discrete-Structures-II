import munit.*
import ModelCheckSum.CheckSum

class TestChecksum extends FunSuite {




  test("Positive Test 1: Chunck data with blockSize 2") {
    val data = List[Byte](1, 2, 3, 4, 5, 6)
    val blockSize = 2
    val expectedChunckedData = List[Byte](3, 7, 11) // (1+2, 3+4, 5+6)
    assertEquals(CheckSum().chunckData(data, blockSize), expectedChunckedData)
  }

  test("Positive Test 2: Chunck data with blockSize 3") {
    val data = List[Byte](1, 2, 3, 4, 5, 6)
    val blockSize = 3
    val expectedChunckedData = List[Byte](6, 15) // (1+2+3, 4+5+6)
    assertEquals(CheckSum().chunckData(data, blockSize), expectedChunckedData)
  }

  test("Positive Test 3: Chunck data with blockSize 1") {
    val data = List[Byte](1, 2, 3, 4, 5, 6)
    val blockSize = 1
    val expectedChunckedData = List[Byte](1, 2, 3, 4, 5, 6) // Each element in its own block
    assertEquals(CheckSum().chunckData(data, blockSize), expectedChunckedData)
  }

  test("Positive Test 4: Chunck data with empty data") {
    val data = List[Byte]()
    val blockSize = 2
    val expectedChunckedData = List[Byte]() // Empty list
    assertEquals(CheckSum().chunckData(data, blockSize), expectedChunckedData)
  }

  test("Positive Test 5: Chunck data with blockSize larger than data size") {
    val data = List[Byte](1, 2, 3)
    val blockSize = 2
    val expectedChunckedData = List[Byte](3,3)// Sum of all elements
    assertEquals(CheckSum().chunckData(data, blockSize), expectedChunckedData)
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