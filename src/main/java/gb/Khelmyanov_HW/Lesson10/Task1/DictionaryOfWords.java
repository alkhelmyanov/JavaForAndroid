package gb.Khelmyanov_HW.Lesson10.Task1;

import java.util.*;

public class DictionaryOfWords {

    public static void main(String[] args) {

        // Создаем коллекцию с различными словами
        List<String> dictionaryOfWords = new ArrayList<>();

        dictionaryOfWords.add("вум");     // долина по Саамски
        dictionaryOfWords.add("вуон");    // залив по Саамски
        dictionaryOfWords.add("вуон");    // залив по Саамски
        dictionaryOfWords.add("йок");     // река по Саамски
        dictionaryOfWords.add("корч");    // сквозное ущелье в горах по Саамски
        dictionaryOfWords.add("корч");    // сквозное ущелье в горах по Саамски
        dictionaryOfWords.add("лаг");     // пологий участок склона горы по Саамски
        dictionaryOfWords.add("ламбина"); // проточное озеро по Саамски
        dictionaryOfWords.add("озеро");
        dictionaryOfWords.add("лес");
        dictionaryOfWords.add("лес");
        dictionaryOfWords.add("лес");
        dictionaryOfWords.add("поле");
        dictionaryOfWords.add("море");
        dictionaryOfWords.add("Сопка");
        dictionaryOfWords.add("Сопка");
        dictionaryOfWords.add("нярк");   //  мыс, полуостров по Саамски
        dictionaryOfWords.add("суол");   //  остров по Саамски
        dictionaryOfWords.add("чорр");   //   горный массив с плоской вершиной по Саамски
        dictionaryOfWords.add("чорр");   //   горный массив с плоской вершиной по Саамски
        dictionaryOfWords.add("чорр");   //   горный массив с плоской вершиной по Саамски
        dictionaryOfWords.add("явр");    //   озеро по Саамски
        dictionaryOfWords.add("озеро");  //   озеро по Саамски
        dictionaryOfWords.add("озеро");  //   озеро по Саамски
        dictionaryOfWords.add("луг");    //   озеро по Саамски
        dictionaryOfWords.add("хребет"); //   озеро по Саамски

        System.out.println("Имеется коллекция dictionaryOfWords :\n" + dictionaryOfWords);

        // Создаем сортированный список с исключительными словами из колекциии dictionaryOfWords,  тут же их сравниваем и считаем

        Set<String> dictionaryOfWordsUnic = new HashSet<>(dictionaryOfWords);
        System.out.println("\nВ коллекции dictionaryOfWords следующие слова повторяются:");
        for (String s : dictionaryOfWordsUnic) {
            System.out.printf("Слово \"%s\" встречается %d раз\n", s, Collections.frequency(dictionaryOfWords, s));
        }

        System.out.println("\nКоллекция уникальных слов в dictionaryOfWords :\n" + dictionaryOfWordsUnic);
    }
}
