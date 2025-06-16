package example;

import java.util.LinkedList;
import java.util.Queue;

public class WordSearch {
    public static void main(String[] args) {
        String[][] board = {{"A", "B", "C", "E"},
                {"S", "F", "C", "S"},
                {"A", "D", "E", "E"}};

        String word = "ABCCED";
        boolean check = false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j].equals(String.valueOf(word.charAt(0)))){
                    check = checkWord(board, word, i, j);
                }
            }
            if(check)break;
        }
        System.out.println(check);
    }

    static boolean checkWord(String[][] board, String word, int r, int c){
        boolean[][] visited = new boolean[board.length][board[0].length];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        Queue<int[]> queue = new LinkedList<>();
        visited[r][c] = true;
        queue.offer(new int[]{r, c, 1});

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int R = cur[0];
            int C = cur[1];
            int idx = cur[2];

            if(idx == word.length()) return true;

            for (int i = 0; i < 4; i++) {
                int nr = R + dr[i];
                int nc = C + dc[i];

                if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length) {
                    if (board[nr][nc].equals(String.valueOf(word.charAt(idx)))) {
                        if(!visited[nr][nc]) {
                            queue.offer(new int[]{nr, nc, idx + 1});
                            visited[nr][nc] = true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
