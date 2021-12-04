package as.course.foodslist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            ArrayList<Food> foodsItem = new ArrayList<Food>();
            foodsItem.add( new Food ( "aaa", 10.5, 540.0, 23, "fffffff"  ));
            foodsItem.add( new Food ( "bbb", 11.5, 640.0, 24, "ggggggg"  ));

            ListView foodsListView = findViewById(R.id.foods_list_view);
            FoodsAdapter foodListAdapter = new FoodsAdapter(this, R.layout.foods_list_item, foodsItem);
            foodsListView.setAdapter(foodListAdapter);
        }
    }
