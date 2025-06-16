package example;

public class 태어난김에세계일주1 {
    public static void main(String[] args) {
        int balance = 600;
        int[][] countries = {{70, 350}, {100, 550}, {350, 400}};
        boolean[] visited = new boolean[countries.length];

        int count = dfs(countries, visited, balance);

        System.out.println(count);
    }

    public static int dfs(int[][] countries, boolean[] visited, int balance){
        if(balance < 0) return -1;
        int max = 0;

        for(int i = 0; i < countries.length; i++){
            if(balance >= countries[i][1]){
                if(!visited[i]){
                    visited[i] = true;
                    max = Math.max(max, dfs(countries, visited, balance-countries[i][0])+1);
                    visited[i] = false;
                }
            }
        }

        return max;
    }
}
