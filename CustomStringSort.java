// Time Complexity : O(n+m) where n is length of S, m is length of T
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//The idea is to store chars of T and freq in hashmap
//take a result string to return
//order of chars should be maintained as in S, so lets iterate through chars in S and if we find them in T, we can add to string as per their count
//reduce the freq value each time
//the remaining elements in the map with freq > 0 are added to the string as per their count, order is not mandatory for them
//return the string

class Solution {
    public String customSortString(String S, String T) {
        if(S==null||T==null) return "";
        HashMap<Character, Integer> hm=new HashMap<>();
        for(int i=0;i<T.length();i++){
            char ch= T.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        String result="";
        for(int j=0;j<S.length();j++){
            char c=S.charAt(j);
            if(hm.containsKey(c)){
                while(hm.get(c)>0){
                    result+=c;
                    hm.put(c,hm.get(c)-1);
                }
            }
        }
        for (Map.Entry<Character, Integer> entry : hm.entrySet()){
            Character cha= entry.getKey();
            Integer count=entry.getValue();
            while(count>0){
                result+=cha;
                count--;
            }
        }
        return result;
    }
}