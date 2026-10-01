// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
import java.util.EmptyStackException;
import java.util.Random;
import java.util.Stack;

class MinStack {
   private Stack<Integer> stack = new Stack();
   private Stack<Integer> minStack = new Stack();

   public MinStack() {
   }

   public void push(int var1) {
      this.stack.push(var1);
      if (this.minStack.isEmpty() || var1 <= (Integer)this.minStack.peek()) {
         this.minStack.push(var1);
      }

   }

   public int pop() {
      if (this.stack.isEmpty()) {
         throw new EmptyStackException();
      } else {
         int var1 = (Integer)this.stack.pop();
         if (var1 == (Integer)this.minStack.peek()) {
            this.minStack.pop();
         }

         return var1;
      }
   }

   public int getMin() {
      if (this.minStack.isEmpty()) {
         throw new EmptyStackException();
      } else {
         return (Integer)this.minStack.peek();
      }
   }

   public int top() {
      if (this.stack.isEmpty()) {
         throw new EmptyStackException();
      } else {
         return (Integer)this.stack.peek();
      }
   }

   public static void main(String[] var0) {
      MinStack var1 = new MinStack();
      var1.push(30);
      var1.push(20);
      var1.push(10);
      var1.push(25);
      var1.push(5);
      System.out.println("Minimum: " + var1.getMin());
      var1.pop();
      System.out.println("After pop, Minimum: " + var1.getMin());
      var1.pop();
      System.out.println("After pop, Minimum: " + var1.getMin());
      Random var2 = new Random();
      System.out.println("\nRandom Values:");

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = var2.nextInt(100);
         var1.push(var4);
         System.out.println("Pushed: " + var4 + " | Current Minimum: " + var1.getMin());
      }

   }
}
