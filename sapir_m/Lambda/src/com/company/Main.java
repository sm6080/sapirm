package com.company;

public class Main {

    public static void main(String[] args) {
        //region Lambda
        Writable writable1 = new Writable() {
            @Override
            public void write(String s) {
                System.out.println(s);
            }
        };
        writable1.write("I am an anonymous class");
        Writable writable2 = s -> System.out.println(s);
        writable2.write("heyy");
        BinaryOperator multiplication = (int x, int y) -> x*y;
        BinaryOperator addition = (x, y) -> x+y;
        //TODO: lambda operators can be written with or without parameter types
        Point[] points={new Point(3,4),new Point(7,3),new Point(98,1)};
        Point p=new Point(7,3);
        System.out.println(contains(points,p,(a,b) -> a.x == b.x && a.y == b.y));
        //endregion
        //region Stack
        ArrStacky<Comparable> stacky = new ArrStacky<>();
        stacky.push(2);
        stacky.push(6);
        stacky.push(3);
        stacky.push(5);
        stacky.push(1);
        stacky.push(4);
        stacky=sortStack(stacky);
        while (!stacky.isEmpty())
            System.out.print(stacky.pop()+ " ");
        //endregion
    }
    //region Interfaces_For_Lambda
    interface Writable {
        void write(String s);
    }
    interface BinaryOperator {
        int operate(int x, int y);
    }
    interface Equal{
        boolean areEqual (Point x, Point y);
    }
    static class Point {
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        int x,y;
    }
    public static boolean contains (Point[] arr, Point z, Equal equal){
        for (int i = 0; i < arr.length; i++) {
            if(equal.areEqual(arr[i],z))
                return true;
        }
        return false;
    }
    //endregion
    //region StackFunctions
    //Class exercise: sort the stack
    static ArrStacky<Comparable>  sortStack (Stacky<Comparable> stack){
        ArrStacky<Comparable> sorted=new ArrStacky<Comparable>();
        ArrStacky<Comparable> smaller=new ArrStacky<Comparable>();
        sorted.push(stack.pop()); //first element
        while(!stack.isEmpty()){
            Comparable curr=stack.pop();
            if(curr.compareTo(sorted.peek())<0) {//curr<sorted.peek()
                while (!smaller.isEmpty() && smaller.peek().compareTo(curr) > 0) //while elements in sorted array are larger than curr
                    sorted.push(smaller.pop());
                smaller.push(curr);
            }
            else{ //curr>=sorted.peek()
                while(!sorted.isEmpty() && sorted.peek().compareTo(curr)<0) //while elements in smaller array are smaller than curr
                    smaller.push(sorted.pop());
                sorted.push(curr);
            }
        }
        while(!smaller.isEmpty())
            sorted.push(smaller.pop());
        return sorted;
    }
    //endregion
}