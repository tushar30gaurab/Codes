import java.util.Stack;
public class StackUtil
{
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<Integer>();
        st.push(20);
        st.push(21);
        st.push(10);
        System.out.println(st);
        st.pop();
        System.out.println(st);
        st.push(11);
        System.out.println(st);
        st.pop();
        System.out.println(st);
        System.out.println("Peek Element: "+st.peek());

    }
}