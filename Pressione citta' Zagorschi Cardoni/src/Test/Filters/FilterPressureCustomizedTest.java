package Test.Filters;

import Filters.FilterPressureCustomized;
import Model.Pressure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FilterPressureCustomizedTest {

    private FilterPressureCustomized filtro;

    private Map<String,Vector<Pressure>> allpressures = new HashMap<String, Vector<Pressure>>();
    private Vector<Pressure> pressures1 = new Vector<>();
    private Vector<Pressure> pressures2 = new Vector<>();

    private Pressure p1;
    private Pressure p2;
    private Pressure p3;
    private Pressure p4;


    @BeforeEach
    public void setUp() {

        this.p1 = new Pressure(1000,"19:00", "2020-12-23","Agugliano" );
        this.p2 = new Pressure(1100,"21:00", "2020-12-27","Agugliano" );

        this.p3 = new Pressure(900,"21:00", "2020-12-23","Polverigi" );
        this.p4 = new Pressure(800,"21:00", "2020-12-22","Polverigi" );

        this.pressures1.add(this.p1);
        this.pressures1.add(this.p2);

        this.pressures2.add(this.p3);
        this.pressures2.add(this.p4);

        this.filtro = new FilterPressureCustomized("2020-12-23","2020-12-27",this.pressures1);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testFiltersPressure() {

        assertEquals("Minimum value is 1000.0\nMaximum value is 1100.0\nAvarege is 1050.0\nVariance is 2500.0",
                this.filtro.filtersPressure());
    }
}