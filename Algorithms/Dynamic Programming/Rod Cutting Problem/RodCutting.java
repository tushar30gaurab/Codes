import java.util.*;
public class RodCutting{

    static int solveRodCutting(int Length[], int price[], int n, int size, int t[][])
    {
        if(n==0 || size==0)
        return 0;

        if(Length[n-1]<=size)
            return t[n][size] = Math.max(price[n-1]+solveRodCutting(Length, price, n, size-Length[n-1], t), solveRodCutting(Length, price, n-1, size, t));
        else if(Length[n-1]>size)
            return t[n][size] = solveRodCutting(Length, price, n-1, size, t);

        return t[n][size];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of lengths of rod in an array:");
        int n = sc.nextInt();
        int l[] = new int [n];
        int price[] = new int[n];
        for(int i=0;i<n;i++){
        System.out.println("Enter length of rod piece "+(i+1));
        l[i] = sc.nextInt();
        System.out.println("Enter price of rod piece "+(i+1));
        price[i] = sc.nextInt();
        }
        System.out.println("Enter Length of Rod:");
        int size = sc.nextInt();
        int t[][] = new int[n+1][size+1];
        System.out.println("Maximum profit achieved: "+ solveRodCutting(l,price,n,size,t));
        sc.close();
    }
}