# Test Design
  
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
