package org.example.DataModel;

//Structure referenced from
// Link : https://git.cs.dal.ca/courses/2023-summer/csci-5308/demo/dbmockdemo/-/blob/master/src/main/java/dataObject/Employee.java
public class BookingDetails {
    private long bookingId;

    private String firstName;

    private String lastName;

    private String date;
    private String slot;
    private int count;

    public BookingDetails (long bookingId ,String firstName,String lastName , String date , String slot, int count ){
        this.bookingId = bookingId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
        this.slot = slot;
        this.count = count;
    }

//    Getters
    public long getBookingId(){
        return bookingId;
    }

//    Getters
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getDate(){
        return date;
    }
    public String getSlot(){
        return slot;
    }
    public int getCount(){
        return count;
    }

//    Setters
    public String setFirstName(String firstName){
    return this.firstName = firstName;
}
    public String setLastName(String lastName){
        return this.lastName = lastName;
    }

    public String setdate(String date){
        return this.date = date;
    }

    public String setSlot(String slot){
        return this.slot = slot;
    }
    public int setCount(int count){
        return this.count = count;
    }
}


