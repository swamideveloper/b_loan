package com.gopal.fast.vid.NewImplement.ui;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class bankDatabase extends SQLiteOpenHelper {
    private static final String database_NAME = "HBLocalDB.sqlite";
    private static final int database_VERSION = 1;
    private static final String TABLE_NAME = "bank_details";
    private String database_PATH;
    private final Context myContext;

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public bankDatabase(Context context) {
        super(context, database_NAME, (SQLiteDatabase.CursorFactory) null, 1);
        this.myContext = context;
        this.database_PATH = context.getDatabasePath(database_NAME).getPath();
        if (checkDataBase()) {
            return;
        }
        try {
            copyDataBase();
        } catch (IOException e) {
            throw new RuntimeException("Error copying database: " + e.getMessage());
        }
    }

    private boolean checkDataBase() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = SQLiteDatabase.openDatabase(this.database_PATH, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
        }
        return sQLiteDatabase != null;
    }

    private void copyDataBase() throws IOException {
        InputStream open = this.myContext.getAssets().open(database_NAME);
        FileOutputStream fileOutputStream = new FileOutputStream(this.database_PATH);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = open.read(bArr);
            if (read > 0) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileOutputStream.flush();
                fileOutputStream.close();
                open.close();
                return;
            }
        }
    }

    public ArrayList<bankModel> getTableData() {
        ArrayList<bankModel> arrayList = new ArrayList<>();
        Cursor rawQuery = getReadableDatabase().rawQuery("SELECT * FROM bank_details", null);
        if (rawQuery.moveToFirst()) {
            do {
                arrayList.add(new bankModel(rawQuery.getInt(0), rawQuery.getString(1), rawQuery.getString(3), rawQuery.getString(4), rawQuery.getString(5)));
            } while (rawQuery.moveToNext());
            rawQuery.close();
            return arrayList;
        }
        rawQuery.close();
        return arrayList;
    }

    public ArrayList<bankHolidayModel> getOpenBankDetails(String state) {
        ArrayList<bankHolidayModel> arrayList = new ArrayList<>();
        Cursor rawQuery = getReadableDatabase().rawQuery("select * from bank_holiday where vstate=?", new String[]{state});
        if (rawQuery.moveToFirst()) {
            do {
                arrayList.add(new bankHolidayModel(rawQuery.getInt(0), rawQuery.getString(7), rawQuery.getString(4), rawQuery.getString(5), rawQuery.getString(6)));
            } while (rawQuery.moveToNext());
            rawQuery.close();
            return arrayList;
        }
        rawQuery.close();
        return arrayList;
    }

    public ArrayList<String> getBankNameForSpinner() {
        ArrayList<String> arrayList = new ArrayList<>();
        Cursor rawQuery = getReadableDatabase().rawQuery("select * from state_list where vLanguage=?", new String[]{"EN"});
        if (rawQuery.moveToFirst()) {
            do {
                arrayList.add(rawQuery.getString(1));
            } while (rawQuery.moveToNext());
            rawQuery.close();
            return arrayList;
        }
        rawQuery.close();
        return arrayList;
    }
}