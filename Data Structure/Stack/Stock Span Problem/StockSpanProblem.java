import java.util.*;
public class StockSpanProblem {

    static Stack<Integer> stack = new Stack<Integer>();
    static ArrayList<Integer> list = new ArrayList<Integer>();


    static void findNextLargest(int arr[], int n)
    {
        for(int i=0;i<n;i++)
        {
            if(stack.isEmpty())
                list.add(i+1);
            else if(!stack.isEmpty() && arr[stack.peek()]>arr[i])
                list.add(Math.abs(i-stack.peek()));
            else if(!stack.isEmpty() && arr[stack.peek()]<=arr[i])
            {
                while(!stack.isEmpty() && arr[stack.peek()]<=arr[i]){
                    stack.pop();
                }

                if(stack.isEmpty())
                    list.add(i+1);
                else
                    list.add(Math.abs(i-stack.peek()));
            }
            stack.push(i);
        }
        System.out.println("\nStock Span Solution:");
        for(int i=0;i<list.size();i++)
            System.out.print(list.get(i)+" ");
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size of Array:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter Stocks per day: ");
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        findNextLargest(arr,n);
        sc.close();
    }
}
