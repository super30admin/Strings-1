//1.Custom Sort
//Time Complexity-> O(logn)
//Space Complexity - > O(n)
class Solution {
    public String customSortString(String order, String s) {
        if(order == null || order.length() == 0) return s;
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0 ;i<s.length();i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch, 1);
            }else{
                int count = map.get(ch);
                count = count + 1;
                map.put(ch,count);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< order.length();i++){
             char ch = order.charAt(i);
             if(map.containsKey(ch)){
                 int count = map.get(ch);
                 for(int k = 0; k<count;k++){
                     sb.append(ch);
                 }
                 map.remove(ch); //deleting iot from the map once it is completed
             }
        }
        for(Character ch : map.keySet()){
             int count = map.get(ch);
             for(int k = 0;k< count;k++){
                 sb.append(ch);
             }
        }
        return sb.toString();
        
    }
}
//2nd Longest Substring without repeating characters
class Solution {
    //Using HashSet
    //Time Complexity - >O(2n) because we will be iterating over each character twice but 2 does'nt matter so it will be O(n)'
    //Space Complexity -> O(26)->O(1)
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int max = 0;
        int slow = 0;
        for(int i = 0 ;i < s.length();i++){
            char ch = s.charAt(i);
            if(set.contains(ch)){
                while(s.charAt(slow)!=ch){
                    set.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            }
            set.add(ch);
            max = Math.max(max, i - slow +1); //i - slow are indices and indices and +1 to get the length of the string

        }
        return max;
        
    }
}

//Using Hashmap
class Solution {
    //Using HashMap
    //Time Complexity - >O(n)
    //Space Complexity -> O(26)->O(1)
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        Map<Character,Integer> map = new HashMap<>();
        int max = 0;
        int slow = 0;
        for(int i = 0 ;i < s.length();i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                slow = Math.max(slow,map.get(ch)+1);
            }
            map.put(ch,i);
            max = Math.max(max, i - slow +1); //i - slow are indices and indices and +1 to get the length of the string

        }
        return max;
        
    }
}