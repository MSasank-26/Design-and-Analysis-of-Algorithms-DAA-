
// Program 13: TSP using Branch and Bound

public class TSPBranchAndBound {

    static final int N = 4;

    static int finalResult = Integer.MAX_VALUE;

    static void tsp(int[][] graph,
                    boolean[] visited,
                    int currentPos,
                    int count,
                    int cost) {

        if (count == N &&
            graph[currentPos][0] > 0) {

            finalResult = Math.min(
                    finalResult,
                    cost + graph[currentPos][0]
            );

            return;
        }

        for (int i = 0; i < N; i++) {

            if (!visited[i] &&
                graph[currentPos][i] > 0) {

                visited[i] = true;

                tsp(
                        graph,
                        visited,
                        i,
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

        boolean[] visited = new boolean[N];

        visited[0] = true;

        tsp(graph, visited, 0, 1, 0);

        System.out.println(
                "Minimum Cost = " + finalResult
        );
    }
}
