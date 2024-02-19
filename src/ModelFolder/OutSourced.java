package ModelFolder;


/****
 *** @author Nicholas Walters
 **/

/****
 *** OutSourced class - 1.
 *** OutSourced is inherited by Part with extend - 4.
 **/

/**
 * This class will house the info if the outsourced radio button is clicked.
 */
public class OutSourced extends Part {

    /****
     *** String CompanyName - 2A.
     **/
    private String companyName;

    /****
     *** need constructor - 3A
     ***
     *** @param id
     *** @param stock
     *** @param min
     *** @param max
     *** @param name
     *** @param price
     *** @param companyName
     **/
    public OutSourced(int id, int stock, int min, int max, String name, double price, String companyName) {
        super(id, stock, min, max, name, price);
        this.companyName = companyName;


    }

    /****
     *** need method to set the company name - 3B
     **/
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /****
     *** need method to get the company name - 3C
     **/
    public String getCompanyName() {
        return companyName;
    }


    /****
     *** end of the line
     *** don't continue
     **/

/*#^#^#^#^#^#^##^#^#^#^ REQUIREMENTS  ^#^#^#^#^#^#^#^#^#^#^#^#
1. Name of Class = OutSourced
2. Data Members =
2A. - String = CompanyName
3. Methods =
3A. - Constructor
!! needs
- int = id
- String = name
- Double = Price
- int = stock
- int = min
- int = max
- String = companyName
3B. Method = setCompanyName (companyName)- void
3C. Method = getCompanyName (companyName)- String
4. OutSourced is inherited by Part

^##^#^#^#^#^#^#^#^#^##^^##^#^#^#^#^#^#^#^#^##^^##^#^#^#^#^#^#^#^#^#
 */

}
