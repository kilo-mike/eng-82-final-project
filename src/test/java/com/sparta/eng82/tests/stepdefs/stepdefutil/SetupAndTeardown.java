package com.sparta.eng82.tests.stepdefs.stepdefutil;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class SetupAndTeardown {

    @Before
    public void setUp() {
        DriverManager.setUp();
    }

    @After
    public void tearDown() {
        DriverManager.tearDown();
    }
}
