import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalcTest {

    @Test
    public void calculation() {
        Calc calc = new Calc();

        calc.calculation(1.0, 1.0, '-');
        Assert.assertEquals(0, calc.getResult(), 0.1);

        calc.calculation(1.0, 1.0, '+');
        Assert.assertEquals(2, calc.getResult(), 0.1);

        calc.calculation(1.0, 1.0, '*');
        Assert.assertEquals(1, calc.getResult(), 0.1);

        calc.calculation(3.0, 1.0, '/');
        Assert.assertEquals(3, calc.getResult(), 0.1);

        calc.calculation(3.0, 1.0, '>');
        assertTrue(calc.isException());
    }

    @Test
    public void toJson() throws JsonProcessingException {
        Calc calc = new Calc();
        calc.calculation(1.0, 3.5, '+');
        assertEquals("{\"exception\":false,\"infoException\":\"Последняя операция - сложение\",\"result\":4.5}", calc.toJson());

        calc.calculation(1.0, 1.0, '>');
        assertEquals("{\"exception\":true,\"infoException\":\"Неизвестная арифметическая операция - >\",\"result\":0.0}", calc.toJson());
    }
}