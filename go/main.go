package main

import (
	"fmt"
	"hexhoc/leetcode/pkg/arrays"
)

func main() {
	var result1 int = arrays.FindMaxConsecutiveOnes([]int{1, 1, 0, 1, 1, 1})
	var result2 int = arrays.FindMaxConsecutiveOnes([]int{1, 0, 1, 1, 0, 1})
	fmt.Println(result1, result2)
}
