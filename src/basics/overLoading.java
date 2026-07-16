public class overLoading {
    public static void main (String[] args){
        fun(45,54);
    }
    static void fun(int a){
        System.out.println(a);
    }
    static void fun(int a,int b){
        System.out.println(a+ " " + b);
    }
}