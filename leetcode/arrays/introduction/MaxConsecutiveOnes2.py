# Given a binary array, find the maximum number of consecutive ones in this array 
# if you can flip at most one 0.
# Example 1:
# Input: [1,0,1,1,0]
# Output: 4
# Explanation: Flip the first zero will get the the maximum number of consecutive ones.
#     After flipping, the maximum number of consecutive 1s is 4.
# Note:
# The input array will only contain 0 and 1.
# The length of input array is a positive integer and will not exceed 10,000

def GetConsecutive(start_index:int, nums: list[int], flip:int) -> int:
    flip -= 1
    counter:int = 1
    for i in range(start_index, len(nums)):
        if nums[i] == 1:
            counter += 1
        else:
            if flip > 0:
                counter += GetConsecutive(i+1, nums, flip)
            break
    return counter

def MaxConsecutiveOnes2(nums: list[int])->int:
    max_c:int = 0
    counter:int = 0
    flip:int = 1
    
    for i in range(len(nums)):
        if (nums[i] != 0):
            counter += 1
        else:
            counter += GetConsecutive(i+1, nums, flip)
        
        if counter > max_c:
            max_c = counter
        
        if nums[i] == 0:
            counter = 0

    return max_c

    
print(MaxConsecutiveOnes2([1,0,1,1,0]))
print(MaxConsecutiveOnes2([1,0,1,1,0,1,1,1,0,1,1]))