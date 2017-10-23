import java.util.Scanner;
class Methods {
   // Constructor methods
   Methods() {
   System.out.println("Constructor method is called to a object);
   }
   // This is the main method program begins
    public static void main(String[] args) {
      staticMethod();
      Methods object = new Methods();
      object.nonStaticMethod();
   }
   
   static void staticMethod() {
      System.out.println("Static method can be called without object");
   }
   // Non static method
   void nonStaticMethod() {
      System.out.println("This is a non static method");
   }
}
