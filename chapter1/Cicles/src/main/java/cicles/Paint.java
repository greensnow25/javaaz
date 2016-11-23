package cicles;


public class Paint {



    String piramid (int h){

        StringBuilder sb = new StringBuilder(); // создаем обьект класса Stringbuilder


        for (int i=1; i<=h; i++){                    // цикл для высоты

            int wieght= 2*h-1 ;                         // ширина пирамиды
               for (int j = 1;j <= wieght; j++) {      // ширина


                    if (h-i<=j&& j<=h+i && j%2!=0 && i%2!=0)       //должно находиться в промежутке j = h+ -i,
                    sb.append("1");                                 //где h это высота, а i - єто столбец.
                                                                    //получается например если столбец i = 2 , 
                   else if (h-i<=j && j<=h+i && j%2==0 && i%2==0)    // а  высота h =5, то j  заполняем в
                    sb.append("2");                                   // промежутке h +  - 3

                     else sb.append(" ");


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
