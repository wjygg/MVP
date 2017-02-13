package com.example.administrator.mvp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.administrator.mvp.R;
import com.example.administrator.mvp.entity.ExpandableListViewEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/30.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter{

    private List<ExpandableListViewEntity> datas;

    private Context context;

    private Map<String,Boolean> map;

    public ExpandableListAdapter(Context context,List<ExpandableListViewEntity> datas,Map<String,Boolean> map){

        this.context=context;

        this.datas=datas;

        this.map=map;
    }


    @Override
    public int getGroupCount() {
        return datas.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return datas.get(groupPosition).getDatas().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return datas.get(groupPosition).getTitle();
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return datas.get(groupPosition).getDatas().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {


        View view= LayoutInflater.from(context).inflate(R.layout.item_expgroup,null);

        TextView textview= (TextView) view.findViewById(R.id.title);

        textview.setText(datas.get(groupPosition).getTitle());

        final CheckBox checkBox= (CheckBox) view.findViewById(R.id.checkbox);

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(map.get(datas.get(groupPosition).getId())){
                    //如果是true 设置本身是false 并且子目录是false
                    map.put(datas.get(groupPosition).getId(),false);

                    for(int i=0;i<=datas.get(groupPosition).getDatas().size()-1;i++){
                        map.put(datas.get(groupPosition).getDatas().get(i).getId(),false);
                    }

                }else{
                    map.put(datas.get(groupPosition).getId(),true);

                    for(int i=0;i<=datas.get(groupPosition).getDatas().size()-1;i++){
                        map.put(datas.get(groupPosition).getDatas().get(i).getId(),true);
                    }
                }
                checkBox.setChecked(map.get(datas.get(groupPosition).getId()));

                notifychange();
            }
        });
        checkBox.setChecked(map.get(datas.get(groupPosition).getId()));

        return view;
    }

    @Override
    public View getChildView(final int groupPosition,final  int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_expgroup,null);

        TextView textview= (TextView) view.findViewById(R.id.title);

        textview.setText(datas.get(groupPosition).getDatas().get(childPosition).getName());

        final CheckBox checkBox= (CheckBox) view.findViewById(R.id.checkbox);

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(map.get(datas.get(groupPosition).getDatas().get(childPosition).getId())){
                    //如果是true
                    map.put(datas.get(groupPosition).getDatas().get(childPosition).getId(),false);
                }else{
                    map.put(datas.get(groupPosition).getDatas().get(childPosition).getId(),true);
                }
                checkBox.setChecked(map.get(datas.get(groupPosition).getDatas().get(childPosition).getId()));
            }
        });
        checkBox.setChecked(map.get(datas.get(groupPosition).getDatas().get(childPosition).getId()));
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    public void notifychange(){
        this.notifyDataSetChanged();
    }
}
