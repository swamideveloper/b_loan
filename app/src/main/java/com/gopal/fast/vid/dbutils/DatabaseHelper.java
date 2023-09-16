package com.gopal.fast.vid.dbutils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.gopal.fast.vid.model.BankModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "HBLocalDB.sqlite";
    private static final int DATABASE_VERSION = 1;
    private Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS bank_details (" + "id INTEGER PRIMARY KEY AUTOINCREMENT, " + "vName TEXT)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public ArrayList<BankModel> getDataFromTable(String tableName, String language) {
        ArrayList<BankModel> bankModels = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        String query1 = "SELECT " + "*" + " FROM " + tableName + " WHERE " + language + " LIKE 'EN'";

        Cursor cursor = db.rawQuery(query1, null);

        if (cursor.moveToFirst()) {
            do {
                int iBankDetailsId = cursor.getInt(cursor.getColumnIndex("iBankDetailsId"));
                String vName = cursor.getString(cursor.getColumnIndex("vName"));
                String vLogo = cursor.getString(cursor.getColumnIndex("vLogo"));
                String vBalance = cursor.getString(cursor.getColumnIndex("vBalance"));
                String vStatement = cursor.getString(cursor.getColumnIndex("vStatement"));
                String vCustomerCare = cursor.getString(cursor.getColumnIndex("vCustomerCare"));
                String vLanguage = cursor.getString(cursor.getColumnIndex("vLanguage"));
                String NetBanking = cursor.getString(cursor.getColumnIndex("NetBanking"));
                String vHeader = cursor.getString(cursor.getColumnIndex("vHeader"));
                int iHeaderNum = cursor.getInt(cursor.getColumnIndex("iHeaderNum"));
                int iCategory = cursor.getInt(cursor.getColumnIndex("iCategory"));
                String vTag = cursor.getString(cursor.getColumnIndex("vTag"));

                BankModel bankModel = new BankModel(iBankDetailsId, vName, vLogo, vBalance, vStatement, vCustomerCare, vLanguage, NetBanking, vHeader, iHeaderNum, iCategory, vTag);
                bankModels.add(bankModel);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return bankModels;
    }

    public String getBankDetailByID(String tableName, String iBankDetailsId, int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        String query1 = "SELECT " + "vName " + "FROM " + tableName + " " + "WHERE " + iBankDetailsId + " " + "= " + id;

        Cursor cursor = db.rawQuery(query1, null);
        cursor.moveToFirst();
        String vName = cursor.getString(cursor.getColumnIndex("vName"));
        cursor.close();
        db.close();
        return vName;
    }

    public ArrayList<String> getBankContactDetailByID(String tableName, String iBankDetailsId, int id) {
        ArrayList<String> bankDetailList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query1 = "SELECT " + "* " + "FROM " + tableName + " " + "WHERE " + iBankDetailsId + " " + "= " + id;

        Cursor cursor = db.rawQuery(query1, null);
        cursor.moveToFirst();

        if (cursor.moveToFirst()) {
            do {
                String vBalance = cursor.getString(cursor.getColumnIndex("vBalance"));
                String vStatement = cursor.getString(cursor.getColumnIndex("vStatement"));
                String vCustomerCare = cursor.getString(cursor.getColumnIndex("vCustomerCare"));
                bankDetailList.add(vBalance);
                bankDetailList.add(vStatement);
                bankDetailList.add(vCustomerCare);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return bankDetailList;
    }

    public void copyDatabaseFromAssets() throws IOException {
        InputStream inputStream = context.getAssets().open(DATABASE_NAME);
        String outFileName = context.getDatabasePath(DATABASE_NAME).getPath();
        File outFile = new File(outFileName);

        if (!outFile.exists()) {
            OutputStream outputStream = new FileOutputStream(outFile);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        }
    }
}
