// Time Complexity - O(n)
// Space Complexity - O(n)

// Using HashMap

// Create an map and store all char and their occurenace of string s
// For all char in order string , check if char exist in map, 
// keep adding the char(append map.get(ch) times) in result string
// Append all rest of char from map in result.

class CustomSort {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : order.toCharArray()){
            if (map.containsKey(ch)){
                for (int i =0;i<map.get(ch);i++)
                    sb.append(ch);
                map.remove(ch);
            }
        }
        for (char ch : map.keySet()){
            for (int i =0;i<map.get(ch);i++)
                sb.append(ch);
        }
        return sb.toString();
    }
}
