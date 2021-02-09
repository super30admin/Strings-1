/*
    Time : O(N^2) | After each repeated char for loop starts from beginning so. (Not 100% sure)
    Space : O(N) | N being length of s. HashMap space
    Leetcode : YES
*/


class LengthOfLongestSubstring {
/*
    Approach :
    1. Iterate through given string while maintaining hashmap of char and indexes.
    2. If we encounter char which is already present in the hashmap. then reset i 
       to the index of that char+1
    3. maintain curr and max variables and update curr by 1 when you add new element to substring.
    4. reset curr = 0 when you encounter repeated char.
*/
    
    public int lengthOfLongestSubstring(String s) {
        if(s == null ) return 0;
        if(s.length() <= 1) return s.length();
        
        HashMap<Character,Integer> hashMap = new HashMap<>();
        int max = 0;
        int curr = 0;
        for(int i=0; i < s.length();i++){
            char c = s.charAt(i);
            if(!hashMap.containsKey(c)){
                hashMap.put(c,i);
                curr += 1;               
            }else{
                curr = 0;
                i = hashMap.get(c);
                hashMap.clear();
            }
            max = Math.max(max, curr);
        }
        
        return max;
    }
}
