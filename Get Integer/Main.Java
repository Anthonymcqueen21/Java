import java.util.*;
public class GetInteger {
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.print("Enter an integer: ");
        int i = GetInteger();
        System.out.println("You entered " + i);
    }
    
    public static int GetInteger() {
        while (true) {
            try {
               return sc.nextInt();
            }
            catch (InputMisMatchException e) {
               sc.next();
               System.out.printf("Thats not " + "an integer.Try again: ");
            }
        }
    }
}
       
