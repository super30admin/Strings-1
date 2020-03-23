// Time Complexity : nlogn
// Space Complexity :logn
// Did this code successfully run on Leetcode :yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
class Solution {
    public String customSortString(String S, String T) {
    if(S==null || S.length()==0 || T==null || T.length()==0){
        String s =" ";
        return s;
    }   
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<S.length();i++){
            map.put(S.charAt(i),i);
        }
       String s = "";
        Comparator<Pair> customComparator = new Comparator<>(){
        public int compare(Pair a, Pair b){
            return a.val-b.val;
        }            
        };
        PriorityQueue<Pair> minHeap = new PriorityQueue(customComparator);
        for(int i=0;i<T.length();i++){
            if(!map.containsKey(T.charAt(i))){
                Pair p = new Pair(T.charAt(i),0);
                minHeap.add(p);
            }
            else{
                minHeap.add(new Pair(T.charAt(i),map.get(T.charAt(i))));
            }
        }
        while(!minHeap.isEmpty()){
            // sb.append(minHeap.poll().c)
                s=s+minHeap.poll().c;
        }
        return s;
    }
}
class Pair{
    char c;
    int val;
    Pair(char c, int val){
        this.c=c;
        this.val=val;
    }
}