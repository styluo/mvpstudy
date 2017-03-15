package edu.shu.styluo.search.queryprescription;

import java.util.List;

import edu.shu.styluo.search.BasePresenter;
import edu.shu.styluo.search.BaseView;

/**
 * Created by a1056 on 2017/3/14.
 */

public interface QueryPrescriptionContract {
    interface view extends BaseView<presenter>{
        void showData(List<String> symptomList);
    }

    interface presenter extends BasePresenter{
        void getData();
    }
}
