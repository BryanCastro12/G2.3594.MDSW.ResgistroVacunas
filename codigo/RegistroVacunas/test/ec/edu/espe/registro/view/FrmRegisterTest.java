package ec.edu.espe.registro.view;

import ec.edu.espe.registro.view.FrmRegister;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bryan Castro
 */
public class FrmRegisterTest {
    
    public FrmRegisterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of emptyFields method, of class FrmRegister.
     */
    @Test
    public void testEmptyFields() {
        System.out.println("emptyFields");
        FrmRegister instance = new FrmRegister();
        instance.emptyFields();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class FrmRegister.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        FrmRegister.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
