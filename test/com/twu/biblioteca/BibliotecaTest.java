package com.twu.biblioteca;

import com.twu.biblioteca.Option.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BibliotecaTest {

    public Biblioteca biblioteca;
    public ConsolePrinter consolePrinter;
    public List<Option> options;
    public List<BookRecord> bookRecords;

    @Before
    public void setUp() throws Exception {
        consolePrinter=mock(ConsolePrinter.class);

        List<Option> menu=new ArrayList<>();
        menu.add(new ListBookOption(1,"List"));
        menu.add(new CheckoutBookOption(2, "Checkout"));
        menu.add(new ReturnBookOption(3, "Return"));
        menu.add(new QuitOption(4, "Quit"));

        List<BookRecord> bookRecords=new ArrayList<>();
        bookRecords.add(new BookRecord(new Book("ISBN0001","Book1","Author1","1991")));
        bookRecords.add(new BookRecord(new Book("ISBN0002","Book2","Author2","2000")));

        biblioteca=new Biblioteca(consolePrinter,menu, bookRecords);
    }

    @Test
    public void shouldShowWelcomeWords() throws Exception {
        biblioteca.showWelcomeWords();

        verify(consolePrinter).print("welcome to biblioteca");
    }

    @Test
    public void shouldShowQuitWords() throws Exception {
        biblioteca.showQuitWords();

        verify(consolePrinter).print("good bye");
    }
    @Test
    public void shouldShowSuccessfulCheckout() throws Exception {
        biblioteca.showSuccessfulCheckout();

        verify(consolePrinter).print("Thank you! Enjoy the book");

    }

    @Test
    public void shouldShowUnsuccessfulCheckout() throws Exception {
        biblioteca.showUnsuccessfulCheckout();

        verify(consolePrinter).print("That book is not available");

    }

    @Test
    public void shouldShowSuccessfulWhenReturnBook() throws Exception {
        biblioteca.showSuccessfulReturn();

        verify(consolePrinter).print("Thank you for returning the book");

    }

    @Test
    public void shouldShowUnsuccessfulWhenReturnBook() throws Exception {
        biblioteca.showUnsuccessfulReturn();

        verify(consolePrinter).print("That is not a valid book to return");
    }


    @Test
    public void shouldShowInvalidMessage() throws Exception {
        biblioteca.showInvalidMessage();

        verify(consolePrinter).print("Select a valid option!");

    }


    @Test
    public void shouldShowBookTitle() throws Exception {
        biblioteca.listTitle();

        verify(consolePrinter).print("isbn\tname\tauthor\tyear");

    }

    @Test
    public void shouldSetStopSignTrueWhenQuit() throws Exception {
        biblioteca.quit();

        assertEquals(biblioteca.isStopSign(),true);
    }

    @Test
    public void shouldReturnTrueWhenValidateIsbnInputGivenISBN0001() throws Exception {
        boolean result=biblioteca.validateIsbnInput("ISBN0001");

        assertEquals(result,true);
    }

    @Test
    public void shouldReturnFalseWhenValidateIsbnInputGivenISBN0000() throws Exception {
        boolean result=biblioteca.validateIsbnInput("ISBN0000");

        assertEquals(result,false);
    }


    @Test
    public void shouldReturnFalseWhenValidateIsbnInputGivenAAAAAAA() throws Exception {

        boolean result=biblioteca.validateIsbnInput("AAAAAAA");
        assertEquals(result,false);
    }


    @Test
    public void shouldReturnTrueWhenValidateMenuIdGiven1() throws Exception {
        boolean result=biblioteca.validateMenuId(1);

        assertEquals(result,true);
    }


    @Test
    public void shouldReturnFalseWhenValidatemenuidGiven9() throws Exception {
        boolean result=biblioteca.validateMenuId(9);

        assertEquals(result,false);

    }


    @Test
    public void shouldReturnFalseWhenValidateMenuIdGivenNegtive() throws Exception {
        boolean result=biblioteca.validateMenuId(-1);

        assertEquals(result,false);
    }


    @Test
    public void shouldOutputBookListWhenListbook() throws Exception {
        biblioteca.listBooks();

        verify(consolePrinter,times(1)).print("isbn\tname\tauthor\tyear");
        verify(consolePrinter,times(1)).print("ISBN0001\tBook1\tAuthor1\t1991");
        verify(consolePrinter,times(1)).print("ISBN0002\tBook2\tAuthor2\t2000");
    }


    @Test
    public void shouldOutputMenuListWhenListmenu() throws Exception {
        biblioteca.listMenu();

        verify(consolePrinter,times(1)).print("1\tList");
        verify(consolePrinter,times(1)).print("2\tCheckout");
        verify(consolePrinter,times(1)).print("3\tReturn");
        verify(consolePrinter,times(1)).print("4\tQuit");
    }

}