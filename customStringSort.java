//time complexity: O(max(m,n)) where m is the number of elements in S and T strings respectively
//space complexity: O(number of unique elements in T string)
//executed on leetcode : yes
//approach: we take a hashmap to store the characters in T and their counts.
// then we iterate along S and for every character, we find it in the map and append to a string builder the number of times the character's count
//after we are done appending every element in the S string , we simply add remaining elements in the hashmap to the string builder
class Solution {
    public String customSortString(String S, String T) {
        HashMap<Character,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<T.length();++i)
        {
            if(!map.containsKey(T.charAt(i)))
            {
                map.put(T.charAt(i),1);
            }
            else
            {
                map.put(T.charAt(i),map.get(T.charAt(i))+1);
            }
        }
        for(int i=0;i<S.length();++i)
        {
            if(map.containsKey(S.charAt(i)))
            {   int count = map.get(S.charAt(i));
                while(count>0)
                {
                    sb.append(S.charAt(i));
                    count--;
                }
                map.remove(S.charAt(i));
            }
        }
        for(char c : map.keySet())
            {
                int count = map.get(c);
                while(count>0)
                {
                    sb.append(c);
                    count--;
                }
            map.put(c,count);
                
            }
        return sb.toString();
    }
}