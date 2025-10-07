// Time complexity - O(n), where n is number of characters in a string
// Space complexity - O(1)
function lengthOfLongestSubstring(s: string): number {
	let max = 0;
	const map = new Map<string, number>();
	let left = 0;
	for (let i = 0; i < s.length; i++) {
		const char = s[i];

		// if the char was seen previously, update the left to next index of char's previous occurence
		if (map.has(char) && map.get(char) >= left) {
			left = map.get(char) + 1;
		}

		// add current char index
		map.set(char, i);

		// update max length
		max = Math.max(max, i - left + 1);
	}

	return max;
}
