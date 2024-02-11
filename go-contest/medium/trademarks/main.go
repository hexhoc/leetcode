package main

import (
	"bufio"
	"fmt"
	"io/ioutil"
	"os"
	"strconv"
	"strings"
)

func main() {
	for x := 1; x <= 35; x++ {
		testNum := ""
		if x < 10 {
			testNum = "0" + strconv.Itoa(x)
		} else {
			testNum = strconv.Itoa(x)
		}

		// Open the file
		file, err := os.Open("e_trademarks/tests/" + testNum)
		if err != nil {
			fmt.Println("Error opening file:", err)
			return
		}
		defer file.Close()

		var result strings.Builder

		scanner := bufio.NewScanner(file)
		scanner.Buffer(make([]byte, 64*1024), 1024*1024)
		//scanner := bufio.NewScanner(os.Stdin)
		//scanner.Split(bufio.ScanLines)

		scanner.Scan()
		dataSetCount, _ := strconv.Atoi(scanner.Text())

		for i := 0; i < dataSetCount; i++ {
			scanner.Scan()
			totalData, _ := strconv.Atoi(scanner.Text())
			arr := make([]string, totalData)
			for j := 0; j < totalData; j++ {
				scanner.Scan()
				arr[j] = scanner.Text()
			}
			str := registerTrademark(arr)
			result.WriteString(fmt.Sprintf("%s\r\n", str))
		}

		output := result.String()
		//fmt.Println(output)

		answerFile, err := os.Open("e_trademarks/tests/" + testNum + ".a")
		if err != nil {
			fmt.Println("Error opening file:", err)
			return
		}
		defer answerFile.Close()
		answerStr, err := ioutil.ReadAll(answerFile)

		if string(answerStr) == output {
			fmt.Println(testNum + " OK")
		} else {
			fmt.Println(testNum + " NOT OK")
		}
	}
}

func registerTrademark(arr []string) string {

	var result string
	registeredTrademark := make(map[string]bool)
	for i := 0; i < len(arr); i++ {
		registeredTrademark[reduceConsecutiveChars(arr[i])] = true
	}
	result = strconv.Itoa(len(registeredTrademark))

	//fmt.Println(reduceConsecutiveChars("Booble"))
	//fmt.Println(reduceConsecutiveChars("Boooble"))
	//fmt.Println(reduceConsecutiveChars("aPple"))
	//fmt.Println(reduceConsecutiveChars("aPpleee"))
	return result
}
func reduceConsecutiveChars(word string) string {
	var reduced strings.Builder
	reduced.WriteByte(word[0])
	prev := word[0]
	count := 1

	for i := 1; i < len(word); i++ {
		curr := word[i]

		if curr == prev {
			count++
			if count <= 2 {
				reduced.WriteByte(curr)
			}
		} else {
			reduced.WriteByte(curr)
			prev = curr
			count = 1
		}
	}

	return reduced.String()
}
