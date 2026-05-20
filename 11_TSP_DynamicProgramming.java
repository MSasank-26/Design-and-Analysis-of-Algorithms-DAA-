
// Program 11: Traveling Sales Person Problem using Dynamic Programming

public class TSPDynamicProgramming {

    static final int N = 4;

    static int tsp(int graph[][], boolean visited[],
                   int currentPos, int n, int count,
                   int cost, int ans) {

        if (count == n &&
            graph[currentPos][0] > 0) {

            ans = Math.min(ans,
                    cost + graph[currentPos][0]);

            return ans;
        }

        for (int i = 0; i < n; i++) {

            if (!visited[i] &&
                graph[currentPos][i] > 0) {

                visited[i] = true;

                ans = tsp(
                        graph,
                        visited,
                        i,
                        n,
                        count + 1,
                        cost + graph[currentPos][i],
                        ans
                );

                visited[i] = false;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[][] graph = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };

        boolean[] visited = new boolean[N];

        visited[0] = true;

        int ans = Integer.MAX_VALUE;

        ans = tsp(graph, visited, 0,
                N, 1, 0, ans);

        System.out.println(
                "Minimum Cost = " + ans
        );
    }
}
