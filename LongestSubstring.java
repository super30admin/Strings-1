//HashMap Approach
// TC - O(2n)
// SC-O(1)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int slow =0;
        int result =0;

        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);

            if(set.contains(c)) {
                while(s.charAt(slow) != c) {
                    set.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            }

            set.add(c);
            result = Math.max(result, i-slow+1);
        }

        return result;
    }
}

//HashMap Approach
// TC - O(n)
// SC-O(1)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int slow =0;
        int result =0;

        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);

            if(map.containsKey(c)) {
                int index = map.get(c);
                slow = Math.max(slow,index+1);
            }

            map.put(c, i);
            result = Math.max(result, i-slow+1);
        }

        return result;
    }
}
