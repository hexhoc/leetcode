package main

import (
	"bufio"
	"errors"
	"fmt"
	"os"
	"sort"
	"strconv"
	"strings"
)

func main() {

	var result strings.Builder

	reader := bufio.NewReader(os.Stdin)

	line := readLine(reader)
	totalDataSet, _ := strconv.Atoi(line)

	for i := 0; i < totalDataSet; i++ {
		length, _ := strconv.Atoi(readLine(reader))
		workLog := make([]string, length)
		for i := 0; i < length; i++ {
			workLog[i] = readLine(reader)
		}
		str := checkTimeSegment(workLog)
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

func checkTimeSegment(arr []string) string {

	sort.Strings(arr)
	endLastWork := -1

	for _, v := range arr {
		timeRange := strings.Split(v, "-")
		start, err := convertTimeFromStrToInt(strings.Split(timeRange[0], ":"))
		if err != nil {
			return "NO"
		}
		end, err := convertTimeFromStrToInt(strings.Split(timeRange[1], ":"))
		if err != nil {
			return "NO"
		}
		if start > end || start <= endLastWork {
			return "NO"
		}

		endLastWork = end
	}
	return "YES"
}

func convertTimeFromStrToInt(timeArr []string) (int, error) {
	hour, _ := strconv.Atoi(timeArr[0])
	minute, _ := strconv.Atoi(timeArr[1])
	seconds, _ := strconv.Atoi(timeArr[2])
	if hour > 23 || minute > 59 || seconds > 59 {
		return 0, errors.New("Not valid time")
	}

	return hour*3600 + minute*60 + seconds, nil
}
