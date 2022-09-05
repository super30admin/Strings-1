// Time - O(n)
// Space-O(1) as 26 can be treated as constant

class Solution {
    public String customSortString(String order, String s) {
        StringBuilder res = new StringBuilder();
        int[] characters = new int[26];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            characters[ch-'a'] = characters[ch-'a']  + 1;
        }
        for(int i=0;i<order.length();i++){
            char ch = order.charAt(i);
            if(characters[ch-'a']>0){
                for(int j=0;j<characters[ch-'a'];j++){
                    res.append(ch);
                }
                characters[ch-'a'] = 0;
            }
            
        }
        
        for(char i='a';i<='z';i++){
            if(characters[i-'a']>0){
                for(int j=0;j<characters[i-'a'];j++){
                    res.append(i);
                }
                characters[i-'a'] = 0;
            }
        }
        return res.toString();
    }
}
