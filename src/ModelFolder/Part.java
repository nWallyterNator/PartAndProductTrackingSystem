package ModelFolder;

/****
 *** @author Nicholas Walters
 **/

/****
 *** Part class - 1.
 *** Part needs to be abstract - 4.
 **/

/**
 * This will have the info pertaining to the part.
 * This class is an abstract class.
 */
public abstract class  Part  {
/****
 *** 2A. - int = @param id,name,price,stock,min,max
 *** 2B. - String = name
 *** 2C. - double = price
 *** 2D. - int = stock
 *** 2E. - int min
 *** 2F. - int max
 **/


    /****
     *** - fixed  refactored idPart to id based on the test results
     **/
    private int id,stock,min,max;
    private String name;
    private double price;


/****
 *** need constructor - 3A
 *** redid constructor based on test result
 **/
    public Part(int id, int stock, int min, int max, String name, double price) {
        this.id = id;
        this.stock = stock;
        this.min = min;
        this.max = max;
        this.name = name;
        this.price = price;
    }
    /****
     *** need getters and setters for methods  - 3B-3L
     **/



    /****
     *** returns the id - 3H
     **/
    public int getId() {
        return id;
    }

    /****
     *** sets the id - 3B
     **/
    public void setId(int id) {
        this.id = id;
    }

    /****
     *** returns the inventory number - 3J
     **/
    public int getStock() {
        return stock;
    }

    /****
     *** sets the inventory number - 3E
     **/
    public void setStock(int stock) {
        this.stock = stock;
    }

    /****
     *** returns the min number - 3K
     **/
    public int getMin() {
        return min;
    }

    /****
     *** sets the min number - 3F
     **/
    public void setMin(int min) {
        this.min = min;
    }

    /****
     *** returns the max number - 3L
     **/
    public int getMax() {
        return max;
    }

    /****
     *** sets the max number - 3G
     **/
    public void setMax(int max) {
        this.max = max;
    }

    /****
     *** returns the name of the part - 3M
     **/
    public String getName() {
        return name;
    }

    /****
     *** sets the name of the part - 3C
     **/
    public void setName(String name) {
        this.name = name;
    }

    /****
     *** returns the price of the part - 3I
     **/
    public double getPrice() {
        return price;
    }

    /****
     *** sets the price of the part - 3D
     **/
    public void setPrice(double price) {
        this.price = price;
    }

    /****
     *** end of the line
     *** don't continue
     **/

/*#^#^#^#^#^#^##^#^#^#^ REQUIREMENTS  ^#^#^#^#^#^#^#^#^#^#^#^#
1. Name of Class = Part
2. Data Members =
2A. - int = id
2B. - String = name
2C. - double = price
2D. - int = stock
2E. - int min
2F. - int max
3. Methods =
3A. - Constructor
!! needs
- int = id
- String = name
- Double = Price
- int = stock
- int = min
- int = max
3B. - setID
3C. - setName
3D. - setPrice
3E. - setStock
3F. - setMin
3G. - setMax
3H. - getid
3I. - getPrice
3J. - getStock
3K. - getMin
3l. - getMax
3M. - getName
4. it needs to be abstract

^##^#^#^#^#^#^#^#^#^##^^##^#^#^#^#^#^#^#^#^##^^##^#^#^#^#^#^#^#^#^#
 */

}
