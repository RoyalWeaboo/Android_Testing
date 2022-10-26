package com.malikazizali.androidtesting

object Register {
    private val existingUsers = listOf("Maleek", "Royal", "Weaboo")
    private val existingEmail = listOf("Maleek@gmail.com","Royal@gmail.com","Weaboo@gmail.com")

    fun validateRegistrationInput(
        username : String,
        email : String,
        password : String,
        confirmedPassword : String
    ) : Boolean{
        if(username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmedPassword.isEmpty()){
            return false
        }
        when{
            username in existingUsers -> return false
            email in existingEmail -> return false
            password != confirmedPassword -> return false
            password.length < 6 -> return false
            password.length > 50 -> return false
            password.filter { it.isUpperCase()}.isEmpty() -> return false
            password.filter { it.isLowerCase()}.isEmpty() -> return false
            password.count { it.isDigit() } < 2 -> return false
        }
        return true
    }

}