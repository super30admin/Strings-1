// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
have an arr of 128 length
set maxcount and i to 0
loop on s
if arr[char] is more than i set i to it
if pos - i + 1 is more than maxcount set it
set arr[char] to pos+1

return maxcount
*/
package main

import "fmt"

func lengthOfLongestSubstring(s string) int {
	var arr [128] int
	maxcount := 0
	i := 0
	for pos, char := range s {
		if arr[char] > i { i = arr[char] }
		if pos - i + 1 > maxcount { maxcount = pos - i + 1 }
		arr[char] = pos + 1
	}
	return maxcount
}

func MainLengthOfLongestSubstring() {
	fmt.Println(lengthOfLongestSubstring("abcabcbb")) //expected 3
}
