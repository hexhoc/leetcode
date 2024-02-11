package main

import (
	"bufio"
	"fmt"
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
		sum := getPayAmount(arr)
		str := strconv.Itoa(sum)
		result.WriteString(fmt.Sprintf("%s\r\n", str))
	}

	output := result.String()
	fmt.Println(output)
}

func getPayAmount(arr []int) int {
	sum := 0
	productsCount := make(map[int]int)
	for _, v := range arr {
		productsCount[v]++
	}
	for price, count := range productsCount {
		sum = sum + price*(count-count/3)
	}

	return sum
}

func readLine(reader *bufio.Reader) string {
	line, _ := reader.ReadString('\n')
	line = strings.TrimRight(line, " \t\r\n")
	return line
}
