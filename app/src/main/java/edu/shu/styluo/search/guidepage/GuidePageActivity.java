package edu.shu.styluo.search.guidepage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.shu.styluo.search.R;
import edu.shu.styluo.search.queryprescription.QueryPrescriptionActivity;

/**
 * author: styluo
 * date: 2017/3/15 23:29
 * e-mail: shu_jiahuili@foxmail.com
 */

public class GuidePageActivity extends AppCompatActivity
        implements GestureDetector.OnGestureListener {
    @BindView(R.id.guide_page)
    private ViewFlipper viewFlipper;
    private GestureDetector detector; //手势检测
    private Button button_enter;

    Animation leftInAnimation;
    Animation leftOutAnimation;
    Animation rightInAnimation;
    Animation rightOutAnimation;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_page_act);

        ButterKnife.bind(this);
        detector = new GestureDetector(this);

        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View view =  layoutInflater.inflate(R.layout.guide_entry_view, null);
        button_enter = (Button) view.findViewById(R.id.guide_to_query);

        button_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(GuidePageActivity.this, QueryPrescriptionActivity.class);
                startActivity(intent);
            }
        });


        //往viewFlipper添加View
        viewFlipper.addView(getImageView(R.drawable.page1));
        viewFlipper.addView(getImageView(R.drawable.page2));
        viewFlipper.addView(view);

        //动画效果
        leftInAnimation = AnimationUtils.loadAnimation(this, R.anim.left_in);
        leftOutAnimation = AnimationUtils.loadAnimation(this, R.anim.left_out);
        rightInAnimation = AnimationUtils.loadAnimation(this, R.anim.right_in);
        rightOutAnimation = AnimationUtils.loadAnimation(this, R.anim.right_out);

    }

    private ImageView getImageView(int id){
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(id);
        return imageView;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return this.detector.onTouchEvent(event); //touch事件交给手势处理。
    }

    @Override
    public boolean onDown(MotionEvent e) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                           float velocityY) {

        if(e1.getX()-e2.getX()>120){
            viewFlipper.setInAnimation(leftInAnimation);
            viewFlipper.setOutAnimation(leftOutAnimation);
            viewFlipper.showNext();//向右滑动
            return true;
        }else if(e1.getX()-e2.getY()<-120){
            viewFlipper.setInAnimation(rightInAnimation);
            viewFlipper.setOutAnimation(rightOutAnimation);
            viewFlipper.showPrevious();//向左滑动
            return true;
        }
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                            float distanceY) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        // TODO Auto-generated method stub
        return false;
    }

}