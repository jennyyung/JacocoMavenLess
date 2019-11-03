package exec;

/**
 * Created by macpro on 2019/10/27.
 */
public class CalCategories {
    public String cal(int seed){
        String category = "";
        switch (seed){
            case 1: category = "Agriculture & Food";break;
            case 2: category = "Apparel,Textiles & Accessories";break;
            case 3: category = "Auto & Transportation";break;
            default:category = "Bags, Shoes & Accessories";
        }
        return  category;
    }
}
