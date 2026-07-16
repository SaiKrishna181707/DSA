import java.util.Scanner;

public class primitives {
    public static void main(String[] args) {

        // string is not primitive
        // String name = "kittu";
        // a primitive is datatype where we cannot further break it into another datatype
        // because here string can be broken into further datatype like characters it cannot be primitive
        // where as integer cannot be broken into further datatype so integer is primitive
        char gender = 'M';
        float marks = 99.9f;
        double largeDecimalValues = 6969.696969;
        long largeIntegerValues = 69696969L;
        boolean bool = true;
        Scanner input =new  Scanner(System.in);

        String rollno=input.nextLine();

        System.out.println("your roll no is "+ rollno);
    }
}
