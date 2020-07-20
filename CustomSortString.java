// Time Complexity- O(m+n) m= length of S and n=length of T but since S length is atmost 26, it is O(n)
// Space Complexity- O(1) // HashMap size as it stores 26 characters in worst case

// The main idea to this problem is maintain a HashMap of counts of characters of second string
// and push elements of first string to resultant string (count) number of times.
// Push remaining elements in HashMap (second string) in any order to the resultant string. 

class Solution {
    public String customSortString(String S, String T) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character,Integer> map = new HashMap<>();
        // maintain count of all characters in longer string in map
        for(int i=0;i<T.length();i++) {
            map.put(T.charAt(i),map.getOrDefault(T.charAt(i),0)+1);
        }
        for(int i=0;i<S.length();i++) {
            if(map.containsKey(S.charAt(i))) {
                int count = map.get(S.charAt(i));
                while(count > 0) {
                    sb.append(S.charAt(i));
                    count--;
                }
                map.remove(S.charAt(i));
            }
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet()) {
            int count = entry.getValue();
            while(count > 0) {
                sb.append(entry.getKey());
                count--;
            }
        }
        return sb.toString();
    }
}