//TC : O(2*N) in worst case if last two characters are duplicate, we will have to traverse through it again.
//SC: O(1)

// Sliding window

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;

        int lo = 0;

        for(int i = 0; i < s.length() ; i++){
            char c = s.charAt(i);
            if(!set.contains(c)){
                set.add(c);
            }
            else{
                while(set.contains(c)){
                    set.remove(s.charAt(lo++));
                }
                set.add(c);
            }
            max = Math.max(max, set.size());

        }

        return max;
    }
}

// Single Pass solution
// TC: O(N)
// Approach : maintain previous occurence index of the character, and move the start of the window to next index to escape duplicate.


class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                start = Math.max(start, map.get(c)+1);
            }

            map.put(c, i);
            max = Math.max(max, i - start + 1);
        }

        return max;
    }
}