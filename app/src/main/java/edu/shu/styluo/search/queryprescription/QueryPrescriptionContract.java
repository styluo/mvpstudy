package edu.shu.styluo.search.queryprescription;

import edu.shu.styluo.search.BasePresenter;
import edu.shu.styluo.search.BaseView;

/**
 * Created by a1056 on 2017/3/14.
 */

public interface QueryPrescriptionContract {
    interface view extends BaseView<presenter>{
        void showData(String[] strArray);
    }

    interface presenter extends BasePresenter{
        void getData();

        String getText(int position);
    }
}
