package ModelFolder;

/****
 *** @author Nicholas Walters
 **/

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.concurrent.atomic.AtomicInteger;

/****
 *** Inventory class - 1.
 *** needs to be static
 **/


/**
 * This class will house the the methods for the parts and the products.
 */
public class Inventory {
    /****
     *** need observablelist allParts & allProducts - 2A & 2B
     *** need to be static
     **/

    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();


    /*P@P@P@P@P@P@P@@P@P@ PART METHODS P@P@P@P@@P@P@P@@P@P@P@P@P@P@P@P@P@P@

     @P@@P@P@P@P@P@P@P@P@@P@@P@P@P@P@P@P@P@P@@P@P@P@P@P@P@P@P@@@P@P@P@P@P@@
     */

    /****
     *** need observablelist getAllParts - 3K
     *** @return allParts
     **/
    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    /****
     *** need boolean that deletes selectedPart - 3I
     *** it will delete the part from the list
     **/
    public static boolean deletePart(Part selectedPart) {
        if (allParts.contains(selectedPart)) {
            allParts.remove(selectedPart);

            return true;
        } else {

            return false;
        }
    }

    /****
     *** need a method called updatePart - 3G
     *** this method will update the parts table and save it
     *** needs to be void
     **/
    public static void updatePart(int index, Part selectedPart) {

        Part changedPart = Inventory.lookupPart(index);
        Inventory.deletePart(changedPart);
        Inventory.addPart(selectedPart);

    }

    /****
     *** need a method called addPart and newPart - 3A
     *** this method will add a part to part table
     *** needs to be void
     **/
    public static void addPart(Part newPart) {

        allParts.add(newPart);
    }

    /****
     *** need a method called lookupPart  - 3C
     *** this method will be able to find the part with id
     **/
    public static Part lookupPart(int partId) {

        for (Part part : allParts) {
            if (partId == part.getId()) {
                return part;
            }
        }

        return null;

    }


    /****
     *** need a method called lookupPart  - 3E
     *** this method will be able to find the part name
     **/
    public static ObservableList<Part> lookupPart (String partialName){
        ObservableList<Part> detectedPart = FXCollections.observableArrayList();

        /****
         ***  adding a lower case condition
         **/

        /****
         *** - fixed I changed the method to convert to uppercase vs lowercase
         *** - added toUpperCase to the inside parenthesis as well to be applied to the partialName not just the part
         **/
        for(Part part : getAllParts()){
            if((part.getName().toUpperCase().contains(partialName.toUpperCase())) ) {
                detectedPart.add(part);
            }

            }


        return detectedPart;
    }


    /*pr0pr0pr0pr0pr0pr0pr0pr0pr0 PRODUCT METHODS  pr0pr0pr0pr0rpr0rpr0pr0pr0rpr

    0pr0pr0rpr0rpr0pr0pr0rpr0pr0rpr00pr0pr0rpr0rpr0pr0pr0rpr0pr0rpr00pr0pr0rpr0rpr0
     */

