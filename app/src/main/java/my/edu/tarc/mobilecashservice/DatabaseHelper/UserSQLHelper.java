package my.edu.tarc.mobilecashservice.DatabaseHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import my.edu.tarc.mobilecashservice.Contract.UserContract;
import my.edu.tarc.mobilecashservice.Entity.UserRecord;

/**
 * Created by Nan Fung Lim on 31/12/2017.
 */

public class UserSQLHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "users.db";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + UserContract.User.TABLE_NAME + "(" +
                    UserContract.User.COLUMN_USERID + " bigint," +
                    UserContract.User.COLUMN_USERNAME + " TEXT," +
                    UserContract.User.COLUMN_USERPASSWORD + " TEXT," +
                    UserContract.User.COLUMN_IC + " TEXT," +
                    UserContract.User.COLUMN_EMAIL + " TEXT," +
                    UserContract.User.COLUMN_PHONE + " bigint)";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + UserContract.User.TABLE_NAME;
    private String[] allColumn = {
            UserContract.User.COLUMN_USERID,
            UserContract.User.COLUMN_USERNAME,
            UserContract.User.COLUMN_USERPASSWORD,
            UserContract.User.COLUMN_IC,
            UserContract.User.COLUMN_EMAIL,
            UserContract.User.COLUMN_PHONE
    };
    public UserSQLHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onUpgrade(db, oldVersion, newVersion);
    }

    public void insertUser(UserRecord userRecord){
        //Prepare record
        ContentValues values = new ContentValues();
        values.put(UserContract.User.COLUMN_USERID, userRecord.getUser_id());
        values.put(UserContract.User.COLUMN_USERNAME, userRecord.getUser_name());
        values.put(UserContract.User.COLUMN_USERPASSWORD, userRecord.getPassword());
        values.put(UserContract.User.COLUMN_IC, userRecord.getIc_number());
        values.put(UserContract.User.COLUMN_EMAIL, userRecord.getEmail());
        values.put(UserContract.User.COLUMN_PHONE, userRecord.getPhone());


        //Insert a row
        SQLiteDatabase database = this.getWritableDatabase();
        database.insert(UserContract.User.TABLE_NAME, null, values);

        //Close database connection
        database.close();
    }


    public String searchPass(String usernamestr) {
        SQLiteDatabase database = this.getReadableDatabase();
        String query = " select user_name, password from " + UserContract.User.TABLE_NAME;
        Cursor cursor = database.rawQuery(query , null);
        String a,b;
        b ="not found";
        if(cursor.moveToFirst()){
            do{
                a=cursor.getString(0);

                if(a.equals(usernamestr)){
                    b=cursor.getString(1);
                    break;
                }
            }while(cursor.moveToNext());
        }
        return b;
    }
}
