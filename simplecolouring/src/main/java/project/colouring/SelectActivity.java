package project.colouring;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

public class SelectActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory {

    private ImageSwitcher mImageSwitcher;
    int position = 0;
    private int[] mImageIds = {R.drawable.taipei, R.drawable.paris, R.drawable.moscow, R.drawable.berlin};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_image);

        mImageSwitcher = (ImageSwitcher)findViewById(R.id.imageSwitcher);
        mImageSwitcher.setFactory(this);

        Animation inAnimation = new AlphaAnimation(0, 1);
        inAnimation.setDuration(2000);
        Animation outAnimation = new AlphaAnimation(1, 0);
        outAnimation.setDuration(2000);

        mImageSwitcher.setInAnimation(inAnimation);
        mImageSwitcher.setOutAnimation(outAnimation);

        mImageSwitcher.setImageResource(mImageIds[0]);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnNext:
                setPositionNext();
                mImageSwitcher.setImageResource(mImageIds[position]);
                break;
            case R.id.btnPrev:
                setPositionPrev();
                mImageSwitcher.setImageResource(mImageIds[position]);
                break;
            case R.id.btnSelect:
                Intent selectIntent = new Intent(SelectActivity.this, MainActivity.class);
                selectIntent.putExtra("srcId", mImageIds[position]);
                startActivity(selectIntent);
            default:
                break;
        }
    }

    public void setPositionNext(){
        position++;
        if(position > mImageIds.length - 1){
            position = 0;
        }
    }

    public void setPositionPrev(){
        position--;
        if(position < 0){
            position = mImageIds.length - 1;
        }
    }

    final String TAG = "States";

    @Override
    public View makeView(){
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(new
                ImageSwitcher.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
        ));
        //imageView.setBackgroundColor(0xFF000000);
        return  imageView;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "SelectActivity: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "SelectActivity: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "SelectActivity: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "SelectActivity: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "SelectActivity: onDestroy()");
    }
}
