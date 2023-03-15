import java.util.*;

public class LongestwoRepeating {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0)return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int slow = 0;
        int maxLength = 0;
        for(int fast=0;fast<s.length();fast++){
            char curr = s.charAt(fast);
            if(map.containsKey(curr)){
                //record new max length substring after updating slow ptr
                slow = Math.max(slow,map.get(curr)+1);
            }
            maxLength = Math.max(maxLength,fast-slow+1);
            map.put(curr,fast);
        }
        return maxLength;
    }
}
