package edu.shu.styluo.search.prescriptiondetail;

import android.app.Activity;

import java.util.List;

import edu.shu.styluo.search.data.PrescriptionDetail;
import edu.shu.styluo.search.data.local.PrescriptionLocalDataSource;

/**
 * Created by a1056 on 2017/3/15.
 */

public class PreScriptionDetailPresenter implements PrescriptionDetailContract.presenter {
    PrescriptionDetailContract.view mPrescriptionDetailView;

    PrescriptionLocalDataSource prescriptionLocalDataSource;

    String symtomName;

    String symptomIntro;

    public PreScriptionDetailPresenter(PrescriptionDetailContract.view mPrescriptionDetailView){
        this.mPrescriptionDetailView = mPrescriptionDetailView;
    }

    @Override
    public void start() {
       // getData();
    }

    @Override
    public void getData(String diseaseName) {
        prescriptionLocalDataSource = PrescriptionLocalDataSource.getInstance((Activity)mPrescriptionDetailView);
        List<PrescriptionDetail> prescriptionDetailList;
        prescriptionDetailList = prescriptionLocalDataSource.getInfoFromName(diseaseName);
        if(prescriptionDetailList.size() > 0){
            PrescriptionDetail prescriptionDetail = prescriptionDetailList.get(0);

            symtomName = prescriptionDetail.getDisease_name();
            symptomIntro = prescriptionDetail.getSymptom_intro();
        }else{
            //TODO EMPTY VIEW
            symptomIntro = "";
            symtomName = "";
        }
        mPrescriptionDetailView.initAdapter(prescriptionDetailList);
    }

    @Override
    public void updateHeader() {
        mPrescriptionDetailView.setSymptomName(symtomName);
        mPrescriptionDetailView.setSymptomIntro(symptomIntro);
    }
}