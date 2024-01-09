package org.example;

import org.example.DataModel.BookingDetails;

import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static Booking booking = new Booking();

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println(" Welcome to slot booking");
       menu();
    }

    public static void displayData(){

        System.out.print("Please enter the bookingId : ");
        long id = scanner.nextLong();
        boolean status = false;
        BookingDetails selectedBooking = booking.getBookingById(id);
        if(selectedBooking.getFirstName().equals("")){
            System.out.println("Invalid bookingId. Please try again");
        }else{
            System.out.println("Selected slot is : ");
            System.out.println("Booking Id - "+selectedBooking.getBookingId());
            System.out.println("First name - "+selectedBooking.getFirstName());
            System.out.println("Last name  - "+selectedBooking.getLastName());
            System.out.println("Date       - "+selectedBooking.getDate());
            System.out.println("Slot       - "+selectedBooking.getSlot());
            System.out.println("Count      - "+selectedBooking.getCount());
        }

        menu();
    }

    public static boolean editSlot(){
        System.out.print("Please enter the bookingId : ");
        long id = scanner.nextLong();
        boolean status = false;
        BookingDetails selectedBooking = booking.getBookingById(id);
        System.out.println("Selected slot is : ");
        System.out.println(selectedBooking.getBookingId()+"\t"+selectedBooking.getFirstName()+"\t" +
                selectedBooking.getLastName()+"\t"+selectedBooking.getDate()+"\t"+selectedBooking.getSlot()+"\t"
                +selectedBooking.getCount());
        if(selectedBooking.getFirstName()==""){
            System.out.println("Entering booking ID does not match with any existing ID. Please enter a valid ID");
        }
        else{
            status = true;
            BookingDetails updatedBooking = new BookingDetails(id,selectedBooking.getFirstName(),selectedBooking.getLastName(),
            selectedBooking.getDate(),selectedBooking.getSlot(),selectedBooking.getCount());
//            int index = list.indexOf(selectedBooking);
//            System.out.println(index);
            boolean flag = true;
            while(flag){
                editMenu();
                int input = scanner.nextInt();
                switch(input){
                    case 1:
                        System.out.print("Enter updated first name : ");
                        String firstName = scanner.nextLine();
                        updatedBooking.setFirstName(firstName);
                        break;
                    case 2:
                        System.out.print("Enter updated last name : ");
                        String lastName = scanner.nextLine();

                        updatedBooking.setLastName(lastName);
                        break;
                    case 3:
                        System.out.print("Enter updated date in (23-May-2023) format : ");
                        String date = scanner.nextLine();
                        updatedBooking.setdate(date);
                        break;
                    case 4:
                        System.out.print("Enter updated slot : ");
                        String slot = scanner.next();
                        updatedBooking.setFirstName(slot);
                        break;
                    case 5:
                        System.out.print("Enter updated count : ");
                        int count = scanner.nextInt();
                        updatedBooking.setCount(count);
                        break;
                    default : flag = false;
                        break;
                }
            }
            if(booking.updateData(selectedBooking, updatedBooking)){
                System.out.println("Your details are edited and are listed below");
                System.out.println(updatedBooking.getBookingId()+"\t"+updatedBooking.getFirstName()+"\t" +
                        updatedBooking.getLastName()+"\t"+updatedBooking.getDate()+"\t" +
                        updatedBooking.getSlot()+"\t"+updatedBooking.getDate()+"\t" +
                        updatedBooking
                                .getCount());
            }

        }
        return status;
    }

    public static boolean deleteSlot(){
        System.out.println("Enter the bookingId of the slot to delete : ");
        long bookingId = scanner.nextLong();
        boolean status = booking.deleteSlot(bookingId);
        return status;
    }

    public static boolean deleteAllSlots(){
        boolean status = booking.deleteAllSlots();
        return status;
    }

