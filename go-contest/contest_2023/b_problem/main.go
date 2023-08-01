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

	scanner := bufio.NewScanner(os.Stdin)
	scanner.Buffer(make([]byte, 1024*1024), 1024*1024)
	scanner.Split(bufio.ScanLines)

	scanner.Scan()
	size, _ := strconv.Atoi(scanner.Text())
	for i := 0; i < size; i++ {
		scanner.Scan()
		str := scanner.Text()
		answer := isShipCorrect(str)
		result.WriteString(fmt.Sprintf("%s\r\n", answer))
	}

	output := result.String()
	fmt.Println(output)

}

func isShipCorrect(s string) string {
	result := "YES"
	arr := strings.Split(s, " ")
	correctShipMap := make(map[int]int, len(arr))
	correctShipMap[1] = 4
	correctShipMap[2] = 3
	correctShipMap[3] = 2
	correctShipMap[4] = 1
	shipMap := make(map[int]int, len(arr))
	for _, v := range arr {
		intValue, _ := strconv.Atoi(v)
		shipMap[intValue]++
	}
	for i := 1; i <= 4; i++ {
		if correctShipMap[i] != shipMap[i] {
			result = "NO"
		}
	}
	return result
}
