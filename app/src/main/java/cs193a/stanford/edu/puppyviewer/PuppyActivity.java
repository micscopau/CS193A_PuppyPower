/*
 * CS 193A, Marty Stepp
 * This activity class demonstrates several useful libraries shown in class today.
 */

package cs193a.stanford.edu.puppyviewer;

import android.os.*;
import android.view.*;
import android.widget.*;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import stanford.androidlib.*;

public class PuppyActivity extends SimpleActivity {
    // constant for base web URL where image files are found
    private static final String WEBSITE_DIRECTORY = "http://www.martystepp.com/dogs/";

    private static final String[] ALL_IMAGES = {
            "barney-and-clyde-12.jpg",
            "daisy-14.jpg",
            "barney-and-clyde-02-large.jpg"
    };

    //@BindView(R.id.puppyphoto) ImageView img; //usefull if using a lot of findViewById

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puppy);
        ButterKnife.bind(this);

        SimpleList.with(this).setItems(R.id.puppy_spinner, ALL_IMAGES); //instead of using adaptor

        //* Code being replaced by ButterKnife Library (see annotation onItemSelected :
//        Spinner spin = (Spinner) findViewById(R.id.puppy_spinner);
//        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });

    }

    @OnItemSelected(R.id.puppy_spinner)
    public void itemGotSelected(AdapterView<?> adapterView, View view, int i, long l){
        String filename = ALL_IMAGES[i];
        log("You clicked: " + filename);
    }

    @OnClick(R.id.clickme)
    public void clickMeClick(View view) {
        //widget effects
        YoYo.with(Techniques.Wobble)
                .duration(2000)
                .withListener(new AnimatorListenerAdapter() {
                    @Override  // to perform an action after effect is completed, need to implement .withListener of YoYo
                    public void onAnimationEnd(Animator animation) {
                        displayImage();
                    }
                })
                .playOn(view);

    }

    private void displayImage(){
        ImageView img = $IV(R.id.puppyphoto);
        //download and display
        Picasso.with(this)
                .load("http://www.martystepp.com/dogs/barney-and-clyde-12.jpg")
                .placeholder(R.drawable.loading)
                .into(img);
    }
}
