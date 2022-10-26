package com.malikazizali.androidtesting

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class LoginTest{
    private lateinit var login : Login

    @Before
    fun setUp(){
        login = Login
    }

    @Test
    fun emptyUsername() {
        val username = ""
        val result = login.validateLogin(username)
        assertEquals("Please enter username", result)
    }

    @Test
    fun shortUsername() {
        val username = "A"
        val result = login.validateLogin(username)
        assertEquals("Username is too short", result)
    }

    @Test
    fun longUsername() {
        val username = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
        val result = login.validateLogin(username)
        assertEquals("Username is too long", result)
    }

    @Test
    fun ValidUsername() {
        val username = "RoyalWeaboo"
        val result = login.validateLogin(username = username)
        assertEquals("Login Success", result)
    }

    @Test
    fun emptyEmail() {
        val email = ""
        val result = login.validateLogin(email = email)
        assertEquals("Email cant be empty !", result)
    }
}