//    Functin to get booking ID by name and date
    public static long getBookingIDByNameAndDate(){
        System.out.print(" Enter your first name : ");
        String firstName = scanner.next();
//        Referenced from : https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo
        scanner.nextLine();

        System.out.print("Enter seat booked date in \"dd-MONTH-yyyy\" format (Ex: 28-May-2023) : ");
        String date = scanner.nextLine();


        long id = booking.getBookingIdByNameAndDate(firstName,date);
        return id;
    }

    public static void displayAllData(){
        List<BookingDetails> list = booking.getDetails();
        System.out.println("BookingId\tFirst Name\tLast Name\t Slot\t Date\tCount");
//        For loop syntax referred from : https://git.cs.dal.ca/courses/2023-summer/csci-5308/demo/dbmockdemo/-/blob/master/src/main/java/Main.java
        for(BookingDetails currentBooking : list){
            System.out.println(currentBooking.getBookingId()+"\t"+currentBooking.getFirstName()+"\t" +
                    currentBooking.getLastName()+"\t"+currentBooking.getSlot()+"\t"+currentBooking.getDate()+"" +
                    "\t"+currentBooking.getCount());
        }
    }
//Menu to display when user selectes edit slot option
    public static void editMenu(){
        System.out.println("Select the fields you wish to edit");
        System.out.println("1. First Name");
        System.out.println("2. Last name");
        System.out.println("3. Date");
        System.out.println("4. Slot");
        System.out.println("5. Count");
        System.out.println("Press 6 to finish editing");
    }

    public static void getCountByDate(){
        System.out.print("Enter the date(Ex : 25-May-2023 format) to get the count of seats : ");
        String date = scanner.next();
        System.out.println(date);
        int count = booking.getCountByDate(date);
        System.out.println("Count of seats are:"+count);
    }

    public static void menu(){

        System.out.println("Press 1 - To book the slot");
        System.out.println("Press 2 - View the booked slot");
        System.out.println("Press 3 - Edit the slot");
        System.out.println("Press 4 - To delete particular slot");
        System.out.println("Press 5 - Clear all the slots");
        System.out.println("Press 6 - Forgot Booking ID");
        System.out.println("Press 7 - To view all the bookings");
        System.out.println("Press 8 - Get total number of seats booked");
        System.out.println("Press 9 - Get number of seats by date");
        System.out.println("Press 0 key to exit");
        System.out.print("Please enter your input : ");

        int input = scanner.nextInt();

        switch (input){
            case 1 : boolean status = booking.newBooking();
                if(status){
                    System.out.println("Slot was booked successfully\n");
                    menu();
                }
                else{
                    System.out.println("Something went wrong. Please try again");
                    System.exit(0);
                }
                break;
            case 2:
                System.out.println("The details are: ");
                displayData();
                break;

            case 3:boolean editStatus = editSlot();
                    if(editStatus){
                        System.out.println("Slot was successfully edited");
                        menu();
                    }
                    else{
                        System.out.println("Something went wrong. Please try again");
                        System.exit(0);
                    }
                    break;
            case 4: boolean deleteStatus = deleteSlot();
                    if(deleteStatus){
                        System.out.println("Slot was deleted successfully");
                        menu();
                    }
                    else{
                        System.out.println("Entered ID did not exist. Please enter a valid Id");
                        menu();
                    }
                    break;
            case 5: boolean deleteAllSlots = deleteAllSlots();
                    if(deleteAllSlots){
                        System.out.println("All slots are deleted successfully");
                        menu();
                    }
                    else{
                        System.out.println("Something went wrong. Please try again later");
                        System.exit(0);
                    }
                    break;
            case 6: long id = getBookingIDByNameAndDate();
                    if(id==0){
                        System.out.println("Credentials do not match. Please try again");
                        System.exit(0);
                    }
                    else{
                        System.out.println("Your booking Id is : "+id);
                        menu();
                    }
                    break;
            case 7: displayAllData();
                    menu();
                    break;
            case 8: int value = booking.getTotalCount();
                    System.out.println("Total Seats booked are : "+value);
                    menu();
                    break;
            case 9: getCountByDate();
                    menu();
                    break;
            default : System.exit(0);
        }
    }
}