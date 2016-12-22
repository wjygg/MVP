package com.example.administrator.mvp.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mvp.R;
import com.example.administrator.mvp.adapter.listviewadapter.ListViewAdapter;
import com.example.administrator.mvp.adapter.listviewadapter.ListViewViewHolder;
import com.example.administrator.mvp.base.BaseFragment;
import com.example.administrator.mvp.presenter.BookClassiFicationFragmentPresenter;
import com.example.administrator.mvp.presenter.listener.BookClassiFicationFragmentPresenterListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

/**
 * Created by Administrator on 2016/11/27.
 * 书本分类fragment
 */

public class BookClassiFicationFragment extends BaseFragment<BookClassiFicationFragmentPresenterListener,BookClassiFicationFragmentPresenter> implements BookClassiFicationFragmentPresenterListener {

    @InjectView(R.id.listview)
    ListView listview;

    private List<String> datas=new ArrayList<String>();
    private ListViewAdapter<String> adapter;

    public static BookClassiFicationFragment getInstance(){

        return new BookClassiFicationFragment();
    }

    @Override
    public int getContentViewId() {
        return R.layout.fragment_bookclassification;
    }

    @Override
    public BookClassiFicationFragmentPresenter initPresenter() {

        return new BookClassiFicationFragmentPresenter();
    }

    @Override
    public void initDatas() {

     //   Toast.makeText(getActivity(),"缓加载第二个页面",Toast.LENGTH_SHORT).show();

        datas.add("1");
        datas.add("2");
        datas.add("3");
        adapter=new ListViewAdapter<String>(getActivity(),R.layout.item_fragmentlist,datas) {
            @Override
            public void convert(ListViewViewHolder holder, int position) {
                TextView text=holder.getView(R.id.tv_num);
                text.setText(datas.get(position));
            }
        };
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),"缓加载第二个页面"+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void initEvent() {


    }
}
