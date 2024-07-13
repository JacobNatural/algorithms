# Java Algorithms Collection

Welcome to the Java Algorithms Collection! This repository houses various basic algorithms organized into different packages to facilitate learning and exploration.

## Packages and Algorithms Included
Cipher
### Package: Cipher

#### Class: [Caesar Cipher](https://github.com/JacobNatural/Algorithms/blob/master/src/main/java/com/app/cipher/caesar_cipher/CaesarCipher.java)
- A basic encryption technique where each letter in the plaintext is shifted a certain number of places down or up the alphabet.

#### Class: [Replacement Cipher](https://github.com/JacobNatural/Algorithms/blob/master/src/main/java/com/app/cipher/replacement_cipher/ReplacementCipher.java)
- An encryption method where each letter in the plaintext is replaced with another letter.

#### Class: [RSA Cipher](https://github.com/JacobNatural/Algorithms/blob/master/src/main/java/com/app/cipher/rsa_cipher/RSACipher.java)
- A public-key encryption algorithm that uses two different keys, one for encryption and one for decryption.

### Package: Geometry

#### Class: [Point](https://github.com/JacobNatural/Algorithms/blob/master/src/main/java/com/app/geometry/point/Point.java)
- Methods:
    - Vector Product
    - Dot Product
    - Point Comparison
    - Vector Calculation between Two Points

#### Class: [LineFunction](https://github.com/JacobNatural/Algorithms/blob/master/src/main/java/com/app/geometry/line_function/LineFunction.java)
- Method:
    - Check if a Point is on the Line

#### Class: [LineSegment](https://github.com/JacobNatural/Algorithms/blob/master/src/main/java/com/app/geometry/line_segment/LineSegment.java)
- Methods:
    - Check if Two Line Segments Intersect
    - Check if a Point Lies on the Line Segment

### Package: Huffman

#### Class: [HuffmanPack](https://github.com/JacobNatural/Algorithms/blob/master/src/main/java/com/app/huffman/HuffmanPack.java)
- Method:
    - Pack: Compresses text using Huffman coding

#### Class: [HuffmanUnpack](https://github.com/JacobNatural/Algorithms/blob/master/src/main/java/com/app/huffman/HuffmanUnpack.java)
- Method:
    - Unpack: Decompresses Huffman coded text

#### Class: [Node](https://github.com/JacobNatural/Algorithms/blob/master/src/main/java/com/app/huffman/Node.java)
- Utility class to assist in building Huffman trees

### Package: morse_code

#### Class: [MorseCode](https://github.com/JacobNatural/Algorithms/blob/master/src/main/java/com/app/morse_code/MorseCode.java)
- Methods:
    - toMorse: Converts text to Morse code
    - toAlphabet: Converts Morse code back to text

### Package: number

#### Subpackage: fibo

#### Class: [FibonacciBinet](https://github.com/JacobNatural/Algorithms/blob/master/src/main/java/com/app/numbers/fibo/FibonacciBinet.java)
- Method:
    - value: Calculate Fibonacci sequence using Binet's formula

#### Class: [FibonacciDynamic](https://github.com/JacobNatural/Algorithms/blob/master/src/main/java/com/app/numbers/fibo/FibonacciDynamic.java)
- Method:
    - value: Calculate Fibonacci sequence dynamically

#### Class: [FibonacciIterative](https://github.com/JacobNatural/Algorithms/blob/master/src/main/java/com/app/numbers/fibo/FibonacciIterative.java)
- Method:
    - value: Calculate Fibonacci sequence iteratively

#### Class: [FibonacciRecursive](https://github.com/JacobNatural/Algorithms/blob/master/src/main/java/com/app/numbers/fibo/FibonacciRecursive.java)
- Method:
    - value: Calculate Fibonacci sequence recursively

#### Subpackage: gcd

#### Class: [GcdEuclidIteration](https://github.com/JacobNatural/Algorithms/blob/master/src/main/java/com/app/numbers/gcd/GcdEuclidIteration.java)
- Method:
    - value: Calculate GCD using Euclidean algorithm iteratively

#### Class: [GcdEuclidRecursion](https://github.com/JacobNatural/Algorithms/blob/master/src/main/java/com/app/numbers/gcd/GcdEuclidRecursion.java)
- Method:
    - value: Calculate GCD using Euclidean algorithm recursively

#### Class: [GcdSubstractIteration](https://github.com/JacobNatural/Algorithms/blob/master/src/main/java/com/app/numbers/gcd/GcdSubtractIteration.java)
- Method:
    - value: Calculate GCD using subtraction method iteratively

#### Class: [GcdSubstractRecursion](https://github.com/JacobNatural/Algorithms/blob/master/src/main/java/com/app/numbers/gcd/GcdSubtractRecursion.java)
- Method:
    - value: Calculate GCD using subtraction method recursively

#### Subpackage: greedy_algorithm_gives_leftovers

#### Class: [Denominations](https://github.com/JacobNatural/Algorithms/blob/master/src/main/java/com/app/numbers/greedy_algorithm_gives_leftovers/Denominations.java)
- Method:
    - calculate: Implement greedy algorithm to distribute leftovers

