import java.util.HashMap;
import java.util.Map;

/*
Custom Sort String
approach: iterate on s and make frequency map and then iterate on order and chars from map
time: O(n)
space: O(1)
 */
public class Problem1 {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        String res = "";
        int i=0;
        while(i<order.length()) {
            char ch = order.charAt(i);
            String t = "";
            while(map.containsKey(ch) && map.get(ch)>=1) {
                t +=ch;
                map.put(ch, map.get(ch)-1);
            }
            res+=t;
            i++;
        }

        for(Map.Entry<Character, Integer> e: map.entrySet()) {
            String t = "";
            while(e.getValue()>=1) {
                t+=e.getKey();
                map.put(e.getKey(), e.getValue()-1);
            }
            res+=t;
        }

        return res;
    }

    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        problem1.customSortString("cba", "abcd");
    }
}
