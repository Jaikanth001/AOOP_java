package com.palindrome;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PalindromeFinderTest {

    @Test
    void testOnePalindrome() {
        PalindromeFinder finder = new PalindromeFinder();
        assertEquals("bab", finder.findLongestPalindrome("babad"));
    }

    @Test
    void testMultiplePalindromes() {
        PalindromeFinder finder = new PalindromeFinder();
        assertEquals("bb", finder.findLongestPalindrome("cbbd"));
    }

    @Test
    void testNoPalindrome() {
        PalindromeFinder finder = new PalindromeFinder();
        assertEquals("a", finder.findLongestPalindrome("abc"));
    }

    @Test
    void testSingleCharacter() {
        PalindromeFinder finder = new PalindromeFinder();
        assertEquals("a", finder.findLongestPalindrome("a"));
    }

    @Test
    void testEntireStringPalindrome() {
        PalindromeFinder finder = new PalindromeFinder();
        assertEquals("racecar", finder.findLongestPalindrome("racecar"));
    }

    @Test
    void testEmptyString() {
        PalindromeFinder finder = new PalindromeFinder();
        assertEquals("", finder.findLongestPalindrome(""));
    }

    @Test
    void testStringWithSpaces() {
        PalindromeFinder finder = new PalindromeFinder();
        assertEquals("A man a plan a canal Panama", finder.findLongestPalindrome("A man, a plan, a canal, Panama"));
    }
}
