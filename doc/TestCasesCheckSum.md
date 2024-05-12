# Test Design

---

#### Positive test: Checksum calculation for a valid message

This test verifies the correctness of the checksum calculation for a valid message composed of ASCII characters. The input message "Hello" is converted into a list of bytes, and the checksum is calculated using the singleMessageDoubleChecksum method of the CheckSum class. The expected checksum value is compared with the actual calculated checksum.

**Input**
```scala
val message = List[Byte](72, 101, 108, 108, 111) // "Hello" in ASCII
val modulus = 256
val k = 8
val blockSize = 2
```

**Output**
```scala
val expectedChecksum: Byte = 72
```

---

#### Positive test: Checksum calculation for a message with different characters

This test ensures the accuracy of the checksum calculation when the input message contains characters other than alphabets. The input message "Testing" is converted into a list of bytes, and the checksum is computed using the singleMessageDoubleChecksum method. The expected checksum value is compared with the actual calculated checksum.

**Input**
```scala
val message = List[Byte](84, 101, 115, 116, 105, 110, 103) // "Testing" in ASCII
val modulus = 256
val k = 8
val blockSize = 2
```

**Output**
```scala
val expectedChecksum: Byte = 19
```

---

#### Positive test: Checksum calculation for a longer message

This test validates the checksum calculation for a longer input message. The input message, "This is a longer message to test the checksum function," is converted into a list of bytes, and the checksum is computed using the singleMessageDoubleChecksum method. The expected checksum value is compared with the actual calculated checksum.

**Input**
```scala
val message = "This is a longer message to test the checksum function".getBytes().toList
val modulus = 256
val k = 8
val blockSize = 10
```

**Output**
```scala
val expectedChecksum: Byte = -20 // Value calculated from the actual function
```

---

#### Positive test: Checksum calculation for a small message

This test validates the checksum calculation for a small input message. The input message "Hi" is converted into a list of bytes, and the checksum is computed using the singleMessageDoubleChecksum method. The expected checksum value is compared with the actual calculated checksum.

**Input**
```scala
val message = List[Byte](72, 105) // "Hi" in ASCII
val modulus = 256
val k = 8
val blockSize = 1
```

**Output**
```scala
val expectedChecksum: Byte = -90 // Value calculated from the actual function
```

---

#### Positive test: Checksum calculation for an empty message

This test ensures that the checksum calculation behaves correctly when provided with an empty input message. An empty list of bytes is passed as the message, and the checksum is computed using the singleMessageDoubleChecksum method. The expected checksum value is compared with the actual calculated checksum.

**Input**
```scala
val message = List[Byte]()
val modulus = 256
val k = 8
val blockSize = 1
```

**Output**
```scala
val expectedChecksum: Byte = 0
```

---

#### Negative test: Checksum calculation with invalid modulus (zero)

This test verifies the error handling mechanism when an invalid modulus (zero) is provided for checksum calculation. The input message "Test" is converted into a list of bytes, and an attempt is made to compute the checksum with a modulus value of zero. An IllegalArgumentException is expected to be thrown during this operation.

**Input**
```scala
val message = "Test".getBytes().toList
val modulus = 0
val k = 8
val blockSize = 2
```

**Output**
```scala
Intercepts IllegalArgumentException
```

---

#### Negative test: Checksum calculation with invalid block size (zero)

This test checks the error handling behavior when an invalid block size (zero) is provided for checksum calculation. The input message "Test" is converted into a list of bytes, and an attempt is made to compute the checksum with a block size value of zero. An IllegalArgumentException is expected to be thrown during this operation.

**Input**
```scala
val message = "Test".getBytes().toList
val modulus = 256
val k = 8
val blockSize = 0
```

**Output**
```scala
Intercepts IllegalArgumentException
```

---

#### Negative test: Checksum calculation with negative modulus

This test evaluates the error handling mechanism when a negative modulus value is provided for checksum calculation. The input message "Test" is converted into a list of bytes, and an attempt is made to compute the checksum with a negative modulus value. An IllegalArgumentException is expected to be thrown during this operation.

**Input**
```scala
val message = "Test".getBytes().toList
val modulus = -256
val k = 8
val blockSize = 2
```

**Output**
```scala
Intercepts IllegalArgumentException
```

---

#### Negative test: Checksum calculation with negative block size

This test examines the error handling behavior when a negative block size value is provided for checksum calculation. The input message "Test" is converted into a list of bytes, and an attempt is made to compute the checksum with a negative block size value. An IllegalArgumentException is expected to be thrown during this operation.

**Input**
```scala
val message = "Test".getBytes().toList
val modulus = 256
val k = 8
val blockSize = -2
```

**Output**
```scala
Intercepts IllegalArgumentException
```

---

#### Negative test: Checksum calculation with block size greater than message length

This test assesses the error handling mechanism when the block size provided for checksum calculation is greater than the length of the input message. The input message "Test" is converted into a list of bytes, and an attempt is made to compute the checksum with a block size greater than the message length. An IllegalArgumentException is expected to be thrown during this operation.

