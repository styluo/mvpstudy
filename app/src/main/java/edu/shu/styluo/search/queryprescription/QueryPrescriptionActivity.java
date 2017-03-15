package edu.shu.styluo.search.queryprescription;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import butterknife.OnItemSelected;
import butterknife.OnTextChanged;
import edu.shu.styluo.search.R;
import edu.shu.styluo.search.prescriptiondetail.PrescriptionDetailActivity;

/**
 * Created by a1056 on 2017/3/14.
 */

public class QueryPrescriptionActivity extends AppCompatActivity implements QueryPrescriptionContract.view{

    private QueryPrescriptionContract.presenter mPresenter;

    @BindView(R.id.prescription_list_view)
    ListView mListView;

    @BindView(R.id.search_prescription_view)
    EditText mSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.queryprescription_act);

        ButterKnife.bind(this);

        mPresenter = new QureyPrescriptionPresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.start();
    }

    /*think about fragment*/
    @Override
    public void setPresenter(@NonNull QueryPrescriptionContract.presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showData(String[] strArray) {
        mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strArray));
        mListView.setTextFilterEnabled(true);
    }

    @OnTextChanged(R.id.search_prescription_view)
    void onQueryTextChange(CharSequence newText) {
        if (!TextUtils.isEmpty(newText.toString())) {
            mListView.setFilterText(newText.toString());
        } else {
            mListView.clearTextFilter();
        }
    }

    @OnItemClick(R.id.prescription_list_view)
    void onItemClick(int position) {
        String diseaseName = mPresenter.getText(position);

        if(diseaseName != null){
            Intent intent = new Intent(this, PrescriptionDetailActivity.class);
            intent.putExtra("disease", diseaseName);
            startActivity(intent);
        }
    }

    /*think about some special phonea*/
    @OnItemSelected(R.id.prescription_list_view)
    void onItemSelected(int position) {

    }
}
