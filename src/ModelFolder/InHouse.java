package ModelFolder;
/****
 *** @author Nicholas Walters
 **/


/****
 *** Inhouse class - 1.
 *** InHouse is inherited by Part with extend - 4.
 **/


/**
 * This class has the info inregards to the inhouse radio button.
 * This information will also pull from the parts class.
 */
public class InHouse extends Part {
    /****
     *** Int machineID - 2A.
     **/
    private int machineID;


    /****
     *** need constructor - 3A
     ***
     *** @param id
     *** @param stock
     *** @param min
     *** @param max
     *** @param name
     *** @param price
     **/

    public InHouse(int id,int stock,int min,int max,String name,double price, int machineID){
        super(id,stock,min,max,name,price);
        this.machineID = machineID;
    }



    /****
     *** need method to set the machine ID - 3B
     **/
    public void setMachineID(int machineID) {
        this.machineID = machineID;
    }

    /****
     *** need method to get the machine ID - 3C
     **/
    public int getMachineID() {
        return machineID;
    }



    /****
     *** end of the line
     *** don't continue
     **/

/*#^#^#^#^#^#^##^#^#^#^ REQUIREMENTS  ^#^#^#^#^#^#^#^#^#^#^#^#
1. Name of Class = InHouse
2. Data Members =
2A. - int = MachineID
3. Methods =
3A. - Constructor
!! needs
- int = id
- String = name
- Double = price
- int = stock
- int = min
- int = max
- int = MachineId
3B. Method = setMachineID (companyName)- void
3C. Method = getMachineID (companyName)- String
4. Inhouse is inherited by Part

^##^#^#^#^#^#^#^#^#^##^^##^#^#^#^#^#^#^#^#^##^^##^#^#^#^#^#^#^#^#^#
 */

}
