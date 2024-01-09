package org.example;

import org.example.DataModel.BookingDetails;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class CreateConnectionTest {

//    Referenced from :
//    https://git.cs.dal.ca/courses/2023-summer/csci-5308/demo/dbmockdemo/-/blob/master/src/test/java/service/DBServiceImplTest.java
    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }{


    }

    @Test
    public void openConnectionTest(){
        CreateConnection createConn = new CreateConnection();
        assertEquals(true, createConn.openConnection());
    }

    @Test
    public void closeConnectionTest(){
        CreateConnection createConn = new CreateConnection();
        assertEquals(true, createConn.closeConnection());
    }


}