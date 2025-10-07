// Time complexity - O(m+n), m is the length of the order string and n is the length of the input string
// Space complexity - O(1)
function customSortString(order: string, s: string): string {
	const map = new Map<string, number>();
	const result = [];

	// add char to occurence entry in the map
	for (let i = 0; i < s.length; i++) {
		map.set(s[i], (map.get(s[i]) || 0) + 1);
	}

	// for each character in order, find the occurence in the string
	// add the char to result array on occurence count
	// remove the char from map once added to result array
	for (let i = 0; i < order.length; i++) {
		const char = order[i];

		if (map.has(char)) {
			let count = map.get(char);

			for (let c = 0; c < count; c++) {
				result.push(char);
			}
			map.delete(char);
		}
	}

	// if we still have some characters left in the map from original string
	// add the char to the result array based on occurence count
	if (map.size > 0) {
		const keys = map.keys();
		for (let key of keys) {
			const count = map.get(key);
			for (let c = 0; c < count; c++) {
				result.push(key);
			}
		}
	}

	// return the string version of result
	return result.join("");
}
