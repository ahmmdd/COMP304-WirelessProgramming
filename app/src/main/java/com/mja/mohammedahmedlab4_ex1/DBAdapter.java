package com.mja.mohammedahmedlab4_ex1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter {
    static final String KEY_TESTID = "testid";
    static final String KEY_PATIENTID="patientid";
    static final String KEY_STAFFID="staffid";
    static final String KEY_DOCTORID="doctorid";
    static final String KEY_ROOM="room";
    static final String KEY_BPH="BPH";
    static final String KEY_BPL="BPL";
    static final String KEY_TEMPRATURE="temprature";
    static final String KEY_RBCC="PR";
    static final String KEY_FNAME = "firstname";
    static final String KEY_LNAME = "lastname";
    static final String KEY_DEPT = "department";
    static final String KEY_USER = "username";
    static final String KEY_PASS = "password";
    static final String KEY_POS = "position";
    static final String TAG = "DBAdapter";

    static final String DATABASE_TABLE = "contacts";
    static final int DATABASE_VERSION = 1;

    static final String DATABASE_NAME = "Hospital.db";
    //static final String DATABASE_TABLE = "contacts";


    //table names
    private static final String tables[]={"Patient","Test","Staff","Doctor","Usertable"};
    //corresponding create table queries
    private static final String tableCreatorString[] ={"CREATE TABLE Patient (patientid INTEGER PRIMARY KEY , firstname TEXT, lastname TEXT,department TEXT,doctorid INTEGER,room TEXT);",
            "CREATE TABLE Test (testid INTEGER PRIMARY KEY ,patientid INTEGER, BPH TEXT, BPL TEXT,PR TEXT,temprature TEXT);",
            "CREATE TABLE Staff (staffid INTEGER PRIMARY KEY , firstname TEXT,lastname TEXT,department TEXT);",
            "CREATE TABLE Doctor (doctorid INTEGER PRIMARY KEY  , firstname TEXT,lastname TEXT,department TEXT);",
            "CREATE TABLE Usertable(username PRIMARYKEY,password TEXT,position TEXT);"};

    final Context context;

    DatabaseHelper DBHelper;
    SQLiteDatabase db;

    public DBAdapter(Context ctx)
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);

    }

    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            for (int i=0;i<tables.length;i++)
                db.execSQL("DROP TABLE IF EXISTS " + tables[i]);
            for (int i=0;i<tables.length;i++)
                db.execSQL(tableCreatorString[i]);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS contacts");
            onCreate(db);
        }
    }

    //---opens the database---
    public DBAdapter open() throws SQLException
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //---closes the database---
    public void close()
    {
        DBHelper.close();
    }

    //---insert a user into the database---
    public long insertUser(String uname, String pass,String pos)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_USER, uname);
        initialValues.put(KEY_PASS, pass);
        initialValues.put(KEY_POS,pos);
        return db.insert("Usertable", null, initialValues);
    }
    //---insert a patient into the database---
    public long insertPatient(Integer pid,String fname, String lname,Integer did,String dept,String room)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_PATIENTID,pid);
        initialValues.put(KEY_FNAME, fname);
        initialValues.put(KEY_LNAME, lname);
        initialValues.put(KEY_DOCTORID,did);
        initialValues.put(KEY_DEPT, dept);
        initialValues.put(KEY_ROOM,room);
        return db.insert("Patient", null, initialValues);
    }
    //---insert a doctor into the database---
    public long insertDoctor(Integer id,String fname, String lname,String dept)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_DOCTORID,id);
        initialValues.put(KEY_FNAME, fname);
        initialValues.put(KEY_LNAME, lname);
        initialValues.put(KEY_DEPT, dept);
        return db.insert("Doctor", null, initialValues);
    }
    //---insert a NURSE into the database---
    public long insertStaff(Integer id,String fname, String lname,String dept)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_STAFFID,id);
        initialValues.put(KEY_FNAME, fname);
        initialValues.put(KEY_LNAME, lname);
        initialValues.put(KEY_DEPT, dept);
        return db.insert("Staff", null, initialValues);
    }
    //---insert a Test into the database---
    public long insertTest(Integer testid,Integer patientid,String BPH, String BPL,String temp)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_TESTID, testid);
        initialValues.put(KEY_PATIENTID,patientid);
        initialValues.put(KEY_BPH, BPH);
        initialValues.put(KEY_BPL,BPL);
        initialValues.put(KEY_TEMPRATURE,temp);
        return db.insert("Test", null, initialValues);
    }

    //---deletes a particular contact---
   /* public boolean deleteContact(long rowId)
    {
        return db.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
    }*/

    //---retrieves all the contacts---
    public Cursor getAllUsers()
    {
        return db.query("Patient", new String[] {KEY_PATIENTID, KEY_FNAME,KEY_LNAME,KEY_DEPT,KEY_DOCTORID,KEY_ROOM
        }, null, null, null, null, null);
    }
    //---retrieves all the contacts---
    public Cursor getTest(Integer pid)
    {
        return db.query("Test", new String[] {KEY_TESTID, KEY_PATIENTID,KEY_BPH,KEY_BPL,KEY_TEMPRATURE,KEY_RBCC
        }, KEY_PATIENTID + "=" + pid, null, null, null, null);
    }
    public Cursor getUser(String user,String pass)
    {
        return db.query("Usertable", new String[] {KEY_USER, KEY_PASS,KEY_POS,
        }, KEY_USER + " = ?" + " AND "+KEY_PASS +" = ?"  ,new String[]{user,pass}, null, null, null);
    }
    //---retrieves a particular contact---
   /* public Cursor getContact(long rowId) throws SQLException
    {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[] {KEY_ROWID,
                KEY_NAME, KEY_EMAIL}, KEY_ROWID + "=" + rowId, null,
                null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }*/
    //---updates a contact---
   /* public boolean updateContact(long rowId, String name, String email)
    {
        ContentValues args = new ContentValues();
        args.put(KEY_NAME, name);
        args.put(KEY_EMAIL, email);
        return db.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
    }*/

}
