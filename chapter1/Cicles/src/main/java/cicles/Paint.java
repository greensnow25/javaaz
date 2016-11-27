package cicles;


public class Paint {



    String piramid (int h){

        StringBuilder sb = new StringBuilder(); // создаем обьект класса Stringbuilder


        for (int i=1;i<=h; i++){
            int  wieght = 2*h-1;
            boolean flag = true;
            for (int j = wieght;j >0; j--) { //изменили внутренний цикл,теперь цыкл для длинн
                                            // начинает считать с конца предпологаемой длинны
                                            //с каждым счетом j уменьшаем на 1
                if (j<=i){
                    sb.append("1");

                }


                 else
                    sb.append("0");

            }
            sb.append("\r\n");

       }
        return sb.toString();




    }



    public static void main (String [] args){
      Paint paint = new Paint ();
        String piramid = paint.piramid(3);
        System.out.println(piramid);
    }
}
