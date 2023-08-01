package main

import (
	"bufio"
	"fmt"
	"io/ioutil"
	"os"
	"strconv"
	"strings"
)

var ROW_OFFSET = [6]int{-1, -1, 0, 1, 1, 0}
var COL_OFFSET = [6]int{-1, 1, 2, 1, -1, -2}

const EMPTY_CELL uint8 = 46

func main() {

	for x := 1; x <= 25; x++ {
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

		scanner := bufio.NewScanner(file)
		scanner.Buffer(make([]byte, 64*1024), 64*1024)
		//scanner := bufio.NewScanner(os.Stdin)
		//scanner.Split(bufio.ScanLines)

		scanner.Scan()
		nums, _ := strconv.Atoi(scanner.Text())

		for i := 0; i < nums; i++ {
			scanner.Scan()
			colRowStr := scanner.Text()
			colRowArr := strings.Split(colRowStr, " ")
			rows, _ := strconv.Atoi(colRowArr[0])
			cols, _ := strconv.Atoi(colRowArr[1])

			gameMap := make([][]byte, rows)
			for j := 0; j < rows; j++ {
				scanner.Scan()
				mapRow := scanner.Text()
				gameMap[j] = []byte(mapRow)
			}

			str := isValidMap(rows, cols, gameMap)
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

	fmt.Println("END")
}

func isValidMap(rows int, cols int, gameMap [][]byte) string {
	result := "YES"
	visited := make([][]bool, rows)
	checkedFactions := make(map[byte]bool)
	for i := 0; i < len(visited); i++ {
		visited[i] = make([]bool, cols)
	}
	for row := 0; row < rows; row++ {
		for col := 0; col < cols; col++ {
			if visited[row][col] || gameMap[row][col] == EMPTY_CELL {
				continue
			}

			faction := gameMap[row][col]
			if checkedFactions[faction] {
				result = "NO"
				return result
			}
			checkCellConnection(row, col, rows, cols, faction, &visited, &gameMap)
			checkedFactions[faction] = true
		}
	}

	return result
}

func checkCellConnection(row int, col int, rows int, cols int, faction byte, visitedRef *[][]bool, gameMapRef *[][]byte) {
	(*visitedRef)[row][col] = true
	for i := 0; i < 6; i++ {
		newRow := row + ROW_OFFSET[i]
		newCol := col + COL_OFFSET[i]
		if newRow >= 0 && newRow < rows &&
			newCol >= 0 && newCol < cols &&
			(*gameMapRef)[newRow][newCol] != EMPTY_CELL &&
			!(*visitedRef)[newRow][newCol] &&
			(*gameMapRef)[newRow][newCol] == faction {

			checkCellConnection(newRow, newCol, rows, cols, faction, visitedRef, gameMapRef)
		}
	}
}
