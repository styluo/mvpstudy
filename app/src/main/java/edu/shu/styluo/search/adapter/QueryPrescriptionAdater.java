package edu.shu.styluo.search.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import edu.shu.styluo.search.R;

/**
 * author: styluo
 * date: 2017/3/15 22:35
 * e-mail: shu_jiahuili@foxmail.com
 */

public class QueryPrescriptionAdater extends BaseAdapter {
    private List<String> symptomList;

    public QueryPrescriptionAdater(List<String> symptomList){
        this.symptomList = symptomList;
    }

    /*the size of the data source*/
    @Override
    public int getCount() {
        return symptomList.size();
    }

    @Override
    public Object getItem(int position) {
        return symptomList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        ViewHolder viewHolder;

        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.queryprescription_item_view, parent, false);

            TextView symptomTextView = (TextView) convertView.findViewById(R.id.symptom);

            viewHolder = new ViewHolder(symptomTextView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        String symptomName = symptomList.get(position);

        viewHolder.getSymptomTextView().setText(symptomName);

        return convertView;
    }

    private static class ViewHolder{
        public TextView getSymptomTextView() {
            return symptomTextView;
        }

        public void setSymptomTextView(TextView symptomTextView) {
            this.symptomTextView = symptomTextView;
        }

        private TextView symptomTextView;

        public ViewHolder(TextView symptomTextView){
            this.symptomTextView = symptomTextView;
        }
    }
}
