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

	for x := 1; x <= 10; x++ {
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
			readLine(reader)
			rowColArr := strings.Split(readLine(reader), " ")
			rowTotal, _ := strconv.Atoi(rowColArr[0])
			colTotal, _ := strconv.Atoi(rowColArr[1])

			// создаем матрицу
			matrix := make([][]int, rowTotal)
			for curRow := 0; curRow < rowTotal; curRow++ {
				strLine := readLine(reader)
				strArr := strings.Split(strLine, " ")
				matrix[curRow] = make([]int, colTotal)
				for curCol := 0; curCol < colTotal; curCol++ {
					matrix[curRow][curCol], _ = strconv.Atoi(strArr[curCol])
				}
			}

			clickCount, _ := strconv.Atoi(readLine(reader))
			columnSortStr := strings.Split(readLine(reader), " ")
			columnSort := make([]int, len(columnSortStr))
			for i, v := range columnSortStr {
				columnSort[i], _ = strconv.Atoi(v)
			}

			sortedTable := sortTable(matrix, clickCount, columnSort)
			result.WriteString(fmt.Sprintf("%s\r\n", MatrixToString(sortedTable)))
		}

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
