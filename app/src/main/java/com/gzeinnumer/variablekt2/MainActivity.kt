package com.gzeinnumer.variablekt2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    //`part1
    fun variable(){
        //VARIABLE ---------------------------------------------------------------------------------
        val company_0 : String = "Dicoding"
        val company_1 = "Dicoding"

        val company_2 = "Dicoding"
//        company_2 = "JetBrains" //error, variable tidak bisa diganti

        var company_3 = "Dicoding"
        company_3 = "JetBrains" //sukses, value dari company adalah “JetBrains”

        val student_1 = Student_1()
        student_1.studentName = "rohmen"
        val name = student_1.studentName

        val student_2 = Student_2()
        student_2.studentName = "rohmen"
        val name_2 = student_2.studentName
    }

    class Student_1 { var studentName : String = "" }

    class Student_2 {
        var studentName: String = ""
            get() = field.toUpperCase()
            set(value) {
                field = "Name: $value"
            }
    }


    //part 2
    //if
    fun ifCondition(){

        //IF ---------------------------------------------------------------------------------------
        val a = 3
        val b = 2
        //type 1
        if (a > b) {
            print("a is greater than b")
        } else {
            print("a is not greater than b")
        }

        //type 2
        val result = if (a > b) a else b

        //WHEN -------------------------------------------------------------------------------------
        val x = 4
        when (x) {
            1 -> print("x == 1")
            2 -> print("x == 2")
            else -> {
                print("x is neither 1 nor 2")
            }
        }

        val validNumbers = 4

        when (x) {
            in 1..10 -> print("x is in the range")
            validNumbers -> print("x is valid")
            !in 10..20 -> print("x is outside the range")
            else -> print("none of the above")
        }

        //LOOP -------------------------------------------------------------------------------------
        for (number in 1..5) {
            print(number)
        } //12345

        for (number in 1 until 5) {
            print(number)
        } //1234

        for (number in 0..10 step 2) {
            print(number)
        }//02468

        for (number in 9 downTo 0 step 2) {
            print(number)
        }//97531

        val arrayNumbers = intArrayOf(1,3,5,7,9)

        //menggunakan withIndex()
        for ((index, value) in arrayNumbers.withIndex()) {
            print("bilangan $value adalah indeks ke-$index\n")
        }

        //menggunakan indices
        for (index in arrayNumbers.indices) {
            print("bilangan ${arrayNumbers[index]} adalah indeks ke-$index\n")
        }

        //REPEAT -----------------------------------------------------------------------------------
        repeat(3) {
            println("Kotlin!")
        }

        //WHILE LOOPS ------------------------------------------------------------------------------
        val condition = true
        while (condition) {
            //action
        }

        do {
            //action
        } while (condition)

    }
}

//CLASSES ------------------------------------------------------------------------------------------
//type one
class Users_1 (name : String, email: String)

class Users_2 (name : String, email: String){
    init {
        //action
    }
    constructor(name : String, email: String, student: Users_2) : this(name, email){

    }
}

//type 2
open class Users_3{
    open fun userAddress(): String{
        return "Bandung"
    }
}
open class Student : Users_3(){
    override fun userAddress(): String {
        return super.userAddress()
    }
}

class InformaticsStudent : Student(){
    override fun userAddress(): String {
        return super.userAddress()
    }
}

//type 3
open class Users_4{
    open fun userAddress(){

    }
}

abstract class Student_2 : Users_4(){
    override abstract fun userAddress()
}

//type 4
class User_5 {
    inner class Name(private val name: String) {
        fun printName(){
            println("Your Name Is $name")
        }
    }
}

class Student_3{
    init {
        val user_1 = User_5()
        user_1.Name("Zein").printName()

        val user_2 = User_5().Name("Zein")
        user_2.printName()

    }
}

//type 5
//to make programmer data
enum class User_6(val field: String) {
    NAME("Alfian Yusuf Abdullah") {
        override fun print() {
            println("Your Name is $field")
        }
    },
    EMAIL("alfian@dicoding.com") {
        override fun print() {
            println("Your Email is $field")
        }
    },
    PHONE("082208220822") {
        override fun print() {
            println("Your Phone is $field")
        }
    };

    abstract fun print()
}


