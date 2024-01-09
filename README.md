Booking Management System

How to run the Application : 
This is a Maven application. Code is not compiled. Source code is uploaded instead. Users need to clone the code into their local machine and run the program in IntelliJ editor.

Application flow:
When we run main.java file, command line will show list of options to user. It takes integer inputs to select particular option. Since data is stored in the variable, value at the starting of the program would be zero. Users can start by "Booking a slot" as the starting point. And later perform other operations. 

Pattern of flow of application is in the following manner:
1. Application starts from main function.
2. Input from the user is passed to booking class. 
3. Booking class calls createConnection class which implments createConnectionInterface.This is assumed to be the createConnection written for accessing JDBC/Database.
4. Result class acts as the source of truth for modifying data. This is assumned to be the data storage which is mocked in testing.

About the Application;
Aplication developed is a Booking Management System. Application takes the input from the user through the command line. User can 
1.Book a slot
2.View booked slot
3.Edit the slot
4.Delete the slot
5.Clear all the entries
6.Delete particular entry
7. View all the bookings
8.Get the count of total seats reserved.

All the data entered by the user will be stored in the list and CRUD operations are performed on the list. Mockito is used to mock the database and do the testing of business logics.

Application consists of following files:
1. DataModel.BookingDetails - BookingDetails is a modal class in which properties of the booking object is defined. It conatins fields like First name, last name, slot, count, booking id ,date. All are private methods and are accessed using getter and setter methods.

2. Booking - Booking class is used to get the data from the interface for all the user inputs. This class basically takes input from the main function and called the interface methods to perform the actions.

3. CreateConnection : CreateConnection implements create connection interface. This is ideally used to get the data from the database and other third party sources. Since no real DB is used, it will call the methods that will edit the list.

4. Main - Main methods coonatins all the switch cases and print statements for guiding the user.

5. Result - This is the class where actual editing to the list happens. This class is not accessible to booking directly. It has to use the createConnection method in order to perform CRUD operations.

Based on the classes,2 test cases are written for 2 clasees.
1. BookingTest - This class is used to test the methods of Booking class which conatins the code to business logic. Mock object of createConnection is created in order to mock the working of the database. Any method in booking Class that uses create connection will be mocked in Test cases.

2. CreateConnectionTest - Tests 2 methods. openConnection and ClosedConnection

