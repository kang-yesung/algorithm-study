package example;


public class WordSearch {
    public static void main(String[] args) {

        char[][] board = {{'A', 'B','C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";

        boolean check = false;

        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                if(board[r][c] == word.charAt(0)){
                    check = dfs(board, word, r, c, 0);
                }
                if(check) break;
            }
            if (check) break;
        }

        System.out.println(check);
    }

    static boolean dfs(char[][] board, String word, int r, int c, int idx){
        if(idx == word.length()) return true;

        if(r < 0 || c < 0 || r >= board.length || c >+ board[0].length || board[r][c] != word.charAt(idx)) return false;

        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};

        char temp = board[r][c];

        board[r][c] = '#'; // 방문처리

        for(int i = 0; i < 4; i++){
            if(dfs(board, word, r + dr[i], c + dc[i], idx+1)) return true;
        }

        board[r][c] = temp;

        return false;
    }
}
