package as.course.foodslist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;

public class FoodViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_food_view );

        Intent intent = getIntent();
        Integer currentId = intent.getIntExtra(MainActivity.EXTRA_ID, 0);
       // Toast.makeText(getApplicationContext(), String.valueOf(currentId), Toast.LENGTH_SHORT).show();

        String imgName = "f" + currentId;
        int resourceId = this.getResources().getIdentifier(imgName, "drawable", this.getPackageName());
        ImageView foodImage = (ImageView) findViewById(R.id.foodimage);
        foodImage.setImageResource(resourceId);

        XmlPullParser xpp = getResources ().getXml ( R.xml.foods );
        FoodsXMLParser fxp = new FoodsXMLParser ( xpp );
        Food food = fxp.getFood (currentId);
        Toast.makeText(getApplicationContext(), food.getName (), Toast.LENGTH_SHORT).show();
    }

}