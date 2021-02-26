package org.example;

import org.junit.*;

import static org.junit.Assert.*;

public class ApplicationTest {

    private Application tested=new Application();

    @Before
    public void setup(){
        tested.setName("Application.class");
        System.out.println("Set Up");
    }

    @After
    public void finish(){
        System.out.println("Finish");
    }

    @BeforeClass
    public static void init(){
        System.out.println("Initialize class");
    }

    @AfterClass
    public static void finalMethod(){
        System.out.println("After all tests");
    }

    @Test
    public void shouldReturnName(){
        String expected="Application.class";

        String actual = tested.getName();

        assertEquals(expected, actual);//сперва ожидаемый, потом полученный

    }
//    @Ignore
//    @Test
//    public void shouldReturnNullIfValueIsNull(){
//        tested.setName(null);
//        String actual = tested.getName();
//
//        assertNull(actual);//
//
//    }

    @Test
    public void shouldNotBeTheSame(){
        String expected=new String("Application.class");
        String actual = tested.getName();

        assertNotSame(expected, actual);//сперва ожидаемый, потом полученный
    }

    @Test
    public void shouldBeTheSame(){
        String expected=new String("Application.class").intern();
        String actual = tested.getName();

        assertSame(expected, actual);//сперва ожидаемый, потом полученный
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExeptionIfNameIsNull(){
        tested.setName(null);
    }

    @Test
    public void shouldThrowExeptionIfNameIsEmptyString(){
        String expected="Empty String is not allowed";
        try {
            tested.setName("");
        }catch (RuntimeException e){
            assertEquals(expected,e.getMessage());
        }

    }

}