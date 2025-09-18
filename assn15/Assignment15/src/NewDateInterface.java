/**
 * An interface for date manipulation and management.
 * <p>
 * This interface provides methods to set and get individual date components
 * (day, month, year)
 * and methods to advance the date by a specified number of days.
 * <p>
 * Implementations of this interface should handle date validation, ensuring
 * that the date remains valid after any operation. They should properly manage
 * month-end transitions and year boundaries when advancing days.
 * <p>
 * All methods are expected to maintain date consistency and handle invalid
 * inputs
 * according to the implementation's specifications.
 */
public interface NewDateInterface {
    /**
     * Sets the day component of the date.
     * 
     * @param day the day value to set
     */
    public void setDay(int day);

    /**
     * Sets the month component of the date.
     * 
     * @param month the month value to set
     */
    public void setMonth(int month);

    /**
     * Sets the year component of the date.
     * 
     * @param year the year value to set
     */
    public void setYear(int year);

    /**
     * Gets the current day component of the date.
     * 
     * @return the current day
     */
    public int getDay();

    /**
     * Gets the current month component of the date.
     * 
     * @return the current month
     */
    public int getMonth();

    /**
     * Gets the current year component of the date.
     * 
     * @return the current year
     */
    public int getYear();

    /**
     * Advances the date by the specified number of days.
     * 
     * @param days the number of days to advance
     */
    public void advanceDays(int days);
}
