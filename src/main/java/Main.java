import com.fasterxml.jackson.core.JsonProcessingException;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        Calc calc = new Calc();

        System.out.println("1.3999 - 1.3998");
        calc.calculation(1.3999, 1.3998, '-');
        if (!calc.isException()){
            System.out.println(calc.toString());
        }
        else System.out.println(calc.getInfoException());
        System.out.println("Json - " + calc.toJson() + "\n");

        System.out.println("1.3999 & 1.3998");
        calc.calculation(1.3999, 1.3998, '&');
        if (!calc.isException()){
            System.out.println(calc.toString());
        }
        else System.out.println(calc.getInfoException());
        System.out.println("Json - " + calc.toJson() + "\n");

    }
}
