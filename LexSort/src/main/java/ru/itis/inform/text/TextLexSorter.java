package ru.itis.inform.text;

import ru.itis.inform.ArrayList;
import ru.itis.inform.Iterator;
import ru.itis.inform.LinkedListImpl;

/**
 * Created by Тимур on 01.03.2016.
 */
public class TextLexSorter {
    public LinkedListImpl<String> sort(LinkedListImpl<String> linkedList) {

        ArrayList<LinkedListImpl<String>> arrayList = new ArrayList<>(30);

        //Initialize
        for (int i = 0; i <= 26; i++) {
            if (arrayList.get(i) == null) {
                arrayList.set(i, new LinkedListImpl<String>());
            }
        }
        LinkedListImpl<String> appendCell = new LinkedListImpl<>();
        //
        for (int i = linkedList.getFirst().getValue().length() - 1; i >= 0; i--) {
            for (int j = 90; j >= 65; j--) {
                Iterator<String> iterator = linkedList.iterator();
                while (iterator.hasNext()) {
                    if (iterator.peekNext().charAt(i) == (char) j) {
                        arrayList.get(j - 65).push(iterator.peekNext());
                        iterator.next();
                    } else {
                        iterator.next();
                    }
                }
            }
            Boolean f = false;
                for (int ap = 0; ap <= 25; ap++) {
                    if (arrayList.get(ap).getFirst() != null) {
                        f = true;
                        appendCell.append(arrayList.get(ap));
                        arrayList.set(ap, new LinkedListImpl<String>());
                    }
            }
            if (f) {
                linkedList = appendCell;
                appendCell = new LinkedListImpl<String>();
            }
        }
        return linkedList;
    }
}
