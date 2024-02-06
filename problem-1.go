/*package main

import (
	"fmt"
)

func main() {
	order := "cba"
	s := "abcdaaaaaaaaaaaaaaaaaa"
	fmt.Println(customSortString(order, s))
}*/

/*time complexity : O(n)
space Complexity : O(1)*/

func customSortString(order string, s string) string {
	var result string
	var sCount = make(map[string]int)
	for _, char := range s {
		//fmt.Println(string(char))
		_, check := sCount[string(char)]
		if check {
			sCount[string(char)] = sCount[string(char)] + 1
		} else {
			sCount[string(char)] = 1
		}
	}
	for _, char := range order {
		count := sCount[string(char)]
		for i := 0; i < count; i++ {
			result = result + string(char)
		}
		delete(sCount, string(char))
	}
	for key, char := range sCount {
		for i := 0; i < char; i++ {
			result = result + key
		}
	}
	return result
}
