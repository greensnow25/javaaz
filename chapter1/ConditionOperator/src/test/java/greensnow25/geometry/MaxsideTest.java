 
 package greensnow25.geometry;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
 
 
 public class MaxsideTest{
		Point a = new Point (2,1);
        Point b = new Point (4,-4);
        Point c = new Point (12,7); 
	
	    double firstside = a.distanceTo(b);
        double secondside = a.distanceTo(c);
        double thirdside = b.distanceTo(c);

	@Test
	 public void whenEnterCoodinatesOfPoinsthenReturnArea(){
       
            Triangle tr = new Triangle(a,b,c);
                 double area = tr.area();
      
	 assertThat(area, is(31.000000000000018d));
	}
	 

	 @Test
	  public void whenEnterCoodinatesOfPoinsthenShowLongestSideOfTriangle(){
		
			Maxside max = new Maxside();
				double side =max.max(firstside, secondside, thirdside);
		 assertThat(side, is(13.601470508735444d));
    }
 }