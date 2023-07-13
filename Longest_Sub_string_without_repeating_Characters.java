//Time complexity = O(N);
//Space Complexity = O(N);
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //base
        if(s.length() ==0)return 0;
        System.out.println(s.length());
        int maxlen =0;
        HashMap<Character,Integer> map = new HashMap<>();
        // int fast =1
        int slow =0;
        // map.put(s.charAt(0),0);
        for(int i =0 ; i< s.length(); i++){
            char a = s.charAt(i);
            //if contains, move the slow pointer
            if(map.containsKey(a))slow = Math.max(slow , map.get(a)+1);
            map.put(a,i);
            // fast++;
            maxlen = Math.max(maxlen,i-slow+1);
        }
        return maxlen;

    }
}