package gb.Khelmyanov_HW.Temp;

import gb.Khelmyanov_HW.Lesson9.MyArrayDataException;

public class TempForLesson_9 {
    public static void main (String[] args)
    {
         String s = "fred";  // используйте это, если вам нужно протестировать //исключение ниже
        //String s = "100";

        try
        {
            // именно здесь String преобразуется в int
            int i = Integer.parseInt(s.trim());

            // выведем на экран значение после конвертации
            System.out.println("int i = " + i);
        }
        catch (MyArrayDataException nfe)
        {
            System.out.println("MyArrayDataException: " + nfe.getMessage());
        }
    }
}
