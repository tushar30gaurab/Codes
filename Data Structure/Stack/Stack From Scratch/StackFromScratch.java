import java.util.*;
public class StackFromScratch {

    static final int SIZE = 1000;
    static int stack[] = new int[SIZE];
    static int top=-1;

    static void push(int data)
    {
        if(top>=SIZE-1)
        {
            System.out.println("Stack Overflow:");
        }
        else{
        stack[++top] = data;
        System.out.println("Pushed: "+data);
        }
    }

    static void pop()
    {
        if(top<0)
            System.out.println("Stack UnderFlow");

        else{
            int p = stack[top];
            top--;
            System.out.println("Popped: "+ p);
        }
    }

    static void peek()
    {
        if(top<0)
        System.out.println("Stack Underflow");

        else if(top>=SIZE-1)
        System.out.println("Stack Overflow");
        else
        System.out.println("Current Top of Stack is: "+ stack[top]);
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        push(2);
        push(3);
        push(5);
        push(6);
        push(8);
        push(10);
        push(12);
        pop();
        pop();
        pop();
        peek();
    }
}