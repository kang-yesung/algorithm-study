package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 연구소 {
    static int N;
    static int M;
    static List<int[]> empty;
    static List<int[]> vires;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        empty = new ArrayList<>();
        vires = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line[j]);
                if(map[i][j]==0) empty.add(new int[]{i, j});
                if(map[i][j]==2) vires.add(new int[]{i, j});
            }
        }


        int count = dfs( 0);
        System.out.println(count);
    }

    static int dfs(int count){
        if(count == 3){
            int[][] copy = copyList();
            return check(copy);
        }

        int maxVires = 0;


        for(int i = 0; i < empty.size(); i++){
            int[] cur = empty.get(i);
            if(map[cur[0]][cur[1]]==0) {
                map[cur[0]][cur[1]] = 1;
                maxVires = Math.max(maxVires, dfs(count + 1));
                map[cur[0]][cur[1]] = 0;
            }
        }

        return maxVires;
    }

    static int[][] copyList(){
        int[][] copy = new int[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                copy[i][j] = map[i][j];
            }
        }
        return copy;
    }

    static int check(int[][] copy){

        for(int i = 0; i < vires.size(); i++){
            int[] cur = vires.get(i);
            bfs(copy, cur[0], cur[1]);
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copy[i][j] == 0) count++;
            }
        }

        return count;
    }

    static void bfs(int[][] copy, int i, int j){
        Queue<int[]> queue = new LinkedList<>();

        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};

        queue.offer(new int[]{i, j});

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            for(int z = 0; z < 4; z++){
                int nr = r + dr[z];
                int nc = c + dc[z];

                if(nr >= 0 && nc>=0 && nr < N && nc < M && copy[nr][nc]==0){
                        queue.offer(new int[]{nr, nc});
                        copy[nr][nc] = 2;

                }
            }
        }
    }
}