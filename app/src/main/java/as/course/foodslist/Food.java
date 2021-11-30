package as.course.foodslist;

public class Food {
    private String name;
    private double price;
    private double calories;
    private Integer id;
    private String description;

    public Food ( ) {
    }

    public Food ( String name , double price , double calories , Integer id , String description ) {
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.id = id;
        this.description = description;
    }

    public String getName ( ) {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public double getPrice ( ) {
        return price;
    }

    public void setPrice ( double price ) {
        this.price = price;
    }

    public double getCalories ( ) {
        return calories;
    }

    public void setCalories ( double calories ) {
        this.calories = calories;
    }

    public Integer getId ( ) {
        return id;
    }

    public void setId ( Integer id ) {
        this.id = id;
    }

    public String getDescription ( ) {
        return description;
    }

    public void setDescription ( String description ) {
        this.description = description;
    }
}