#### Subpackage: polynomial

#### Class: [Polynomial](https://github.com/JacobNatural/Algorithms/blob/master/src/main/java/com/app/numbers/polynomial/Polynomial.java)
- Method:
    - calculate: Calculate polynomial with x

#### Class: [PolynomialUtility](https://github.com/JacobNatural/Algorithms/blob/master/src/main/java/com/app/numbers/polynomial/PolynomialUtility.java)
- Methods:
    - trapezoidal: Trapezoidal rule for numerical integration
    - rectangle: Rectangular rule for numerical integration
    - calculateZeroPlaces: Find zeros of a polynomial

#### Subpackage: position_system

#### Class: [Binary](https://github.com/JacobNatural/Algorithms/blob/master/src/main/java/com/app/numbers/position_systems/Binary.java)
- Methods:
    - changeToDecimal: Convert binary to decimal
    - changeToSystem: Convert decimal to binary

#### Class: [Hexadecimal](https://github.com/JacobNatural/Algorithms/blob/master/src/main/java/com/app/numbers/position_systems/Hexadecimal.java)
- Methods:
    - changeToDecimal: Convert hexadecimal to decimal
    - changeToSystem: Convert decimal to hexadecimal

#### Class: [Octal](https://github.com/JacobNatural/Algorithms/blob/master/src/main/java/com/app/numbers/position_systems/Octal.java)
- Methods:
    - changeToDecimal: Convert octal to decimal
    - changeToSystem: Convert decimal to octal

#### Subpackage: sieve_eratosthenes

#### Class: [SieveErastosthenes](https://github.com/JacobNatural/Algorithms/blob/master/src/main/java/com/app/numbers/sieve_eratosthenes/SieveEratosthenes.java)
- Method:
    - isPrime: Determine if a number is prime using Sieve of Eratosthenes

#### Subpackage: sort

#### Class: [BubbleSort](https://github.com/JacobNatural/Algorithms/blob/master/src/main/java/com/app/numbers/sort/BubbelSort.java)
- Method:
    - sort: Implement Bubble Sort algorithm

#### Class: [InsertionSort](https://github.com/JacobNatural/Algorithms/blob/master/src/main/java/com/app/numbers/sort/InsertSort.java)
- Method:
    - sort: Implement Insertion Sort algorithm

#### Class: [MergeSort](https://github.com/JacobNatural/Algorithms/blob/master/src/main/java/com/app/numbers/sort/MergeSort.java)
- Method:
    - sort: Implement Merge Sort algorithm

#### Class: [QuickSort](https://github.com/JacobNatural/Algorithms/blob/master/src/main/java/com/app/numbers/sort/QuickSort.java)
- Method:
    - sort: Implement Quick Sort algorithm

#### Class: [SelectionSort](https://github.com/JacobNatural/Algorithms/blob/master/src/main/java/com/app/numbers/sort/SelectSort.java)
- Method:
    - sort: Implement Selection Sort algorithm

#### Subpackage: utility

#### Class: [NumberUtilityIteration](https://github.com/JacobNatural/Algorithms/blob/master/src/main/java/com/app/numbers/utility/iteration/NumberUtilityIteration.java)
- Methods:
    - exponentiation: Implement iterative method for fast exponentiation
    - isPerfect: Determine if a number is perfect
    - isPrime: Determine if a number is prime
    - rootSquare: Calculate square root of a number
    - getMax: Find maximum number in an array
    - getMin: Find minimum number in an array

#### Class: [NumberUtilityRecursion](https://github.com/JacobNatural/Algorithms/blob/master/src/main/java/com/app/numbers/utility/recursion/NumberUtilityRecursion.java)
- Methods:
    - exponentiation: Implement recursive method for fast exponentiation
    - getMax: Find maximum number in an array recursively
    - getMin: Find minimum number in an array recursively

### Package: text

#### Subpackage: reverse_polish_notation

#### Class: [ReversePolishNotation](https://github.com/JacobNatural/Algorithms/blob/master/src/main/java/com/app/text/reverse_polish_notation/ReversePolishNotation.java)
- Method:
    - calculate: Evaluate an expression in Reverse Polish Notation

#### Subpackage: utility

#### Class: [TextUtility](https://github.com/JacobNatural/Algorithms/blob/master/src/main/java/com/app/text/utility/TextUtility.java)
- Methods:
    - isAnagram: Check if two strings are anagrams
    - isPalindrome: Check if a string is a palindrome
    - isPattern: Check if a pattern exists in a text

## [Testing and Coverage](https://jacobnatural.github.io/Algorithms/)

All algorithms are thoroughly tested, achieving 95% code coverage.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 22
- A Java IDE or text editor (e.g., IntelliJ IDEA, Eclipse, VSCode)

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/java-algorithms-collection.git
   cd java-algorithms-collection
Open the project in your preferred Java IDE.
Usage
Each algorithm is located in its respective package and class file within the src directory. You can run each algorithm by executing its main method or by integrating it into your own Java applications.

Contributing
Contributions are welcome! Please feel free to submit a Pull Request.
