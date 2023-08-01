package main

import (
	"bufio"
	"fmt"
	"io/ioutil"
	"os"
	"strconv"
	"strings"
	"time"
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
			intervals := make([]string, size)

			for j := 0; j < size; j++ {
				scanner.Scan()
				dataStr := scanner.Text()
				intervals[j] = dataStr
			}

			str := isTimeCorrect(intervals)
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
			fmt.Println(testNum + " OK")
		} else {
			fmt.Println(testNum + " NOT OK")
		}
	}
}

func isTimeCorrect(intervals []string) string {

	result := "YES"
	parseTimeForm := "15:04:05"
	check := make([]bool, 86400)

	for i := 0; i < len(intervals); i++ {
		times := strings.Split(intervals[i], "-")
		t1, err := time.Parse(parseTimeForm, times[0])
		if err != nil {
			result = "NO"
			break
		}

		t2, err := time.Parse(parseTimeForm, times[1])
		if err != nil {
			result = "NO"
			break
		}

		t1Second := t1.Hour()*60*60 + t1.Minute()*60 + t1.Second()
		t2Second := t2.Hour()*60*60 + t2.Minute()*60 + t2.Second()

		if t1Second > t2Second {
			result = "NO"
			break
		}

		for second := t1Second; second <= t2Second; second++ {
			if check[second] == true {
				result = "NO"
				break
			}
			check[second] = true
		}
	}

	return result
}
