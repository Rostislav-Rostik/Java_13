import java.util.*;
import java.io.*;

public class InputTest {
    public static void main(String args[]) {
        if(args.length < 2) {
            System.out.println("Нужно два параметра вызова: имя файла и строка для поиска");
            return;
        }
        String fileName = args[0];
        String searchString = args[1];

        String thisLine;
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader fin = null;

        try {
            fin = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            while ((thisLine = fin.readLine()) != null) {
                System.out.println("==Введена строка:" + thisLine);
                list.add(thisLine);
            }
            Collections.sort(list);
            System.out.println("Отсортированный список строк:");
            Iterator<String> iter = list.iterator();
            while (iter.hasNext()) {
                String str = iter.next();
                System.out.println(str);
            }

            if(list.contains(searchString)) {
                System.out.println("Результат поиска: Строка '" + searchString + "' найдена");
            } else {
                System.out.println("Результат поиска: Строка '" + searchString + "' не найдена");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + fileName);
            System.out.println("Error: " + e);
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода. Файл " + fileName);
            System.out.println("Error: " + e);
        } finally {
            if (fin != null) {
                try {
                    fin.close(); // !!! Закрыть файл
                } catch (IOException ex) {
                    System.out.println("Ошибка закрытия файла " + fileName);
                    System.out.println("Error: " + ex);
                }
            }
        }
    }
}
