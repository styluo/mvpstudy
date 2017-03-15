package edu.shu.styluo.search.prescriptiondetail;

import java.util.List;

import edu.shu.styluo.search.BasePresenter;
import edu.shu.styluo.search.BaseView;
import edu.shu.styluo.search.data.PrescriptionDetail;

/**
 * Created by a1056 on 2017/3/15.
 */

public interface PrescriptionDetailContract {
    interface view extends BaseView<presenter> {
        void initAdapter(List<PrescriptionDetail> prescriptionDetailList);
        void setSymptomName(String symptomName);
        void setSymptomIntro(String symptomIntro);
    }

    interface presenter extends BasePresenter {
        void getData(String diseaseName);
        void updateHeader();
    }
}
