package edu.shu.styluo.search.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import edu.shu.styluo.search.R;
import edu.shu.styluo.search.data.PrescriptionDetail;

/**
 * Created by a1056 on 2017/3/15.
 */

public class PrescriptionAdapter extends BaseQuickAdapter<PrescriptionDetail> {
    public PrescriptionAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, PrescriptionDetail item) {
        helper.setText(R.id.prescription_name, item.getPrescription_name())
                .setText(R.id.prescription_intro, item.getPrescription_intro());
    }
}
