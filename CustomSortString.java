/**
 * A HasMap to keep track of Source.
 * Follow Order and form a string depending on frequency.
 * At the end fill any pending Source left which is not present in Order.
 * 
 * Concurent HashMap Modication
 * At the end of the program we are adding the string present in String which is not present in Order.
 * We cannot delete it similar to loop followed on string formation.
 * We can just remove myMap.remove(c, 0) at the end
 * 
 * Time Complexity: O(m+n) m = Source String, n = Order String
 * Space Complexity: We are using temporary storage StringBuilder to build String on lenght s.length()
 * So, O(s.length)
 */

class CustomSortString {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> myMap = new HashMap<>();
        for(Character c: s.toCharArray()){
           myMap.put(c, myMap.getOrDefault(c, 0)+1);
        }

        StringBuilder sb = new StringBuilder();
        for(Character c: order.toCharArray()){
            if(myMap.containsKey(c)){
            int count = myMap.get(c);
            for(int i=1; i<=count; i++){
                    sb.append(c);
                    myMap.put(c, myMap.get(c)-1);
                }
                myMap.remove(c, 0);
            }
        }

        for(Character c: myMap.keySet()){
            int count = myMap.get(c);
            for(int i=1; i<=count; i++){
                sb.append(c);
                myMap.put(c, myMap.get(c)-1);
            }
            //myMap.remove(c, 0);
        }
    return sb.toString();
    }
}