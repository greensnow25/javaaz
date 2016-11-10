/* class defines the maximum side of the triangle
* @ author grensnow25
 * @ sinse 05.11.16
 * @version 1
*/
package greensnow25.geometry;

/* class defines the maximum side of the triangle
* @ author grensnow25
 * @ sinse 05.11.16
 * @version 1
*/


public class Maxside{
		    			
       double maxlenght;
 
// method calculate the longest side of the triangle

    public double max (double firstside, double secondside, double thirdside){
            
      
	   
        if(firstside > secondside && firstside > thirdside)
            maxlenght = firstside;
	 
        if (secondside >firstside && secondside >thirdside)
            maxlenght = secondside;
		else
            maxlenght = thirdside;
      return maxlenght;  
    }
}

