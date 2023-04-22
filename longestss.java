class Solution {
    public int lengthOfLongestSubstring(String s) {
        //SC-0(1),TC-O(2n)=O(n)
        // in O(2n), use sliding window and use hashset to find chars in current window, if smething
        // is repeating, move the left pointer till the first occurance is removed
        // HashSet<Character> hs = new HashSet<>();
        // int slow = 0;
        // int fast = 0;
        // int len = s.length();
        // int ans = 0;
        // while(fast < len){
        //     char cur = s.charAt(fast);
        //     if(hs.contains(cur)){
        //         //move slow till encountering the first occurance 
        //         while(s.charAt(slow)!=cur){
        //             hs.remove(s.charAt(slow));
        //             slow+=1;
        //         }
        //         hs.remove(s.charAt(slow));
        //         slow+=1;

        //     }
        //     hs.add(cur);
        //     ans = Math.max(ans,hs.size());
        //     fast+=1;

        // } 
        // return ans;

        // using hashmap , store indices of the characters, if same character is found,move slow to its index+1, and update its index to fast
        HashMap<Character,Integer> hm = new HashMap<>();
        int slow =0;
        int fast = 0;
        int n = s.length();
        int ans = 0;
        while(fast<n){
            if(hm.containsKey((s.charAt(fast)))){
                int ind = hm.get((s.charAt(fast)));
                // as wea re not removing chars from hashmap, check if its in range of slow and fast, if yes then only move slow to ind+1, else continue
                if (ind >= slow){
                    slow = ind + 1;
                }
                hm.put(s.charAt(fast),fast);
            }
            else{
                // if not present, add it to hashmap
                hm.put(s.charAt(fast),fast);
            }
            ans = Math.max(ans, fast - slow + 1);
            fast+=1;

        }
        return ans;

    }
}