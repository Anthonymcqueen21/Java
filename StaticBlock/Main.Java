import java.util.Scanner;
// Initialize main class
class StaticBlock {
    public static void main(String[] args) {
        System.out.println("Main method is executed linux operating");
    }
    // os string
    static {
        String os = System.getenv("OS");
        if (os.equals("Windows_NT") != true) {
            System.exit(1);
        }
    }
}
