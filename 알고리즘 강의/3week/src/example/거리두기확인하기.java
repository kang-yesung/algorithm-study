package Example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 거리두기확인하기 {
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};

    public static void main(String[] args) {

        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };


        int[] arr = new int[places.length];

        for(int i = 0; i<places.length; i++){
            if(check(places[i])) arr[i]=1;
        }

        System.out.println(Arrays.toString(arr));
    }

    static boolean check(String[] places){
        for(int r = 0; r < 5; r++){
            for(int c = 0; c< 5; c++){
                if(places[r].charAt(c)=='P'){
                    if(!bfs(r, c, places)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    static boolean bfs(int sr, int sc, String[] places){
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{sr, sc, 0});
        visited[sr][sc] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int dis = cur[2];

            if(dis>=2)continue;

            for(int i = 0; i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(isValid(nr, nc, places)){
                    if(!visited[nr][nc]){
                        if(places[nr].charAt(nc)=='P') return false;
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc, dis+1});
                    }
                }
            }
        }
        return true;
    }


    static boolean isValid(int r, int c, String[] places){
        return r>=0 && r < 5 && c>=0 && c<5 && places[r].charAt(c)!='X';
    }
}
