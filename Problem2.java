//time complexity:o(n)
//space complexity:o(1) as we are only storing 26 charc in hashmap
//run on letcode: yes
//any doubts: no

class Solution {
    //by using hashmap and storing all the charac, whenever we see a duplicate char then we move the slow pointer to the prev occur char index +1 and continue
        public int lengthOfLongestSubstring(String s) {
            HashMap<Character, Integer> hmap = new HashMap<>();
            int slow=0;int max=0;
            for(int i=0;i< s.length();i++){
                char c =s.charAt(i);
                if(hmap.containsKey(c)){
                    //if we found char in hash map then we will take max of slow and the value in hashmap because sometimes the value in hashmap might be lesser and back then we take slow . zabcdefbghibcz here at 2nd c we see that slow is at g and for c we have index 3 in hashmap 
                    slow = Math.max(slow, hmap.get(c));
                }
                // total length of substring
                max = Math.max(max, i-slow+1);
                hmap.put(c,i+1);
            }
            return max;
        }
    }s