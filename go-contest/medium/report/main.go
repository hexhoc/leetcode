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
		readLine(reader)
		workLog := strings.Split(readLine(reader), " ")
		str := checkReport(workLog)
		result.WriteString(fmt.Sprintf("%s\r\n", str))
	}

	output := result.String()
	output = output[:len(output)-2]
	fmt.Println(output)
}

func readLine(reader *bufio.Reader) string {
	line, _ := reader.ReadString('\n')
	line = strings.TrimRight(line, " \t\r\n")
	return line
}

func checkReport(arr []string) string {
	workMap := make(map[string]int, len(arr))
	for i, v := range arr {
		if _, found := workMap[v]; found {
			if workMap[v] != i-1 {
				return "NO"
			}
		}

		workMap[v] = i
	}

	return "YES"
}
