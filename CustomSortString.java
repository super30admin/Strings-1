// TC - O(T.length() + S.length()), SC -O(T.length())
// LC - 791
class Solution {
    public String customSortString(String S, String T) {
		// Initializing stringbuilder
        StringBuilder sb = new StringBuilder();
		//sanity check
        if(S == null || S.length() == 0 || T == null || T.length() == 0){
            return sb.toString();
        }
		// Initalize hashmap to store all the elements of T and its count
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : T.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
		// Iterate over S and check if it is present in map and get the count. append that character count times to stringbuilder, remove that element from map
        for(char ch : S.toCharArray()){
            if(map.containsKey(ch)){
                int count = map.get(ch);
                while(count > 0){
                    sb.append(ch);
                    count--;
                }
                map.remove(ch);   
            }
        }
		// There may be few characters left in map, we need to get count and append count times to stringbuilder
        for(Character ch : map.keySet()){
            int count = map.get(ch);
            while(count > 0){
                sb.append(ch);
                count--;
            }
        }
		// return sb
        return sb.toString();
    }
}