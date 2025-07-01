//maintain a hashset and keep adding characters to it. Keep left and right pointers and check length. If char is already present in Hashset, left++ till we encounter that char. Remove those chars from Hashset too. While adding, maintain length of that substring.
//Time complexity: O(2n)
//Space complexity: O(1)

class Solution {
    public int lengthOfLongestSubstring(String str) {
       if(str.length()==0)
             return 0;
        int maxans = Integer.MIN_VALUE;
        Set < Character > set = new HashSet < > ();
        int l = 0;
        for (int r = 0; r < str.length(); r++) // outer loop for traversing the string
        {
            if (set.contains(str.charAt(r))) //if duplicate element is found
            {
                while (l < r && set.contains(str.charAt(r))) {
                    set.remove(str.charAt(l));
                    l++;
                }
            }
            set.add(str.charAt(r));
            maxans = Math.max(maxans, r - l + 1);
        }
        return maxans;
    }
}