package Test.Filters;

import Model.Pressure;
import Utils.FiltersUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FiltersUtilTest {

    private Vector<Pressure> pressures1 = new Vector<>();
    private Vector<Pressure> pressures2 = new Vector<>();
    private Vector<Pressure> pressures = new Vector<>();

    private Pressure p1;
    private Pressure p2;
    private Pressure p3;
    private Pressure p4;

    private FiltersUtil util = new FiltersUtil();

    private LocalDate startperiod;
    private LocalDate endperiod;

    @BeforeEach
    void setUp() {

        this.p1 = new Pressure(1000,"19:00", "2020-12-23","Agugliano" );
        this.p2 = new Pressure(1100,"21:00", "2020-12-27","Agugliano" );

        this.pressures1.add(this.p1);
        this.pressures1.add(this.p2);

        this.startperiod = LocalDate.parse("2020-12-25");
        this.endperiod = LocalDate.parse("2020-12-27");

        this.pressures.add(this.p2);

    }

    @AfterEach
    public void tearDown() {
        this.pressures.clear();
    }

    @Test
    public void testGetPressureFiltred(){
        assertEquals(pressures,this.util.getPressureFiltred(pressures1,this.startperiod,this.endperiod));
    }
}