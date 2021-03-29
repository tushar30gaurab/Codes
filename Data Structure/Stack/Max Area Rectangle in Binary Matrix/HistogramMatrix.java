import java.util.*;
public class HistogramMatrix {


    static Stack<Integer> st = new Stack<Integer>();
    static ArrayList<Integer> leftBound = new ArrayList<Integer>();
    static ArrayList<Integer> rightBound = new ArrayList<Integer>();
    static ArrayList<Integer> rightBound1 = new ArrayList<Integer>();

    static int solveHistogram(int arr[], int n)
    {
        //solve leftBound

        for(int i=0;i<n;i++)
        {
            if(st.isEmpty())
                leftBound.add(i,-1);
            else if(!st.isEmpty() && arr[st.peek()]<arr[i])
                leftBound.add(st.peek());
            else if(!st.isEmpty() && arr[st.peek()]>=arr[i])
            {
                while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                {
                    st.pop();
                }
                if(st.isEmpty())
                    leftBound.add(i,-1);
                else
                    leftBound.add(st.peek());
            }

            st.push(i);
        }
        st.clear();


        //solve rightBound

        for(int i=n-1;i>=0;i--)
        {
            if(st.isEmpty())
                rightBound.add(n);
            else if(!st.isEmpty() && arr[st.peek()]<arr[i])
                rightBound.add(st.peek());
            else if(!st.isEmpty() && arr[st.peek()]>=arr[i])
            {
                while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                {
                    st.pop();
                }
                if(st.isEmpty())
                rightBound.add(n);
                else
                rightBound.add(st.peek());
            }

            st.push(i);
        }
        st.clear();

        for(int i=rightBound.size()-1;i>=0;i--)
        {
            rightBound1.add(rightBound.get(i));
        }
        int width, maxwidth=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            width = (rightBound1.get(i)-leftBound.get(i)-1)*arr[i];
            if(width>maxwidth)
                maxwidth = width;
        }
        leftBound.clear();
        rightBound.clear();
        rightBound1.clear();

        return maxwidth;
        

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter dimension of Matrix:");
        int n = sc.nextInt();
        int matrix[][] = new int[n][n];
        System.out.println("\nEnter Elements:");
        for(int i=0;i<n;i++){
            System.out.println("Row number "+(i+1)+": ");
            for(int j=0;j<n;j++)
            {
                matrix[i][j] = sc.nextInt();
            }

        }

        int arr[] = new int[n];
        int m, max=Integer.MIN_VALUE;

        for(int i=0;i<n;i++)
        {
            arr[i] = matrix[0][i];
        }

        m = solveHistogram(arr,arr.length);
        if(m>max)
            max=m;

        for(int i=1;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==0)
                    arr[j] = 0;
                else
                    arr[j] = arr[j]+matrix[i][j];
            }
            m = solveHistogram(arr,arr.length);
            if(m>max)
                max=m;
        }
        System.out.println("\nMax Area Histogram in a Binary Matrix is: "+ max);
        sc.close();
        System.gc();
    }
}
