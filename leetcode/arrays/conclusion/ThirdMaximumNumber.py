# Given an integer array nums, return the third distinct maximum number in this array. 
# If the third maximum does not exist, return the maximum number.

# Example 1:

# Input: nums = [3,2,1]
# Output: 1
# Explanation:
# The first distinct maximum is 3.
# The second distinct maximum is 2.
# The third distinct maximum is 1.

# Example 2:

# Input: nums = [1,2]
# Output: 2
# Explanation:
# The first distinct maximum is 2.
# The second distinct maximum is 1.
# The third distinct maximum does not exist, so the maximum (2) is returned instead.

# Example 3:

# Input: nums = [2,2,3,1]
# Output: 1
# Explanation:
# The first distinct maximum is 3.
# The second distinct maximum is 2 (both 2's are counted together since they have the same value).
# The third distinct maximum is 1.

def ThirdMaximumNumber(nums: list[int]) -> int:
    nums.sort(reverse=True)
    i = 0
    for j in range(1, len(nums)):
        if (nums[i] != nums[j]):
            i += 1
            nums[i] = nums[j]
    
    unique_nums = nums[0:i+1]
    if len(unique_nums) >= 3:
        return unique_nums[2]
    else:
        return unique_nums[0]

print(ThirdMaximumNumber([2,2,3,1,1]))
print(ThirdMaximumNumber([2,2,3,1,1,4,5]))
print(ThirdMaximumNumber([1,2]))
print(ThirdMaximumNumber([1,2,3]))