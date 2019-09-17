package CustomSortString;
import java.util.HashMap;


//Time Complexity	-	O(m+n) m - number of characters in string T
//							   n - number of characters in string S
//Space Complexity	-	O(1) as given in the problem, string T is composed of lower case letters ~ O(26) ~ O(const)

class CustomSortString {
	public String customSortString(String S, String T) {
		HashMap<Character, Integer> map = new HashMap<>();
		StringBuilder result = new StringBuilder();

		// Form the HashMap from T
		for (char ch : T.toCharArray()) {
			map.put(Character.valueOf(ch), map.getOrDefault(Character.valueOf(ch), 0) + 1);
		}

		// For each character in S, add number of characters in the same order as S in
		// result string
		for (char sCh : S.toCharArray()) {
			if (map.containsKey(Character.valueOf(sCh))) {
				for (int i = 0; i < map.get(Character.valueOf(sCh)); i++)
					result.append(sCh);
				map.remove(Character.valueOf(sCh));
			}
		}

		// Append remaining characters to the end of the result string
		for (char remainig : map.keySet()) {
			for (int i = 0; i < map.get(Character.valueOf(remainig)); i++)
				result.append(remainig);
		}

		return result.toString();
	}
}