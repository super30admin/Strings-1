class Solution {
    public String customSortString(String S, String T) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<S.length(); i++){
            hm.put(S.charAt(i), i);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>(){
            public int compare(Character a, Character b){
                    return hm.getOrDefault(a,27) - hm.getOrDefault(b, 27);
            }
        });
        for(int i=0; i<T.length(); i++){
            pq.add(T.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while(pq.size()>0){
            sb.append(pq.poll());
        }
        return sb.toString();
    }
}

//Time complexity : O(tlogt) where t is the length of string T
//Space complexity : O(t) where t is extra space needed for priorityQueue
