package Example;

import java.util.LinkedList;
import java.util.Queue;

public class 보물지도 {
    public static void main(String[] args) {
        int n = 5;
        int m = 4;

        int[][] hole = {
//                {2,3},
//                {3,3}
                {1,4},
                {2,1},
                {2,2},
                {2,3},
                {2,4},
                {3,3},
                {4,1},
                {4,3},
                {5,3}
        };

        int[][] grape = new int[n+1][m+1];

        for(int[] i : hole){
            int a =i[0];
            int b =i[1];
            grape[a][b]=1;
        }
        int answer = bfs(n,m, grape);

        System.out.println(answer);
    }

    static int bfs(int lastR, int lastC, int[][] grape) {
        //3차원 배열을 사용해서 2차원 배열을 두개인것처럼 사용
        boolean[][][] visited = new boolean[lastR+1][lastC+1][2];
        Queue<int[]> queue = new LinkedList<>();
        int[] dr1 = {0,1,0,-1};
        int[] dc1 = {1,0,-1,0};

        int[] dr2 = {0,2,0,-2};
        int[] dc2 = {2,0,-2,0};

        visited[1][1][0]= true;
        queue.offer(new int[]{1,1,0,0});

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];
            int jumped = cur[3];

            for(int i = 0; i<4; i++){
                int nr = r + dr1[i];
                int nc = c + dc1[i];
                if(isValid(nr, nc, lastR, lastC, grape)){
                    if(!visited[nr][nc][jumped]){
                        queue.offer(new int[] {nr, nc, dist+1, jumped});
                        visited[nr][nc][jumped] = true;
                    }
                }
            }
            // 따로 분리해서 점프안한것을 관리해야 가독성도 좋고 불필요한 연산을 줄일 수 있다.
            if(jumped==0){
                for(int i = 0; i< 4; i++){
                    int nr = r + dr2[i];
                    int nc = c + dc2[i];
                    if(isValid(nr, nc, lastR, lastC, grape)){
                        if(!visited[nr][nc][1]){
                            queue.offer(new int[]{nr, nc, dist+1, 1});
                            visited[nr][nc][1] = true;
                        }
                    }
                }
            }
        }

        return -1;
    }
    static boolean isValid(int r, int c, int lr, int lc, int[][] grape){
     return   r>=1 && r <= lr && c>=1 && c <= lc && grape[r][c] != 1;
    }
}