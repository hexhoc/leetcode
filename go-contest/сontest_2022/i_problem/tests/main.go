package main

import (
	"bufio"
	"fmt"
	"io/ioutil"
	"os"
	"sort"
	"strconv"
	"strings"
	"time"
)

func main() {

	for x := 1; x <= 1; x++ {
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
		scanner.Buffer(make([]byte, 2048*1024), 2048*1024)
		//scanner := bufio.NewScanner(os.Stdin)
		//scanner.Split(bufio.ScanLines)

		scanner.Scan()
		nums := strings.Split(scanner.Text(), " ")
		procCount, _ := strconv.Atoi(nums[0])
		taskCount, _ := strconv.Atoi(nums[1])
		processors := make([]int, procCount)
		tasks := make(map[int]int, taskCount)
		tasksKeys := make([]int, taskCount)

		scanner.Scan()
		procArr := strings.Split(scanner.Text(), " ")
		for i := 0; i < len(procArr); i++ {
			processors[i], _ = strconv.Atoi(procArr[i])
		}

		for i := 0; i < taskCount; i++ {
			scanner.Scan()
			task := strings.Split(scanner.Text(), " ")
			startTime, _ := strconv.Atoi(task[0])
			execTime, _ := strconv.Atoi(task[1])
			tasks[startTime] = execTime
			tasksKeys[i] = startTime
		}

		str := getPowerConsumption(processors, tasks, tasksKeys)
		result.WriteString(fmt.Sprintf("%s\r\n", str))

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

func getPowerConsumption(processors []int, tasks map[int]int, tasksKeys []int) string {

	start := time.Now()

	sort.Ints(processors)
	availableProcessors := make([]Processor, len(processors))
	for i := 0; i < len(processors); i++ {
		availableProcessors[i] = Processor{i, processors[i], 0}
	}

	totalPowerConsumption := 0
	for _, startTime := range tasksKeys {
		duration := tasks[startTime]
		for i := 0; i < len(processors); i++ {
			if availableProcessors[i].releaseTime <= startTime {
				availableProcessors[i].releaseTime = startTime + duration
				totalPowerConsumption += duration * availableProcessors[i].powerConsumption
				break
			}
		}
	}

	timeDuration := time.Since(start)

	fmt.Println(timeDuration)
	return strconv.Itoa(totalPowerConsumption)
}

type Processor struct {
	id               int
	powerConsumption int
	releaseTime      int
}
