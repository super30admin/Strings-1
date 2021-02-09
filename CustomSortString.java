// TC: O(M+N) -> M -> length of S and N -> length of T
// SC: O(N)   -> length of stringbuilder (length of T)
// Did it run successfully on Leetcode? : Yes
class Solution {
    public String customSortString(String S, String T) {
        if (T == null || T.length() == 0)
            return null;
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap();
        for ( char c : T.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : S.toCharArray())
        {
            if (map.containsKey(c))
            {
                int count = map.get(c);
                while (count > 0)
                {
                    sb.append(c);
                    count--;
                }
                map.remove(c);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet())
        {
            char c = entry.getKey();
            int count = entry.getValue();
                while (count > 0)
                {
                    sb.append(c);
                    count--;
                }
        }
        return sb.toString();
    }
}
