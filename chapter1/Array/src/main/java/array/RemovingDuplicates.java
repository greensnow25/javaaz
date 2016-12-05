package array;


public class RemovingDuplicates {



    private String [] removd (String [] words){


        String [] result = new String[words.length ]; // результирующий массив

        for (int i=0; i<words.length-1;i++){        //просматриваем массив с начала


           for(int j=i+1;j<words.length-1;j++){

               if(words [i].equals(words [j])  ) {  //eсли елементы равны

                   result[i] = words[i];           // записуе элемент в результирующий массив



                }


           }

       }

        return result;
    }




    public static void main (String [] args){

        RemovingDuplicates remov = new RemovingDuplicates();

        String [] words = new String[]{"Привет", "Привет", "Мир", "Мир", "Меня", "Меня","Зовут", "Александр", "Мир"};

        String [] removd = remov.removd(words);


        for (int i=0; i<=removd.length-1;i++){
            System.out.print(removd [i] + " ");
        }

    }

}
