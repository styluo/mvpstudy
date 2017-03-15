package edu.shu.styluo.search.data.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;
import java.util.List;

import edu.shu.styluo.search.data.Prescription;
import edu.shu.styluo.search.data.Symptom;

/**
 * Created by a1056 on 2017/3/14.
 */

public class PrescriptionDatabaseHelper extends SQLiteOpenHelper {

    static final String DB_NAME = "prescription.db";

    private static final int DB_VERSION = 1;

    public PrescriptionDatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_PRESCRIPTION_TABLE = "CREATE TABLE " + PrescriptionContract.PrescriptionEntry.TABLE_NAME + " (" +
                PrescriptionContract.PrescriptionEntry.COLUMN_DISEASE_NAME + " Text, " +
                PrescriptionContract.PrescriptionEntry.COLUMN_PRESCRIPTION_NAME + " Text, " +
                PrescriptionContract.PrescriptionEntry.COLUMN_PRESCRIPTION_INTRO + " Text"
                + " ); ";


        final String SQL_CREATE_SYMPTOM_TABLE = "CREATE TABLE " + PrescriptionContract.SymptomEntry.TABLE_NAME + " (" +
                PrescriptionContract.SymptomEntry.COLUMN_DISEASE_NAME + " Text, " +
                PrescriptionContract.SymptomEntry.COLUMN_SYMPTOM_INTRO + " Text"
                + " ); ";

        db.execSQL(SQL_CREATE_PRESCRIPTION_TABLE);
        db.execSQL(SQL_CREATE_SYMPTOM_TABLE);

        testInit(db);
    }

    /*NOTHING TO DO*/
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void initPrescription(SQLiteDatabase db, List<Prescription> prescriptionList){
        try{
            db.beginTransaction();

            for(Prescription prescription : prescriptionList){
                ContentValues contentValues = new ContentValues();
                contentValues.put(PrescriptionContract.PrescriptionEntry.COLUMN_DISEASE_NAME, prescription.getDisease_name());
                contentValues.put(PrescriptionContract.PrescriptionEntry.COLUMN_PRESCRIPTION_NAME, prescription.getPrescription_name());
                contentValues.put(PrescriptionContract.PrescriptionEntry.COLUMN_PRESCRIPTION_INTRO, prescription.getPrescription_intro());

                db.insertWithOnConflict(PrescriptionContract.PrescriptionEntry.TABLE_NAME,
                        null,
                        contentValues,
                        SQLiteDatabase.CONFLICT_REPLACE);
            }

            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }

    }

    public void initSymptom(SQLiteDatabase db, List<Symptom> symptomList){
        try{
            db.beginTransaction();

            for(Symptom symptom : symptomList){
                ContentValues contentValues = new ContentValues();
                contentValues.put(PrescriptionContract.SymptomEntry.COLUMN_DISEASE_NAME, symptom.getDisease_name());
                contentValues.put(PrescriptionContract.SymptomEntry.COLUMN_SYMPTOM_INTRO, symptom.getSymptom_intro());

                db.insertWithOnConflict(PrescriptionContract.SymptomEntry.TABLE_NAME,
                        null,
                        contentValues,
                        SQLiteDatabase.CONFLICT_REPLACE);
            }

            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }

    }

    /*Just one data*/
    public void testInit(SQLiteDatabase db){
        List<Prescription> prescriptionList = new LinkedList<Prescription>();
        List<Symptom> symptomList = new LinkedList<Symptom>();

        Prescription prescription = new Prescription("颈椎病","吐纳导引法","悬垂导引法");
        Symptom symptom = new Symptom("颈椎病","颈椎病又称颈椎综合征，是颈椎骨关节炎、增生性颈椎炎、颈神经根综合征、颈椎间盘脱出症的总称,是一种以退行性病理改变为基础的疾患。");

        prescriptionList.add(prescription);
        symptomList.add(symptom);

        initPrescription(db, prescriptionList);
        initSymptom(db, symptomList);
    }
}
