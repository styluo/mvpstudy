package edu.shu.styluo.search.prescriptionintro;

import edu.shu.styluo.search.BasePresenter;
import edu.shu.styluo.search.BaseView;

/**
 * author: styluo
 * date: 2017/3/27 15:47
 * e-mail: shu_jiahuili@foxmail.com
 */

public interface PrescriptionIntroContract {
    interface view extends BaseView<presenter>{
        void initAdapter(String prescriptionIntro);
    }

    interface presenter extends BasePresenter{
        void getData(String prescritionName);
    }
}
