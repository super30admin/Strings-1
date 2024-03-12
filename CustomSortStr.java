package week7.day6;

import java.util.HashMap;
import java.util.Map;
//TC -O(m+n)
//SC - O(1)
//https://leetcode.com/problems/custom-sort-string/
class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map= new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(char ch:order.toCharArray()){
            if(map.containsKey(ch)){
                int count = map.get(ch);
                while(count>0){
                    sb.append(ch);
                    count--;
                }
                map.remove(ch);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character ch = entry.getKey();
            Integer count = entry.getValue();
            while(count>0){
                    sb.append(ch);
                    count--;
                }
        }
        return sb.toString();
    }
}
public class CustomSortStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
