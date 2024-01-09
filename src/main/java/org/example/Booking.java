package org.example;

import org.example.DataModel.BookingDetails;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Booking {

    public CreateConnectionInterface createConn = new CreateConnection();

    public Scanner scanner = null;
//    Function to add or create new booking
    public boolean newBooking(){

         scanner = new Scanner(System.in);
//        createConn = new CreateConnection();

        System.out.print("Enter first name : ");
        String firstName = scanner.next();
        scanner.nextLine();

        System.out.print("Enter last name : ");
        String lastName = scanner.nextLine();


        System.out.println("\nYou will need to book one day prior and you can choose a slot in 4 days window");
        System.out.println("Select a date from the below list");
        List<String> availableDates = generateDate();
        for(int i=0;i<availableDates.size();i++){
            System.out.println("Press "+(i+1)+" - "+availableDates.get(i));
        }
        System.out.print("Please enter your input : ");
        int index = scanner.nextInt();
        String date = availableDates.get(index-1);

        System.out.println("Enter the count : ");
        int count = scanner.nextInt();

        System.out.println("Press N to book for slot in the Noon(12PM - 3PM) and E to book a slot in the evening(7PM -10PM) : ");
        String slotIndentifier = scanner.next().toLowerCase();
        String slot = slotIndentifier=="n"?"Afternoon" : "Evening";

        long id = Math.round(Math.random()*10000);

        BookingDetails newBooking = new BookingDetails(id,firstName , lastName, date , slot , count);
        boolean status = createConn.addEntry(newBooking);
        System.out.println("\n Please make a note of the booking ID for future reference");
        System.out.println("Your booking Id is : "+id);
        return status;
    }

//    Function to get all the booked slot
    public List<BookingDetails> getDetails(){
        List<BookingDetails> list = createConn.getData();
        return list;
    }


//    Function to get the booking by ID
    public BookingDetails getBookingById(long id){
        BookingDetails selectedBooking = createConn.getBookingBasedOnId(id);
        return selectedBooking;
    }

//    Function to update particular booking details
    public boolean updateData(BookingDetails oldData , BookingDetails updatedData){
        boolean status = createConn.upDateData(oldData,updatedData);
        return status;
    }

//Delete a particular slot based on booking id
    public boolean deleteSlot(long id){
        boolean status = createConn.deleteSlot(id);
        return status;
    }

//    Delete all the booking slots
    public boolean deleteAllSlots(){
        boolean status = createConn.deleteAllSlots();
        return status;
    }

//    Generate the dynamic date for seat selection
    public List<String> generateDate(){
            Calendar calendar = Calendar.getInstance();
            List<String> calendarDays = new ArrayList<String>();
            for(int i=1;i<=4;i++){
                calendar.add(Calendar.DATE, 1);

                // Referenced from : https://www.javatpoint.com/how-to-get-day-name-from-date-in-java
                // How to get day name from date in Java
                //        Referencing starts here
                SimpleDateFormat formatDate = new SimpleDateFormat("dd-MMMM-yyyy");
                String dateAfterndays = formatDate.format(calendar.getTime());
                calendarDays.add(dateAfterndays);
                // Referencing ends here
            }
            return calendarDays;
    }

    public long getBookingIdByNameAndDate(String firstName , String date){
        long id = createConn.getBookingIdByNameAndDate(firstName,date);
        return id;
    }
    public int getTotalCount(){
        int count = createConn.getTotalCount();
        return count;
    }

    public int getCountByDate(String date){
        int count = createConn.getCountByDate(date);
        return count;
    }
}

