package org.example;

import org.example.DataModel.BookingDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class BookingTest {

    @Mock
    Scanner scanner;

    @Mock
    CreateConnection createConn;


    //    Referenced from :
//    https://git.cs.dal.ca/courses/2023-summer/csci-5308/demo/dbmockdemo/-/blob/master/src/test/java/service/DBServiceImplTest.java
    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getDetailsTest(){
        Booking booking = new Booking();
        booking.createConn = createConn;
        when(createConn.getData()).thenReturn(new ArrayList<BookingDetails>());

        assertEquals(0,booking.getDetails().size());
    }

    @Test
    public void getBookingByIdTest() {
        Booking booking = new Booking();
        booking.createConn = createConn;
        when(createConn.getBookingBasedOnId(1234)).
                thenReturn(new BookingDetails(1234, "James", "Potter", "", "", 0));

        assertEquals("James", booking.getBookingById(1234).getFirstName());
    }

    @Test
    public void updateDataTest() {
        Booking booking = new Booking();
        BookingDetails oldObject = new BookingDetails(1234, "Peter", "Henry", "28/05/2023", "noon", 2);
        BookingDetails updatedObject = new BookingDetails(1234, "Peter", "Henry", "28/05/2023", "noon", 2);
        booking.createConn = createConn;
        when(createConn.upDateData(oldObject, updatedObject)).thenReturn(true);

        assertEquals(true, booking.updateData(oldObject, updatedObject));
    }

    @Test
    public void deleteSlotTest(){
        Booking booking = new Booking();
        booking.createConn = createConn;
        when(createConn.deleteSlot(1234)).thenReturn(true);

        assertEquals(true, booking.deleteSlot(1234));
    }

    @Test
    public void deleteAllSlotsTest(){
        Booking booking = new Booking();
        booking.createConn = createConn;
        when(createConn.deleteAllSlots()).thenReturn(true);

        assertEquals(true, booking.deleteAllSlots());
    }

    @Test
    public void getBookingIDByNameAndDateTest(){
        Booking booking = new Booking();
        booking.createConn = createConn;
        when(createConn.getBookingIdByNameAndDate("James","29 May 2023")).thenReturn(4958L);

        assertEquals(4958, booking.getBookingIdByNameAndDate("James","29 May 2023"));
    }

    @Test
    public void generateDateTest(){
        Booking booking = new Booking();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        SimpleDateFormat formatDate = new SimpleDateFormat("dd-MMMM-yyyy");
        String dateAfterndays = formatDate.format(calendar.getTime());

        assertEquals(dateAfterndays,booking.generateDate().get(0));
    }

    @Test
    public void getTotalCountTest(){
        Booking booking = new Booking();
        booking.createConn = createConn;
        when(createConn.getTotalCount()).thenReturn(3);

        assertEquals(3, booking.getTotalCount());
    }

    @Test
    public void getCountByDateTest(){
        Booking booking = new Booking();
        booking.createConn = createConn;
        when(createConn.getCountByDate("28 May 2023")).thenReturn(2);

        assertEquals(2, booking.getCountByDate("28 May 2023"));
    }
}

