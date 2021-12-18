package as.course.foodslist;

import android.content.pm.PackageManager;
import android.text.BoringLayout;
import android.util.Log;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;
import java.util.List;

public class FoodsXMLParser {
    XmlPullParser xpp;
    private String currentName;
    private Double currentPrice;
    private Integer currentId;

    public FoodsXMLParser(XmlPullParser xpp) {
        this.xpp = xpp;
    }

    public ArrayList<Food> getFoodsList() {
        ArrayList<Food> foodsList = new ArrayList<>();
        int isName = 0;
        int isPrice = 0;


        try {

            //Food currentFood;
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {

                if (eventType == XmlPullParser.START_DOCUMENT) {
                }
                else if (eventType == XmlPullParser.START_TAG) {
                    if (xpp.getName().equals("food")) {
                        currentId = Integer.valueOf(xpp.getAttributeValue(0));
                    }
                    if (xpp.getName().equals("name")) {
                        isName = 1;
                    }
                    if (xpp.getName().equals("price")) {
                        isPrice = 1;
                    }

                } else if (eventType == XmlPullParser.END_TAG) {
                    if (xpp.getName().equals("food")) {
                        foodsList.add(new Food(this.currentName, this.currentPrice,this.currentId));
                    }


                } else if (eventType == XmlPullParser.TEXT) {
                    if (isName == 1) {
                        this.currentName = xpp.getText();
                        isName=0;
                    }
                    if (isPrice == 1) {
                        this.currentPrice = Double.valueOf(xpp.getText());
                        isPrice=0;
                    }
                }

                eventType = xpp.next();
            }
        } catch (Throwable t) {
            Log.v("Parser", "Ошибка при загрузке XML-документа: " + t.toString());
        }
        return foodsList;
    }

    public Food getFood(Integer id) {
        Food currentFood = new Food ();
        Boolean isFound = false;
        Boolean isName = false;
        Boolean isPrice = false;
        Boolean isDescription = false;
        Boolean isCalories = false;

        try {
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {

                if (eventType == XmlPullParser.START_TAG) {
                    if (xpp.getName ( ).equals ( "food" )) {
                        if (Integer.valueOf ( xpp.getAttributeValue ( 0 ) ) == id) {
                            isFound = true;
                        }
                    }
                    else if (xpp.getName().equals("name")) {
                        isName = true;
                    }
                    else if (xpp.getName().equals("price")) {
                        isPrice = true;
                    }
                    else if (xpp.getName().equals("description")) {
                        isDescription = true;
                    }
                    else if (xpp.getName().equals("calories")) {
                        isCalories = true;
                    }
                }
                else if (eventType == XmlPullParser.TEXT) {
                    if (isName && isFound) {
                        currentFood.setName ( xpp.getText() );
                        isName=false;
                    }
                    else if (isPrice && isFound) {
                        currentFood.setPrice (Double.valueOf( xpp.getText()) );
                        isPrice=false;
                    }
                    else if (isDescription && isFound) {
                        currentFood.setDescription ( xpp.getText() );
                        isDescription=false;
                    }
                    else if (isCalories && isFound) {
                        currentFood.setCalories (Double.valueOf( xpp.getText()) );
                        isCalories=false;
                    }
                }
                else if (eventType == XmlPullParser
                        .END_TAG && xpp.getName ( ).equals ( "food" )) {
                    isFound = false;
                }


                eventType = xpp.next();
            }
        }
        catch (Throwable t) {
            Log.v("Parser", "Ошибка при загрузке XML-документа: " + t.toString());
        }
        return currentFood;
    }}