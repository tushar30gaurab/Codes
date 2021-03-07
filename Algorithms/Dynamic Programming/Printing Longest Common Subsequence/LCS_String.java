import java.util.*;
public class LCS_String
{
    static void solve(char c1[], char c2[], int n, int m)
    {
       
        int t[][] = new int[n+1][m+1];
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

                    else
                        t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }

            int i=n,j=m;
            int index=t[n][m];
            int temp = index;
            char[] lcs = new char[index+1];
            lcs[index] = '\u0000';

            while(i>0 && j>0)
            {
                if(c1[i-1]==c2[j-1])
                {
                    lcs[index-1] = c1[i-1];
                    i--;
                    j--;
                    index--;
                }

                else{
                    if(t[i][j-1]<t[i-1][j])
                        i--;
                    else
                        j--;
                }
            }


        System.out.print("LCS of X and Y is: ");
        for(int k=0;k<=temp;k++) 
            System.out.print(lcs[k]);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter 1st string:");
        String s1 = sc.nextLine();
        System.out.println("Enter 2nd String:");
        String s2 = sc.nextLine();

        char c1[] = s1.toCharArray();
        char c2[] = s2.toCharArray();
        
        solve(c1,c2,c1.length,c2.length);
        sc.close();
    }
}