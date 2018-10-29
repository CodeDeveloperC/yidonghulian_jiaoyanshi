package com.example.mloong.yidonghulian.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.mloong.yidonghulian.R;

public class NavigationFragment extends BaseFragment implements View.OnClickListener {

    private LinearLayout mTabItemHome;
    private LinearLayout mTabItemCategory;
    private LinearLayout mTabItemCart;
    private LinearLayout mTabItemPerson;
    private ImageView mTabItemHomeBtn;
    private ImageView mTabItemCategoryBtn;
    private ImageView mTabItemCartBtn;
    private ImageView mTabItemPersonBtn;
    private FragmentManager mFragmentManager;

    private HomeFragment mHomeFragment;
    private CategoryFragment mCategoryFragment;
    private CartFragment mCartFragment;
    private PersonFragment mPersonFragment;

    private int currentId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation, container, false);

        initViews(view);

        setTabSelection(R.id.tab_item_home);


        return view;
    }

    private void initViews(View view) {
        mTabItemHome = view.findViewById(R.id.tab_item_home);
        mTabItemHome.setOnClickListener(this);

        mTabItemCategory = view.findViewById(R.id.tab_item_category);
        mTabItemCategory.setOnClickListener(this);

        mTabItemCart = view.findViewById(R.id.tab_item_cart);
        mTabItemCart.setOnClickListener(this);

        mTabItemPerson = view.findViewById(R.id.tab_item_personal);
        mTabItemPerson.setOnClickListener(this);

        mTabItemHomeBtn = view.findViewById(R.id.tab_item_home_btn);
        mTabItemCategoryBtn = view.findViewById(R.id.tab_item_category_btn);
        mTabItemCartBtn = view.findViewById(R.id.tab_item_cart_btn);
        mTabItemPersonBtn = view.findViewById(R.id.tab_item_personal_btn);

        mFragmentManager = getFragmentManager();
    }

    public void setTabSelection(int id) {
        mTabItemHomeBtn.setImageResource(R.drawable.tab_item_home_focus);
        mTabItemCategoryBtn.setImageResource(R.drawable.tab_item_category_focus);
        mTabItemCartBtn.setImageResource(R.drawable.tab_item_cart_focus);
        mTabItemPersonBtn.setImageResource(R.drawable.tab_item_personal_focus);

        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();

        if (mHomeFragment != null) {
            fragmentTransaction.hide(mHomeFragment);
        }
        if (mCategoryFragment != null) {
            fragmentTransaction.hide(mCategoryFragment);
        }
        if (mCartFragment != null) {
            fragmentTransaction.hide(mCartFragment);
        }
        if (mPersonFragment != null) {
            fragmentTransaction.hide(mPersonFragment);
        }

        switch (id) {
            case R.id.tab_item_home:
                mTabItemHomeBtn.setImageResource(R.drawable.tab_item_home_normal);
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.content, mHomeFragment);
                } else {
                    fragmentTransaction.show(mHomeFragment);
                }
                break;
            case R.id.tab_item_category:
                mTabItemCategoryBtn.setImageResource(R.drawable.tab_item_category_normal);
                if (mCategoryFragment == null) {
                    mCategoryFragment = new CategoryFragment();
                    fragmentTransaction.add(R.id.content, mCategoryFragment);
                } else {
                    fragmentTransaction.show(mCategoryFragment);
                }
                break;

            case R.id.tab_item_cart:
                mTabItemCartBtn.setImageResource(R.drawable.tab_item_cart_normal);
                if (mCartFragment == null) {
                    mCartFragment = new CartFragment();
                    fragmentTransaction.add(R.id.content, mCartFragment);
                } else {
                    fragmentTransaction.show(mCartFragment);
                }
                break;

            case R.id.tab_item_personal:
                mTabItemPersonBtn.setImageResource(R.drawable.tab_item_personal_normal);
                if (mPersonFragment == null) {
                    mPersonFragment = new PersonFragment();
                    fragmentTransaction.add(R.id.content, mPersonFragment);
                } else {
                    fragmentTransaction.show(mPersonFragment);
                }
                break;
        }

        fragmentTransaction.commit();

        currentId = id;

    }


    @Override
    public void onClick(View v) {
        setTabSelection(v.getId());
    }
}
