
// Time - O(Order.length + Str.length)

// Space - O(Str.length)


class Solution {
    public String customSortString(String order, String str) {

        StringBuilder result = new StringBuilder(); // initialize result

        if(str == null) return result.toString();

        HashMap<Character,Integer> map = new HashMap<>(); // hashmap with character count

        for(int i = 0; i < str.length(); i++) {  // add characters with their count in hashmap

            char c = str.charAt(i);

            map.put(c,map.getOrDefault(c,0) + 1);

        }

        for(int i = 0; i < order.length(); i++) {   // go through the original list find each character and append it to main result string

            char c =  order.charAt(i);

            if(map.containsKey(c)) {

                int cnt = map.get(c);

                while(cnt > 0) {

                    result.append(c);
                    cnt--;

                }

                map.remove(c); // remove the character from the map after appending it to string

            }


        }
        for(char key: map.keySet()) { // add remaining values from the map to the result string

            int cnt = map.get(key);

            while(cnt > 0) {

                result.append(key);
                cnt--;

            }


        }

        return result.toString();

    }

}