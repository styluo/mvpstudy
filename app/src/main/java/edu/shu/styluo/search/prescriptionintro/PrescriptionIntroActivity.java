package edu.shu.styluo.search.prescriptionintro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.shu.styluo.search.R;

/**
 * author: styluo
 * date: 2017/3/27 15:46
 * e-mail: shu_jiahuili@foxmail.com
 */

public class PrescriptionIntroActivity extends Activity implements PrescriptionIntroContract.view{

    String prescriptionName;

    PrescriptionIntroContract.presenter mPresenter;

    @BindView(R.id.prescrition_intro)
    TextView prescriptionIntroTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prescriptionintro_act);

        ButterKnife.bind(this);
        Intent intent = this.getIntent();
        prescriptionName = intent.getStringExtra("prescriptionName");

        mPresenter = new PrescriptionIntroPresenter(this);

        mPresenter.getData(prescriptionName);
    }

    @Override
    public void setPresenter(PrescriptionIntroContract.presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void initAdapter(String prescriptionIntro) {
        prescriptionIntroTextView.setText(prescriptionIntro);
    }

}
