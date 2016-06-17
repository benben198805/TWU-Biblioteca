package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void shouldReturenRightFormatWhenCallShowBook() throws Exception {
        Book book=new Book("ISBN0001","Book1","Author1","1991");

        assertEquals(book.showBook(),"ISBN0001\tBook1\tAuthor1\t1991");
    }


}