import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Main {
    //Line Coding Test Problem 4
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfNodes = Integer.valueOf(br.readLine().toString());
        Graph graph = new Graph(numberOfNodes);
        List<List<Integer>> adj = new ArrayList<>(numberOfNodes);

        for (int i = 0; i < numberOfNodes; i++)
            adj.add(new LinkedList<>());

        String[] edge;
        while (br.ready()) {
            edge = br.readLine().split(" ");
            graph.addEdge(Integer.valueOf(edge[0]), Integer.valueOf(edge[1]));
        }

        if (graph.isCyclic()) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    public static class Graph {

        private int N;
        private List<List<Integer>> adjacencyList;

        public Graph(int N) {
            this.N = N;
            this.adjacencyList = new ArrayList<>(N);
            for (int i = 0; i < N; i++) {
                this.adjacencyList.add(new LinkedList<>());
            }
        }

        private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {
            if (recStack[i]) {
                return true;
            }
            if (visited[i]) {
                return false;
            }
            visited[i] = true;
            recStack[i] = true;
            List<Integer> children = this.adjacencyList.get(i);
            for (Integer c : children) {
                if (isCyclicUtil(c, visited, recStack)) {
                    return true;
                }
            }
            recStack[i] = false;
            return false;
        }

        private void addEdge(int source, int dest) {
            this.adjacencyList.get(source).add(dest);
        }

        private boolean isCyclic() {
            boolean[] visited = new boolean[this.N];
            boolean[] recStack = new boolean[this.N];
            for (int i = 0; i < this.N; i++) {
                if (isCyclicUtil(i, visited, recStack)) {
                    return true;
                }
            }
            return false;
        }

    }

}