**Input**
```scala
val message = "Test".getBytes().toList
val modulus = 256
val k = 8
val blockSize = 10
```

#### Positive Test 1: Chunck data with blockSize 2

This test verifies the correctness of the data chunking process when the blockSize is set to 2. The input data [1, 2, 3, 4, 5, 6] is chunked into blocks of size 2, and the sum of consecutive elements within each block is computed. The expected chunked data is compared with the actual chunked data obtained from the chunckData method of the CheckSum class.

**Input**
```scala
val data = List[Byte](1, 2, 3, 4, 5, 6)
val blockSize = 2
```

**Output**
```scala
val expectedChunckedData = List[Byte](3, 7, 11) // (1+2, 3+4, 5+6)
```

---

#### Positive Test 2: Chunck data with blockSize 3

This test ensures the accuracy of the data chunking process when the blockSize is set to 3. The input data [1, 2, 3, 4, 5, 6] is chunked into blocks of size 3, and the sum of consecutive elements within each block is computed. The expected chunked data is compared with the actual chunked data obtained from the chunckData method.

**Input**
```scala
val data = List[Byte](1, 2, 3, 4, 5, 6)
val blockSize = 3
```

**Output**
```scala
val expectedChunckedData = List[Byte](6, 15) // (1+2+3, 4+5+6)
```

---

#### Positive Test 3: Chunck data with blockSize 1

This test validates the data chunking process when the blockSize is set to 1. Each element of the input data [1, 2, 3, 4, 5, 6] is considered as an individual block. The expected chunked data is compared with the actual chunked data obtained from the chunckData method.

**Input**
```scala
val data = List[Byte](1, 2, 3, 4, 5, 6)
val blockSize = 1
```

**Output**
```scala
val expectedChunckedData = List[Byte](1, 2, 3, 4, 5, 6) // Each element in its own block
```

---

#### Positive Test 4: Chunck data with empty data

This test ensures that the data chunking process behaves correctly when provided with an empty input data. An empty list of bytes is passed as the input data, and the blockSize is set to 2. The expected chunked data is compared with the actual chunked data obtained from the chunckData method.

**Input**
```scala
val data = List[Byte]()
val blockSize = 2
```

**Output**
```scala
val expectedChunckedData = List[Byte]() // Empty list
```

---

#### Positive Test 5: Chunck data with blockSize larger than data size

This test validates the behavior of the data chunking process when the blockSize is larger than the size of the input data. The input data [1, 2, 3] is chunked into blocks of size 2, and since the blockSize exceeds the data size, the sum of all elements is considered as a single block. The expected chunked data is compared with the actual chunked data obtained from the chunckData method.

**Input**
```scala
val data = List[Byte](1, 2, 3)
val blockSize = 2
```

**Output**
```scala
val expectedChunckedData = List[Byte](3,3) // Sum of all elements
```

---

#### Positive Test 1: Create blocks with blockSize 2

This test verifies the correctness of the block creation process when the blockSize is set to 2. The input data [1, 2, 3, 4, 5, 6] is divided into blocks of size 2, and each block is represented as a sublist. The expected blocks are compared with the actual blocks obtained from the createBlocks method of the CheckSum class.

**Input**
```scala
val data = List[Byte](1, 2, 3, 4, 5, 6)
val blockSize = 2
```

**Output**
```scala
val expectedBlocks = List(List[Byte](1, 2), List[Byte](3, 4), List[Byte](5, 6))
```

---

#### Positive Test 2: Create blocks with blockSize 3

This test ensures the accuracy of the block creation process when the blockSize is set to 3. The input data [1, 2, 3, 4, 5, 6] is divided into blocks of size 3, and each block is represented as a sublist. The expected blocks are compared with the actual blocks obtained from the createBlocks method.

**Input**
```scala
val data = List[Byte](1, 2, 3, 4, 5, 6)
val blockSize = 3
```

**Output**
```scala
val expectedBlocks = List(List[Byte](1, 2, 3), List[Byte](4, 5, 6))
```

---

#### Positive Test 3: Create blocks with empty data

This test validates the block creation process when provided with an empty input data. An empty list of bytes is passed as the input data, and the blockSize is set to 2. The expected result is an empty list of blocks, which is compared with the actual blocks obtained from the createBlocks method.

**Input**
```scala
val data = List[Byte]()
val blockSize = 2
```

**Output**
```scala
val expectedBlocks = List[List[Byte]]() // Empty list of blocks
```

---

#### Positive Test 4: Create blocks with blockSize larger than data size

This test examines the behavior of the block creation process when the blockSize is larger than the size of the input data. The input data [1, 2, 3] is divided into blocks of size 5, and since the blockSize exceeds the data size, the entire data is represented as a single block. The expected blocks are compared with the actual blocks obtained from the createBlocks method.

**Input**
```scala
val data = List[Byte](1, 2, 3)
val blockSize = 5
```

**Output**
```scala
val expectedBlocks = List(List[Byte](1, 2, 3)) // Entire data in one block
```

**Output**
```scala
Intercepts IllegalArgumentException
```
