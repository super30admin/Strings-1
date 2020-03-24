// Time Complexity: O(m + n), m is the length of string S and n is the length of string T
// Space Complexity: O(n)

class Solution {
    public String customSortString(String S, String T) {
        Map<Character, Integer> hashMap = new LinkedHashMap<>();

        for(char t: T.toCharArray()) {
        	hashMap.put(t, hashMap.getOrDefault(t, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        for(char c: S.toCharArray()) {
        	int freq = hashMap.getOrDefault(c, 0);
        	for(int i = 0; i < freq; i++) {
        		sb.append(c);
        	}
        	hashMap.remove(c);
        }

        for(char t: hashMap.keySet()) {
        	int freq = hashMap.getOrDefault(t, 0);
        	for(int i = 0; i < freq; i++) {
        		sb.append(t);
        	}
        }
        return sb.toString();
    }
}

