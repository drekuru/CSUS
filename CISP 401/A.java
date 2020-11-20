class A{
  {System.out.print("1");}
  static { System.out.print("2");}
  A(int a){
     System.out.print("3");
  }
}


class B extends A{
  {System.out.print("a");}
   static { System.out.print("b");}
   B(){
        super(1);
        System.out.print("c");
   }

   public static void main(String[] args){ }
}