    /****
     *** need observablelist getAllProducts - 3L
     *** @return allProducts
     **/
    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }

    /****
     *** need boolean that deletes selectedProduct - 3J
     *** it will delete the product from the list
     **/
    public static boolean deleteProduct(Product selectedProduct) {
        if (allProducts.contains(selectedProduct)) {
            allProducts.remove(selectedProduct);

            return true;
        } else {

            return false;
        }
    }

    /****
     *** need a method called updateProduct - 3H
     *** this method will update the product table and save it
     *** needs to be void
     **/
    public static void updateProduct(int index, Product newProduct) {

        allProducts.set(index, newProduct);
        /****
         *** - tried a bunch of the methods below to see if that would delete the product when modify was clicked and saved
         *** - nothing worked except for making a new int named modIndex and I had it find the index of the selectedProduct
         *** -  commentting out the failures
         **/

        //Product changedProduct = Inventory.lookupProduct(index);      //fixed
        //Inventory.deleteProduct(changedProduct);
       // Inventory.addProduct(selectedProduct);
       //Product changedProduct = Inventory.lookupProduct(index);
       // Inventory.deleteProduct(newProduct);
       // Inventory.addProduct(newProduct);


    }

    /****
     *** need a method called addProduct and newProduct - 3B
     *** this method will add a product to product table
     *** needs to be void
     **/
    public static void addProduct(Product newProduct) {

        allProducts.add(newProduct);
    }


    /****
     *** need a method called lookupproduct  - 3D
     *** this method will be able to find the product with matching id
     **/
    public static Product lookupProduct(int productId) {

        for (Product product : allProducts) {
            if (productId == product.getIdProduct()) {
                return product;
            }
        }

        return null;

    }


    /****
     *** need a method called lookupProduct  - 3E
     *** this method will be able to find the product name
     **/
    public static ObservableList<Product> lookupProduct (String productPartialName){
        ObservableList<Product> detectedProduct = FXCollections.observableArrayList();

        /****
         *** - fixed I changed the method to convert to uppercase vs lowercase
         *** -  added toUpperCase to the inside parenthesis as well to be applied to the productPartialName not just to product
         **/

        for(Product product : getAllProducts()){
            if(product.getName().toUpperCase().contains(productPartialName.toUpperCase())){
                detectedProduct.add(product);
            }

        }
        return detectedProduct;
    }


    /****
     *** need to call testable data method and make it static to make it ru
     **/

    static{
        testableData();
    }

    /*@P@@P@P@P@P@P@P@P@P@@P@@P@P@P@P     OTHER METHODS        @P@P@P@P@@P@P@P@P@P@P@P@P@@@P@P@P@P@P@@*/

    /****
     *** method to get a new id each time for parts
     **/
    public static AtomicInteger getBrandNewPartID = new AtomicInteger(43);

    /****
     *** method to get new id for products
     **/
    public static AtomicInteger getGetBrandNewProductID = new AtomicInteger(11);



    /****
     *** method to generate testing data
     **/
    public static void testableData (){


        /* ^^^**iiiii**^^ ^^^**iiiii**^^ ^^^**iiiii**^^    INHOUSE PARTS  WITH PRODUCTS       ^^^**iiiii**^^ ^^^**iiiii**^*/

        InHouse arc_reactor = new InHouse(001, 15, 1, 100, "arc reactor", 55.00, 98); // iron man product
        Inventory.addPart(arc_reactor);

        InHouse mind_stone = new InHouse(002,5,3,800,"mind stone",60.76,43); // infinityGauntlet product
        Inventory.addPart(mind_stone);

        InHouse vibranium = new InHouse(003,10,5,1000,"vibranium",457.00, 5000); // capn america shield product
        Inventory.addPart(vibranium);

        InHouse nickel_plated_brass = new InHouse(004, 10,1,2000,"nickel and brass pieces",3.00,1234 ); //spiderman webshooters product
        Inventory.addPart(nickel_plated_brass);

        InHouse uru = new InHouse(005,25, 7, 450,"uru",45.68,4589); // mjolnir product
        Inventory.addPart(uru);

        InHouse gold_titanium_alloy = new InHouse(006,31,12,40,"gold titanium alloy",284,257); //iron man product
        Inventory.addPart(gold_titanium_alloy);

        InHouse time_stone = new InHouse(007, 45, 20,59, "time stone",500.34, 3957); // infinityGuantlet
        Inventory.addPart(time_stone);

        InHouse disc_shaped_alloy = new InHouse(8,15,2,78,"disc alloy",600, 3279); //cpn America shield product
        Inventory.addPart(disc_shaped_alloy);

        InHouse cartridges= new InHouse(9,50,13,500,"cartridges",67.98, 458); //spider man web shooters product
        Inventory.addPart(cartridges);

        InHouse worthiness_enchantment = new InHouse(10,53,26,68,"worthiness enchantment", 37.97, 5748); // mjolnir product
        Inventory.addPart(worthiness_enchantment);

        InHouse anti_tank_missles = new InHouse(11, 47, 13,50,"anti tank missles", 604.54,247); // iron man suit product
        Inventory.addPart(anti_tank_missles);

        InHouse power_stone = new InHouse(12,45,28,63,"power stone", 55.00,48); // infinity guantlet product
        Inventory.addPart(power_stone);

        InHouse red_white_blue = new InHouse(13,45,3,58,"red white blue", 9.99,20489); //cpn america shield product
        Inventory.addPart(red_white_blue);

        InHouse palm_switch = new InHouse(14,50,7,77,"palm switch", 58.32,946); // spiderman web shooter product
        Inventory.addPart(palm_switch);

        InHouse weather_manipulation_enchantment = new InHouse(15,49,35,87,"weather enchantment", 93.87,938); // mjolnir product
        Inventory.addPart(weather_manipulation_enchantment);

        /* ^^^**iiiii**^^ ^^^**iiiii**^^ ^^^**iiiii**^^ ^^^**iiiii**^^ ^^^**iiiii**^^ ^^^**iiiii**^^ ^^^**iiiii**^^ ^^^**iiiii**^^* ^^^**iiiii**^ */


        /*!!O^&##&^O!!!!O^&##&^O!!!!O^&##&^O!!!!O^&##&^O!!!!O^&#      OUTSOURCED WITH PRODUCT        #&^O!!!!O^&##&^O!!!!O^&##&^O!!!!O^&##&^O!!!!O^&##&^O!!!!O^&##&^O!! */
        OutSourced shoulder_mini_guns = new OutSourced(16,5,2,8,"mini guns", 492.22,"Stark Industrys"); // ironman product
        Inventory.addPart(shoulder_mini_guns);

        OutSourced space_stone = new OutSourced(17,80,32,98,"space stone",421.87,"Thanos Ship"); // infinity guantlet
        Inventory.addPart(space_stone);

        OutSourced patriotic_stars = new OutSourced(18, 22,11,198,"patriotic stars", 642.35, "America Home of the Brave"); //cpn america shield product
        Inventory.addPart(patriotic_stars);

        OutSourced reality_stone = new OutSourced(19,20,2,200,"reality stone", 85.98,"Doctor Strange Amulet"); // infinity guantlet product
        Inventory.addPart(reality_stone);

        OutSourced web_fluid = new OutSourced(20, 13,3,40,"web fluid", 7.77,"Oscorp"); // spiderman webshooters product
        Inventory.addPart(web_fluid);

        OutSourced flight_enchantment = new OutSourced(21, 6,2,88, "flight enchantment", 98.77,"Valhalla"); // mljornir product
        Inventory.addPart(flight_enchantment);

        OutSourced energy_protection_enchantment = new OutSourced(22, 8, 5,10," energy protection ", 46.71, "Byfrost"); //mjolnir product
        Inventory.addPart(energy_protection_enchantment);

        OutSourced jarvis = new OutSourced(23, 65, 23, 89, "jarvis", 999.99,"Stark Industries"); //iron man suit product
        Inventory.addPart(jarvis);


        OutSourced soul_stone = new OutSourced(24,55,43,93,"soul stone", 875.99,"Black Widow Fall" ); // infinity gauntlet product
        Inventory.addPart(soul_stone);


        /*!!O^&##&^O!!!!O^&##&^O!!!!O^&##&^O!!!!O^&##&^O!!!!O^&##&^O!!!!O^&##&^O!!!!O^&##&^O!!!!O^&##&^O!!!!O^&##&^O!!!!O^&##&^O!!!!O^&##&^O!!!!O^&##&^O!!!!O^&##&^O!*/



        /* %  %  %  %  %  %  %  %  %  %  %  %  %  %  %  %  %  %  %  %       OUTSOURCED PART NO PRODUCT     %  %  %  %  %  %  %  %  %  %  %  %  %  %  %  %  %  %  %  %  %  %  %  % */

        OutSourced bc_rich_warlock = new OutSourced(25,76,32,741,"bc rich", 789.99,"Upside Down" );
        Inventory.addPart(bc_rich_warlock);

        OutSourced happy_thoughts = new OutSourced(26,57,34,59,"happy thoughts", 700.00,"Neverland");
        Inventory.addPart(happy_thoughts);

        OutSourced force = new OutSourced(27, 8,4,62,"force", 65.56,"Jedi Counsel");
        Inventory.addPart(force);

        OutSourced baymax = new OutSourced(28,83,59, 99,"baymax",384.10,"sanfransocio");
        Inventory.addPart(baymax);

        OutSourced snow_globe = new OutSourced(29,67,45,87,"snow globe", 91.43,"North Pole");
        Inventory.addPart(snow_globe);

        OutSourced sausage = new OutSourced(30,12,9,29,"sausage", 87.99," Sausage King of Chicago");
        Inventory.addPart(sausage);

        OutSourced mad_Party = new OutSourced(31, 43,20,75,"mad party", 73.08," Wonderland");
        Inventory.addPart(mad_Party);

        OutSourced lil_Sebastion = new OutSourced(32,55,33,88,"lil sebastian",56.21,"Pawnee");
        Inventory.addPart(lil_Sebastion);

        OutSourced wine = new OutSourced(33,77,45,98,"wine",74.80,"Rose Apocathery");
        Inventory.addPart(wine);

        /*  % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % % %  */

        /*-_-___-__--_-___-_--_-___-_--_-___-_--_-___-_--_-___-_--_-___-_--    INHOUSE NO PRODUCt        _-___-_--_-___-_--_-___-_--_-___-_--_-___-_--_-___-_--_-___-_-*/
        InHouse mario_mushroom = new InHouse(34,91,58,100,"mario mushroom", 67.09,857);
        Inventory.addPart(mario_mushroom);

        InHouse elder_wand = new InHouse(35,51,32,98,"elder wand", 85.13, 9478);
        Inventory.addPart(elder_wand);

        InHouse one_ring = new InHouse(36,73,53,91," one ring", 83.77,9);
        Inventory.addPart(one_ring);

        InHouse pick_destiny = new InHouse(37, 19,11,92, "pick of destiny", 474.98,76);
        Inventory.addPart(pick_destiny);

        InHouse sonic_rings = new InHouse(38,71,38,1001,"sonic rings",77.10,101);
        Inventory.addPart(sonic_rings);

        InHouse golden_ticket = new InHouse(39, 81,37,900,"golden ticket",55.55, 893);
        Inventory.addPart(golden_ticket);

        InHouse wardrobe = new InHouse(40,68,51,79," wardrobe", 91.72,484);
        Inventory.addPart(wardrobe);

        InHouse zora_tunic = new InHouse(41, 55,44,66," zora tunic",71.01,341);
        Inventory.addPart(zora_tunic);

        InHouse dragon_ball = new InHouse(42,71,17,717,"dragon ball", 67.67, 3838);
        Inventory.addPart(dragon_ball);

        /*-_-___-_--_-___-_--_-___-_--_-___-_--_-___-_--_-___-_--_-___-_--_-___-_--_-___-_--_-___-_--_-___-_--_-___-_--_-___-_--_-___-_--_-___-_--_-___-_--_-___-_-*/


        /*--__^#^#__----__^#^#__----__^#^#__----__^#^#__----__^#^#__----_      PRODUCTS WITH PARTS   _^#^#__----__^#^#__----__^#^#__----__^#^#__----__^#^#__----__^#^#__----__^#^#__--*/

        Product ironManSuit = new Product(99,1,001,15,"iron man suit",8585);
        Inventory.addProduct(ironManSuit);
        ironManSuit.addAssoicatedPart(arc_reactor);
        ironManSuit.addAssoicatedPart(gold_titanium_alloy);
        ironManSuit.addAssoicatedPart(anti_tank_missles);
        ironManSuit.addAssoicatedPart(shoulder_mini_guns);
        ironManSuit.addAssoicatedPart(jarvis);

        Product infinityGuantlet = new Product(100,45,002,55," infinity gauntlet",78.90);
        Inventory.addProduct(infinityGuantlet);
        infinityGuantlet.addAssoicatedPart(mind_stone);
        infinityGuantlet.addAssoicatedPart(time_stone);
        infinityGuantlet.addAssoicatedPart(power_stone);
        infinityGuantlet.addAssoicatedPart(space_stone);
        infinityGuantlet.addAssoicatedPart(reality_stone);
        infinityGuantlet.addAssoicatedPart(soul_stone);

        Product captainAmericaShield = new Product(300,200,003,250,"captain america shield",790.32);
        Inventory.addProduct(captainAmericaShield);
        captainAmericaShield.addAssoicatedPart(vibranium);
        captainAmericaShield.addAssoicatedPart(disc_shaped_alloy);
        captainAmericaShield.addAssoicatedPart(red_white_blue);
        captainAmericaShield.addAssoicatedPart(patriotic_stars);

        Product spiderManWebShooters = new Product(412,354,004,380,"web shooters",90.34);
        Inventory.addProduct(spiderManWebShooters);
        spiderManWebShooters.addAssoicatedPart(nickel_plated_brass);
        spiderManWebShooters.addAssoicatedPart(cartridges);
        spiderManWebShooters.addAssoicatedPart(palm_switch);
        spiderManWebShooters.addAssoicatedPart(web_fluid);

        Product mjolnir = new Product(735,623,005,699,"mjolnir",686.45);
        Inventory.addProduct(mjolnir);
        mjolnir.addAssoicatedPart(uru);
        mjolnir.addAssoicatedPart(worthiness_enchantment);
        mjolnir.addAssoicatedPart(weather_manipulation_enchantment);
        mjolnir.addAssoicatedPart(flight_enchantment);
        mjolnir.addAssoicatedPart(energy_protection_enchantment);
        /*--__^#^#__----__^#^#__----__^#^#__----__^#^#__----__^#^#__----__^#^#__----__^#^#__----__^#^#__----__^#^#__----__^#^#__----__^#^#__----__^#^#__----__^#^#__----__^#^#__----__^#^#__----__^#^#__- */


        /*###-___-==###-___-==###-___-==###-___-==###-___-==##   PRODUCTS NO PARTS       ##-___-==###-___-==###-___-==###-___-==###-___-==###-___-==###-___-==###-___-=*/
        Product batMobile = new Product(59,2,006,16,"bat mobile",8639.99);
        Inventory.addProduct(batMobile);

        Product storybook = new Product(91,57,007,68,"storybook",56.88);
        Inventory.addProduct(storybook);

        Product delorium = new Product(780,12,8,64,"delorium",6748.99);
        Inventory.addProduct(delorium);

        Product symbiote = new Product(855,321,9,600,"symbiote", 87.45 );
        Inventory.addProduct(symbiote);

        Product owl = new Product(54,8,10,32,"owl",34.34);
        Inventory.addProduct(owl);


        /*###-___-==###-___-==###-___-==###-___-==###-___-==###-___-==###-___-==###-___-==###-___-==###-___-==###-___-==###-___-==###-___-==###-___-==###-___-==###-___-== */


    }
    /*@P@@P@P@P@P@P@P@P@P@@P@@P@P@P@P@P@P@P@P@@P@P@P@P@P@P@P@P@@@P@P@P@P@P@@@P@P@P@P@P@P@P@P@P@@P@P@P@P@@ */



    /****
     *** end of the line
     *** don't continue
     **/

/*#^#^#^#^#^#^##^#^#^#^ REQUIREMENTS  ^#^#^#^#^#^#^#^#^#^#^#^#
1. Name of Class = Inventory
2. Data Members =
2A. - ObservableList = allParts<Part>
2B. - ObservableList = allProducts<Product>
3. Methods =
3A. - addPart(newPart:Part)void
3B. - addProduct(newProduct:Product)void
3C. - lookupPart(partId:int) part
3D. - lookupProduct(ProductId: int) product
3E. - lookupPart(partName: String) ObservableList <Part>
3F. - lookupProduct(productName: String) ObservableList <Product>
3G. - updatePart(index: int, selectedPart:Part): boolean
3H. - updateProduct(index: int, newProduct:Product): boolean
3I. - deletePart(selectedPart: Part): boolean
3J. - deleteProduct(selectedProduct: Product): boolean
3K. - getAllParts():ObservableList <Part>
3L. - getAllProducts():ObservableList <Product>
4.  - needs to be static


^##^#^#^#^#^#^#^#^#^##^^##^#^#^#^#^#^#^#^#^##^^##^#^#^#^#^#^#^#^#^#
 */
}
