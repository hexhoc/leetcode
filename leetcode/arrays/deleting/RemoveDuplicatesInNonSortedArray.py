# [3,4,3,4,5,1,2,3,4,5]
# expected [3,4,5,1,2], k=5

def RemoveDuplicatesInNonSortedArray(nums: list[int]) -> int:
    already_processed = set()
    i: int = 0
    
    for j in range(len(nums)):
        if nums[j] not in already_processed:
            nums[i] = nums[j]
            i += 1
            already_processed.add(nums[j])
    
    for j in range(i, len(nums)):
        nums[j] = 0
        
    return i+1

print(RemoveDuplicatesInNonSortedArray([3,4,3,4,5,1,2,3,4,5]))
print(RemoveDuplicatesInNonSortedArray([3,4,3]))