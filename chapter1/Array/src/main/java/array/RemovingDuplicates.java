package array;


public class RemovingDuplicates {



    private String [] removd (String [] words){

        String [] result = new String[words.length ]; // array with out duplicats

            for (int i=0; i<words.length-1;i++){
                 result[i]= words [i];
                 for(int j=i+1;j<words.length-1;j++){
                     if(words [i].equals(words [j])  ) {
                         result[i] = null;
                     }
                 }
            }
        String [] sort = new String [result.length];             //sort array
                int count=0;
            for(int i = 0; i<result.length-1;i++){
                for(int j=i+1;j<result.length-1;j++){
                    if(result[i]== null && result[j]!=null ){
                        sort[i]=result[j];
                        result[j]=null;

                        break;
                    }

                }
            }

            for (int i =0;i<=sort.length-1;i++){                // counter
                if(sort [i]!=null) {

                    count++;
                }
            }

            String [] small = new String[count];                 // array with out null

                for(int i=0; i<=sort.length-1; i++){

                        if(sort[i]!=null){
                            small[i] = sort[i];

                   }
                }
        return small;
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
