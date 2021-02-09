import java.util.*;
public class KnightProblem {
    static int n;

    static void printPuzzle(int puzzle[][])
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(" "+puzzle[i][j]+" ");
            }
            System.out.println();
        }
    }

    static boolean isSafe(int puzzle[][], int p, int q)
    {


        return (p >= 0 && p < n && q >= 0 && q < n && puzzle[p][q] == -1);
    }

    static boolean solveKT(int puzzle[][])
    {

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                puzzle[i][j] = -1;
            }
        }

        puzzle[0][0]=0;
        // int xMove[] = {1,1,-1,-1,2,2,-2,-2};
        // int yMove[] = {2,-2,2,-2,1,-1,1,-1};
        int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
        if(solveKTUtil(puzzle, 0, 0, 1, xMove, yMove)){
            printPuzzle(puzzle);
            return true;
        }
        else{
            System.out.println("Solution dosen't exist!");
            return false;
        }
    }

    static boolean solveKTUtil(int puzzle[][],int x, int y, int movei, int xMove[], int yMove[])
    {
        int i,xnext,ynext;

        if(movei==n*n)
            return true;

        for(i=0;i<n;i++)
        {
            xnext = x+xMove[i];
            ynext = y+yMove[i];

            if(isSafe(puzzle, xnext, ynext))
            {
                puzzle[xnext][ynext] = movei;
                if(solveKTUtil(puzzle, xnext, ynext, movei+1, xMove, yMove))
                    return true;
                
                    else{
                        puzzle[xnext][ynext]=-1;  
                    }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of chess matrix of order n*n");
        n = sc.nextInt();
        int puzzle[][] = new int[n][n];
        sc.close();
        solveKT(puzzle);
    }
}
