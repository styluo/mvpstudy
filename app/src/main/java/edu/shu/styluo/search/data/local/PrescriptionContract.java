package edu.shu.styluo.search.data.local;

import android.provider.BaseColumns;

/**
 * Created by a1056 on 2017/3/14.
 */

/**
 * Defines table and column names for the prescription database.
 */
public class PrescriptionContract {

    /*Inner class to defines the contents of the prescription table*/
    public static final class PrescriptionEntry implements BaseColumns{

        public static final String TABLE_NAME = "prescription";

        public static final String COLUMN_DISEASE_NAME =  "disease_name";

        public static final String COLUMN_PRESCRIPTION_NAME =  "prescription_name";

        public static final String COLUMN_PRESCRIPTION_INTRO =  "prescription_intro";
    }

    /*Inner class to defines the contents of the symptom table*/
    public static final class SymptomEntry implements BaseColumns{

        public static final String TABLE_NAME = "symptom";

        public static final String COLUMN_DISEASE_NAME =  "disease_name";

        public static final String COLUMN_SYMPTOM_INTRO = "symptom_intro";
    }
}
