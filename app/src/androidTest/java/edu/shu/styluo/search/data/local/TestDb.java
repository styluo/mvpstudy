package edu.shu.styluo.search.data.local;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

import java.util.HashSet;

/**
 * Created by a1056 on 2017/3/14.
 */

public class TestDb extends AndroidTestCase{

    void deleteTheDatabase() {
        mContext.deleteDatabase(PrescriptionDatabaseHelper.DB_NAME);
    }

    public void setUp() {
        deleteTheDatabase();
    }

    public void testCreateDb() throws Throwable{
        final HashSet<String> tableNameHashSet = new HashSet<String>();
        tableNameHashSet.add(PrescriptionContract.PrescriptionEntry.TABLE_NAME);
        tableNameHashSet.add(PrescriptionContract.SymptomEntry.TABLE_NAME);

        mContext.deleteDatabase(PrescriptionDatabaseHelper.DB_NAME);
        SQLiteDatabase db = new PrescriptionDatabaseHelper(
                this.mContext).getWritableDatabase();
        assertEquals(true, db.isOpen());

        Cursor c = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);

        assertTrue("Error: This means that the database has not been created correctly",
                c.moveToFirst());

        do {
            tableNameHashSet.remove(c.getString(0));
        } while( c.moveToNext() );

        assertTrue("Error: Your database was created without both the prescription entry and symptom entry tables",
                tableNameHashSet.isEmpty());

        c = db.rawQuery("PRAGMA table_info(" + PrescriptionContract.PrescriptionEntry.TABLE_NAME + ")",
                null);

        assertTrue("Error: This means that we were unable to query the database for table information.",
                c.moveToFirst());

        final HashSet<String> prescriptionColumnHashSet = new HashSet<String>();
        prescriptionColumnHashSet.add(PrescriptionContract.PrescriptionEntry._ID);
        prescriptionColumnHashSet.add(PrescriptionContract.PrescriptionEntry.COLUMN_DISEASE_NAME);
        prescriptionColumnHashSet.add(PrescriptionContract.PrescriptionEntry.COLUMN_PRESCRIPTION_NAME);
        prescriptionColumnHashSet.add(PrescriptionContract.PrescriptionEntry.COLUMN_PRESCRIPTION_INTRO);

        int columnNameIndex = c.getColumnIndex("name");
        do {
            String columnName = c.getString(columnNameIndex);
            prescriptionColumnHashSet.remove(columnName);
        } while(c.moveToNext());

        assertTrue("Error: The database doesn't contain all of the required prescription entry columns",
                !prescriptionColumnHashSet.isEmpty());
        db.close();
    }

}
