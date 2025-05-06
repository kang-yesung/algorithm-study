package Example;

import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(solution(begin, target, words));
    }

    public static int solution(String begin, String target, String[] words){
        Queue<WordData> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        queue.offer(new WordData(begin, 0));

        while(!queue.isEmpty()){
           WordData wor = queue.poll();
           if(wor.word.equals(target)) return wor.count;

           for(int i=0; i< words.length; i++){
               if(!visited[i] && equals(wor.word, words[i])==1){
                   queue.offer(new WordData(words[i], wor.count+1));
                   visited[i]=true;
               }
           }
        }
        return 0;
    }
    public static int equals(String word, String target){
        int count=0;
        for(int i = 0; i<word.length(); i++) {
            if(word.charAt(i)!=target.charAt(i))count++;
        }
        return count;
    }
}
    class WordData{
    String word;
    int count;

        public WordData(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
