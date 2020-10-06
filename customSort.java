//Time Complexity: O(n+m)
//Space Complexity: O(1) since hashmap has used constant space
//Did run on leetcode: Yes

class Solution {
    public String customSortString(String S, String T) {
        //base case
        if(S==null || S.length()==0){
            if(T==null || T.length()==0)
                return "";
            else
                return T;
        }    
        
        //create a hashmap and count the occurence of each char in string T
        HashMap<Character, Integer> map = new HashMap<>(26);
        
        for(int i=0; i<T.length(); i++){
            char ch = T.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        
        //now we iterate S and sort T characters according 
        //Use hashmap to get count of occurence of each character
        
        StringBuilder output = new StringBuilder();
        for(int i=0; i<S.length(); i++){
            char ch = S.charAt(i);
            if(map.containsKey(ch)){
                int count = map.get(ch);
                while(count>0){
                    output.append(ch);
                    count -= 1;
                }
                map.remove(ch);
            }
        }
        
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            char ch = entry.getKey();
            int count = entry.getValue();
            while(count>0){
                    output.append(ch);
                    count -= 1;
                }
        }
        
        return output.toString();
        
    }
}
