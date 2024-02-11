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

	for x := 1; x <= 1; x++ {
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

		nums := strings.Split(readLine(reader), " ")
		totalUsers, _ := strconv.Atoi(nums[0])
		totalPairs, _ := strconv.Atoi(nums[1])
		pairArr := make([]string, totalPairs)
		for j := 0; j < totalPairs; j++ {
			dataStr := readLine(reader)
			pairArr[j] = dataStr
		}

		str := getPossibleFriends(totalUsers, pairArr)
		result.WriteString(fmt.Sprintf("%s\r\n", str))

		output := result.String()

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
