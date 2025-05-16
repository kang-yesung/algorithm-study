package Example;


public class 네트워크DFS {
    public static  void dfs(int curVertex , boolean[] visited, int[][] computers){
        visited[curVertex] = true;
        for (int nextVerTex = 0; nextVerTex< computers.length; nextVerTex++){
            if(computers[curVertex][nextVerTex]==1 && !visited[nextVerTex]){
                dfs(nextVerTex, visited, computers);
            }
        }
    } 

    public static void main(String[] args) {
        int answer = 0;
        int[][] computers = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };
        int n = 3;
        boolean[] visited = new boolean[n];
        for(int i=0; i< n; i++){
            if (!visited[i]) {
                dfs(i,visited, computers);
                answer++;
            }
        }

        System.out.println(answer);
    }

}
