# Test Design


### Test Name and Number

#### Brief Description and Objective

This test suite evaluates the functionality of the CheckSum class, which is responsible for calculating checksums for messages. The checksum calculation employs a double checksum algorithm, which involves splitting the message into blocks, calculating checksums for each block, and then combining them to generate a final checksum. The objective is to ensure that the CheckSum class performs accurately under various scenarios and handles different inputs appropriately.

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

**Output**
```scala
Intercepts IllegalArgumentException
```
