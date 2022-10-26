package com.malikazizali.androidtesting

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class RegisterTest{
    private lateinit var reg : Register

    @Before
    fun setUp(){
        reg = Register
    }

    @Test
    fun valid_reg(){
        val result = reg.validateRegistrationInput("Kiko","kiko@gmail.com","ah1rAB2","ah1rAB2")
        assertEquals(true,result)
    }

    @Test
    fun empty_username(){
        val result = reg.validateRegistrationInput(
            username = "",
            email = "a@gmail.com",
            password = "ah1rAB2",
            confirmedPassword = "ah1rAB2")
        assertEquals(false,result)
    }

    @Test
    fun empty_email(){
        val result = reg.validateRegistrationInput(
            username = "a",
            email = "",
            password = "ah1rAB2",
            confirmedPassword = "ah1rAB2")
        assertEquals(false,result)
    }

    @Test
    fun empty_password(){
        val result = reg.validateRegistrationInput(
            username = "a",
            email = "a@gmail.com",
            password = "",
            confirmedPassword = "ah1rAB2")
        assertEquals(false,result)
    }

    @Test
    fun empty_confirmedPassword(){
        val result = reg.validateRegistrationInput(
            username = "a",
            email = "a@gmail.com",
            password = "ah1rAB2",
            confirmedPassword = "")
        assertEquals(false,result)
    }

    @Test
    fun exisiting_username(){
        val result = reg.validateRegistrationInput(
            username = "Maleek",
            email = "a@gmail.com",
            password = "a",
            confirmedPassword = "a")
        assertEquals(false,result)
    }

    @Test
    fun exisiting_email() {
        val result = reg.validateRegistrationInput(
            username = "a",
            email = "maleek@gmail.com",
            password = "ah1rAB2",
            confirmedPassword = "ah1rAB2"
        )
        assertEquals(true,result)
    }

    @Test
    fun password_less_than_6_false(){
        val result = reg.validateRegistrationInput(
            username = "a",
            email = "a@gmail.com",
            password = "a",
            confirmedPassword = "a")
        assertEquals(false,result)
    }

    @Test
    fun long_password(){
        val result = reg.validateRegistrationInput(
            username = "a",
            email = "a@gmail.com",
            password = "23j0tinmeogmoew94jgiwmeokfmi30n2oinfiefkwoemfpwefwpeigneipwgn3wk2r3",
            confirmedPassword = "23j0tinmeogmoew94jgiwmeokfmi30n2oinfiefkwoemfpwefwpeigneipwgn3wk2r3")
        assertEquals(false,result)
    }

    @Test
    fun no_uppercase_pass(){
        val result = reg.validateRegistrationInput(
            username = "a",
            email = "a@gmail.com",
            password = "aaaaaa",
            confirmedPassword = "aaaaaa")
        assertEquals(false,result)
    }

    @Test
    fun no_lowercase_pass(){
        val result = reg.validateRegistrationInput(
            username = "a",
            email = "a@gmail.com",
            password = "BBBBBBBBBB",
            confirmedPassword = "BBBBBBBBBB")
        assertFalse(result)
    }

    @Test
    fun short_pass(){
        val result = reg.validateRegistrationInput(
            username = "a",
            email = "a@gmail.com",
            password = "1",
            confirmedPassword = "1")
        assertFalse(result)
    }
}