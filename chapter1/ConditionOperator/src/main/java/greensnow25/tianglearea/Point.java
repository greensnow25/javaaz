/**
 * Class Point для нахождения растояния между точками
 * @ author grensnow25
 * @ sinse 05.11.16
 * @version 1
 * @ return - return distance between points
 */
package greensnow25.tianglearea;
 
public class Point {


        public double x;
        public double y;


        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double distanceTo(Point point) {
            return Math.sqrt(Math.pow(point.x - this.x,2)+(Math.pow(point.y-this.y,2)));
        }
}




