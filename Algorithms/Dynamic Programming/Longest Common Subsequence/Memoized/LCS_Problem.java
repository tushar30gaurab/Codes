import java.util.*;
    public class LCS_Problem {

    static int solveLCS(char c1[], char c2[], int n, int m, int t[][])
    {
        if(n==0 || m==0)
            return t[n][m] = 0;
        if(c1[n-1]==c2[m-1])
            return t[n][m] = (1+solveLCS(c1, c2, n-1, m-1,t));
        else if(c1[n-1]!=c2[m-1])
            return t[n][m] = Math.max(solveLCS(c1, c2, n-1, m,t), solveLCS(c1, c2, n, m-1,t));

        return t[n][m];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a String: ");
        String s = sc.nextLine();
        System.out.print("Enter another String: ");
        String ss = sc.nextLine();
        char c1[] = s.toCharArray();
        char c2[] = ss.toCharArray();
        int t[][] = new int[c1.length+1][c2.length+1];
        System.out.println("\nLCS Solution( Memoized ): "+ solveLCS(c1,c2,c1.length,c2.length,t));
        sc.close();
    }
}

