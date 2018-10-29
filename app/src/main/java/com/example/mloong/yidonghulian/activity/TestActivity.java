package com.example.mloong.yidonghulian.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mloong.yidonghulian.R;
import com.example.mloong.yidonghulian.db.Category;
import com.example.mloong.yidonghulian.db.GreenDaoManager;
import com.example.mloong.yidonghulian.entity.MemberEntity;
import com.example.mloong.yidonghulian.gen.CategoryDao;
import com.example.mloong.yidonghulian.http.ProgressDialogSubscriber;
import com.example.mloong.yidonghulian.presenter.MemberPresenter;
import com.example.mloong.yidonghulian.utils.OkHttpUtils;

import java.net.MalformedURLException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class TestActivity extends AppCompatActivity {

    @BindView(R.id.txt)
    TextView txt;

    private CategoryDao mCategoryDao;
    private Category mCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);


//okHttp test
//        try {
//            testPost();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }

        //greendao test
//        before();
//       // testGreenAdd();
//        update();
//        delete();
//        testQuery();

//        testRetrofit
//        testRetrofit();
//        testRetrofit2();
//        testRetrofit3();
        testRetrofit4();

        //txt.setText("ni");
    }

//    public void testRetrofit() {
//        MemberPresenter.register(new Subscriber<MemberEntity>() {
//            @Override
//            public void onSubscribe(Subscription s) {
//
//            }
//
//            @Override
//            public void onNext(MemberEntity memberEntity) {
//                txt.setText(memberEntity.toString());
//            }
//
//            @Override
//            public void onError(Throwable t) {
//                txt.setText(t.getMessage());
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        }, "zhangshan", "password", "206");
//
//
//    }
//
//    public void testRetrofit2() {
//        MemberPresenter.register(new Consumer<MemberEntity>() {
//            @Override
//            public void accept(MemberEntity memberEntity) throws Exception {
//                txt.setText(memberEntity.toString());
//            }
//        }, "zhangshan", "password", "206");
//
//
//    }

    public void testRetrofit3() {
        MemberPresenter.register(new Observer<MemberEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(MemberEntity memberEntity) {
                txt.setText(memberEntity.toString());
            }

            @Override
            public void onError(Throwable e) {
                txt.setText(e.getMessage());
            }

            @Override
            public void onComplete() {
                Toast.makeText(TestActivity.this, "success", Toast.LENGTH_SHORT).show();
            }
        }, "zhangshan", "password", "2060344029@qq.com");


    }

    public void testRetrofit4() {
        MemberPresenter.register(new ProgressDialogSubscriber<MemberEntity>(this) {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(MemberEntity memberEntity) {
                txt.setText(memberEntity.toString());
            }

            @Override
            public void onError(Throwable e) {
                txt.setText(e.getMessage());
            }

            @Override
            public void onComplete() {
                Toast.makeText(TestActivity.this, "success", Toast.LENGTH_SHORT).show();
            }
        }, "zhangshan", "password", "2060344029@qq.com");


    }

    public void before() {
        mCategoryDao = GreenDaoManager.getDaoSession().getCategoryDao();
        mCategory = new Category();
        mCategory.setGoods_counts(1);
        mCategory.setCat_id(10L);
        mCategory.setImage("image");
        mCategory.setList_show(10);
        mCategory.setParent_id(3);
    }

    public void testGreenAdd() {
        long insert = mCategoryDao.insert(mCategory);
        System.out.println(insert);
    }

    private void testPost() throws MalformedURLException {
        OkHttpUtils.postOkHttp(this, txt);
    }

    private void update() {
        mCategory.setImage("Chen位");
        mCategoryDao.update(mCategory);

    }

    private void delete() {
        mCategoryDao.delete(mCategory);
    }

    private void testQuery() {
        List<Category> categories = mCategoryDao.loadAll();
        System.out.println(categories);
        txt.setText(categories.toString());
    }
}
