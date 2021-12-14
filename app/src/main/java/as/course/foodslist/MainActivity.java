package as.course.foodslist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_ID = "foodId";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            ///ArrayList<Food> foodsItem = new ArrayList<Food>();

           /// foodsItem.add( new Food ( "aaa", 10.5, 540.0, 23, "fffffff"  ));
           /// foodsItem.add( new Food ( "bbb", 11.5, 640.0, 24, "ggggggg"  ));

           //foodsItem = parser.getFoods;

            XmlPullParser xpp = getResources ().getXml ( R.xml.foods );
            FoodsXMLParser fxp = new FoodsXMLParser ( xpp );
            ArrayList<Food> foodsItem = fxp.getFoodsList();

            ListView foodsListView = findViewById(R.id.foods_list_view);
            FoodsAdapter foodListAdapter = new FoodsAdapter(this, R.layout.foods_list_item, foodsItem);
            foodsListView.setAdapter(foodListAdapter);

            foodsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                        long id) {
                    //Integer currentId = foodsItem.get ( position ).getId ();

                    //Toast.makeText(getApplicationContext(), String.valueOf ( currentId ),Toast.LENGTH_SHORT).show();
                    //showFoodDetails(currentId);
                    showFoodDetails (foodsItem.get ( position ).getId () );
                }
            });

        }


        public void showFoodDetails(Integer currentId) {
            Intent intent = new Intent(this, FoodViewActivity.class);
            intent.putExtra ( MainActivity.EXTRA_ID, currentId );
            startActivity(intent);
        }
}
