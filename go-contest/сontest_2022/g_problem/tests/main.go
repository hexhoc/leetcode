package main

import (
	"bufio"
	"fmt"
	"io/ioutil"
	"os"
	"sort"
	"strconv"
	"strings"
)

func main() {
	for x := 1; x <= 25; x++ {
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
		scanner.Buffer(make([]byte, 512*1024), 512*1024)
		//scanner := bufio.NewScanner(os.Stdin)
		//scanner.Split(bufio.ScanLines)

		scanner.Scan()
		nums := strings.Split(scanner.Text(), " ")
		totalUsers, _ := strconv.Atoi(nums[0])
		totalPairs, _ := strconv.Atoi(nums[1])
		pairArr := make([]string, totalPairs)
		for j := 0; j < totalPairs; j++ {
			scanner.Scan()
			dataStr := scanner.Text()
			pairArr[j] = dataStr
		}

		str := getPossibleFriends(totalUsers, pairArr)
		output := str
		//output = output[:len(output)-2]
		//fmt.Println(str)

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

func getPossibleFriends(totalUsers int, pairArr []string) string {
	var result []string
	userMap := make(map[string]map[string]bool)

	for i := 0; i < len(pairArr); i++ {
		pair := strings.Split(pairArr[i], " ")
		appendFriend(userMap, pair[0], pair[1])
		appendFriend(userMap, pair[1], pair[0])
	}

	for i := 1; i <= totalUsers; i++ {
		hasMutualFriend := false
		maxMutualFriend := 0
		userId := strconv.Itoa(i)
		friendMap := userMap[userId]
		possibleFriendMap := make(map[string]int)
		for friendId, _ := range friendMap {
			friendFriendsMap := userMap[friendId]
			for possibleFriendId, _ := range friendFriendsMap {
				if !friendMap[possibleFriendId] && possibleFriendId != userId {
					possibleFriendMap[possibleFriendId]++
					if possibleFriendMap[possibleFriendId] > 1 {
						hasMutualFriend = true
						if maxMutualFriend < possibleFriendMap[possibleFriendId] {
							maxMutualFriend = possibleFriendMap[possibleFriendId]
						}
					}
				}
			}
		}

		possibleFriends := make([]int, 0)
		for possibleFriendId, v := range possibleFriendMap {
			//if v > 1 || len(friendMap) == 1 || len(possibleFriendMap) == 1 {
			if (!hasMutualFriend) ||
				(v > 1 || len(friendMap) == 1 || len(possibleFriendMap) == 1) {
				if hasMutualFriend && v != maxMutualFriend {
					continue
				}
				intId, _ := strconv.Atoi(possibleFriendId)
				possibleFriends = append(possibleFriends, intId)
			}
		}

		sort.Ints(possibleFriends)

		if len(possibleFriends) == 0 {
			result = append(result, fmt.Sprintf("%s ", "0"))
		} else {
			for _, possibleFriend := range possibleFriends {
				result = append(result, fmt.Sprintf("%d ", possibleFriend))
			}
		}

		result[len(result)-1] = strings.TrimSpace(result[len(result)-1])
		result = append(result, "\r\n")
	}

	return strings.Join(result, "")
}

func appendFriend(userMap map[string]map[string]bool, user1 string, user2 string) {
	if userMap[user1] == nil {
		friendMap := make(map[string]bool)
		friendMap[user2] = true
		userMap[user1] = friendMap
	} else {
		userMap[user1][user2] = true
	}
}
