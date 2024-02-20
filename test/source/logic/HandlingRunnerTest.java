package logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class HandlingRunnerTest {

    private HandlingRunner handlingRunner;
    @BeforeEach
    void setUp() {
        handlingRunner = new HandlingRunner();
        handlingRunner.addRunner(new Runner(123,"Camilo Montaña", 1.85, 72, LocalDate.of(2004, Month.APRIL,02), LocalTime.parse("02:20")));
        handlingRunner.addRunner(new Runner(312,"Bibian  Corredor", 1.60, 53, LocalDate.of(2005, Month.FEBRUARY,13), LocalTime.parse("02:30")));
        handlingRunner.addRunner(new Runner(231,"Carlos Saenz", 1.78, 60, LocalDate.of(2003, Month.SEPTEMBER,01), LocalTime.parse("02:40")));
    }

    @Test
    void findRunner() {
        setUp();
        assertNotNull(handlingRunner.findRunner(123));
        assertNotNull(handlingRunner.findRunner(312));
        assertNotNull(handlingRunner.findRunner(231));
        assertNull(handlingRunner.findRunner(345));
        assertNull(handlingRunner.findRunner(567));
    }

    @Test
    void addRunner() {
        assertFalse(handlingRunner.addRunner(new Runner(123,"Camilo Montaña", 1.85, 72, LocalDate.of(2004, Month.APRIL,02), LocalTime.parse("02:20"))));
        assertFalse(handlingRunner.addRunner(new Runner(312,"Bibian  Corredor", 1.60, 53, LocalDate.of(2005, Month.FEBRUARY,13), LocalTime.parse("02:30"))));
        assertFalse(handlingRunner.addRunner(new Runner(231,"Carlos Saenz", 1.78, 60, LocalDate.of(2003, Month.SEPTEMBER,01), LocalTime.parse("02:40"))));
        assertTrue(handlingRunner.addRunner(new Runner(345,"Eimy Ricaurte", 1.67, 52, LocalDate.of(2004, Month.NOVEMBER,14), LocalTime.parse("02:10"))));
        assertTrue(handlingRunner.addRunner(new Runner(456,"Juan Fernandez", 1.76, 75, LocalDate.of(2003, Month.DECEMBER,07), LocalTime.parse("02:00"))));
    }

    @Test
    void getChampion() {
        setUp();
        assertEquals(handlingRunner.findRunner(123),handlingRunner.getChampion());
        handlingRunner.addRunner(new Runner(987,"Camila Figueredo",1.88,70,LocalDate.of(2000, Month.AUGUST, 20), LocalTime.parse("01:56")));
        assertEquals(handlingRunner.findRunner(987),handlingRunner.getChampion());
    }

    @Test
    void getAverage() {
        setUp();
        LocalTime localTime = LocalTime.parse("02:30");
        assertEquals(localTime,handlingRunner.getAverage());
    }

    @Test
    void getRunnerSlow() {
        setUp();
        assertEquals(handlingRunner.findRunner(231),handlingRunner.getRunnerSlow());
        handlingRunner.addRunner(new Runner(987,"Camila Figueredo",1.88,70,LocalDate.of(2000, Month.AUGUST, 20), LocalTime.parse("03:00")));
        assertEquals(handlingRunner.findRunner(987),handlingRunner.getRunnerSlow());
    }

    @Test
    void showClasification() {
        setUp();
        HandlingRunner temp = handlingRunner;
        assertEquals(handlingRunner.showClasification(), temp.showClasification());

        temp = new HandlingRunner();
        temp.addRunner(new Runner(231,"Carlos Saenz", 1.78, 60, LocalDate.of(2003, Month.SEPTEMBER,01), LocalTime.parse("02:40")));
        temp.addRunner(new Runner(123,"Camilo Montaña", 1.85, 72, LocalDate.of(2004, Month.APRIL,02), LocalTime.parse("02:20")));
        temp.addRunner(new Runner(31,"Bibian  Corredor", 1.60, 53, LocalDate.of(2005, Month.FEBRUARY,13), LocalTime.parse("02:30")));
        assertNotEquals(handlingRunner.showClasification(), temp.showClasification());
    }

    @Test
    void getRunners() {
        setUp();
        HandlingRunner temp = handlingRunner;
        assertEquals(handlingRunner.getRunners(), temp.getRunners());

        temp = new HandlingRunner();
        temp.addRunner(new Runner(231,"Carlos Saenz", 1.78, 60, LocalDate.of(2003, Month.SEPTEMBER,01), LocalTime.parse("02:40")));
        temp.addRunner(new Runner(312,"Bibian  Corredor", 1.60, 53, LocalDate.of(2005, Month.FEBRUARY,13), LocalTime.parse("02:30")));
        temp.addRunner(new Runner(123,"Camilo Montaña", 1.85, 72, LocalDate.of(2004, Month.APRIL,02), LocalTime.parse("02:20")));
        assertNotEquals(handlingRunner.getRunners(), temp.getRunners());
        assertEquals(handlingRunner.getRunners().get(0).toString(), temp.getRunners().get(2).toString());
        assertNotEquals(handlingRunner.getRunners().get(0).toString(), temp.getRunners().get(1).toString());
    }
}