package arrays

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
