import java.util.Scanner;
// Initiate a class
class Computer {
    Computer() {
       System.out.println("Constructor of computer class.");
    }
    void computer_method() {
       System.out.println("Power gone! Shut down your pc...");
    }
    public static void main(String[] args) {
        Computer my = new Computer();
        Laptop your = new Laptop();
        my.computer_method();
        your.laptop_method();
    }
}
class Laptop {
    Laptop() {
        System.out.println("Constructor of laptop class.");
    }
    void laptop_method() {
        System.out.println("98.5% Battery availible");
    }
}
