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
import com.squareup.picasso.Picasso;

import stanford.androidlib.*;

public class PuppyActivity extends SimpleActivity {
    // constant for base web URL where image files are found
    private static final String WEBSITE_DIRECTORY = "http://www.martystepp.com/dogs/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puppy);
    }

    public void clickMeClick(View view) {
        //widget effects
        YoYo.with(Techniques.Wobble)
                .duration(5000)
                .playOn(view);

        // to perform an action after effect is completed, need to implement .withListener of YoYo


        //download and display
        ImageView img = $IV(R.id.puppyphoto);
        Picasso.with(this)
                .load("http://www.martystepp.com/dogs/barney-and-clyde-12.jpg")
                .placeholder(R.drawable.loading)
                .into(img);
    }
}
