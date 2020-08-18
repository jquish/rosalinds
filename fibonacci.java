public class fibonacci {

    public static void main (String[] args) {
        int n = 20;
        int f = fibonacci(n);
        
        System.out.printf("%d\n", f);
    }
    
    public static int fibonacci(int n) {
        
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}