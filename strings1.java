//problem1
class Solution {
    public String customSortString(String order, String s) {
       StringBuilder sb=new StringBuilder();
       int[] freq=new int[26];
       for(int i=0;i<s.length();i++){
        char ch=s.charAt(i);
        freq[ch-'a']++;
       }
       for(int i=0;i<order.length();i++){
        char c=order.charAt(i);
        while(freq[c-'a']>0){
            sb.append(c);
            freq[c-'a']--;
        }
       }
       for(int i=0;i<26;i++){
        while(freq[i]>0){
            sb.append((char)(i+'a'));
            freq[i]--;
        }
       }
       return sb.toString();
    }
}
//problem2
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int slow=0;
        int maxim=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch)){
                slow=Math.max(slow,map.get(ch)+1);
            }
            map.put(ch,i);
            maxim=Math.max(maxim,i-slow+1);
        }
        return maxim;
    }
}
