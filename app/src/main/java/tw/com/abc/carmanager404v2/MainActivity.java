package tw.com.abc.carmanager404v2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public String TAG="geoff";
    private Page1 page1;
    private Page2 page2;
    private Page3 page3;
    private Page4 page4;
    private FragmentManager fmgr;
    private ViewPager viewPager;
    private Fragment[] fragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.container);

        page1 = new Page1();
        page2 = new Page2();
        page3 = new Page3();
        page4 = new Page4();

        fragments = new Fragment[]{page1,page2,page3,page4};

        fmgr = getSupportFragmentManager();
        viewPager.setAdapter(new  MyPagerAdapter(fmgr));
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setCurrentItem(0);

    }

    private class MyPagerAdapter extends FragmentStatePagerAdapter{

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments[position];
            //return null;
        }

        @Override
        public int getCount() {
            return  fragments.length;
//            return 0;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String strTitle = "輸入資料";
            switch (position){
                case 0:
                    strTitle ="輸入資料";
                    break;
                case 1:
                    strTitle ="瀏覽資料";
                    break;
                case 2:
                    strTitle ="設定";
                    break;
                case 3:
                    strTitle ="關於我";
                    break;
            }


            return strTitle;
//            return super.getPageTitle(position);
        }

    }
}
