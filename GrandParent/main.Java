import java.util.Scanner;
// Class grandparent simple integer.
class GrandParent {
   int a;
   GrandParent(int a) {
       this.a = a;
   }
}
class Parent extends GrandParent {
    int b;
    Parent(int a, int b) {
       super(a);
       this.b = b;
    }
    void Show() {
       System.out.println("GrandParent a = " + a);
       System.out.println("Parent's b = " + b);
    }
}
class Child {
   public static void main(Strin[] args) {
        Parent object = new Parent(8, 9);
        object.show();
   }
}
