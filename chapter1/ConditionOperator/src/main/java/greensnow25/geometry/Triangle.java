/**
 * Class Triangle для нахожения площади треугольнтка по заданым точкам
 * @ author grensnow25
 * @ sinse 05.11.16
 * @version 1
 */
package greensnow25.geometry;
 
public class Triangle {
   

    public Point a ;
    public Point b ;
    public Point c ;


    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        /**
         @param firstside - side from point a to point b
         @param secondside - side from point a to point c
         @param thirdside - side from point b to point c
         @return - result
         */
        double firstside = a.distanceTo(b);
        double secondside = a.distanceTo(c);
        double thirdside = b.distanceTo(c);
       

          if (firstside + secondside < thirdside || firstside + thirdside < secondside ||
                  secondside + thirdside < firstside) {
            System.out.println("Пстроение треугольника невозможно!");
             return -1;  }
      else {
           double p = (firstside + secondside + thirdside) / 2;
            double result = Math.sqrt(p * (p - secondside) * (p - firstside) * (p - thirdside));
              return result;
        }


    }
}
