// Time Complexity : O(n) to store each character in map and then again building it
// Space Complexity : O(1) since the number of characters is constant in the map
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create a hashmap where we will store the frequency of each charater in the string
// Now we will traverse through the order string and get the frequencies from the hashMap
//We will keep adding these in string buffer, and remove the element from the hashmap
//Now we will add all the rest of the characters in hashmap to string buffer and return it.
class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char x = s.charAt(i);
            hm.put(x,hm.getOrDefault(x,0)+1);
        }
        StringBuffer ans = new StringBuffer();
        for(int i = 0; i < order.length(); i++){
            char x = order.charAt(i);
            if(hm.containsKey(x)){
                for(int j = 0; j < hm.get(x); j++)
                    ans.append(x);
                hm.remove(x);
            }
        }
        for (Map.Entry<Character, Integer> entry : hm.entrySet()){
            
            for(int i = 0; i < entry.getValue(); i++)
                    ans.append(entry.getKey());
        }
        return ans.toString();
    }
}