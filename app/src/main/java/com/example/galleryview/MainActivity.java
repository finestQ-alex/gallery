package com.example.galleryview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

  Gallery gallery;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    gallery = (Gallery) findViewById(R.id.gallery);

    // 변수 적용 gAdpater
    MyGalleryAdapter gAdpater;
    gAdpater = new MyGalleryAdapter(this);
    gallery.setAdapter(gAdpater);
  }

  // BaseAdapter 상속받는 MyGalleryAdapter 클래스 생성
  class MyGalleryAdapter extends BaseAdapter{
    Context context;
    Integer[] posterID = {R.drawable.mov11, R.drawable.mov12, R.drawable.mov13, R.drawable.mov14,
      R.drawable.mov15, R.drawable.mov16, R.drawable.mov17, R.drawable.mov18,
      R.drawable.mov19, R.drawable.mov20
    };

    public MyGalleryAdapter(Context c){
      context = c;
    }

    @Override
    public int getCount() {
      return posterID.length; // 포스터 아이디의 갯수와 동일
    }

    @Override
    public Object getItem(int i) {
      return null;
    }

    @Override
    public long getItemId(int i) {
      return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
      ImageView imageView = new ImageView(context);
      imageView.setLayoutParams(new Gallery.LayoutParams(200, 300));
      imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      imageView.setPadding(5, 5, 5, 5);
      imageView.setImageResource(posterID[i]);

      int pos = i;
      imageView.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
          ImageView ivPoster = (ImageView) findViewById(R.id.ivPoster);
          ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
          ivPoster.setImageResource(posterID[pos]);
          return false;
        }
      });
      return imageView;
    }
  }
}