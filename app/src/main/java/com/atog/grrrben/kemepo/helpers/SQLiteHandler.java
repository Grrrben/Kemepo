package com.atog.grrrben.kemepo.helpers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.atog.grrrben.kemepo.classes.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SQLiteHandler extends SQLiteOpenHelper {

    private static final String TAG = SQLiteHandler.class.getSimpleName();

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "kemepo";
    private static final String TABLE_PRODUCTS = "products";

    // Login Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_EAN = "ean";
    private static final String KEY_PRICE = "price";


    public SQLiteHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        /*
         * SQLiteOpenHelper onCreate() and onUpgrade() callbacks are invoked when the database is
         * actually opened, for example by a call to getWritableDatabase().
         * The database is not opened when the database helper object itself is created.
         * SQLiteOpenHelper versions the database files. The version number is the int argument
         * passed to the constructor. (DATABASE_VERSION)
         * In the database file, the version number is stored in PRAGMA user_version.
         */

//        String sqlTableContacts = "CREATE TABLE " + TABLE_PRODUCTS + "("
//                + KEY_ID + " INTEGER PRIMARY KEY,"
//                + KEY_USERNAME + " TEXT,"
//                + KEY_EMAIL + " TEXT UNIQUE,"
//                + KEY_UUID + " TEXT,"
//                + KEY_GROUP + " TEXT"
//                + ")";
//        db.execSQL(sqlTableContacts);

        Log.d(TAG, "todo create db");
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        // Create tables again
        onCreate(db);
    }

    public List<Product> getProducts() {
        String selectQuery = "SELECT * FROM " + TABLE_PRODUCTS;
        List<Product> products = new ArrayList<>();

        // @todo

//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//
//        if (cursor.getCount() > 0) {
//            if (cursor.moveToFirst()) {
//                do {
//                    User contact = getContact(cursor);
//                    products.add(contact);
//                } while (cursor.moveToNext());
//            }
//        }
//        cursor.close();
//        db.close();

        Product p1 = new Product();
        p1.name = "Product One";
        p1.ean = 87115678910L;
        p1.price = 10.95;
        p1.active = true;

        Product p2 = new Product();
        p2.name = "Secondo";
        p2.ean = 87115600002L;
        p2.price = 1.95;
        p2.active = false;

        Product p3 = new Product();
        p3.name = "La Trappe Triple";
        p3.ean = 87115670003L;
        p3.price = 5.00;
        p3.active = true;

        products.add(p1);
        products.add(p2);
        products.add(p3);

        return products;
    }

    /**
     * Get a Product object from the cursor
     */
    private Product getProduct(Cursor cursor) {
        Product product = new Product();
        product.name = cursor.getString(1);
        product.ean = cursor.getLong(2);
        product.price = cursor.getDouble(3);
        return product;
    }

    /**
     * Put the products in the database.
     */
    public void addProducts(JSONArray products) {
//        deleteAllProducts();
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        for(int n = 0; n < contacts.length(); n++) {
//            ContentValues values = new ContentValues();
//
//            try {
//                JSONObject contact = contacts.getJSONObject(n);
//                values.put(KEY_USERNAME, contact.getString("username"));
//                values.put(KEY_EMAIL, contact.getString("email"));
//                values.put(KEY_UUID, contact.getString("uuid"));
//                values.put(KEY_GROUP, group);
//                long id = db.insert(TABLE_CONTACTS, null, values);
//
//                Log.d(TAG, "syncContacts: synced: " + contact.getString("username"));
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//        db.close();
    }

    private void deleteAllProducts() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PRODUCTS, null, null);
        db.close();
    }
}
