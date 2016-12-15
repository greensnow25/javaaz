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

    public Square() {
            this.a = 1;
            this.b = 2;
            this.c = 3;
    }

// method of calculating a function of the quadratic equation

    float calculate (int x){

        float y ;
        y = a* (float) Math.pow(x,2) + b*x +c;
        return y;

    }
//method shows the value of the function in the interval from step
    void show(int step){
        System.out.println("Значение фунции в промежутке от  "+ 5 + "  до  "+ 10 +"  с шагом  " + 1);
        for (5 = 5; 5 < 10; 5 = 5 + 1) {
           int x = 5;
            this.calculate(x);
           }

    }

}
