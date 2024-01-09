package org.example;

import org.example.DataModel.BookingDetails;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private List<BookingDetails> list= new ArrayList<BookingDetails>();

    public boolean addItems(BookingDetails newItem){
        list.add(newItem);
        return true;
    }

    public List<BookingDetails> getData(){
        return list;
    }

    public BookingDetails getBookingBasedOnId(long id){
        BookingDetails selectedBooking = new BookingDetails(id,"","","","",0);
        for(BookingDetails bookingSlot : list){
            if(bookingSlot.getBookingId()==id){
//                 selectedBooking = bookingSlot;
                 selectedBooking.setFirstName(bookingSlot.getFirstName());
                 selectedBooking.setLastName(bookingSlot.getLastName());
                 selectedBooking.setdate(bookingSlot.getDate());
                 selectedBooking.setSlot(bookingSlot.getSlot());
                 selectedBooking.setCount(bookingSlot.getCount());
                break;
            }
        }
        return selectedBooking;
    }

    public boolean updateData(BookingDetails oldData , BookingDetails updatedData){
        for(int i=0;i< list.size();i++){
            if(list.get(i).getBookingId()==oldData.getBookingId()){
                list.remove(i);
                list.add(updatedData);
            }
        }

        return true;
    }

    public boolean deleteSlot(long bookingID){
        boolean status =false;
        for(int i=0;i< list.size();i++){
            if(list.get(i).getBookingId()==bookingID){
                list.remove(i);
                status = true;
                break;
            }
        }
        return status;
    }

    public boolean deleteAllSlots(){
        list.clear();
        return true;
    }

    public long getBookingIdByNameAndDate(String firstName , String date) {
        long id = 0;
        for (BookingDetails currentBooking : list) {
            if (currentBooking.getFirstName().toLowerCase().equals(firstName.toLowerCase()) && currentBooking.getDate().equals(date)) {
                id = currentBooking.getBookingId();
                break;
            }
        }
        return id;
    }

    public int getTotalCount(){
        int count=0;
        for(BookingDetails item:list){
            count+=item.getCount();
        }
        return count;
    }

    public int getCountByDate(String date){
        int count =0;
        for(BookingDetails currentItem:list){
            if(currentItem.getDate().equals(date)){
                count+=currentItem.getCount();
            }
        }
        return count;
    }
}
