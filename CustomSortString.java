// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create a HashMap to store character and it's total occurence as string.
// Iterate over the string and see if a particular character is present in 
// HashMap as key. If not create a new entry with character as key and value
// otherwise if found just append the character to the value. Now iterate over
// order and for every character check if it present in HashMap as key if 
// present then append its value to the output string and remove the key from
// HashMap else continue. Finally iterate over the remaining entries in the Map
// which are not present in the order string and append the values to the 
// output string and finally return it.

class Solution {
    Map<Character,String> m = new HashMap<>();
    public String customSortString(String order, String s) {
        String output = "";
        for(int i=0;i<s.length();i++){
            if(m.containsKey(s.charAt(i))){
                m.put(s.charAt(i),m.get(s.charAt(i))+s.charAt(i));
            }
            else{
                m.put(s.charAt(i),""+s.charAt(i));
            }
        }
        for(int i=0;i<order.length();i++){
            if(m.containsKey(order.charAt(i))){
                output = output + m.get(order.charAt(i));
                m.remove(order.charAt(i));
            }
        }
        if(m.size()>0){
            for(Character c:m.keySet()){
                output = output + m.get(c);
            }
        }
        return output;
    }
}