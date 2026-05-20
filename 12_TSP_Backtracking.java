
// Program 12: TSP using Backtracking

public class TSPBacktracking {

    static int minCost = Integer.MAX_VALUE;

    static void tsp(int graph[][],
                    boolean visited[],
                    int currentPos,
                    int n,
                    int count,
                    int cost) {

        if (count == n &&
            graph[currentPos][0] > 0) {

            minCost = Math.min(
                    minCost,
                    cost + graph[currentPos][0]
            );

            return;
        }

        for (int i = 0; i < n; i++) {

            if (!visited[i] &&
                graph[currentPos][i] > 0) {

                visited[i] = true;

                tsp(
                        graph,
                        visited,
                        i,
                        n,
                        count + 1,
                        cost + graph[currentPos][i]
                );

                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {

        int[][] graph = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };

        boolean[] visited = new boolean[4];

        visited[0] = true;

        tsp(graph, visited, 0,
                4, 1, 0);

        System.out.println(
                "Minimum Cost = " + minCost
        );
    }
}
