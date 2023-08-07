package main

import (
	"bufio"
	"fmt"
	"io/ioutil"
	"os"
	"strconv"
	"strings"
	"testing"
)

func TestMain(t *testing.T) {

	for x := 1; x <= 20; x++ {
		var result strings.Builder

		testNum := ""
		if x < 10 {
			testNum = "0" + strconv.Itoa(x)
		} else {
			testNum = strconv.Itoa(x)
		}

		// Open the file
		file, err := os.Open("tests/" + testNum)
		if err != nil {
			fmt.Println("Error opening file:", err)
			return
		}
		defer file.Close()

		reader := bufio.NewReader(file)

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
		// fmt.Println(output)

		answerFile, err := os.Open("tests/" + testNum + ".a")
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

	fmt.Println("END")

}
