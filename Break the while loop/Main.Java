import java.util.Scanner;
// Breaking the while loops
class BreakWhileLoop {
    public static void main(String[] args) {
        int n;
        // Importing new input scanner
        Scanner input = new Scanner(System.in);
        // While loop containing a integer
        while(true) {
            System.out.println("Input an integer");
            n = input.nextInt();
            if(n == 0) {
                // Breaks
            break;
            }
            System.out.println("You entered " + n);
        }
    }
}
