package com.cbsingh.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode633SumOfSquareNumbersTest {
    LeetCode633_SumOfSquareNumbers solution;

    @BeforeEach
    void setUp() {
        solution = new LeetCode633_SumOfSquareNumbers();
    }

    @Test
    void judgeSquareSum() {
        assertTrue(solution.judgeSquareSum(5));
        assertTrue(solution.judgeSquareSum(4));
        assertFalse(solution.judgeSquareSum(3));
    }

    @Test
    void judgeSquareSumBinarySearch() {
        assertTrue(solution.judgeSquareSum_BinarySearch(5));
        assertTrue(solution.judgeSquareSum_BinarySearch(4));
        assertFalse(solution.judgeSquareSum_BinarySearch(3));
    }
}