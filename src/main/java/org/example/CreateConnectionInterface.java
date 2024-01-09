package org.example;

import org.example.DataModel.BookingDetails;

import java.util.List;

public interface CreateConnectionInterface {

    public boolean addEntry(BookingDetails newEntry);

    public boolean openConnection();

    public boolean closeConnection();

    public List<BookingDetails> getData();

    public BookingDetails getBookingBasedOnId(long id);

    public boolean upDateData(BookingDetails oldData, BookingDetails updatedData);

    public boolean deleteSlot(long bookingId);

    public boolean deleteAllSlots();

    public long getBookingIdByNameAndDate(String firstName , String date);

    public int getTotalCount();

    public int getCountByDate(String date);

}
