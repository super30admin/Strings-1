import java.util.*;

public class CourseScheduleDFS { //O(v+e) T.C where v is vertices(prereq relations) and e is edges(courses)
    HashMap<Integer, List<Integer>> map; //O(v+e) S.C
    HashSet<Integer> path; //current path for backtracking, O(e) S.C
    HashSet<Integer> visited; //visited edges to eliminate repeated subproblems, O(e) S.C
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.map = new HashMap<>();
        this.path = new HashSet<>();
        this.visited = new HashSet<>();

        for(int[] pr : prerequisites) { //adjacency matrix
            int dependent = pr[0];
            int independent = pr[1];
            if(!map.containsKey(independent)) {
                map.put(independent, new ArrayList<>());
            }
            map.get(independent).add(dependent);
        }

        for(int i=0; i<numCourses; i++) {
            //if the edge is not visited yet and the edge has a cycle
            if(!visited.contains(i) && !hasNoCycle(i)) return false;
        }

        return true;
    }

    //returns true if no cycle is present and false if there is a cycle
    private boolean hasNoCycle(int parent) {
        //base
        //if the same edge has encountered again in the recursion, there is a cycle
        if(path.contains(parent)) return false;
        //if the edge has already been visited and no cycle found, skip this recursion call
        if(visited.contains(parent)) return true;

        //logic
        //action
        path.add(parent); //add the current parent edge to the recursion call

        //recurse
        List<Integer> children = map.get(parent); //get the dependent courses out of the parent course
        if(children != null) { //if the dependents are not null
            for(int child : children) { //iterate over each dependent course
                if(!hasNoCycle(child)) { //add it to the recursion
                    return false; //if cycle is found, return false immediately and terminate further recursion
                }
            }
        }

        //backtrack
        path.remove(parent); //remove the currently added edge from the path
        visited.add(parent); //if the cycle turns out to be false, add this edge to the visited so to skip further calls
        return true;
    }

    public static void main(String[] args) {
        int numCourses = 5;
        int[][] prereqs = {
                {1,5},
                {2,3},
                {0,1},
                {3,4},
                {3,5}
        };

        CourseScheduleDFS courseScheduleDFS = new CourseScheduleDFS();
        System.out.println("Can the student finish all courses with prereqs: " + Arrays.deepToString(prereqs) +
                " " + courseScheduleDFS.canFinish(numCourses, prereqs));
    }
}