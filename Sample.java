//Problem 1
// TC O(n*t)
//SC O(n)
class Solution {
    public String customSortString(String order, String s) {
        if(s==null || s.length()==0) return s;
        HashMap<Character,Integer> map=new HashMap();
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(int i=0;i<order.length();i++)
        {
            char c=order.charAt(i);
            if(map.containsKey(c))
            {
                int times=map.get(c);
                for(int j=0;j<times;j++)
                {
                    sb.append(c);
                }
                map.remove(c);
            }
        }
        for(char key: map.keySet())
        {
            int times=map.get(key);
            for(int j=0;j<times;j++)
            {
                sb.append(key);
            }
        }
        return sb.toString();
    }
}

//Problem 2
// TC O(n)
//SC O(n)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0) return 0;
        HashMap<Character,Integer> map=new HashMap<>();
        int start=0;
        int max=0;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(map.containsKey(c))
            {
                start=Math.max(start,map.get(c));//to remove the dublecate and start from the latest 
                // and to move forward the start and we already calculated for previous
            }
            max=Math.max(max, i-start+1);// +1 as the start is starting from 0
            map.put(c,i+1);// again updating the map and adding the latest index
            // i +1 because we are taking the start from index 1 not 0
        }
        return max;
    }
}