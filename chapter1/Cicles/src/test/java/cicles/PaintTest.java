package cicles;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class PaintTest {
    @Test
    public void whenEnterHieghtthenReturnPiramidOfSymbols()  {

        Paint paint = new Paint ();
        String piramid = paint.piramid();

        assertThat(piramid, is ("  ^  \r\n ^ ^ \r\n^   ^\r\n"));
    }

}