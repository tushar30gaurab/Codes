import java.util.*;
public class LongestCommonSubstring
{
    static int solveLCSubstring(char c1[], char c2[], int n, int m)
    {
        int result=0;
        int t[][] = new int[n+1][m+1];
        for(int i=0;i<n+1;i++)
        {
            t[i][0] = 0;
        }
        for(int j=0;j<m+1;j++)
        {
            t[0][j] = 0;
        }
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<m+1;j++)
            {
                if(c1[i-1]==c2[j-1]){
                    t[i][j] = 1+t[i-1][j-1];
                    result = Math.max(t[i][j],result);
                }
                else
                    t[i][j] = 0;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter 1st string:");
        String s1 = sc.nextLine();
        System.out.println("Enter 2nd string:");
        String s2 = sc.nextLine();

        char c1[] = s1.toCharArray();
        char c2[] = s2.toCharArray();
        System.out.println("Solution of Longest Common Substring is: "+solveLCSubstring(c1,c2,c1.length,c2.length));
        sc.close();
    }
}