// Time Complexity : O(m+n) m,n are the length or order and provided string respectively
// Space Complexity : O(n) n = Length of given string

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> hs = new HashMap<>();
        StringBuilder ans = new StringBuilder();
        // Add characters of string into Map
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(hs.containsKey(c)){
                hs.put(c, hs.getOrDefault(c, 0) + 1);
            }else{
                hs.put(c,1);
            }
        }
        //check order and output elements with frequency
        for(int i=0;i<order.length();i++){
            char o = order.charAt(i);
            int count = 0;
            if(hs.containsKey(o)){
                count = hs.get(o);
                for(int j=0;j<count;j++){
                    ans.append(o);
                }
                hs.remove(o);
            }
            
        }
        // Add additional characters at the back
        for(char f : hs.keySet()){
            for(int i=0; i<hs.get(f);i++){
                ans.append(f);
            }
        }
        return ans.toString();
        
    }
}