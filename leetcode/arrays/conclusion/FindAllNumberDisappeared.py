
# Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all 
# the integers in the range [1, n] that do not appear in nums.

# Example 1:

# Input: nums = [4,3,2,7,8,2,3,1]
# Output: [5,6]

# Example 2:

# Input: nums = [1,1]
# Output: [2]

def FindAllNumberDisappeared_ver1(nums: list[int]) -> list[int]:
    checked_nums = [0] * len(nums)
    for x in nums:
        checked_nums[x-1] = 1
        
    result = []
    arr_len = len(nums)
    for i in range(arr_len):
        if (checked_nums[i] == 0):
            result.append(i+1)
            
    return result

def FindAllNumberDisappeared_ver2(nums: list[int]) -> list[int]:
    nums_set = set(nums)
    result = []
    for i in range(1, len(nums)+1):
        if (i not in nums_set):
            result.append(i)
    
    return result

print(FindAllNumberDisappeared_ver1([4,3,2,7,8,2,3,1]))
print(FindAllNumberDisappeared_ver1([1,1]))
print(FindAllNumberDisappeared_ver2([4,3,2,7,8,2,3,1]))
print(FindAllNumberDisappeared_ver2([1,1]))