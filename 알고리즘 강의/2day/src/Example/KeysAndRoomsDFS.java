package Example;

public class KeysAndRoomsDFS {
    public static void main(String[] args) {
        int[][] rooms = {
                {1, 3},
                {3, 0, 1},
                {2},
                {0}
        };
        boolean[] visited = new boolean[rooms.length];
        int count = 0;

        for (int i=0; i< rooms.length; i++){
            if(!visited[i]){
                dfs(i, visited, rooms);
                count++;
            }
        }
        if(count>1){
            System.out.println(false);
        } else {
            System.out.println(true);
        }
    }
    public static void dfs(int curVertex, boolean[] visited, int[][] rooms ){
        visited[curVertex] = true;

        for (int next : rooms[curVertex]){
            if (!visited[next]) {
                dfs(next, visited, rooms);
            }
        }
    }
}
