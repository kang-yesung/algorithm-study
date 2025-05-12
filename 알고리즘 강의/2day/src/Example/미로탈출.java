package Example;

import java.util.LinkedList;
import java.util.Queue;

public class 미로탈출 {
    static boolean[][] visited;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static int rowLength;
    static int colLength;
    public static void main(String[] args) {
        String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};

        rowLength = maps.length;
        colLength = maps[0].length();

        int sR = 0, lR = 0;
        int sC = 0, lC = 0;

        for(int i=0; i< rowLength; i++){
            for(int y = 0; y < colLength; y++){
                if(maps[i].charAt(y)=='S'){
                    sR = i;
                    sC = y;
                } else if(maps[i].charAt(y)=='L'){
                    lR = i;
                    lC = y;
                }
            }
        }

        int l = bfs(sR, sC, maps, 'L');
        if(l < 0 ){
            System.out.println(-1);
            return;
        }

        int e = bfs(lR, lC, maps, 'E');
        if(e < 0 ){
            System.out.println(-1);
            return;
        }
        System.out.println(l + e);
    }

    static int bfs(int sr, int sc, String[] maps, char target){
        visited = new boolean[rowLength][colLength];
        Queue<int[]> queue = new LinkedList<>();

        visited[sr][sc] = true;
        queue.offer(new int[] {sr, sc, 0});

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int time = current[2];

            if(maps[r].charAt(c)==target) return time;

            for(int i =0; i< 4; i++){
                int nextR = r + dr[i];
                int nextC = c + dc[i];

                if(isValid(nextR, nextC, maps)){
                    if(!visited[nextR][nextC]){
                        queue.offer(new int[]{nextR, nextC, time+1});
                        visited[nextR][nextC] = true;
                    }
                }
            }

        }
        return -1;
    }

    static boolean isValid(int r, int c,String[] maps){
        return r >=0 && r < rowLength && c>=0 && c<colLength && maps[r].charAt(c) !='X';
    }
}
