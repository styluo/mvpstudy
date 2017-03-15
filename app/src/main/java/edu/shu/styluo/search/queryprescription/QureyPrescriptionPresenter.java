package edu.shu.styluo.search.queryprescription;

import android.app.Activity;

import java.util.List;

import edu.shu.styluo.search.data.local.PrescriptionLocalDataSource;

/**
 * Created by a1056 on 2017/3/14.
 */

public class QureyPrescriptionPresenter implements QueryPrescriptionContract.presenter {

    private QueryPrescriptionContract.view mQueryPrescriptionView;

    public QureyPrescriptionPresenter(QueryPrescriptionContract.view queryPrescriptionView){
        mQueryPrescriptionView = queryPrescriptionView;

       // mQueryPrescriptionView.setPresenter(this);
    }

    @Override
    public void start() {
        getData();
    }

    @Override
    public void getData() {
        PrescriptionLocalDataSource prescriptionLocalDataSource = PrescriptionLocalDataSource.getInstance((Activity)mQueryPrescriptionView);
        List<String> symptomList = prescriptionLocalDataSource.getSymptomList();
        mQueryPrescriptionView.showData(symptomList);
    }
}

