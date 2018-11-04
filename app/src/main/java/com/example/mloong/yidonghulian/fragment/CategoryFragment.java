package com.example.mloong.yidonghulian.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mloong.yidonghulian.R;
import com.example.mloong.yidonghulian.activity.GoodsListActivity;
import com.example.mloong.yidonghulian.adapter.CategoryLeftListAdapter;
import com.example.mloong.yidonghulian.adapter.CategoryRightListAdapter;
import com.example.mloong.yidonghulian.adapter.OnRecyclerViewItemClickListener;
import com.example.mloong.yidonghulian.bean.GoodsCat;
import com.example.mloong.yidonghulian.common.Share;
import com.example.mloong.yidonghulian.entity.HttpResult;
import com.example.mloong.yidonghulian.http.ProgressDialogSubscriber2;
import com.example.mloong.yidonghulian.presenter.CategoryPresenter;
import com.example.mloong.yidonghulian.utils.AndroidUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {


    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.search_title_icon)
    ImageView searchTitleIcon;
    @BindView(R.id.search_keyword)
    TextView searchKeyword;
    @BindView(R.id.product_list_search_clean)
    ImageButton productListSearchClean;
    @BindView(R.id.search_layout)
    RelativeLayout searchLayout;
    @BindView(R.id.product_list_search_layout)
    RelativeLayout productListSearchLayout;
    @BindView(R.id.common_title)
    RelativeLayout commonTitle;
    @BindView(R.id.left_list)
    RecyclerView leftList;
    @BindView(R.id.right_list)
    RecyclerView rightList;
    @BindView(R.id.mainlayout)
    LinearLayout mainlayout;
    Unbinder unbinder;

    private List<GoodsCat> leftData = new ArrayList<>();
    private List<GoodsCat> rightData = new ArrayList<>();

    private CategoryLeftListAdapter leftAdapter;
    private CategoryRightListAdapter rightAdapter;

    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        unbinder = ButterKnife.bind(this, view);


        initViews();
        return view;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        //不在最前端界面显示，相当于调用了onPause()
        if (hidden) {

        } else {
            initViews();
        }
    }

    private void initViews() {
        //调整搜索栏的样式
        titleBack.setVisibility(View.GONE);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams
                .MATCH_PARENT, AndroidUtils.dp2px(this.getActivity(), 30));
        layoutParams.setMargins(10, 3, 10, 0);
        searchLayout.setLayoutParams(layoutParams);
        //设置列表样式
        LinearLayoutManager leftManager = new LinearLayoutManager(getActivity());
        leftManager.setOrientation(OrientationHelper.VERTICAL);
        //垂直表格
        GridLayoutManager rightManager = new GridLayoutManager(getActivity(),
                Share.SPAN_COUNT,
                OrientationHelper.VERTICAL, false);
        leftList.setLayoutManager(leftManager);
        rightList.setLayoutManager(rightManager);
        //适配数据
        leftAdapter = new CategoryLeftListAdapter(getActivity(), leftData);
        rightAdapter = new CategoryRightListAdapter(getActivity(), rightData);
        leftList.setAdapter(leftAdapter);
        rightList.setAdapter(rightAdapter);
        //加载左侧列表数据和item0对应的右侧列表数据
        CategoryPresenter.getTopList(new ProgressDialogSubscriber2<HttpResult<List<GoodsCat>>>(getContext()) {
            @Override
            public void onNext(HttpResult<List<GoodsCat>> listHttpResult) {
                if (listHttpResult.getStatus().equals(Share.SUCCESS)) {
                    List<GoodsCat> categoryEntities = listHttpResult.getData();
                    if (categoryEntities.size() > 0) {
                        leftData.addAll(categoryEntities);
                        leftAdapter.notifyDataSetChanged();
                        //载入item0的右侧列表数据
                        int cat_id = categoryEntities.get(0).getCatId();
                        loadRight(cat_id);
                        //默认选中第一项
                        leftAdapter.setSelection(cat_id);
                    }
                } else {
                    Toast.makeText(getActivity(), "获取数据失败", Toast.LENGTH_SHORT).show();
                }
            }
        });


        //左侧列表点击事件
        leftAdapter.setOnItemClickListener(new OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, GoodsCat data) {
                //加载右侧数据
                loadRight(data.getCatId());
                leftAdapter.setSelection(data.getCatId());
            }

        });
        //右侧列表点击事件
        rightAdapter.setOnItemClickListener(new OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, GoodsCat entity) {
               /* Toast.makeText(getActivity(), "name:" + entity.getName() + "\r\ncat_id:" + entity.getCat_id(), Toast
                        .LENGTH_SHORT)
                        .show();*/
                //跳转到商品列表界面
                Intent intent = new Intent(getActivity(), GoodsListActivity.class);
                intent.putExtra("catId", entity.getCatId());
                startActivity(intent);
            }
        });
    }

    /**
     * 加载右侧列表数据
     *
     * @param cat_id
     */
    private void loadRight(int cat_id) {

        CategoryPresenter.getSecondList(new ProgressDialogSubscriber2<HttpResult<List<GoodsCat>>>(getContext()) {
            @Override
            public void onNext(HttpResult<List<GoodsCat>> listHttpResult) {
                if (listHttpResult.getStatus().equals(Share.SUCCESS)) {
                    List<GoodsCat> categoryEntities = listHttpResult.getData();
                    if (categoryEntities.size() > 0) {

                        for (int i = 0; i < categoryEntities.size(); i++) {
                            Log.i("CategoryFragment", "rightlist-->" + categoryEntities.get(i).toString());
                        }
                        rightData.clear();
                        rightData.addAll(categoryEntities);
                        rightAdapter.notifyDataSetChanged();
                    }

                } else {
                    Toast.makeText(getActivity(), "获取数据失败", Toast.LENGTH_SHORT).show();
                }

            }
        }, cat_id);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.title_back)
    public void onViewClicked() {
    }
}
