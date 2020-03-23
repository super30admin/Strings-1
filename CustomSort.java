class Solution {
    public String customSortString(String S, String T) {
        char[] t = T.toCharArray();
        char[] s = S.toCharArray();
        
        //put T in map with frequency
        //check for S in T and append to string
        //add the remaining values
        
        Map<Character, Integer> tmap = new HashMap<>();
        for(char ch : t)
            tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
        StringBuilder ans = new StringBuilder();
        
        
        for(int i = 0; i< s.length; i++){
            if(tmap.containsKey(s[i])){
                ans.append(s[i]);
                tmap.put(s[i], tmap.get(s[i])-1);
            }
        }
        
        for(char m : tmap.keySet()){
            ans.append(m);
        }
        
        return ans.toString();
    }
}
