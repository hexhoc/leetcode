package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
	"strings"
)

func main() {

	var result strings.Builder

	reader := bufio.NewReader(os.Stdin)

	line := readLine(reader)
	totalDataSet, _ := strconv.Atoi(line)

	for i := 0; i < totalDataSet; i++ {
		arrLength, _ := strconv.Atoi(readLine(reader))
		arr := make([]int, arrLength)
		data := strings.Split(readLine(reader), " ")
		for j, v := range data {
			intValue, _ := strconv.Atoi(v)
			arr[j] = intValue
		}
		str := pairProgramming(arr)
		result.WriteString(fmt.Sprintf("%s\r\n", str))
	}

	output := result.String()
	output = output[:len(output)-2]
	fmt.Println(output)
}

func readLine(reader *bufio.Reader) string {
	line, _ := reader.ReadString('\n')
	line = strings.TrimRight(line, " \t\r\n")
	return line
}

func pairProgramming(arr []int) string {
	var result strings.Builder
	skip := make(map[int]interface{})
	for i := 0; i < len(arr)-1; i++ {
		if _, ok := skip[i]; ok {
			continue
		}
		suitable := -1
		minValue := 99
		for j := i + 1; j < len(arr); j++ {
			if _, ok := skip[j]; ok {
				continue
			}
			newValue := int(math.Abs(float64(arr[i] - arr[j])))
			if newValue < minValue {
				minValue = newValue
				suitable = j
			}
		}
		skip[i] = nil
		skip[suitable] = nil
		result.WriteString(fmt.Sprintf("%d %d\r\n", i+1, suitable+1))
	}

	return result.String()
}
