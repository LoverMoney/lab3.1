package com.example.a31.FindStudentFragment

import org.junit.Test
import org.junit.Assert.*

fun isOnlineInterface(): Boolean {
    return false
}
fun checkStudentData(Surname: String, Name: String, Group: String) : Boolean {
    if (Surname == "")
        throw Exception("Поле фамилии не может быть пустым")
    else if (Name == "")
        throw Exception("Поле имени не может быть пустым")
    else if (Group == "")
        throw Exception("Поле группы не может быть пустым")
    val regex = "^[а-яА-Я]+$".toRegex()
    if (regex.matches(Surname)==false)
        throw Exception("В поле фамилии допущена ошибка")
    if (regex.containsMatchIn(Name)==false)
        throw Exception("В поле имени допущена ошибка")
    if (isOnlineInterface())
        throw Exception("Нет соединения с интернетом")
    return true
}
fun ConnectionLostClick (Surname: String, Name: String, Group: String)
{
    if (checkStudentData(Surname,Name,Group))
    {
        if (isOnlineInterface())
        {
            //Все гуд
        }
        else
            throw Exception("Потеряно соединение с интернетом")
    }

}
class ProgressDataTest {
    @Test
    fun Test_001_CheckProgressData_BaseFlow() {
        var Surname:String = "Хорешко"
        var Name:String = "Дмитрий"
        var Group:String = "540"
        var expectedReturnValue:Boolean = true
        var actualReturnValue:Boolean = false
        actualReturnValue= checkStudentData(Surname,Name,Group)
        assertEquals(expectedReturnValue, actualReturnValue)
    }
    @Test
    fun Test_002_CheckProgressData_EmptySurname() {
        var Surname:String = ""
        var Name:String = "Дмитрий"
        var Group:String = "540"
        var expectedExceptionMessage:String = "Поле фамилии не может быть пустым"
            val exception = assertThrows(Exception::class.java) {
                checkStudentData(Surname,Name,Group)
            }
        assertEquals(expectedExceptionMessage, exception.message)
    }
    @Test
    fun Test_003_CheckProgressData_EmptyName() {
        var Surname:String = "Хорешко"
        var Name:String = ""
        var Group:String = "540"
        var expectedExceptionMessage:String = "Поле имени не может быть пустым"
        val exception = assertThrows(Exception::class.java) {
            checkStudentData(Surname,Name,Group)
        }
        assertEquals(expectedExceptionMessage, exception.message)
    }
    @Test
    fun Test_004_CheckProgressData_EmptyGroup() {
        var Surname:String = "Хорешко"
        var Name:String = "Дмитрий"
        var Group:String = ""
        var expectedExceptionMessage:String = "Поле группы не может быть пустым"
        val exception = assertThrows(Exception::class.java) {
            checkStudentData(Surname,Name,Group)
        }
        assertEquals(expectedExceptionMessage, exception.message)
    }
    @Test
    fun Test_005_CheckProgressData_WrongSurname() {
        var Surname:String = "Хоре1шко234dfg@#"
        var Name:String = "Дмитрий"
        var Group:String = "540"
        var expectedExceptionMessage:String = "В поле фамилии допущена ошибка"
        val exception = assertThrows(Exception::class.java) {
            checkStudentData(Surname,Name,Group)
        }
        assertEquals(expectedExceptionMessage, exception.message)
    }
    @Test
    fun Test_006_CheckProgressData_WrongName() {
        var Surname:String = "Хорешко"
        var Name:String = "Д1митрий"
        var Group:String = "540"
        var expectedExceptionMessage:String = "В поле имени допущена ошибка"
        val exception = assertThrows(Exception::class.java) {
            checkStudentData(Surname,Name,Group)
        }
        assertEquals(expectedExceptionMessage, exception.message)
    }
    @Test
    fun Test_007_CheckProgressData_ConnectionLost() {
        var Surname:String = "Хорешко"
        var Name:String = "Дмитрий"
        var Group:String = "540"
        var expectedExceptionMessage:String = "Потеряно соединение с интернетом"
        val exception = assertThrows(Exception::class.java) {
            ConnectionLostClick(Surname,Name,Group)
        }
        assertEquals(expectedExceptionMessage, exception.message)
    }
}