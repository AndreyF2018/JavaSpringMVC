package models;
import javax.persistence.*;
@Entity
@Table(name = "dishes")
public class Dish
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer DishID;

    @Column(name = "Title")
    private String diishTitle;


    @Column(name = "Price")
    private float dishPrice;

    public Dish()
    {

    }
    public Integer getId()
    {
        return DishID;
    }

    public void setId(Integer id)
    {
        this.DishID = id;
    }

    public String getDiishTitle()
    {
        return diishTitle;
    }

    public void setDiishTitle(String title)
    {
        this.diishTitle = title;
    }
    public float getDishPrice()
    {
        return dishPrice;
    }

    public void setDishPrice(float price)
    {
        this.dishPrice = price;
    }

    @Override
    public String toString()
    {
        return DishID + ". " + diishTitle + " " +  dishPrice;
    }

    public Dish(String title, float price)
    {

        this.setDiishTitle(title);
        this.setDishPrice(price);
    }
}