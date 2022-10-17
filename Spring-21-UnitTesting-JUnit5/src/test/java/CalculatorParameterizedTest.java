import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorParameterizedTest {

    @ParameterizedTest
    @ValueSource(strings = {"Apple","Orange","Kiwi"})
    void testCase1(String args){
        assertTrue(!args.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void testCase2(int nums){
        assertEquals(0,nums%3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Java", "Spring","DB"})
    @EmptySource
    @NullSource
    void testCase3(String args){
        assertTrue(!args.isEmpty());
    }


    @ParameterizedTest
    @MethodSource("stringsProvider") //Passing the method
    void testCase4(String arg){
        assertNotNull(arg);
    }

    static String[] stringsProvider(){
        return new String[]{"java","Spring","DB"};
    }

    @ParameterizedTest
    @CsvSource({"3,5,7","1,3,7","7,9,16"})
    void testCase5(int num1, int num2, int result){
        assertEquals(result, Calculator.add(num1,num2));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sample-data.csv", numLinesToSkip = 1)
    void testCase6(int num1, int num2, int result){
        assertEquals(result, Calculator.add(num1, num2));
    }
}
