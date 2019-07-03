import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Calc {

    private Boolean exception;
    private String infoException;
    private Double result;

    public Calc() {
        this.exception = false;
        this.infoException = "";
        this.result = 0.0;
    }

    public Calc(Boolean exception, String infoException, Double result) {
        this.exception = exception;
        this.infoException = infoException;
        this.result = result;
    }

    public String getInfoException() {
        return infoException;
    }

    public void setInfoException(String infoException) {
        this.infoException = infoException;
    }

    public boolean isException() {
        return exception;
    }

    public void setException(boolean exception) {
        this.exception = exception;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void calculation(Double n1, Double n2, char sign){
        switch (sign){
            case '+':
                result = n1 + n2;
                exception = false;
                infoException = "Последняя операция - сложение";
                break;
            case '-':
                result = n1 - n2;
                exception = false;
                infoException = "Последняя операция - вычитание";
                break;
            case '*':
                result = n1 * n2;
                exception = false;
                infoException = "Последняя операция - умножение";
                break;
            case '/':
                result = n1 / n2;
                exception = false;
                infoException = "Последняя операция - деление";
                break;
            case '^':
                result = Math.pow(n1, n2);
                exception = false;
                infoException = "Последняя операция - возведение в степень";
                break;
            default:
                infoException = "Неизвестная арифметическая операция - " + sign;
                exception = true;
                result = 0.0;
        }
    }

    @Override
    public String toString() {
        return  "result = " + result;
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(this);
    }
}