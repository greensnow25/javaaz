/* Класс Square  для вычисления функции квадратного уравнения;

@author  greensnow25
@since 13.11.16
@version 1

 */
package cicles;
public class Square {

    public int a;
    public int b;
    public int c;

    public Square (int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
    }

// method of calculating a function of the quadratic equation

    float calculate (int x){

        float y ;
        y = a* (float) Math.pow(x,2) + b*x +c;
        return y;

    }
//method shows the value of the function in the interval from step
    void show(int start,int finish,int step){
        System.out.println("Значение фунции в промежутке от  "+start + "  до  "+finish+"  с шагом  " + step);
        for (start =start; start<finish; start= start+step) {
           int x = start;
            this.calculate(x);
           }

    }

}
