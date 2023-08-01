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
	for x := 1; x <= 40; x++ {
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

		var result strings.Builder

		scanner := bufio.NewScanner(file)
		scanner.Buffer(make([]byte, 512*1024), 512*1024)
		//scanner := bufio.NewScanner(os.Stdin)
		//scanner.Split(bufio.ScanLines)

		scanner.Scan()
		num, _ := strconv.Atoi(scanner.Text())

		for i := 0; i < num; i++ {
			scanner.Scan()
			size, _ := strconv.Atoi(scanner.Text())
			intArr := make([]int, size)

			scanner.Scan()
			dataStr := scanner.Text()
			dataArr := strings.Split(dataStr, " ")
			for j := 0; j < size; j++ {
				intArr[j], _ = strconv.Atoi(dataArr[j])
			}

			str := isReportCorrect(intArr)
			result.WriteString(fmt.Sprintf("%s\r\n", str))
		}

		output := result.String()
		//output = output[:len(output)-2]
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
}

func isReportCorrect(intArr []int) string {

	var result string
	isCorrect := true
	taskDoneSet := make(map[int]bool, len(intArr))
	prevTask := -1

	for _, curTask := range intArr {
		if curTask == prevTask {
			continue
		}
		if taskDoneSet[curTask] == true {
			isCorrect = false
			break
		}

		taskDoneSet[curTask] = true
		prevTask = curTask
	}
	if isCorrect {
		result = "YES"
	} else {
		result = "NO"
	}

	return result

}
