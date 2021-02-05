package com.test.pfbtest

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import com.test.pfbtest.model.DBContract
import com.test.pfbtest.model.DBModel

/**
 * Created by Yogesh Y. Nikam on 05/02/21.
 */
class DocsDBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    @Throws(SQLiteConstraintException::class)
    fun insertDoc(DB: DBModel): Boolean {
        // Gets the data repository in write mode
        val db = writableDatabase

        // Create a new map of values, where column names are the keys
        val values = ContentValues()
        values.put(DBContract.DocsEntry.ID, DB.id)
        values.put(DBContract.DocsEntry.PUBLICATION_DATE, DB.pdate)
        values.put(DBContract.DocsEntry.ARTICLE_TYPE, DB.article_type)

        val newRowId = db.insert(DBContract.DocsEntry.TABLE_NAME, null, values)

        return true
    }


    fun readAllDocs(): ArrayList<DBModel> {
        val dbModel = ArrayList<DBModel>()
        val db = writableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery("select * from " + DBContract.DocsEntry.TABLE_NAME, null)
        } catch (e: SQLiteException) {
            db.execSQL(SQL_CREATE_ENTRIES)
            return ArrayList()
        }

        var id: String
        var name: String
        var age: String
        if (cursor!!.moveToFirst()) {
            while (cursor.isAfterLast == false) {
                id = cursor.getString(cursor.getColumnIndex(DBContract.DocsEntry.ID))
                name = cursor.getString(cursor.getColumnIndex(DBContract.DocsEntry.PUBLICATION_DATE))
                age = cursor.getString(cursor.getColumnIndex(DBContract.DocsEntry.ARTICLE_TYPE))

                dbModel.add(DBModel(id, name, age))
                cursor.moveToNext()
            }
        }
        return dbModel
    }

    companion object {
        // If you change the database schema, you must increment the database version.
        val DATABASE_VERSION = 1
        val DATABASE_NAME = "PFBTest.db"

        private val SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DBContract.DocsEntry.TABLE_NAME + " (" +
                    DBContract.DocsEntry.ID + " TEXT PRIMARY KEY," +
                    DBContract.DocsEntry.PUBLICATION_DATE + " TEXT," +
                    DBContract.DocsEntry.ARTICLE_TYPE + " TEXT)"

        private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + DBContract.DocsEntry.TABLE_NAME
    }

}