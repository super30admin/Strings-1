class Solution {

    //Time Complexity: 0(m + n) where m is the character in order and n is the characters in n
    //Space Complexity: 0(1)
    //Did it successfully run on leetcode: Yes
    //Did you face any problem while coding: No

    //In brief explain your approach

    public String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder(); //using stringbuilder to add the characters from s as per the custom sort of order
        HashMap<Character, Integer> map = new HashMap<>();//using a hashmap to store all the characters and their no. of occurences

        for(int i = 0; i < s.length(); i++){    //storing all the characters from s and their occurences
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < order.length(); i++){    //going through the order string
            char c = order.charAt(i);   //extracting one character at a time
            if(map.containsKey(c)){ //checking if the character in the custom order is present in the hashmap or not
                int a = map.get(c); //if yes, getting their no. of occurences
                for(int j = 0; j < a; j++){ //looping the and adding the character to the no. of times it is present in the s string
                    sb.append(c);
                }
            }
            map.remove(c);  //removing the character once it has been added to the result string
        }

        for(char b : map.keySet()){ //going through the characters in hashmap that are not present in our custom order
            int count = map.get(b); //getting the count of the character
            for(int i = 0; i < count; i++){ //looping through count and adding them to the final result
                sb.append(b);
            }
        }
        return sb.toString();
    }
}