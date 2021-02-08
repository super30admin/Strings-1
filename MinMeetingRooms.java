// Time Complexity : The time complexity is O(nlogn) where n is the number of intervals.
// Space Complexity : The space complexity is O(n) where n is the number of intervals
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int minMeetingRooms(int[][] intervals) {

        if(intervals == null || intervals[0].length == 0){
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Sort the intervals according to its start time
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        int count = 1;
        pq.offer(intervals[0][1]);

        for(int i=1;i<intervals.length;i++){

            // The meetings have intersection if current start is less than previous end time
            if(intervals[i][0] < pq.peek()){
                count++;
            }
            else{
                pq.poll();
            }
            pq.offer(intervals[i][1]);
        }

        return count;

    }
}