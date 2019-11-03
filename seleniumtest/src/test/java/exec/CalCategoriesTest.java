package exec;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by macpro on 2019/10/27.
 */
public class CalCategoriesTest {

    static CalCategories calCategories = null;
    @BeforeClass
    public static void init(){
         calCategories = new CalCategories();
    }

    @Test
    public void calTest(){
        String res = calCategories.cal(1);
        //assertThat(res,endsWith("food"));
        assertThat(res,containsString("Food"));
    }
}