//type 6
//Semua subclass dari Sealed Class harus berada pada berkas yang sama di mana Sealed Class tersebut dideklarasikan.
//Secara default Sealed Class memiliki modifier abstract.
//Sealed Class tidak diijinkan untuk memiliki non-private constructor karena secara default Sealed Class memiliki private constructor.
sealed class Operation {
    class Add(val value: Int) : Operation()
    class Divide(val value: Int) : Operation()
    class Multiply(val value: Int) : Operation()
    class Substract(val value: Int) : Operation()
}

//jika operation true/tau ber isi
fun execute(x: Int, operation: Operation): Int = when (operation) {
    is Operation.Add -> operation.value + x
    is Operation.Divide -> operation.value / x
    is Operation.Substract -> operation.value - x
    is Operation.Multiply -> operation.value * x
}

fun main(){
    val operation = Operation.Add(10)
    val result = execute(10, operation)
    println("Result $result")
}

//type 7
//data clases
data class Student_4(var name:String = "Rohmen",var major:String,var phone:String)

fun main1(){
    val student = Student_4("Rohmen", "Informatics Engineering", "085xxxxxxxxx")
    println("Your name is ${student.name}")
    println("Your major is ${student.major}")
    println("Your phone is ${student.phone}")
}

//type 8 object to variable
fun main_2(){
    val student =Student_4("Zein","Android","082385804045")

    val (name, major, phone) = student

    val strName = student.component1()
    var strMajor = student.component2()
    var strPhone = student.component3()
}

//type 9
fun View.visible() {
    visibility = View.VISIBLE
}

fun main_3(){
    val button : Button? =  null
    button?.visible()
}

//type 10 Generics
class TypedClass<T>(parameter: T) {
    val value: T = parameter
}

fun main_4(){
    val stringType = TypedClass("Hi Kotlin!")
    val intType = TypedClass(7)
    val nullType = TypedClass<String?>(null)
}

//type 11 Variance
//dipakai lansung oleh function
class TypedClassIn<in T> {
    fun toString(value: T): String {
        return value.toString()
    }
}

//dipaka lansugn oleh contructor
class TypedClassOut<out T>(private val value: T) {
    fun get(): T {
        return value
    }
}

//type 12 Observable
class User_7{
    var name: String by Delegates.observable("<No name>"){
        property, oldValue, newValue -> println("$oldValue -> $newValue")
    }
}

fun main_5(){
    val user = User_7()
    user.name = "satu"
    user.name = "dua"

    //<no name> -> first
    //first -> second
}

//type 13 Hashmap
class User(val map: Map<String, Any?>) {
    
    val name: String by map
    val age: Int     by map
}

val user_8 = User(mapOf(
    "name" to "Rohmen",
    "age"  to 22
))

//type 14 lambda
val message = { println("Happy to learn Kotlin!") }
val message1 = { params: String -> println(params) }

fun main_6(){
    message
    message1("I Love You")
}
//variable bisa lansung dipanggil

//type 15
fun main_7(){

    val list: HashMap<Int, String>? = null
    val index = 1
    val element = "String"
//jika mau memakai 2 param
    list.mapIndexed { index, element ->
        "Indeks $index bernilai $element"
    }
//jika cuma mau makai 1 param
    list.mapIndexed { _, element ->
        "Nilai: $element"
    }
}

//type 16
fun getNickName(fullname : String, nickName: String, yourName: (String, String) -> String){
    val result = yourName(fullname, nickName)
    println(result)
}

fun main_8(){
    val name: (String, String) -> String = {
        realName, heroName -> "My Name is $realName and my name is $heroName"
    }

    getNickName("M. Fadli Zein", "GZN", name)
}

//type 17
fun main_9(){
    val a =" Zein"
    //cara lama
    if (a != null && a.length > 0) {
        print("String of length ${a.length}")
    } else {
        print("Empty string")
    }
    //cara baru
    if (a?.length) {
        print("String of length ${a.length}")
    } else {
        print("Empty string")
    }

    val user = "Zein"
    val company: String?
    //cara lama
    if (user != null){
        company = user.company
    } else{
        company = "Default name"
    }
    //cara baru
    val name: String = user.company ?: "default name"


}