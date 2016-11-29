package array;
/*public class BubleSort it sort array the method of buble;
@author greensow25;
@since 30.11.16;
@vwrsion 1;
 */

public class BubleSort {

    public int [] sort(int [] array){

        for (int i =0; i<=array.length-1;i++){        //cicle for firrst element

            for(int j=i+1; j<=array.length-1;j++){   // cicle for second element

                if(array [i]>=array[j]){             // sort condition

                    int temp= array[i];
                    array [i] = array [j];
                    array [j] = temp;
                }

            }

        }
        return array;
    }
    

}
