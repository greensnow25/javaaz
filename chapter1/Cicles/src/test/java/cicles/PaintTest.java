package cicles;

import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Mama on 23.11.2016.
 */
public class PaintTest {
    @Test
    public void piramid() throws Exception {

        Paint paint = new Paint ();
        String piramid = paint.piramid(3);

        assertThat(piramid, is ("  1  \r\n 2 2 \r\n1 1 1\r\n"));
    }

}