package Example;

public class fibo {
    public static void main(String[] args) {
        int result = fibo(7);
        System.out.println(result);
    }
    public static  int fibo(int n){
        if((n==1) || (n ==2)){
            return 1;
        }
        return fibo(n -1 ) + fibo(n-2);
    }
}
