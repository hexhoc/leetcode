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
	testNum := "10"
	// Open the file
	file, err := os.Open("tests/" + testNum)
	if err != nil {
		fmt.Println("Error opening file:", err)
		return
	}
	defer file.Close()

	var result strings.Builder

	scanner := bufio.NewScanner(file)
	//scanner.Buffer(make([]byte, 2048*1024), 2048*1024)
	//scanner := bufio.NewScanner(os.Stdin)
	//scanner.Split(bufio.ScanLines)

	scanner.Scan()
	num, _ := strconv.Atoi(scanner.Text())

	for i := 0; i < num; i++ {
		scanner.Scan()
		rowColStr := scanner.Text()
		if len(rowColStr) == 0 {
			i--
			continue
		}
		rowColArr := strings.Split(rowColStr, " ")
		rowTotal, _ := strconv.Atoi(rowColArr[0])
		colTotal, _ := strconv.Atoi(rowColArr[1])

		// создаем матрицу
		matrix := make([][]int, rowTotal)
		for curRow := 0; curRow < rowTotal; curRow++ {
			scanner.Scan()
			strLine := scanner.Text()
			strArr := strings.Split(strLine, " ")
			matrix[curRow] = make([]int, colTotal)
			for curCol := 0; curCol < colTotal; curCol++ {
				matrix[curRow][curCol], _ = strconv.Atoi(strArr[curCol])
			}
		}

		scanner.Scan()
		clickCount, _ := strconv.Atoi(scanner.Text())

		scanner.Scan()
		columnSortStr := scanner.Text()
		columnSort := strings.Split(columnSortStr, " ")

		str := sortTable(matrix, clickCount, columnSort)
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

func sortTable(matrix [][]int, clickCount int, columnSortArr []string) string {

	var result []string
	prevCol := -1

	for click := 0; click < clickCount; click++ {
		sortColNum, _ := strconv.Atoi(columnSortArr[click])
		//column by index num
		sortColNum = sortColNum - 1
		if sortColNum == prevCol {
			continue
		}

		isSort := false
		for !isSort {
			isSort = true
			for rowNum := 0; rowNum < len(matrix)-1; rowNum++ {
				if matrix[rowNum][sortColNum] > matrix[rowNum+1][sortColNum] {
					for colNum := 0; colNum < len(matrix[rowNum]); colNum++ {
						temp := matrix[rowNum][colNum]
						matrix[rowNum][colNum] = matrix[rowNum+1][colNum]
						matrix[rowNum+1][colNum] = temp
					}
					isSort = false
				}
			}
		}

		prevCol = sortColNum
	}

	for i := range matrix {
		for _, n := range matrix[i] {
			result = append(result, fmt.Sprintf("%d", n))
			result = append(result, " ")
		}
		result = result[:len(result)-1]
		result = append(result, "\r\n")
	}

	return strings.Join(result, "")

}
