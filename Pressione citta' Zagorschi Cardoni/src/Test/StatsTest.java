package Test;

import Model.Pressure;
import Statistics.Stats;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatsTest {

    private Stats s1;
    private Pressure p1;
    private Pressure p2;
    private Vector<Pressure> pressures = new Vector<>();

    @BeforeEach
    public void setUp() {
        this.p1 = new Pressure(1000,"21:00", "2020-12-27","Agugliano" );
        this.p2 = new Pressure(1100,"21:00", "2020-12-27","Agugliano" );
        this.pressures.add(this.p1);
        this.pressures.add(this.p2);
        this.s1 = new Stats(this.pressures);
        this.s1.createStats();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    public void testGetValueMin(){ assertEquals(1000, this.s1.getVal_min()); }

    @Test
    public void testGetValueMax() {
        assertEquals(1100, this.s1.getVal_max());
    }

    @Test
    public void testGetAvarege(){
        assertEquals(1050, this.s1.getAverage());
    }

    @Test
    public void testGetVariance() {
        assertEquals(2500, this.s1.getVariance());
    }




}