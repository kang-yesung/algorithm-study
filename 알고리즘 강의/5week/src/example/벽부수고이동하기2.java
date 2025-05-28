package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String[]map = new String[N];
        for(int i = 0; i < N ; i++ ){
            map[i] = br.readLine();
        }

        int count = bfs(N, M, map, K);

        System.out.println(count);
    }

    static int bfs(int N, int M, String[] map, int K){
        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};

        boolean[][][] visited = new boolean[N][M][K+1];
        Queue<int[]> queue = new LinkedList<>();

        visited[0][0][0] = true;
        queue.offer(new int[]{0,0,1,0}); //세로, 가로, 거리, 벽부셨는지

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];
            int wall = cur[3];

            if (r == N-1 && c == M-1) return dist;

            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(isValid(nr, nc, N, M) && map[nr].charAt(nc) != '1'){
                    if(!visited[nr][nc][wall]){
                        queue.offer(new int[]{nr, nc, dist+1, wall});
                        visited[nr][nc][wall] = true;
                    }
                }
                else if (isValid(nr, nc, N, M) && map[nr].charAt(nc) == '1' && wall < K) {
                    if(!visited[nr][nc][wall+1]){
                        queue.offer(new int[]{nr, nc, dist + 1, wall+1});
                        visited[nr][nc][wall+1] = true;
                    }
                }
            }
        }


        return  -1;
    }

    static boolean isValid(int r, int c, int N, int M){
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
