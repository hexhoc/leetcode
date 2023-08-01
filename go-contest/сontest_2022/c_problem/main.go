package main

import (
	"bufio"
	"fmt"
	"io/ioutil"
	"math"
	"os"
	"strconv"
	"strings"
)

func main() {

	testNum := "20"
	// Open the file
	file, err := os.Open("tests/" + testNum)
	if err != nil {
		fmt.Println("Error opening file:", err)
		return
	}
	defer file.Close()

	var result strings.Builder

	scanner := bufio.NewScanner(file)
	scanner.Buffer(make([]byte, 2048*1024), 2048*1024)
	//scanner := bufio.NewScanner(os.Stdin)
	//scanner.Split(bufio.ScanLines)

	scanner.Scan()
	num, _ := strconv.Atoi(scanner.Text())

	for i := 0; i < num; i++ {
		scanner.Scan()

		scanner.Scan()
		strLine := scanner.Text()
		strArr := strings.Split(strLine, " ")

		str := pairProgramming(strArr)
		result.WriteString(fmt.Sprintf("%s\r\n", str))
	}

	output := result.String()
	output = output[:len(output)-2]
	//fmt.Println(output)

	answerFile, err := os.Open("tests/" + testNum + ".a")
	if err != nil {
		fmt.Println("Error opening file:", err)
		return
	}
	defer answerFile.Close()
	answerStr, err := ioutil.ReadAll(answerFile)

	if string(answerStr) == output {
		fmt.Println("OK")
	} else {
		fmt.Println("NOT OK")
	}
}

func pairProgramming(arr []string) string {
	intArr := make([]int, len(arr))

	// convert arr to intArr
	for i, v := range arr {
		n, _ := strconv.Atoi(v)
		intArr[i] = n
	}

	excludedIndex := make(map[int]interface{})
	var result strings.Builder

	for i := 0; i < len(intArr); i++ {
		if _, ok := excludedIndex[i]; ok {
			continue
		}
		minValue := -1
		minIndex := -1

		for j := i + 1; j < len(intArr); j++ {
			if _, ok := excludedIndex[j]; ok {
				continue
			}

			currentValue := int(math.Abs(float64(intArr[i] - intArr[j])))
			if currentValue < minValue || minIndex == -1 {
				minIndex = j
				minValue = currentValue
			}
		}

		result.WriteString(fmt.Sprintf("%d %d\r\n", i+1, minIndex+1))
		excludedIndex[i] = nil
		excludedIndex[minIndex] = nil

	}

	return result.String()
}
