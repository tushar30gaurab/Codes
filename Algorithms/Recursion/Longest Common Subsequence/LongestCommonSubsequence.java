import java.util.*;
public class LongestCommonSubsequence{

    static int solveLCS(char c1[], char c2[], int n, int m)
    {
        if(n==0 || m==0)
            return 0;
        if(c1[n-1]==c2[m-1])
            return (1+solveLCS(c1, c2, n-1, m-1));
        
        return Math.max(solveLCS(c1, c2, n-1, m), solveLCS(c1, c2, n, m-1));

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\nEnter a String:\n");
        String s = sc.nextLine();
        System.out.println("\nEnter another String:\n");
        String ss = sc.nextLine();
        char c1[] = s.toCharArray();
        char c2[] = ss.toCharArray();
        System.out.println("\n\nLCS Solution: "+ solveLCS(c1,c2,c1.length,c2.length));
    }
}