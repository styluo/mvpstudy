package edu.shu.styluo.search.queryprescription;

/**
 * Created by a1056 on 2017/3/14.
 */

public class QureyPrescriptionPresenter implements QueryPrescriptionContract.presenter {

    private QueryPrescriptionContract.view mQueryPrescriptionView;

    private static String[] mStrs = {"颈椎病", "腰椎间盘突出", "脊椎侧弯", "肩周炎","坐骨神经痛","哮喘（支气管哮喘）","乳腺炎","乳腺增生","乳腺纤维瘤","乳腺囊肿","冠心病","偏头痛","风湿病","前列腺炎","抑郁症","心肌炎","结石","骨质疏松症","肝炎","高血压","肥胖","失眠","感冒","慢性支气管炎","便秘","更年期综合症","糖尿病","胃下垂","慢性咽喉炎","视疲劳","胃痛","慢性腹泻","消化不良","O型腿","落枕","小儿鼻塞","小儿厌食按摩","小儿便秘按摩","痛经","小腿抽筋","呃逆","脱肛","鼠标手（腕管综合症）","美容养颜","牙龈炎","龋齿","肺气肿"};

    public QureyPrescriptionPresenter(QueryPrescriptionContract.view queryPrescriptionView){
        mQueryPrescriptionView = queryPrescriptionView;

       // mQueryPrescriptionView.setPresenter(this);
    }

    @Override
    public void start() {
        getData();
    }

    @Override
    public void getData() {
        mQueryPrescriptionView.showData(mStrs);
    }

    @Override
    public String getText(int position){
        if(position >= mStrs.length) return null;
        return mStrs[position];
    }
}

