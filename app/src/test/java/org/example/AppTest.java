package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void addReturnsSumOfTwoIntegers() {
        assertEquals(7, App.add(3, 4));
        assertEquals(-1, App.add(3, -4));
        assertEquals(0, App.add(0, 0));
    }

    @Test
    void isPrimeReturnsTrueForPrimeNumbers() {
        assertTrue(App.isPrime(2));
        assertTrue(App.isPrime(3));
        assertTrue(App.isPrime(17));
    }

    @Test
    void isPrimeReturnsFalseForNonPrimeNumbers() {
        assertFalse(App.isPrime(1));
        assertFalse(App.isPrime(0));
        assertFalse(App.isPrime(-5));
        assertFalse(App.isPrime(9));
    }

    @Test
    void reverseReturnsReversedString() {
        assertEquals("olleh", App.reverse("hello"));
        assertEquals("", App.reverse(""));
        assertEquals("a", App.reverse("a"));
    }

    @Test
    void factorialReturnsExpectedResult() {
        assertEquals(1, App.factorial(0));
        assertEquals(1, App.factorial(1));
        assertEquals(120, App.factorial(5));
    }

    @Test
    void factorialThrowsExceptionForNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> App.factorial(-1));
    }

    @Test
    void isPalindromeIgnoresCaseSpacesAndPunctuation() {
        assertTrue(App.isPalindrome("A man, a plan, a canal: Panama"));
        assertTrue(App.isPalindrome("Madam"));
        assertFalse(App.isPalindrome("hello"));
    }

    @Test
    void fibonacciUpToReturnsNumbersUpToLimit() {
        assertIterableEquals(List.of(0, 1, 1, 2, 3, 5, 8), App.fibonacciUpTo(8));
        assertIterableEquals(List.of(0), App.fibonacciUpTo(0));
    }

    @Test
    void fibonacciUpToThrowsExceptionForNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> App.fibonacciUpTo(-1));
    }

    @Test
    void charFrequencyCountsEachCharacter() {
        Map<Character, Integer> result = App.charFrequency("banana");

        assertEquals(3, result.get('a'));
        assertEquals(1, result.get('b'));
        assertEquals(2, result.get('n'));
        assertEquals(3, result.size());
    }

    @Test
    void isAnagramIgnoresSpacesAndCase() {
        assertTrue(App.isAnagram("Listen", "Silent"));
        assertTrue(App.isAnagram("Dormitory", "Dirty room"));
        assertFalse(App.isAnagram("hello", "world"));
    }

    @Test
    void averageReturnsMeanValue() {
        assertEquals(3.0, App.average(new int[] {1, 2, 3, 4, 5}));
        assertEquals(-2.0, App.average(new int[] {-1, -2, -3}));
    }

    @Test
    void averageThrowsExceptionForEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> App.average(new int[] {}));
    }

    @Test
    void filterEvensReturnsOnlyEvenNumbers() {
        assertIterableEquals(List.of(2, 4, 6), App.filterEvens(List.of(1, 2, 3, 4, 5, 6)));
        assertIterableEquals(List.of(), App.filterEvens(List.of(1, 3, 5)));
    }

    @Test
    void mostCommonWordReturnsMostFrequentWord() {
        assertEquals("java", App.mostCommonWord("Java is fun. Java is powerful."));
        assertEquals("test", App.mostCommonWord("test test code"));
    }
}
