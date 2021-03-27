import java.util.*;
public class NextSmallestElement1 {

    static Stack<Integer> stack = new Stack<>();
    static ArrayList<Integer> list = new ArrayList<>();

    static void solveNextSmallest(int arr[], int n)
    {
        for(int i=n-1;i>=0;i--)
        {
            if(stack.isEmpty())
                list.add(-1);
            else if(!stack.isEmpty() && stack.peek()<arr[i])
                list.add(stack.peek());
            else if(!stack.isEmpty() && stack.peek()>=arr[i])
            {
                while(!stack.isEmpty() && stack.peek()>=arr[i])
                {
                    stack.pop();
                }

                if(stack.isEmpty())
                    list.add(-1);
                else
                    list.add(stack.peek());
            }

            stack.push(arr[i]);
        }

        System.out.println("Next Smaller Elements to Right: ");
        for(int i= list.size()-1; i>=0; i--)
            System.out.print(list.get(i)+" ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter elements:");
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }

        solveNextSmallest(arr,n);
        sc.close();
        System.gc();
    }
}
