//package facades;
//
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import facades.EmployeeFacade;
//import main.java.entities.Employee;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.fail;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//
//public class facadetest {
//    private static final EntityManagerFactory ENF = Persistence.createEntityManagerFactory("pu");
//    private static final EmployeeFacade FE = EmployeeFacade.getEmployeeFacade(ENF);
//    public EmployeeFacadeTest() {
//    }
//    
//    @BeforeAll
//    public static void setUpClass() {
////        Add code to setup entities for test before running any test methods
//          Employee e = new Employee();
//    }
//    
//    @AfterAll
//    public static void tearDownClass() {
////        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
//    }
//    
//    @BeforeEach
//    public void setUp() {
////        Put the test database in a proper state before each test is run
//    }
//    
//    @AfterEach
//    public void tearDown() {
////        Remove any data after each test was run
//    }
//
//    /**
//     * Test a method here.
//     */
//    //@Test
//    public void TestGetEmployeeByID(){
//        assertEquals(FE.getEmployeeByID(1), 1);
//        
//    }
//    