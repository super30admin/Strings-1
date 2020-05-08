// 3.
//time - O(n)
//space - O(n)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> indexMap = new HashMap<>(); //character to its index + 1
        int start = 0; //start and end denote the current substring
        int end = 0;
        int maxLength = 0;
        while(end < s.length())
        {
            char current = s.charAt(end);
            if(indexMap.containsKey(current)) //update start to value of current to change the window to remove duplicate
            {
                start = Math.max(start, indexMap.get(current)); //max() to prevent start going backwards
            }
            indexMap.put(current, end + 1); //update map with current char and index + 1
            //if maxLength changes store the current substring i.e s.substring(start, end + 1) in result
            maxLength = Math.max(maxLength, end - start + 1); //update result
            end++; //increase window size
        }
        return maxLength;
    }
}
