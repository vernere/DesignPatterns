import org.junit.Assert;
import org.junit.Test;

public class degreeTester {
    
    @Test
    public void degreeTestPhd(){
        int result = App.degreeChecker("PhD");

        Assert.assertEquals(6, result);
    }

    @Test
    public void degreeTestMsc(){
        int result = App.degreeChecker("MSc"); 

        Assert.assertEquals(5, result);
    }

    @Test
    public void degreeTestBsc(){
        int result = App.degreeChecker("BSc"); 

        Assert.assertEquals(3, result);
    }
}
