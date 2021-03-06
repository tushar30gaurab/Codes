import java.util.*;
public class ShortestSuperSequence {

    static int solve(String s1, String s2, int n, int m)
    {
        int table[][] = new int[n+1][m+1];
        for(int i=0;i<n+1;i++)
            table[i][0] = 0;
        for(int i=0;i<m+1;i++)
            table[0][i] = 0;

        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<m+1;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    table[i][j] = 1+table[i-1][j-1];
                else
                    table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
            }
        }

        return (n+m)-table[n][m];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String 1:");
        String s1 = sc.nextLine();
        System.out.println("Enter String 2:");
        String s2 = sc.nextLine();

        System.out.println("Shortest Common Supersequence: "+solve(s1,s2,s1.length(),s2.length()));
    }
}
