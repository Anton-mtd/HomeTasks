package lesson2.NoteBooksSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NotebookSort {

    public static void main(String[] args) {
        List <NoteBook> noteBooks = createNoteBooksList(10000);
        Collections.sort(noteBooks);
        for (NoteBook noteBook : noteBooks) {
            System.out.println(noteBook.toString());
        }
    }


    private static List<NoteBook> createNoteBooksList(int length) {
        List <NoteBook> arr = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            arr.add(new NoteBook());
        }
        return arr;
    }
}
