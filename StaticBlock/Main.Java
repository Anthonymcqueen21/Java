import java.util.Scanner;

class StaticBlock {
    public static void main(String[] args) {
        System.out.println("Main method is executed linux operating");
    }
    
    static {
        String os = System.getenv("OS");
        if (os.equals("Windows_NT") != true) {
            System.exit(1);
        }
    }
}