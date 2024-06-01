
# Test Design CRC

In this case, the performance of the CRC algorithm was evaluated by testing through binary number strings. In the data loading, the volume of data was evaluated by means of large texts.
  
---

#### Normal Case Residue 1

This test verifies the correctness of the residue algorithm in a normal case.

**Input**
```scala  
val dividend = "1110010101"  
val polynomial = "1101"  
```  

**Output**
```scala  
val expectedOutput: String = "110"  
```  
  
---  

#### Normal Case Residue 2

This test verifies the correctness of the residue algorithm in a normal case, this time with more bits.

**Input**
```scala  
val dividend = "11010011101100"  
 val polynomial = "1011"  
```  

**Output**
```scala  
val expectedOutput: String = "100"  
```  
---  

#### Residue Larger Inputs

This test verifies the correctness of the residue algorithm, this time with more bits in the inputs.

**Input**
```scala  
val dividend = "1110010101010101010101010101"  
 val polynomial = "11011111"  
```  

**Output**
```scala  
val expectedOutput: String = "0010101"  
```  
  
---  

#### Residue 16 Bits Polynomial

This test verifies the correctness of the residue algorithm, this time with a 16 bits polynomial.

**Input**
```scala  
val dividend = "1110010101010101"  
val polynomial = "1101111100000111"  
```  

**Output**
```scala  
val expectedOutput: String = "011111011111111"  
```  
  
---  

#### Residue 32 Bits Polynomial

This test verifies the correctness of the residue algorithm, this time with a 32 bits polynomial.

**Input**
```scala  
val dividend = "1110010101010101010101010101"  
val polynomial = "11011111000000011110000011111111"  
```  

**Output**
```scala  
val expectedOutput: String = "0001011010001111111111100011101"  
```  
---  

#### Residue Non Zero Remainder

This test verifies the correctness of the residue algorithm, this time with a non-zero remainder.

**Input**
```scala  
val dividend = "1110010101"  
val polynomial = "1101"  
```  

**Output**
```scala  
val expectedOutput: String = ""  
```  
---  

#### Verify message no errors

This test verifies the correctness of the verify message algorithm no errors.

**Input**
```scala  
val dividend = "11010011101100"  
val polynomial = "1011"  
val remainder = "100"  
```  

**Output**
```scala  
val expectedOutput: Boolean = true  
```  
---  

#### Verify message no errors 2

This test verifies the correctness of the verify message algorithm no errors. this time with different inputs.

**Input**
```scala  
val dividend = "1110010101"  
val polynomial = "1101"  
val remainder = "110"  
```  

**Output**
```scala  
val expectedOutput: Boolean = true  
``` 
---   
#### Verify message with errors  
  
This test verifies the correctness of the verify message algorithm with errors.  
  
**Input**  
```scala
val dividend = "1110010101"  
val polynomial = "1101"  
val remainder = "001"
```  

**Output**
```scala  
val expectedOutput: Boolean = false  
```
---   
#### Verify message empty message  
  
This test verifies the correctness of the verify message algorithm with an empty message.  
  
**Input**  
```scala  
val dividend = ""  
val polynomial = "1101"  
val remainder = "000"  
```  

**Output**
```scala  
val expectedOutput: Boolean = true  
``` 
---   
#### Verify message different combinations  
  
This test verifies the correctness of the verify message algorithm with different combinations of inputs.  
  
**Input**  
```scala  
val dividend1 = "110101"  
val polynomial1 = "1011"  
val remainder1 = "000"  
  
val dividend2 = "1110010101"  
val polynomial2 = "1101"  
val remainder2 = "110"  
  
val dividend3 = "1010101010"  
val polynomial3 = "10011"  
val remainder3 = "0000"  
```  

**Output**
```scala  
val expectedOutput1: Boolean = false  
  
val expectedOutput2: Boolean = true  
  
val expectedOutput2: Boolean = false  
  
```
---

#### Normal case XOR 1

This test verifies the correctness of the XOR algorithm in a normal case.

**Input**
```scala  
val message1 = "1101" 
val message2 = "0010"
```  
**Output**
```scala  
val expectedOutput: String = "1111"  
```  
---  

#### Normal case XOR 2

This test verifies the correctness of the XOR algorithm in a normal case, this time with more bits.

**Input**
```scala  
val message1 = "1010101010"
val message2 = "0101010101"
```  
**Output**
```scala  
val expectedOutput: String = "1111111111"  
```  
---

#### Normal case XOR 3

This test verifies the correctness of the XOR algorithm in a normal case.

**Input**
```scala  
val message1 = "11110000"
val message2 = "00001111"
```  
**Output**
```scala  
val expectedOutput: String = "11111111"  
```  
---

