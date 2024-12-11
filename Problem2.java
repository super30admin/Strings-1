import java.util.*;
public class Problem2 {
    public int lengthOfLongestSubstring(String s) {
        return helperUsingHashMap(s);
    }
    //TC:O(2N) - N for going through all elements and N for moving left pointer
    //SC :O(N)
    public int helperUsingHashSet(String s) {
        char[] chars = s.toCharArray();
        int maxLength = 0;
        Set<Character> duplicates = new HashSet<>();
        int sPtr =0;//slow pointer
        for(int fPtr=0;fPtr<chars.length;fPtr++){
            if(duplicates.contains(chars[fPtr])){
                while(!duplicates.isEmpty() && duplicates.contains(chars[fPtr])){
                    duplicates.remove(chars[sPtr]);
                    sPtr++;
                }
            }
            duplicates.add(chars[fPtr]);
            maxLength = Math.max(maxLength,fPtr-sPtr+1);
        }
        return maxLength;
    }

    //TC:O(N)
    //SC :O(N)
    public int helperUsingHashMap(String s) {
        char[] chars = s.toCharArray();
        int maxLength = 0;
        Map<Character,Integer> charMap = new HashMap<>();
        int sPtr =0;//slow pointer
        for(int fPtr=0;fPtr<chars.length;fPtr++){
            if(charMap.containsKey(chars[fPtr])){
                //this handles edge case where the value exists in map
                //but outside of our window so slow pointer should not update
                //to some value that is lesser than the slow pointer
                sPtr = Math.max(charMap.get(chars[fPtr])+1,sPtr);

            }
            charMap.put(chars[fPtr],fPtr);
            maxLength = Math.max(maxLength,fPtr-sPtr+1);
        }
        return maxLength;
    }
}
