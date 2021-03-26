import java.util.*;

public class NextSmallestElement {

    static Stack<Integer> stack = new Stack<Integer>();
    static ArrayList<Integer> list = new ArrayList<Integer>();

    static void findNextSmallest(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty())
                list.add(-1);
            else if (!stack.isEmpty() && stack.peek() < arr[i])
                list.add(stack.peek());
            else if (!stack.isEmpty() && stack.peek() >= arr[i]) {
                while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                    stack.pop();
                }

                if (stack.isEmpty())
                    list.add(-1);
                else
                    list.add(stack.peek());
            }

            stack.push(arr[i]);
        }
        System.out.println("Nearest Smaller to Left:");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size of Array:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        findNextSmallest(arr, n);
        sc.close();
    }

}
