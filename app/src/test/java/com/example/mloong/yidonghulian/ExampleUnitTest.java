package com.example.mloong.yidonghulian;

import com.example.mloong.yidonghulian.db.Category;
import com.example.mloong.yidonghulian.db.GreenDaoManager;
import com.example.mloong.yidonghulian.gen.CategoryDao;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private CategoryDao mCategoryDao;
    private Category mCategory;

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Before
    public void before() {
        GreenDaoManager.getmInstance();
        mCategoryDao = GreenDaoManager.getDaoSession().getCategoryDao();
        mCategory = new Category();
        mCategory.setGoods_counts(1);
        mCategory.setCat_id(10L);
        mCategory.setImage("image");
        mCategory.setList_show(10);
        mCategory.setParent_id(3);
    }

    @Test
    public void testGreenAdd() {
        long insert = mCategoryDao.insert(mCategory);
        System.out.println(insert);
    }
}