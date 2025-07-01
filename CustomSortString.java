//Solution: Using HashMap
//TC: O(n+m) here, n is length of s & m is length of order
//SC: O(k), keys present in hashmap

class Solution {
    public String customSortString(String order, String s) {
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> smap = new HashMap<>();
        for(char c : s.toCharArray()){
            if(!smap.containsKey(c)){
                smap.put(c,0);
            }
            smap.put(c, smap.get(c)+1);
        }

        for(int i=0; i<order.length(); i++){
            char ch =order.charAt(i);
            if(smap.containsKey(ch)){
                int cnt = smap.get(ch);
                for(int k=0; k<cnt; k++){
                    result.append(ch);
                }
                smap.remove(ch);
            }
        }
        for(char key : smap.keySet()){
            int cnt = smap.get(key);
            for(int k=0; k<cnt; k++){
                result.append(key);
            }
            //smap.remove(ch); --> if we do here then it will give concurrent modification exception because we are iterating over map 
        }
        return result.toString();
        
    }
}