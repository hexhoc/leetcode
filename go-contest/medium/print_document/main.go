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
	for x := 1; x <= 15; x++ {
		testNum := ""
		if x < 10 {
			testNum = "0" + strconv.Itoa(x)
		} else {
			testNum = strconv.Itoa(x)
		}

		// Open the file
		file, err := os.Open("f_printer/tests/" + testNum)
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
			totalPage, _ := strconv.Atoi(scanner.Text())

			scanner.Scan()
			alreadySent := scanner.Text()

			str := printPages(totalPage, alreadySent)
			result.WriteString(fmt.Sprintf("%s\r\n", str))
		}

		output := result.String()
		//fmt.Println(output)

		answerFile, err := os.Open("f_printer/tests/" + testNum + ".a")
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

func printPages(totalPage int, alreadySent string) string {

	var result string
	pages := make([]bool, totalPage+1)
	pagesArr := strings.Split(alreadySent, ",")
	for _, v := range pagesArr {
		pageInterval := strings.Split(v, "-")
		if len(pageInterval) == 2 {
			from, _ := strconv.Atoi(pageInterval[0])
			to, _ := strconv.Atoi(pageInterval[1])
			for pageNum := from; pageNum <= to; pageNum++ {
				pages[pageNum] = true
			}
		} else {
			pageNum, _ := strconv.Atoi(pageInterval[0])
			pages[pageNum] = true
		}

	}
	remainingPages := make([]string, 0)
	from := 0
	to := 0
	for i := 1; i <= totalPage; i++ {
		if from == 0 {
			from = i
		}
		to = i

		if pages[i] == true || i == totalPage {
			if pages[i] == true {
				to = i - 1
			}
			if from > 0 && from <= to {
				if from == to {
					remainingPages = append(remainingPages, fmt.Sprintf("%d", from))
				} else {
					remainingPages = append(remainingPages, fmt.Sprintf("%d-%d", from, to))
				}
			}
			from = 0
			to = 0
		}
	}

	result = strings.Join(remainingPages, ",")

	return result
}
