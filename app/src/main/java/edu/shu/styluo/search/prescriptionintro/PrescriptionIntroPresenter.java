package edu.shu.styluo.search.prescriptionintro;

import android.app.Activity;

import edu.shu.styluo.search.data.local.PrescriptionLocalDataSource;

/**
 * author: styluo
 * date: 2017/3/27 15:47
 * e-mail: shu_jiahuili@foxmail.com
 */

public class PrescriptionIntroPresenter implements PrescriptionIntroContract.presenter {

    PrescriptionIntroContract.view mPrescritionIntroView;

    PrescriptionLocalDataSource prescriptionLocalDataSource;

    public PrescriptionIntroPresenter(PrescriptionIntroContract.view mPrescritionIntroView){
        this.mPrescritionIntroView = mPrescritionIntroView;
    }

    @Override
    public void getData(String prescritionName) {
        prescriptionLocalDataSource = PrescriptionLocalDataSource.getInstance((Activity) mPrescritionIntroView);

        mPrescritionIntroView.initAdapter(prescriptionLocalDataSource.getPrescriptionIntro(prescritionName));
    }

    @Override
    public void start() {

    }
}
