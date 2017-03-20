package edu.shu.styluo.search.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.shu.styluo.search.R;

/**
 * author: styluo
 * date: 2017/3/15 22:35
 * e-mail: shu_jiahuili@foxmail.com
 */

public class QueryPrescriptionAdater extends BaseAdapter implements Filterable{
    private ArrayList<String> symptomList;
    private ArrayList<String> backupDataList;
    private QueryFilter queryFilter;

    public QueryPrescriptionAdater(List<String> symptomList){
        this.symptomList = (ArrayList)symptomList;
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

    @Override
    public Filter getFilter() {
        if(queryFilter == null){
            queryFilter = new QueryFilter();
        }

        return queryFilter;
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

    private class QueryFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            final FilterResults results = new FilterResults();

            List<String> resultList;
            if(backupDataList == null){
                backupDataList = new ArrayList<>(symptomList);
            }

            if(TextUtils.isEmpty(constraint)){
                resultList = new ArrayList<>(backupDataList);
            }else{
                resultList = new ArrayList<>();

                for (String str : symptomList) {
                    if(str.contains(constraint)){
                        resultList.add(str);
                    }
                }
            }

            results.values = resultList;
            results.count = resultList.size();

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            symptomList = (ArrayList<String>) results.values;

            if(results.count > 0){
                notifyDataSetChanged();
            }else{
                notifyDataSetInvalidated();
            }
        }
    }
}
