// TC = O(n)
// SC = O(n)
// Here we are using Map to store the count of char.

class CustomSort{
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            hmap.put(c, hmap.getOrDefault(c, 0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<order.length(); i++){
            char ch = order.charAt(i);
            if(hmap.containsKey(ch)){
                int cnt = hmap.get(ch); // here we are taking the count.
                for(int k = 0; k<cnt; k++){
                    sb.append(ch); //adding to string.
                }
            }
            hmap.remove(ch); // remove from map.
        }

        for(Character c: hmap.keySet()){ // adding remaining char in string.
            int cnt = hmap.get(c);
            for(int k = 0; k<cnt; k++){
                sb.append(c);
            }
        }
        return sb.toString();

    }
}