package ru.itis.inform;

import ru.itis.inform.text.TextLexSorter;
import ru.itis.inform.text.TextReaderWriter;

import java.io.FileNotFoundException;

/**
 * Created by Тимур on 01.03.2016.
 */
public class Main  {
    public static void main(String[] args) throws FileNotFoundException {
        TextReaderWriter textReaderWriter = new TextReaderWriter();
        LinkedListImpl<String> linkedList =  new LinkedListImpl<>();
        linkedList = textReaderWriter.readHumans();

        TextLexSorter sorter = new TextLexSorter();
        linkedList = sorter.sort(linkedList);

        textReaderWriter.writeHumans("Output",linkedList);
    }
}
