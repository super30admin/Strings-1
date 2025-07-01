// TC : (M+N)
// M : Size if String s
// N : Size of string Order

// SC : (M)
// M size for stringbuilder to build the string
// M size for the map to store the characters --> can be considered as O(1)

// Approach:
// Add the characters as a frequency array
// Then iterate over the order string and add characters according to the order in string builder.
add the remaining characters in any way.

class Solution {
    public String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            if(!map.containsKey(c))
                map.put(c,0);
            map.put(c, map.get(c) + 1);
        }

        for(char c : order.toCharArray()){
            if(!map.containsKey(c)) continue;
            int count = map.get(c);
            for(int i =0 ;i<count;++i)
                sb.append(c);
            map.remove(c);
        }

        for(char c : map.keySet()){
            int count = map.get(c);
            for(int i =0 ;i<count;++i)
                sb.append(c);
        }
        return sb.toString();
    }
}
