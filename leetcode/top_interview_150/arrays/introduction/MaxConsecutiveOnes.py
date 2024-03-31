
# Given a binary array nums, return the maximum number of consecutive 1's in the array.

# Example 1:
# Input: nums = [1,1,0,1,1,1]
# Output: 3
# Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.

# Example 2:
# Input: nums = [1,0,1,1,0,1]
# Output: 2

def findMaxConsecutiveOnes(nums: list[int]) -> int:
    i = 0
    max_c = 0
    c = 1
    for j in range(1, len(nums)):
        if (nums[i] == nums[j]):
            c += 1
        else:
            c = 1
        if c > max_c:
            max_c = c
        i += 1
    
    return max_c

print(findMaxConsecutiveOnes([1,1,0,1,1,1]))
print(findMaxConsecutiveOnes([1,0,1,1,0,1]))