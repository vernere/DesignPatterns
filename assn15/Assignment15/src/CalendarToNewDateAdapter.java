import java.util.Calendar;

/**
 * An adapter class that enables Calendar objects to implement the
 * NewDateInterface.
 * This class acts as a bridge between Calendar's date representation and the
 * NewDateInterface,
 * converting method calls between the two systems.
 */
public class CalendarToNewDateAdapter implements NewDateInterface {

    // The internal Calendar instance that's being adapted
    private Calendar calendar = Calendar.getInstance();

    /**
     * Constructs an adapter with the specified date values
     * 
     * @param day   The day of month (1-31)
     * @param month The month (1-12 format where 1=January)
     * @param year  The full year value
     */
    public CalendarToNewDateAdapter(int day, int month, int year) {
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1); // Convert to 0-based month (Calendar uses 0-11)
        calendar.set(Calendar.DAY_OF_MONTH, day);
    }

    /**
     * Sets the day of the month
     * 
     * @param day The day value (1-31, depending on month)
     */
    @Override
    public void setDay(int day) {
        calendar.set(Calendar.DAY_OF_MONTH, day);
    }

    /**
     * Sets the month using 1-based indexing
     * 
     * @param month The month value (1-12, where 1=January)
     */
    @Override
    public void setMonth(int month) {
        calendar.set(Calendar.MONTH, month - 1); // Convert to 0-based month for Calendar
    }

    /**
     * Sets the year
     * 
     * @param year The full year value
     */
    @Override
    public void setYear(int year) {
        calendar.set(Calendar.YEAR, year);
    }

    /**
     * Advances the date by the specified number of days
     * 
     * @param days The number of days to advance (can be negative to go backward)
     */
    @Override
    public void advanceDays(int days) {
        calendar.add(Calendar.DAY_OF_MONTH, days);
    }

    /**
     * Gets the current day of month
     * 
     * @return The day value (1-31)
     */
    @Override
    public int getDay() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Gets the current month
     * 
     * @return The month value (1-12)
     */
    @Override
    public int getMonth() {
        return calendar.get(Calendar.MONTH) + 1; // Convert from 0-based to 1-based month
    }

    /**
     * Gets the current year
     * 
     * @return The full year value
     */
    @Override
    public int getYear() {
        return calendar.get(Calendar.YEAR);
    }
}
