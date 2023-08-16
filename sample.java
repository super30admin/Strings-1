//Problem 1: Custom Sort String
// Time Complexity : O(m+26) Best case
// Space Complexity : O(m)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

//store all the order string characters in a hashmap from string s. then create a string from them, 
//then append all unwanted characters in any way. return resultant string
class Solution {
    //C: O(m+26) SC:O(m)
    public String customSortString(String order, String s) {
        Map<Character, Integer> map= new HashMap<>(); //space O(26)
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        StringBuilder sb=new StringBuilder(); //Space O(n)
        for(int i=0;i<order.length();i++){
            char c=order.charAt(i);
            if(map.containsKey(c)){
                int count=map.get(c);
                for(int k=0;k<count;k++){
                    sb.append(c);
                }
                map.remove(c);
            }
        }

        for(char key: map.keySet()){
            int count=map.get(key);
            for(int k=0;k<count;k++){
                    sb.append(key);
            }
        }
        return sb.toString();
    }
}


//Problem 2: longest substring without repeating characters
// Time Complexity : O(n)
// Space Complexity : O(26)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//HashMap and hashset solution
//HashSet-> store each character as we parse the string, whenever the character is repeated, remove all elements before the repeated character and start again until end
//HashMap -> similar to hashset just instead of skipping character, move slow to repeated character index+1
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set= new HashSet<>();
        int slow=0, max=0;
        //O(2n) O(26)
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(set.contains(ch)){
                //move slow to till earlier occurrence till ch is escaped
                while(s.charAt(slow)!=ch){
                    set.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            }
            set.add(ch);
            max=Math.max(max,i- slow+1);
        }
        return max;

        // HashMap Solution O(n) O(26)
        // Map<Character, Integer> map= new HashMap<>();

        // for(int i=0;i<s.length();i++){
        //     char ch=s.charAt(i);

        //     if(map.containsKey(ch)){
        //         slow=Math.max(slow,map.get(ch)+1);
        //     }
        //     map.put(ch,i);
        //     max=Math.max(max, i-slow+1);
        // }
        // return max;
    }
}