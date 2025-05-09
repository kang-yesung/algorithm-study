package Example;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static String[][] grid;
    static boolean[][] visited;
    static int rowLength;
    static int colLength;
    public static void main(String[] args) {
        grid = new String[][]{
                {"1", "1", "1", "1", "0"},
                {"1", "1", "0", "1", "0"},
                {"1", "1", "0", "0", "0"},
                {"0", "0", "0", "0", "0"}
        };

        rowLength = grid.length;
        colLength= grid[0].length;
        visited = new boolean[rowLength][colLength];
        int islandCount = 0;
        for(int i = 0; i<rowLength; i++){
            for(int y = 0; y <colLength; y++){
                if(!visited[i][y] & isvalid(i, y)){
                    bfs(0, 0);
                    islandCount++;
                }
            }
        }
        System.out.println(islandCount);
    }
    static void bfs(int startR, int startC){
        Queue<int[]> queue = new LinkedList<>();
        visited[startR][startC] = true;
        queue.offer(new int[]{startR, startC});

        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            for(int i = 0; i < dr.length; i++){
                int nextR = r - dr[i];
                int nextC = c - dc[i];

                if(isvalid(nextR, nextC)){
                    if(!visited[nextR][nextC]){
                        queue.offer(new int[]{nextR, nextC});
                        visited[nextR][nextC] = true;
                    }
                }
            }
        }
    }

    static boolean isvalid(int r, int c){
        return r>=0 && r<rowLength && c>=0 && c<colLength && grid[r][c].equals("1");
    }
}
