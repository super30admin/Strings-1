/*Time Complexity : O(n)
Space Complexity : O(1)*/

func lengthOfLongestSubstring(s string) int {
	LongestSubStr := 0
	WindowStart := 0
	seenRunes := map[rune]int{}
	for CurrentIndex, v := range s {
		if value, ok := seenRunes[v]; ok {
			if value > WindowStart-1 {
				WindowStart = max(seenRunes[v]+1, WindowStart+1)
			}
		}
		seenRunes[v] = CurrentIndex
		LongestSubStr = max(LongestSubStr, len(s[WindowStart:CurrentIndex+1]))
	}
	return LongestSubStr
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
