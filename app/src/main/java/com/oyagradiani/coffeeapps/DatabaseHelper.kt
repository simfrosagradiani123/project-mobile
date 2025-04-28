package com.oyagradiani.coffeeapps


import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "coffeeapps.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_USER = "users"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = """
            CREATE TABLE $TABLE_USER (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                email TEXT UNIQUE,
                password TEXT
            )
        """.trimIndent()
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_USER")
        onCreate(db)
    }

    fun registerUser(email: String, password: String): Boolean {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("email", email)
            put("password", password)
        }
        val result = db.insert(TABLE_USER, null, values)
        return result != -1L
    }

    fun checkUser(email: String, password: String): Boolean {
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_USER WHERE email = ? AND password = ?", arrayOf(email, password))
        val exists = cursor.count > 0
        cursor.close()
        return exists
    }
}
