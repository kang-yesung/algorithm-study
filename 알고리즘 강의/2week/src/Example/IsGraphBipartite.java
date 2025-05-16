package Example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {
    public static void main(String[] args) {
        int[][] graph = {
                {1,2,3},
                {0,2},
                {0,1,3},
                {0,2}
        };

        System.out.println(isBipartite(graph));

    }

    public static boolean isBipartite(int[][] graph){
        int[] color = new int[graph.length]; //각 노드의 색 0 or 1
        Arrays.fill(color, -1); //노드 초기 상태 -1로 설정

        //그래프의 모든 정점 확인
        for (int i=0; i<graph.length; i++){
            if(color[i]==-1){ //아직 색이 없으면 시작
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                color[i]=0; //첫 노드의 색을 0으로 지정
                while(!queue.isEmpty()){ // BFS탐색
                    int cur = queue.poll(); // 현재 노드 꺼냄
                    for(int next : graph[cur]){ //현재 노드의 이웃 확인
                        if(color[next]==-1){ //색이 없으면
                            color[next] = 1 - color[cur]; // 반대 색으로 칠 (0 → 1, 1 → 0)
                            queue.offer(next); //다음 탐색 노드에 추가
                        } else if(color[next]==color[cur]){
                            //이미 칠해져있는데 인접 노드와 같은 색이라면 이분 그래프 아님
                            return false;
                        }
                    }
                }
            }
        }
        return true; // 모든 조건을 만족하면 이분그래프
    }
}
