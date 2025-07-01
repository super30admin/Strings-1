class Solution {
    //Sliding Window + HashMap
    public int lengthOfLongestSubstring(String s){
        HashMap<Character,Integer>map = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxlength = 0;
        for(right = 0 ; right < s.length() ; right++){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                //if duplicate is found , move left to max(left , ch value in map)
                left = Math.max(left , map.get(ch));
            }
            //in map , update latest index as last seen index+1
            map.put(ch , right+1);
            maxlength = Math.max(maxlength , right - left + 1);
        }
        return maxlength;


    }


    //Sliding Window + Hashset
    // public int lengthOfLongestSubstring(String s) {
    //     //hashset to store characters in string
    //     HashSet<Character>set = new HashSet<>();

    //     int left = 0;
    //     int right = 0;
    //     int maxlength = 0;

    //     for(right = 0 ; right < s.length() ; right++){
    //         char ch = s.charAt(right);
    //         while(set.contains(ch)){
    //             //remove left char from set and increment left by 1
    //             set.remove(s.charAt(left));
    //             left++;

    //         }
    //         set.add(ch);
    //         maxlength = Math.max(maxlength , right-left+1);

    //     }
    //     return maxlength;
        
        
    // }
}