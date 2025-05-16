package example;


import java.util.*;

public class 감염된폴더1 {
    public static void main(String[] args) {
        String[][] folders = {
                {"root", "apps"}, {"apps", "chrome"}, {"apps", "vscode"}
        };

        String p = "chrome";
        String q = "vscode";


        Map<String, List<String>> graph = new HashMap<>();
        for(int i = 0; i < folders.length; i++){
           String a = folders[i][0];

           graph.put(a, new LinkedList<>());
        }
        for(int i = 0; i < folders.length; i++){
            String a = folders[i][0];
            String b = folders[i][1];
            graph.get(a).add(b);
        }

        String str = dfs(graph, "root", p, q);
        System.out.println(str);
    }
    static String dfs(Map<String, List<String>> graph, String root, String p, String q) {
        if (p.equals(root) || q.equals(root)) return root;
        String found = null;

        for(String next : graph.getOrDefault(root, new ArrayList<>())){
            String result = dfs(graph, next, p, q);
            if(result==null) continue;

            if(found != null){
                return root;
            }
            found =  result;

        }

        return found;

    }
}

