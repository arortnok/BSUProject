package project.colouring;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
    private int[] mImageIds = {R.drawable.unnamed, R.drawable.desert, R.drawable.des2};

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
            case R.id.nextButton:
                setPositionNext();
                mImageSwitcher.setImageResource(mImageIds[position]);
                break;
            case R.id.prevButton:
                setPositionPrev();
                mImageSwitcher.setImageResource(mImageIds[position]);
                break;
            default:
                break;
        }
    }

    public void setPositionNext(){
        position++;
        if(position>mImageIds.length - 1){
            position = 0;
        }
    }

    public void setPositionPrev(){
        position--;
        if(position<0){
            position = mImageIds.length - 1;
        }
    }

    @Override
    public View makeView(){
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(new
                ImageSwitcher.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
        ));
        imageView.setBackgroundColor(0xFF000000);
        return  imageView;
    }

}
