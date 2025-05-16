package Example;

import java.util.LinkedList;
import java.util.Queue;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        int a = coinChange(coins, amount);
        System.out.println(a);


    }

    public static int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;

        boolean[] visited = new boolean[amount+1];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{amount, 0});
        visited[amount] = true;

        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int remaining = current[0];
            int numCoin = current[1];

            if(remaining==0)return numCoin;

            for(int coin : coins){
                int next = remaining-coin;
                if(next>=0 && !visited[next]){
                    queue.offer(new int[]{next, numCoin+1});
                    visited[next] = true;
                }
            }
        }
        return -1;
    }
}
