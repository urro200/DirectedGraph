package main;

import java.util.*;

public class DirectedGraph {
    private HashMap<Integer, ArrayList<Integer>> adjacencyList = new HashMap<>();


    public DirectedGraph(){}
    public void addEdge(int SynsetID1, int SynsetID2) {
        if( adjacencyList.containsKey(SynsetID1) && adjacencyList.containsKey(SynsetID2)) {
            adjacencyList.get(SynsetID1).add(SynsetID2);
        }
    }
    public void addVertex(int id){
        if (!adjacencyList.containsKey(id)) {
            adjacencyList.put(id, new ArrayList<>());
        }
    }

    public HashSet<Integer> DFS (int SynsetID) {
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();

        stack.push(SynsetID);

        while (!stack.isEmpty()) {
            int current = stack.pop();

            if (!visited.contains(current)) {

                visited.add(current);
                List<Integer> children = adjacencyList.get(current);

                if (children != null) {
                    for (int child : children) {
                        if (!visited.contains(child)) {
                            stack.push(child);
                        }
                    }
                }
            }
        }
        return visited;
    }
}

