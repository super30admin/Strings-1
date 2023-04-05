class Solution {
    
    //HashMap Approach
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    
    public int lengthOfLongestSubstring(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        int slow = 0;
        int max = 0;
        
        for(int i=0; i<s.length(); i++){
            
            char c = s.charAt(i);
            
            if(map.containsKey(c)){
                
                slow = Math.max(slow, map.get(c));
                
            }
            map.put(c, i+1);
            max = Math.max(max, i - slow + 1);
        }
        return max;
    }
    
    
    
    //HashSet Approach
    //Time Complexity: O(2*n)
    //Space Complexity: O(1)
    
//     public int lengthOfLongestSubstring(String s) {
     
//         Set<Character> set = new HashSet<>();
        
//         int end =0;
//         int start = 0;
//         int max = 0;
        
//         while(end < s.length()){
            
//             char c = s.charAt(end);
            
//             if(set.contains(c)){
                
//                 while(set.contains(c)){
//                     set.remove(s.charAt(start));
//                     start++;
//                 }
//             }
//             max = Math.max(max, end - start + 1);
//             set.add(c);
//             end++;  
//         }
//         return max;
//     }
    
    
    

   
//     public int lengthOfLongestSubstring(String s) {
        
//         int maxLength = 0;
        
//         Map<Character, Integer> map = new HashMap<>();
        
//         int start=0;
//         int end = 0;
        
//         while(end< s.length()){
            
//             char ch = s.charAt(end);
            
//             if(map.containsKey(ch)){
                
//                 int chIndex = map.get(ch);
                
//                 if(chIndex >= start){
        
//                     start = chIndex+1;
        
//                 }
            
//             }
//             map.put(ch, end);
//             end++;
//             maxLength = Math.max(maxLength, end - start);
                    
//         }
    
//         return maxLength;
//     }
    
    
    
    
    
    
    
    
//     public int lengthOfLongestSubstring(String s) {
        
//         int maxLength = 0;
        
//         Map<Character, Integer> map = new HashMap<>();
        
//         int start=0;
//         int end = 0;
        
//         while(end< s.length()){
            
//             char ch = s.charAt(end);
            
//             if(!map.containsKey(ch)){
                
//                 map.put(ch, end);
//                 end++;
//                 maxLength = Math.max(maxLength, end - start);
                
//             }
//             else{

//                 int chIndex = map.get(ch);
                
//                 if(start > chIndex){
//                     map.remove(ch);
//                 }
//                 else{
//                     start = chIndex+1;
//                     map.remove(ch);
//                 }
    
//             }        
//         }
    
//         return maxLength;
//     }
    
    
    
    
    
    
    
//     public int lengthOfLongestSubstring(String s) {
        
//         int maxLength = 0;
        
//         Set<Character> set = new HashSet<>();
        
//         int start=0;
//         int end = 0;
        
//         while(end< s.length()){
            
//             char ch = s.charAt(end);
            
//             if(!set.contains(ch)){
                
//                 set.add(ch);
//                 end++;
//                 maxLength = Math.max(maxLength, end - start);
                
//             }
//             else{

//                 while(set.contains(ch)){
//                     set.remove(s.charAt(start));
//                     start++;   
//                 }
    
//             }        
//         }
    
//         return maxLength;
//     }
}
