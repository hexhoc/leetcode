package arrays

import (
	"math"
	"sort"
	"strconv"
)

//Given a binary array nums, return the maximum number of consecutive 1's in the array.

//Example 1:
// Input: nums = [1,1,0,1,1,1]
// Output: 3
// Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.

// Example 2:
// Input: nums = [1,0,1,1,0,1]
// Output: 2

func FindMaxConsecutiveOnes(nums []int) int {

	var maxConsecutive int = 0
	var currentConsecutive int = 0

	for _, v := range nums {
		if v == 1 {
			currentConsecutive++
		} else {
			if maxConsecutive < currentConsecutive {
				maxConsecutive = currentConsecutive
			}
			currentConsecutive = 0
		}
	}

	if maxConsecutive > currentConsecutive {
		return maxConsecutive
	}

	return currentConsecutive
}

/*
Given an array nums of integers, return how many of them contain an even number of digits.

Example 1:

Input: nums = [12,345,2,6,7896]
Output: 2

Explanation:
12 contains 2 digits (even number of digits).
345 contains 3 digits (odd number of digits).
2 contains 1 digit (odd number of digits).
6 contains 1 digit (odd number of digits).
7896 contains 4 digits (even number of digits).
Therefore only 12 and 7896 contain an even number of digits.

Example 2:

Input: nums = [555,901,482,1771]
Output: 1
Explanation:
Only 1771 contains an even number of digits.
*/

func FindNumbers(nums []int) int {
	var evenNumbersCount int = 0

	for _, v := range nums {
		if len(strconv.Itoa(v))%2 == 0 {
			evenNumbersCount++
		}
	}

	return evenNumbersCount
}

/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
*/

func SortedSquares(nums []int) []int {
	for i := 0; i < len(nums); i++ {
		nums[i] = int(math.Pow(float64(nums[i]), 2))
	}

	sort.Ints(nums)

	return nums
}
