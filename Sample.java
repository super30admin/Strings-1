//Time Comp: O(n)
//Space Comp: O(n)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        int i = 0;
        int j = 0;
        while(i<n && j<n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                if(maxLen<j-i){
                    maxLen = j-i;
                }
            }
            else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return maxLen;
    }
}

//Time: O(n)
//Space: O(n)
class Solution {
    public String customSortString(String S, String T) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for(Character c: T.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c,1);
            }
            else{
                map.put(c,map.get(c)+1);
            }
        }
        for(Character c: S.toCharArray()){
            int count = map.getOrDefault(c,0);
            for(int i=0;i<count;i++){
                sb.append(c);
            }
            map.remove(c);
        }
        for(Character c: map.keySet()){
            int count = map.getOrDefault(c,0);
            for(int i=0;i<count;i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
