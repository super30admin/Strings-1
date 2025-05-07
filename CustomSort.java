import java.util.HashMap;

//TC O(m+n)
//SC O(n)

/*
This solution custom-sorts string s based on the character order defined in order.
 First, it counts character frequencies in s using a hashmap. Then, it constructs
 the result by appending characters from order in sequence, repeating them according to their
  counts. After processing all ordered characters, any remaining characters from s (not in order)
   are appended to the result in their original frequency. The approach efficiently reorganizes s
    to match the priority of order while preserving unordered characters. This ensures the output
    follows the custom sorting rules precisely.


*
* */
class CustomSort {
    public String customSortString(String order, String s) {


        HashMap<Character,Integer> map=new HashMap<>();

        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        StringBuilder result=new StringBuilder();

        for(char c:order.toCharArray())
        {
            if(map.containsKey(c))
            {
                int cnt=map.get(c);
                for(int k=0;k<cnt;k++)
                {
                    result.append(c);
                }
                map.remove(c);
            }
        }

        for(char c:map.keySet())
        {
            int cnt=map.get(c);
            for(int k=0;k<cnt;k++)
            {
                result.append(c);
            }
        }

        return result.toString();
    }
}