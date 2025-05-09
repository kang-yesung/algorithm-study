package Example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    static boolean[][] visited;
    static int[] dr =  {0, 1,1,1,0,-1,-1,-1};
    static int[] dc =  {1, 1,0,-1,-1,-1,0,1};
    static int rowLength;
    static int colLength;
    public static void main(String[] args) {
        int[][] grid = {
                {0,0,0},
                {1,1,0},
                {1,1,0}
        };
        rowLength = grid.length;
        colLength = grid[0].length;
        visited = new boolean[rowLength][colLength];

        int count = bfs(grid, 0, 0);

        System.out.println(count);
    }

    static int bfs(int[][] grid, int sr, int sc){
        if(grid[sr][sc]==1) return -1;
        Queue<int[]> queue = new LinkedList<>();
        visited[sr][sc]= true;
        queue.offer(new int[]{sr, sc, 1});
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int t = current[2];
            for(int i =0; i<8; i++){
                int nextR = r + dr[i];
                int nextC = c + dc[i];
                if(isValid(nextR, nextC, grid)){
                    if(!visited[nextR][nextC]){
                        visited[nextR][nextC]= true;
                        queue.offer(new int[]{nextR, nextC, t+1});
                        if(nextR == rowLength-1 && nextC == colLength-1){
                            return t+1;
                        }
                    }
                }
            }
        }
        return -1;
    }
    static boolean isValid(int r, int c, int[][] grid){
        return r>=0 && r<rowLength && c >=0 && c<colLength && grid[r][c]==0;
    }

}
