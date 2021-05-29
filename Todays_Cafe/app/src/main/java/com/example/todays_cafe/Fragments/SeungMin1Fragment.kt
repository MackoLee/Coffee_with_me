package com.example.todays_cafe.Fragments

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.todays_cafe.MyIntroPagerRecyclerAdapter
import com.example.todays_cafe.PageItem
import com.example.todays_cafe.R
import kotlinx.android.synthetic.main.fragment_seungmin1.*

class SeungMin1Fragment : AppCompatActivity() {

    private var sliderHandler = Handler()
    private var pageItemList = ArrayList<PageItem>()
    private lateinit var myIntroPagerRecyclerAdapter : MyIntroPagerRecyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_seungmin1)

        Log.v("Log", "SeungMin1Fragment - onCreate called")

        val text1 = "솔직 담백한 카페 리뷰를 바탕으로\n나만의 카페를 추천해드립니다.";
        var text2 = "우리 서비스가 짱이에요!!";
        var text3 = "무~야~호!";

        pageItemList.add(PageItem(R.drawable.a, R.color.obviousBlack, text1))
        pageItemList.add(PageItem(R.drawable.b, R.color.obviousBlack, text2))
        pageItemList.add(PageItem(R.drawable.c, R.color.obviousBlack, text3))

        myIntroPagerRecyclerAdapter = MyIntroPagerRecyclerAdapter(pageItemList)

        // ViewPager 레이아웃에 적용하기
        my_intro_view_pager.apply {
            Log.v("Log", "SeungMin1Fragment - my_intro_view_pager.apply called")
            adapter = myIntroPagerRecyclerAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            dots_indicator.setViewPager2(this)

            // 페이지를 드래그로 넘겼을 때 이벤트를 발생시키는 콜백메소드
            this.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    Log.v("Log", "SeungMin1Fragment - registerOnPageChangeCallback called")
                    sliderHandler.removeCallbacks(sliderRunnable)
                    sliderHandler.postDelayed(sliderRunnable, 3000)
                }
            })
        }
    }

    // 자동 슬라이딩 스레드
    var sliderRunnable = Runnable {
        Log.v("Log", "SeungMin1Fragment - sliderRunnable run called")
        my_intro_view_pager.setCurrentItem((my_intro_view_pager.currentItem + 1) % pageItemList.size)
    }

    override fun onResume() {
        Log.v("Log", "SeungMin1Fragment - onResume called")
        super.onResume()
        sliderHandler.postDelayed(sliderRunnable, 3000)
    }

    override fun onPause() {
        Log.v("Log", "SeungMin1Fragment - onPause called")
        super.onPause()
        sliderHandler.removeCallbacks(sliderRunnable)
    }
}