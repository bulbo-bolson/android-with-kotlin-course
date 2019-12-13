package com.example.kotlin.model

import android.util.Log

class Employee {

    var name: String = "nodefinido"
    var department: String = "systems"
    var active = true
    var salary = 100
        get() {
            Log.i("Getter being used", "Value = $salary")
            return field
        }
        set(value) {
            Log.i("Setter being used", "New value = $salary")
            field = if (value < 0) 0 else value
        }

    override fun toString(): String {
        return "Employee(name='$name', department='$department', active=$active)"
    }




}

open class Book(val title: String, var copiesSold: Int) {
    var author: String? = null
    constructor(title: String, copiesSold: Int, author: String) : this(title, copiesSold) {
        this.author = author
    }

    init {
        Log.i("book", "inside init block")
        val book1 = Book("some title", 20)
        val book2 = Book("another title", 30)
        val books: MutableSet<Book> = mutableSetOf(book1, book2)
        val book3 = Book("another title 2", 40)
        books.add(book3)
    }

    open fun getIndexPage(): String {
        return "retrieving index page"
    }
}

class PocketBook(title: String, copiesSold: Int): Book(title, copiesSold) {
    override fun getIndexPage(): String {
        return super.getIndexPage()
    }
}