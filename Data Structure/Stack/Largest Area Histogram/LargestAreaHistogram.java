import java.util.*;
public class LargestAreaHistogram {

    static Stack<Integer> st = new Stack<Integer>();
    static ArrayList<Integer> leftBound = new ArrayList<Integer>();
    static ArrayList<Integer> rightBound = new ArrayList<Integer>();
    static ArrayList<Integer> rightBound1 = new ArrayList<Integer>();

    static void solveHistogram(int arr[], int n)
    {
        //solve leftBound
        for(int i=0;i<n;i++)
        {
            if(st.isEmpty())
                leftBound.add(-1);
            else if(!st.isEmpty() && arr[st.peek()]<arr[i])
                leftBound.add(st.peek());
            else if(!st.isEmpty() && arr[st.peek()]>=arr[i])
            {
                while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                {
                    st.pop();
                }
                if(st.isEmpty())
                    leftBound.add(-1);
                else
                    leftBound.add(st.peek());
            }

            st.push(i);
        }


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

        System.out.println("Maximum area of Histogram is: "+ maxwidth);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        
        System.out.println("Enter elements:");
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        solveHistogram(arr, n);
        sc.close();
    }
}
