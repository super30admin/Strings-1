// Time Complexity : O(n + m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
create a map of each character and their occurrences  in T
create a result rune array
for each character in S if it exists in map then append that the character that many times and set occurrence to 0
for each character in T if any of the occurrences is not 0 then append it that many number of times and set occurrence to 0
*/
package main

import "fmt"

func customSortString(S string, T string) string {
	m := make(map[rune]int)
	for _, c := range T{
		if _, ok := m[c]; ok{
			m[c] += 1
		}else{
			m[c] = 1
		}
	}
	result := []rune{}
	for _, c := range S{
		for i:=0; i<m[c]; i++{
			result = append(result, c)
		}
		m[c] = 0
	}

	for _, c := range T{
		if m[c] != 0{
			for i:=0; i<m[c]; i++{
				result = append(result, c)
			}
			m[c] = 0
		}
	}

	return string(result)
}

func MainCustomSort() {
	fmt.Println(customSortString("cba", "abcd")) //expected "dcba", "cdba" or "cbda"
}
