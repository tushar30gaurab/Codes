import java.util.*;
public class DelPalindrome {

    static int solve(StringBuilder sb1, StringBuilder sb2, int n,int m)
    {
        int t[][] = new int[n+1][m+1];

        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<m+1;j++)
            {
                if(i==0 || j==0)
                    t[i][j] = 0;

                else if(sb1.charAt(i-1)==sb2.charAt(j-1))
                    t[i][j] = 1+t[i-1][j-1];
                else
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
            }
        }

        return (sb1.length()-t[n][m]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter a String:");
        String s = sc.nextLine();

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        sb1.append(s);
        sb2.append(s);
        sb2.reverse(); // reversed string

        sc.close();
        System.out.println("\n Minimum number of deletion in a string to make it a palindrome : "+solve(sb1,sb2,sb1.length(),sb2.length()));
    }
}
