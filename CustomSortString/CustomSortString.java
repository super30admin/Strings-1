package CustomSortString;
import java.util.HashMap;

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