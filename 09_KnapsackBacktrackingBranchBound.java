
// Program 9: 0/1 Knapsack using Backtracking and Branch & Bound

public class KnapsackBacktrackingBranchBound {

    static int maxProfit = 0;

    static void knapsack(
            int weights[],
            int profits[],
            int capacity,
            int index,
            int currentWeight,
            int currentProfit
    ) {

        if (currentWeight <= capacity &&
            currentProfit > maxProfit) {

            maxProfit = currentProfit;
        }

        if (index >= weights.length)
            return;

        knapsack(
                weights,
                profits,
                capacity,
                index + 1,
                currentWeight + weights[index],
                currentProfit + profits[index]
        );

        knapsack(
                weights,
                profits,
                capacity,
                index + 1,
                currentWeight,
                currentProfit
        );
    }

    public static void main(String[] args) {

        int weights[] = {2, 3, 4, 5};
        int profits[] = {3, 4, 5, 6};

        int capacity = 5;

        knapsack(
                weights,
                profits,
                capacity,
                0,
                0,
                0
        );

        System.out.println(
                "Maximum Profit = " + maxProfit
        );
    }
}
