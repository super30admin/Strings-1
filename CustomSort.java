// Time Complexity : O(Max(S,T) - S - length of string S, T - length of string T
// Space Complexity : O(T)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public String customSortString(String S, String T) {
        if(S == null || T == null) return T;
        HashMap<Character,String> map = new HashMap<>();
        for(int i=0;i<T.length();i++){
            String str ="";
            if(map.containsKey(T.charAt(i)))
                map.put(T.charAt(i),map.get(T.charAt(i))+T.charAt(i));
            else
                map.put(T.charAt(i),str+T.charAt(i));
        }
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<S.length();i++){
            if(map.containsKey(S.charAt(i))){
                sb.append(map.get(S.charAt(i)));
                map.remove(S.charAt(i));
            }
        }
        for(char c:map.keySet()){
            sb.append(map.get(c));
        }
        return sb.toString();
    }
}
