import org.example.DateUtils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateUtilsTest {
    private DateUtils dateUtils;

    @BeforeEach
    public void setUp() {
        dateUtils = new DateUtils();
    }

    @Test
    public void testIsLeapYear() {
        assertTrue(dateUtils.isLeapYear(2000));
        assertTrue(dateUtils.isLeapYear(2012));
        assertTrue(dateUtils.isLeapYear(2016));
        assertTrue(dateUtils.isLeapYear(2020));

        assertFalse(dateUtils.isLeapYear(1900));
        assertFalse(dateUtils.isLeapYear(2001));
        assertFalse(dateUtils.isLeapYear(2018));
        assertFalse(dateUtils.isLeapYear(2022));
    }

    @Test
    public void testGetDaysInMonth() {
        // Non-leap year
        assertEquals(31, dateUtils.getDaysInMonth(2022, 1));
        assertEquals(28, dateUtils.getDaysInMonth(2022, 2));
        assertEquals(31, dateUtils.getDaysInMonth(2022, 3));
        assertEquals(30, dateUtils.getDaysInMonth(2022, 4));

        // Leap year
        assertEquals(29, dateUtils.getDaysInMonth(2020, 2));
        assertEquals(29, dateUtils.getDaysInMonth(2012, 2));
    }

    @Test
    public void testInvalidMonth() {
        assertThrows(IllegalArgumentException.class, () -> {
            dateUtils.getDaysInMonth(2022, 0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            dateUtils.getDaysInMonth(2022, 13);
        });
    }
}
