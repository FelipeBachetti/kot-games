package br.com.kotlinGames.models

import org.example.br.com.kotlinGames.models.Game
import kotlin.random.Random
import java.util.*

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

    val searchedGames:MutableList<Game?> = mutableListOf<Game?>()

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

    companion object{
        fun createGamer(scan: Scanner): Gamer{
            println("Digite seu nome: ")
            val name = scan.nextLine()
            println("Digite seu e-mail: ")
            val email = scan.nextLine()
            println("Deseja completar o cadastro agora? (s/n)")
            val op = scan.nextLine()
            if(op.equals("s", true)){
                println("Digite sua data de nascimento: ")
                val date = scan.nextLine()
                println("Digite seu nome de usuário: ")
                val user = scan.nextLine()
                return Gamer(name, email, date, user)
            }
            return Gamer(name, email)
        }
    }

}
