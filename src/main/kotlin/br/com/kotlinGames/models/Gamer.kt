package br.com.kotlinGames.models

import kotlin.random.Random

data class Gamer(var name:String, var email: String){
    var dateOfBirth: String? = null
    var user: String? = null
        set(value) {
            field = value
            if (identifier.isNullOrBlank()){
                createId()
            }
        }
    var identifier: String? = null
        private set

    constructor(name: String, email: String, dateOfBirth: String, user: String): this(name, email){
        this.dateOfBirth = dateOfBirth
        this.user = user
        createId()
    }

    init {
        if (name.isNullOrBlank()){
            throw IllegalArgumentException("Name can't be null or blank")
        }
        this.email = validateEmail()
    }

    override fun toString(): String {
        return "$name\n$email\n$dateOfBirth\n$user\n$identifier"
    }

    fun createId(){
        val num = Random.nextInt(10000)
        val tag = String.format("%04d", num)

        this.identifier = "$user#$tag"
    }

    fun validateEmail(): String{
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(this.email)){
            return email
        }else{
            throw IllegalArgumentException("Invalid Email")
        }
    }

}
