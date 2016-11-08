 package greensnow25.trianglearea;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TriangleTest{
        
	@Test
        public void whenEnterCoodinatesOfPoinsthenReturnArea(){
	
			Point a = new Point(21,3);
       		Point b = new Point (-2,5);
        	Point c = new Point (6,15);
        
		Triangle triangle = new Triangle(a,b,c);
       double triangleArea = triangle.area();
        assertThat(triangleArea, is(122.99999999999999d));
	
	}    
}
