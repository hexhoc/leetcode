package arrays

import "sort"

/*
Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.

Note that elements beyond the length of the original array are not written. Do the above modifications to the input array in place and do not return anything.


Example 1:

Input: arr = [1,0,2,3,0,4,5,0]
Output: [1,0,0,2,3,0,0,4]
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
*/

func DuplicateZeros(arr []int) {

	duplicateArr := make([]int, 0, len(arr))

	for _, v := range arr {
		duplicateArr = append(duplicateArr, v)
		if v == 0 {
			duplicateArr = append(duplicateArr, 0)
		}
	}

	for i := 0; i < len((arr)); i++ {
		arr[i] = duplicateArr[i]
	}

}

/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers
m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside
the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements
denote the elements that should be merged, and the last n elements are set to 0 and should be ignored.
nums2 has a length of n.

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
*/

func Merge(nums1 []int, m int, nums2 []int, n int) {

	for i := 0; i < n; i++ {
		nums1[m+i] = nums2[i]
	}

	sort.Ints(nums1)

}
