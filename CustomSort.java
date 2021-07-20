//Time Complexity-O(s+t)
//Space complexity-O(t)
//Ran on leetcode-Yes
//Solution with comments-
class Solution {
    public String customSortString(String S, String T) {
        if(S==null || T==null)
            return null;
        StringBuilder sb= new StringBuilder();
        
        HashMap<Character,Integer> map= new HashMap<>();
        for(char ch: T.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);//add all char of t in map with their count
        }
        for(int i=0;i<S.length();i++){
            char ch= S.charAt(i);
            if(map.containsKey(ch)){
                while(map.get(ch)>0){
                    sb.append(ch);//append to output the first char in S to maintain order
                    map.put(ch,map.get(ch)-1);
                }
            }
            map.remove(ch);
        }
        for(char ch: map.keySet()){
            while(map.get(ch)>0){
                sb.append(ch);
                map.put(ch,map.get(ch)-1);
            }
        }
        return sb.toString();
    }
}