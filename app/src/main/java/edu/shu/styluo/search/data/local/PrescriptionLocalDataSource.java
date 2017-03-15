package edu.shu.styluo.search.data.local;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import edu.shu.styluo.search.data.PrescriptionDetail;
import edu.shu.styluo.search.utils.LogUtil;

/**
 * Created by a1056 on 2017/3/15.
 */

public class PrescriptionLocalDataSource {
    private static PrescriptionLocalDataSource INSTANCE;

    private PrescriptionDatabaseHelper mDbHelper;

    // Prevent direct instantiation.
    private PrescriptionLocalDataSource(@NonNull Context context) {
        mDbHelper = new PrescriptionDatabaseHelper(context);
    }

    public static PrescriptionLocalDataSource getInstance(@NonNull Context context) {
        if (INSTANCE == null) {
            INSTANCE = new PrescriptionLocalDataSource(context);
        }
        return INSTANCE;
    }

    public List<PrescriptionDetail> getInfoFromName(String diseaseName){
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        List<PrescriptionDetail> prescriptionDetailList = new ArrayList<>();
        Cursor cursor = null;
        try{
        /*select * from prescription, symptom where prescription.disease_name = symptom.disease_name and prescription.disease_name = disease_name*/
            String sql = "select * from " + PrescriptionContract.PrescriptionEntry.TABLE_NAME +
                    ", " + PrescriptionContract.SymptomEntry.TABLE_NAME +
                    " where " + PrescriptionContract.PrescriptionEntry.TABLE_NAME + "." + PrescriptionContract.PrescriptionEntry.COLUMN_DISEASE_NAME +
                    " = ? and " + PrescriptionContract.SymptomEntry.TABLE_NAME + "." + PrescriptionContract.SymptomEntry.COLUMN_DISEASE_NAME +
                    " = " + PrescriptionContract.PrescriptionEntry.TABLE_NAME + "." + PrescriptionContract.PrescriptionEntry.COLUMN_DISEASE_NAME;
            cursor = db.rawQuery(sql, new String[]{diseaseName});

            if(cursor != null && cursor.moveToFirst()){
                do{
                    String prescritionName = cursor.getString(cursor.getColumnIndex(PrescriptionContract.PrescriptionEntry.COLUMN_PRESCRIPTION_NAME));
                    String presciptonIntro = cursor.getString(cursor.getColumnIndex(PrescriptionContract.PrescriptionEntry.COLUMN_PRESCRIPTION_INTRO));
                    String symptomIntro = cursor.getString(cursor.getColumnIndex(PrescriptionContract.SymptomEntry.COLUMN_SYMPTOM_INTRO));

                    PrescriptionDetail prescriptionDetail = new PrescriptionDetail(diseaseName,prescritionName, presciptonIntro, symptomIntro);
                    prescriptionDetailList.add(prescriptionDetail);
                }while(cursor.moveToNext());

            }
        }finally {
            if(cursor != null && !cursor.isClosed()){
                cursor.close();
            }
        }
        return prescriptionDetailList;
    }
}