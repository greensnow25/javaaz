package cicles;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
public class SquareTest {

    @Test
    public void whenInptXthenOutputY(){
        Square sq = new Square();
        float result =sq.calculate(1);
        assertThat(result, is(6.0f));

    }
    @Test
    public void whenInputParamwhenShovREsult(){
ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Square sq = new Square();
        sq.show(1);
        assertThat(out.toString(),is("Значение фунции в промежутке от  5  до  10  с шагом  1\r\n"));
    }
}
