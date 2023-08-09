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
	output = output[:len(output)-2]
	fmt.Println(output)
}

func MatrixToString(matrix [][]int) string {
	var s string
	row := len(matrix)
	col := len(matrix[0])
	for i := 0; i < row; i++ {
		for j := 0; j < col; j++ {
			s += fmt.Sprintf("%d ", matrix[i][j])
		}
		s = strings.TrimRight(s, " ")
		s += "\r\n"
	}
	return s
}

func readLine(reader *bufio.Reader) string {
	line, _ := reader.ReadString('\n')
	line = strings.TrimRight(line, " \t\r\n")
	return line
}

func sortTable(matrix [][]int, clickCount int, columnSortArr []int) [][]int {
	for _, v := range columnSortArr {
		col := v - 1
		keepSort := true
		for keepSort {
			keepSort = false
			for row := 0; row < len(matrix)-1; row++ {
				if matrix[row][col] > matrix[row+1][col] {
					keepSort = true
					temp := matrix[row]
					matrix[row] = matrix[row+1]
					matrix[row+1] = temp
				}
			}
		}
	}
	return matrix
}
