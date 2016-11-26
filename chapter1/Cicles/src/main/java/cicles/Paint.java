package cicles;


public class Paint {



    String piramid (int h){

        StringBuilder sb = new StringBuilder(); // создаем обьект класса Stringbuilder


        for (int i=1;i<=h; i++){
            int  wieght = 2*h-1;
            boolean flag = true;                   // приравниваем логическое значение равное истине
            for (int j = 1;j <=wieght; j++) {

                if (j<=i){                          // условие для постойки пирамиды
                    sb.append("1");                 // если условие верно, вставляем "1"
                //    flag= false;}      теперь для того , что бы выполнилось следующее условие приравниваем значение ложь
              //  if (flag == false){    условие , при котором, если "1" была вставлена, то сделать промежуток
                 //   sb.append("2");     между символами, в виде символа "2"
                //    flag = true;        для того, что бы виполнилось условие , при котором мы
                }                         //заполняем оставшуюся часть поля "0" приравниваем значение "истине"


                 else
                    sb.append("0");

            }
            sb.append("\r\n");

       }
        return sb.toString();




    }



    public static void main (String [] args){
      Paint paint = new Paint ();
        String piramid = paint.piramid(5);
        System.out.println(piramid);
    }
}
