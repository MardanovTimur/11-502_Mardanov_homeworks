package ru.itis.inform;

import ru.itis.inform.Human.Human;
import ru.itis.inform.Human.HumansReaderWriter;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        HumansReaderWriter humansReaderWriter = new HumansReaderWriter();
        humansReaderWriter.readHumans();




    }
}
