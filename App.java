
import java.util.Scanner;


public class App {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите данные через пробел в формате: ");
        System.out.println("фамилия, имя, отчество - строки\n" +
                "дата _ рождения - строка формата dd.mm.yyyy\n" +
                "номер _ телефона - целое беззнаковое число без форматирования\n" +
                "пол - символ латиницей f или m.");
        String data = in.nextLine();
        in.close();

        String[] splitData = data.split(" ");

        if (splitData.length != 6){
            throw new RuntimeException("Неверное количество введенных данных.");
        }

        try {
            if (splitData[3].length() != 10) throw new Exception();

            String[] birthday = splitData[3].split("\\.");
            if (birthday.length != 3) throw new Exception();

            Integer.parseInt(birthday[0]);
            Integer.parseInt(birthday[1]);
            Integer.parseInt(birthday[2]);
            if (birthday[0].length() != 2) throw new Exception();
            if (birthday[1].length() != 2) throw new Exception();
            if (birthday[2].length() != 4) throw new Exception();

        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Дата рождения введена не верно.");
        }

        try {
            Integer.parseInt(splitData[4]);
        }catch (NumberFormatException e){
            //e.printStackTrace();
            System.err.println("Номер должен состоять только из цифр");
        }

        if (!splitData[5].equals("m") && !splitData[5].equals("f")) {
            throw new RuntimeException("Введен не верный пол человека.");
        }



        String surName = splitData[0];
        String fileName = surName + (".txt");
        StringBuilder personData = new StringBuilder();

        for (int i = 0; i < splitData.length; i++) {

            personData.append("<" + splitData[i] + ">");
        }

        FileWork file = new FileWork();
        file.addData(personData, fileName);

    }

}



