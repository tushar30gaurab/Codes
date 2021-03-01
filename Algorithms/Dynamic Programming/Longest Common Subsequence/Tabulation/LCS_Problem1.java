import java.util.*;
public class LCS_Problem1 {

    static int solveLCS(char c1[], char c2[], int n, int m, int t[][])
    {
        for(int i=0;i<n+1;i++)
            t[i][0] = 0;
        for(int i=0;i<m+1;i++)
            t[0][i] = 0;
        
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<m+1;j++)
            {
                if(c1[i-1]==c2[j-1])
                    t[i][j] = 1+t[i-1][j-1];
                if(c1[i-1]!=c2[j-1])
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
            }
        }

        return t[n][m];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            System.out.println("\nEnter a string: ");
            String s = sc.nextLine();
            System.out.println("Enter another string:");
            String ss = sc.nextLine();

            char c1[] = s.toCharArray();
            char c2[] = ss.toCharArray();
            int t[][] = new int[c1.length+1][c2.length+1];
            System.out.println("\nLCS Solution (Tabulation): "+solveLCS(c1,c2,c1.length,c2.length,t));
            sc.close();

    }
}
