/* Класс SelectSort  для сортировкии масива методом выбора ;

@author  greensnow25
@since 17.11.16
@version 1

 */
package array;

public class SelectSort{

    public static void main (String[] args){
SelectSort ss = new SelectSort();
        ss.arrayContin();
    }
    int[] array= new int[10];

    public void arrayContin() {
        for (int i = 0; i <array.length;i++){
            array[i] =  (int)Math.floor(Math.random() * 100);
                System.out.print(array[i] + "  ");
        }
    }

    public void select(SelectSort array[],int x){
        for (int i =0;i<array.length;i++){

            for(int j=i+1 ;i<=array.length; i++){
                if (j<i){
                    x = array[i];
                    array [i]= array[j];
                    array[j]= SelectSort x;


                }
            }
        }
    }

}
