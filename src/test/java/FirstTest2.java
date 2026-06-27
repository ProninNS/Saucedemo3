import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FirstTest2 {
    //кратно 3, возвращать 't'
    //кратно 5. возвращать 'm'
    //кратно 3 и 5. возвращать 'tim'
    //возвращать 'fail'
    public String trialCode(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "tim";
        } else if (number % 3 == 0) {
            return "t";
        } else if (number % 5 == 0) {
            return "m";
        } else return "fail";

    }

    @Test
    public void timTest() {
        String actualResult = trialCode(9);
        assertEquals(actualResult, "t");
    }

    @Test
    public void timTest2() {
        String actualResult = trialCode(25);
        assertEquals(actualResult, "m");
    }

    @Test
    public void timTest3() {
        String actualResult = trialCode(15);
        assertEquals(actualResult, "tim");
    }

    @Test
    public void timTest4() {
        String actualResult = trialCode(2);
        assertEquals(actualResult, "fail");
    }
}
