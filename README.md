# Enigma

## Story

Hackerman, we need your help. We intercepted correspondence between "the bad guys".
We need an app that can both decrypt and encrypt files, using the ROT13 cipher, Morse code, and Rail-fence cipher.

## What are you going to learn?

- Think in algorithms.
- Handle edge cases and exceptions.
- Read from files.
- Use multidimensional arrays.

## Tasks

1. In `Enigma`, we use the `ArgsParser` class to encapsulate passed parameters.
Finish the implementation of `ArgsParser`.
    - Data is extracted from the given string array.
    - Fields in `ArgsParser` are `null` if no value is provided.
    - The fields in this class are not modifiable.

2. Implement the `CipherFactory` class with a factory method that provides `Cipher` implementations.
It must work for all ciphers (ROT13, Rail-fence and Morse code).
    - Method `isCipherAvailable()` returns `true` if it is passed the name of a supported cipher, `false` otherwise.
    - Method `getCipherForArgs()` returns a proper `Cipher` instance. If not possible, or invalid key is provided for a specific cipher, `EnigmaException` is thrown.

3. Implement the execution engine in `Enigma` that interprets and executes meaningful commands and displays messages for all cases.
    - A help menu is displayed when no arguments are passed, or when the first argument is `'-h'`-
    - Providing a mode that is not `'-h'`, `'-e'`, or `'-d'` leads to `EnigmaException`.
    - Providing too few arguments leads to `EnigmaException`. Using `'-h'` does not require any further arguments.
    - Providing an unsupported cipher name leads to `EnigmaException`.
    - Providing a non-existent filepath leads to `EnigmaException`.
    - All `EnigmaException`s are caught and their messages are printed to the standard output.
    - Method `handleCipherOperation()` encrypts and decrypts file content using the cipher provided by `CipherFactory`, and prints the result.

4. Implement ROT13 cipher encrypt and decrypt methods. Uppercase letters must appear AFTER lowercase ones, similar to the following examples. Create functions `encryptLetter(char)` and `decryptLetter(char)` that perform the mapping of single characters. Methods `encrypt(String)` and `decrypt(String)` map entire texts.
Examples:
```{{prog_lang}}
encryptLetter('a') -> 'n'
encryptLetter('l') -> 'y'
encryptLetter('m') -> 'z'
encryptLetter('n') -> 'A'
encryptLetter('o') -> 'B'
decryptLetter('C') -> 'p'
decryptLetter('D') -> 'q'
```
    - All alphabetic characters are encrypted.
    - All alphabetic characters are decrypted.
    - Non-alphabetic characters are unchanged.

5. Implement Morse code encryption and decryption. Implementation must support 26 English letters `A` through `Z` and Arabic numerals `0` to `9`. Convert spaces into word separators (`'/'`). Every other symbol must be omitted.
```{{prog_lang}}
encode("Hello, World!") -> ".... . .-.. .-.. --- / .-- --- .-. .-.. -.."
decode(".... . .-.. .-.. --- / .-- --- .-. .-.. -..") -> "HELLO WORLD"
```
    - Message is encrypted into Morse code using word separators.
    - Non-alphanumeric characters are omitted from the encrypted message.
    - Message is decrypted using uppercase letters.

6. Implement Rail-fence cipher encryption and decryption. The encrypted message must contain all non-alphanumeric characters. Letters must stay the same (without change the case).
```{{prog_lang}}
encrypt("Hello World!") -> "Horel ol!lWd" // key = 3
decrypt("Horel ol!lWd") -> "Hello World!"
```
    - Message is encrypted.
    - Letter cases are unchanged.
    - Message is decrypted.

## General requirements

None

## Hints

- Consider using the Java version of the abstract data type map or dictionary (called `Map` in Java, check out the Background materials section for more information) when implementing Morse code. Or you can choose to use arrays only.


## Background materials

- <i class="far fa-exclamation"></i> [ROT13 cipher](http://practicalcryptography.com/ciphers/classical-era/rot13/)
- <i class="far fa-exclamation"></i> [Morse code](https://en.wikipedia.org/wiki/Morse_code)
- <i class="far fa-exclamation"></i> [Rail-fence cipher](http://practicalcryptography.com/ciphers/classical-era/rail-fence/)
- <i class="far fa-exclamation"></i> [Design patterns](project/curriculum/materials/pages/general/design-patterns.md)
- <i class="far fa-exclamation"></i> [Factory pattern](project/curriculum/materials/pages/java/factory.md)
- <i class="far fa-exclamation"></i> [Interfaces](https://www.tutorialspoint.com/java/java_interfaces.htm)
- <i class="far fa-exclamation"></i> [Step-by-step guide for the Factory pattern](https://www.tutorialspoint.com/design_pattern/factory_pattern.htm)
- <i class="far fa-exclamation"></i> [`@Override` annotation](https://beginnersbook.com/2014/07/override-annotation-in-java/)
- <i class="far fa-exclamation"></i> [Exceptions in Java](https://www.dummies.com/programming/java/what-you-need-to-know-about-exceptions-in-java/)
- <i class="far fa-exclamation"></i> [Dictionaries: moving from Python to Java](https://stackoverflow.com/questions/36068991/what-is-the-java-equivalent-of-a-python-dictionary?noredirect=1&lq=1)

