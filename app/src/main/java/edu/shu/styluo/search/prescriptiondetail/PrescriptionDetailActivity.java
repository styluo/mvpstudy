package edu.shu.styluo.search.prescriptiondetail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.shu.styluo.search.R;
import edu.shu.styluo.search.adapter.PrescriptionAdapter;
import edu.shu.styluo.search.data.PrescriptionDetail;
import edu.shu.styluo.search.prescriptionintro.PrescriptionIntroActivity;

/**
 * Created by a1056 on 2017/3/14.
 */

public class PrescriptionDetailActivity extends Activity implements PrescriptionDetailContract.view{
    PrescriptionDetailContract.presenter mPresenter;

    String diseaseName;

    @BindView(R.id.prescription_re_view)
    RecyclerView prescriptionReView;

    TextView symptomNameTextView;

    TextView symptomIntroTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prescriptiondetail_act);

        ButterKnife.bind(this);
        prescriptionReView.setLayoutManager(new LinearLayoutManager(this));
        Intent intent = this.getIntent();
        diseaseName = intent.getStringExtra("disease");

        mPresenter = new PreScriptionDetailPresenter(this);

        mPresenter.getData(diseaseName);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void setPresenter(PrescriptionDetailContract.presenter presenter) {
        mPresenter = presenter;
    }


    @Override
    public void initAdapter(final List<PrescriptionDetail> prescriptionDetailList) {
        BaseQuickAdapter prescriptionAdapter = new PrescriptionAdapter(R.layout.prescription_item_view, prescriptionDetailList);
        prescriptionAdapter.openLoadAnimation();
        View top = getLayoutInflater().inflate(R.layout.prescription_top_view, (ViewGroup) prescriptionReView.getParent(), false);
        symptomNameTextView = (TextView) top.findViewById(R.id.symptom_name);
        symptomIntroTextView = (TextView) top.findViewById(R.id.symptom_intro);
        prescriptionAdapter.addHeaderView(top);
        prescriptionReView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                String prescriptionName = prescriptionDetailList.get(i).getPrescription_name();

                Intent intent = new Intent(PrescriptionDetailActivity.this, PrescriptionIntroActivity.class);
                intent.putExtra("prescriptionName", prescriptionName);
                startActivity(intent);

            }
        });

        prescriptionReView.setAdapter(prescriptionAdapter);
        mPresenter.updateHeader();
    }

    @Override
    public void setSymptomIntro(String symptomIntro) {
        symptomIntroTextView.setText(symptomIntro);
    }

    @Override
    public void setSymptomName(String symptomName) {
        symptomNameTextView.setText(symptomName);
    }
}