#### Normal case XOR 4

This test verifies the correctness of the XOR algorithm in a normal case.

**Input**
```scala  
val message1 = "11101000"
val message2 = "00010111"
```  
**Output**
```scala  
val expectedOutput: String = "11111111"  
```  
---

#### Normal case XOR 5

This test verifies the correctness of the XOR algorithm in a normal case of not just '1's.

**Input**
```scala  
val message1 = "11110000"
val message2 = "11001100"
```  
**Output**
```scala  
val expectedOutput: String = "00111100"  
```  
---

#### Normal case XOR 6

This test verifies the correctness of the XOR algorithm in a normal case of not just '1's.

**Input**
```scala  
val message1 = "110111"
val message2 = "110011"
```  
**Output**
```scala  
val expectedOutput: String = "000100"  
```  
---

#### Normal case XOR 7

This test verifies the correctness of the XOR algorithm in a normal case of not just '1's.

**Input**
```scala  
val message1 = "101010100110"
val message2 = "100110101010"
```  
**Output**
```scala  
val expectedOutput: String = "001100001100"  
```  
---

#### Normal case XOR 7

This test verifies the correctness of the XOR algorithm in a normal case of not just '1's.

**Input**
```scala  
val message1 = "101010100110"
val message2 = "100110101010"
```  
**Output**
```scala  
val expectedOutput: String = "001100001100"  
```  
---

#### XOR empty

This test verifies the correctness of the XOR algorithm in a case of empty inputs

**Input**
```scala  
val message1 = ""
val message2 = ""
```  
**Output**
```scala  
val expectedOutput: String = ""  
```  
---

#### XOR lenght one, only ones

This test verifies the correctness of the XOR algorithm in a case of length 1 inputs

**Input**
```scala  
val message1 = "1"
val message2 = "1"
```  
**Output**
```scala  
val expectedOutput: String = "0"  

```  
---

#### XOR lenght one, only zeros

This test verifies the correctness of the XOR algorithm in a case of length 1 inputs

**Input**
```scala  
val message1 = "0"
val message2 = "0"
```  
**Output**
```scala  
val expectedOutput: String = "0"  

```  
---

#### XOR lenght one, mixed imputs

This test verifies the correctness of the XOR algorithm in a case of length 1 inputs. Both xor (message1, message2 and message2, message1)

**Input**
```scala  
val message1 = "0"
val message2 = "1"
```  
**Output**
```scala  
val expectedOutput1: String = "1"  
val expectedOutput2: String = "1"

```  
---

#### XOR only zeros 1.

This test verifies the correctness of the XOR algorithm in a case of an input of only zeros

**Input**
```scala  
val message1 = "0000000000"
val message2 = "0000000000"
```  
**Output**
```scala  
val expectedOutput: String = "0000000000"  

```  
#### XOR only zeros 2.

This test verifies the correctness of the XOR algorithm in a case of an input of only zeros

**Input**
```scala  
val message1 = "000000000000"
val message2 = "000000000000"
```  
**Output**
```scala  
val expectedOutput: String = "000000000000"  

```  
---

#### XOR only ones 1.

This test verifies the correctness of the XOR algorithm in a case of an input of only ones.

**Input**
```scala  
val message1 = "11111"
val message2 = "11111"
```  
**Output**
```scala  
val expectedOutput: String = "00000"  

```  
---

---

#### XOR only ones 2.

This test verifies the correctness of the XOR algorithm in a case of an input of only ones.

**Input**
```scala  
val message1 = "1111111"
val message2 = "1111111"
```  
**Output**
```scala  
val expectedOutput: String = "0000000"  

```  
---

#### GetMessage 1

This test case verifies whether the `getMessage` function returns the same input message when provided with specific polynomial and divisor values.

**Input**
```scala  
val message = "11010011101100"
val polinomio = "1011"
val remainder = "100"
```  
**Output**
```scala  
val expectedOutput: String = "11010011101100"  

```  
---

#### GetMessage 2

This test case also verifies whether the `getMessage` function returns the same input message but with different message, polynomial, and divisor values.

**Input**
```scala  
val message = "1110010101"
val polinomio = "1101"
val remainder = "110"
```  
**Output**
```scala  
val expectedOutput: String = "1110010101"  

```  
---

#### GetMessage 3

This test case checks whether the `getMessage` function properly handles a situation where the remainder of the CRC calculation doesn't match the expected value.

**Input**
```scala  
val message = "1110010101"
val polinomio = "1101"
val remainder = "111"
```  
**Output**
```scala  
val expectedOutput: String = "1110010101"  

```  
---
