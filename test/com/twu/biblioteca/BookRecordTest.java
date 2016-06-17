package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookRecordTest {
    private BookRecord bookRecord;
    @Before
    public void setUp() throws Exception {
        bookRecord=new BookRecord(new Book("ISBN0001","Book1","Author1","1991"));
    }

    @Test
    public void shouldReturenTrueWhenCheckoutBook() throws Exception {
        bookRecord.checkoutBook();

        assertEquals(bookRecord.isCheckoutStatus(),true);
    }

    @Test
    public void shouldReturnFalseWhenCheckoutBookThenReturnBook() throws Exception {
        bookRecord.checkoutBook();
        bookRecord.returnBook();

        assertEquals(bookRecord.isCheckoutStatus(),false);
    }
}