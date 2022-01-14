class Solution {
    public String customSortString(String order, String s) {
        if(s == null || s.length() == 0) return ""; // base case where we check if the string s is null or the length of s is 0, we simply return an empty string
        HashMap<Character, Integer> map = new HashMap<>();// we create a hashmap with has the input as character for key and integer for value where the value has the no. of times a character is occuring in the string.
        for(int i = 0; i < s.length(); i++) { // we iterate through the string s and take each value from s
            char c = s.charAt(i); // we take the character present at each index i from the string s and store it in a character variable with name c.
            map.put(c, map.getOrDefault(c, 0) + 1); // we put that character in the map and if it is the first time we are adding it to the map, we take its value as 1 and if we have already added it earlier, we simply increment its count.
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < order.length(); i++) { // we iterate through the length of the string order.
            char c = order.charAt(i); // we take the character present at each index i of the string 'order' and store it in a character variable c.
            if(map.containsKey(c)) { // if the hash map contains the character c
                int times = map.get(c); //we store the number of times the character c has occured in the string s in the map. map.get method fetches the value mapped to the particular key mentioned in the parameter
                for( int j = 0; j < times; j++) { // after we get the count of no. of times the character c is occuring in string s, we iterate thro
                    sb.append(c); //we add the character c to the string builder the number of times it is specified in the hashmap
                }
                map.remove(c); // after adding them to the sb, we remove it from the map when the value becomes 0
            }
        }
        for(Character c : map.keySet()) { // this loop is for all of the left over elements in the hashmap. map.keySet() returns the set of keys contained in the map
            int times = map.get(c); // we get the no. of times the character is occuring in the string thorugh accessing the value part of the hashmap. We store it in the integer variable called as times.
            for(int i = 0; i < times; i++) { // after we get the count of no. of times the value is there in the map
                sb.append(c); // we add the character c to the stringbuilder.
            }
        }
        return sb.toString(); //in the end, we return the string format of the string builder.
    }
}
//tc and sc - O(m+n) and O(1)