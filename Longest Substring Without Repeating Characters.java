class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.length()==0) return 0;

        int max = 0;
        int i = 0 , j = 0;

        HashSet<Character> set = new HashSet<>();

        while(i<s.length() && j< s.length())
        {
            if(set.contains(s.charAt(j)))
            {
                set.remove(s.charAt(i));
                i++;

            }
            else
            {
                set.add(s.charAt(j));
                j++;
            }

            max = Math.max(max,(j-i));
        }

        return max;

    }
}
