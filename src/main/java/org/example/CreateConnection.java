package org.example;

        import org.example.DataModel.BookingDetails;

        import java.util.List;

public class CreateConnection implements CreateConnectionInterface{

    Result result = new Result();

    @Override
    public boolean addEntry(BookingDetails newEntry){
        boolean flag = result.addItems(newEntry);
        return flag;
    }

    public List<BookingDetails> getData(){
        List<BookingDetails> list = result.getData();
        return list;
    }

    @Override
    public BookingDetails getBookingBasedOnId(long id) {
        BookingDetails selectedBooking = result.getBookingBasedOnId(id);
        return selectedBooking;
    }

    @Override
    public boolean upDateData(BookingDetails oldData, BookingDetails updatedData) {
        boolean status = result.updateData(oldData,updatedData);
        return true;
    }

    @Override
    public boolean deleteSlot(long bookingId) {
        boolean status = result.deleteSlot(bookingId);
       return status;
    }

    @Override
    public boolean deleteAllSlots() {
        boolean status = result.deleteAllSlots();
        return status;
    }

    @Override
    public long getBookingIdByNameAndDate(String firstName, String date) {
        long id = result.getBookingIdByNameAndDate(firstName, date);
        return id;
    }

    public int getTotalCount(){
        int count = result.getTotalCount();
        return count;
    }

    public int getCountByDate(String date){
        int count = result.getCountByDate(date);
        return count;
    }

//    Format referenced from ; https://git.cs.dal.ca/courses/2023-summer/csci-5308/demo/dbmockdemo/-/blob/master/src/main/java/dbcon/DBConnection.java
    @Override
    public boolean openConnection() {
        return true;
    }

//    Format referenced from : https://git.cs.dal.ca/courses/2023-summer/csci-5308/demo/dbmockdemo/-/blob/master/src/main/java/dbcon/DBConnection.java
    @Override
    public boolean closeConnection() {
        return true;
    }
}
