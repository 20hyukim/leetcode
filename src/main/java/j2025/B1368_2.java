package j2025;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class B1368_2 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
        int n = Integer.parseInt(br.readLine());
        parent = new int[n+1];

        for (int i = 1; i < n+1; i++) {
            parent[i] = i;
            edges.offer(new Edge(0, i, Integer.parseInt(br.readLine())));
        }

        for (int i = 1; i < n+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j < n+1; j++) {
                if (i == j) {
                    st.nextToken();
                    continue;
                }
                edges.offer(new Edge(i, j, Integer.parseInt(st.nextToken())));
            }
        }

        int cost = 0;
        while(!edges.isEmpty()) {
            Edge edge = edges.poll();

            if (find_p(edge.from) != find_p(edge.to)) {
                cost += edge.cost;
                union(edge.from, edge.to);
            }
        }

        System.out.println(cost);

    }

    public static void union(int from, int to) {
        int from_p = find_p(from);
        int to_p = find_p(to);
        parent[from_p] = to_p;
    }

    public static int find_p(int child) {
        if (child == parent[child]) {
            return child;
        }

        return parent[child] = find_p(parent[child]);
    }


    private static class Edge {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
}
