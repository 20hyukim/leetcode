package j2025;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

// 백준 16398번 : 행성 연결
public class B16398_s {
    static int[] parents = new int[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparing(e -> e.value));

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i < n+1; i++) {
            parents[i] = i;
            String[] line = br.readLine().split(" ");
            for (int j = 1; j < n+1; j++) {
                if (i < j) queue.add(new Edge(i, j, Integer.parseInt(line[j-1])));
            }
        }

        long cnt = 0;
        while(!queue.isEmpty()) {
            Edge e = queue.poll();

            if (getParent(e.from) != getParent(e.to)) {
                cnt += e.value;
                unify(e.from, e.to);
            }
        }

        System.out.println(cnt);
    }

    // getParent를 하고, parent에서 unify를 진행.
    public static void unify(int from, int to) {
        int pFrom = getParent(from);
        int pTo = getParent(to);
        parents[pFrom] = pTo;
    }


    public static int getParent(int p) {
        if (p == parents[p]) {
            return p;
        }
        return parents[p] = getParent(parents[p]);
    }

    static class Edge {
        private Integer from;
        private Integer to;
        private Integer value;

        public Edge(Integer from, Integer to, Integer value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }
    }

}
