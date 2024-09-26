package code.ca.bcit.comp2522.lab4;

/**
 * Class with Date object validating and containing Year, month and day
 * The constructor allows only years between EIGHTEEN_CENTURY-CURRENT_YEAR
 * and finds the day of the week.
 *
 * @author Dalraj Bains
 * @author Farzad Farzin
 * @author Anil Bronson
 * @version 1.0
 */
public class Date {

  private final int year;
  private final int month;
  private final int day;
  private static final int CURRENT_YEAR = 2024;
  private static final int INITIAL = 0;

  // Month Constants
  private static final int JANUARY    = 1;
  private static final int FEBRUARY   = 2;
  private static final int MARCH      = 3;
  private static final int APRIL      = 4;
  private static final int MAY        = 5;
  private static final int JUNE       = 6;
  private static final int JULY       = 7;
  private static final int AUGUST     = 8;
  private static final int SEPTEMBER  = 9;
  private static final int OCTOBER    = 10;
  private static final int NOVEMBER   = 11;
  private static final int DECEMBER   = 12;

  // Month codes for day of the week calculation
  private static final int JANUARY_MONTH_CODE   = 1;
  private static final int FEBRUARY_MONTH_CODE  = 4;
  private static final int MARCH_MONTH_CODE     = 4;
  private static final int APRIL_MONTH_CODE     = 0;
  private static final int MAY_MONTH_CODE       = 2;
  private static final int JUNE_MONTH_CODE      = 5;
  private static final int JULY_MONTH_CODE      = 0;
  private static final int AUGUST_MONTH_CODE    = 3;
  private static final int SEPTEMBER_MONTH_CODE = 6;
  private static final int OCTOBER_MONTH_CODE   = 1;
  private static final int NOVEMBER_MONTH_CODE  = 4;
  private static final int DECEMBER_MONTH_CODE  = 6;

  // Day constants
  private static final int FIRST_DAY        = 1;
  private static final int FEBRUARY_NO_LEAP = 28;
  private static final int FEBRUARY_LEAP    = 29;
  private static final int THIRTY_DAYS      = 30;
  private static final int THIRTY_ONE_DAYS  = 31;

  // Leap year constants
  private static final int LEAP_YEAR_DIVISOR    = 4;
  private static final int CENTURY_DIVISOR      = 100;
  private static final int FOUR_CENTURY_DIVISOR = 400;

  // Century constants
  private static final int EIGHTEEN_CENTURY = 1800;
  private static final int NINETEEN_CENTURY = 1900;
  private static final int TWENTY_CENTURY   = 2000;

  // Century start codes for day of the week calculation
  private static final int TWENTY_CENTURY_COUNT_START   = 6;
  private static final int EIGHTEEN_CENTURY_COUNT_START = 2;
  private static final int TWO_DIGIT_YEAR_DIVISOR       = 100;
  private static final int NUMBER_OF_MONTHS             = 12;
  private static final int FOUR                         = 4;
  private static final int DAYS_IN_WEEK                 = 7;

  // Day of the week constants
  private static final int SATURDAY   = 0;
  private static final int SUNDAY     = 1;
  private static final int MONDAY     = 2;
  private static final int TUESDAY    = 3;
  private static final int WEDNESDAY  = 4;
  private static final int THURSDAY   = 5;
  private static final int FRIDAY     = 6;

  /**
   * Constructor for Date Object and Validates the inputs.
   *
   * @param year  the year (EIGHTEEN_CENTURY-CURRENT_YEAR)
   * @param month the month of the year (between JANUARY-DECEMBER)
   * @param day the day of the month (check if valid for the given month)
   * @throws IllegalArgumentException if the Date is invalid
   */
  public Date(final int year,final  int month,final  int day) {
    validateYear(year);
    validateMonth(month);
    validateDay(year, month, day);

    this.year   = year;
    this.month  = month;
    this.day    = day;
  }

  /**
   * Validates the year.
   *
   * @param year the year to validate
   * @throws IllegalArgumentException if the year is not between EIGHTEEN_CENTURY and the CURRENT_YEAR
   */
  private void validateYear(final int year) {
    if (year < EIGHTEEN_CENTURY || year > CURRENT_YEAR) {
      throw new IllegalArgumentException("Invalid year");
    }
  }

  /**
   * Validates the month.
   *
   * @param month the month to validate
   * @throws IllegalArgumentException if the month is not between JANUARY and DECEMBER
   */
  private void validateMonth(final int month) {
    if (month < JANUARY || month > DECEMBER) {
      throw new IllegalArgumentException("Invalid month");
    }
  }

  /**
   * Validates the day.
   *
   * @param year  the year of the date
   * @param month the month of the date
   * @param day   the day to validate
   * @throws IllegalArgumentException if the day is not valid for the given month and year
   */
  private void validateDay(final int year,final int month,final int day) {
    if (day < FIRST_DAY || day > getDaysInMonth(year, month)) {
      throw new IllegalArgumentException("Invalid day");
    }
  }

  /**
   * Returns the number of days in the given month and year.
   *
   * @param year  the year
   * @param month the month
   * @return the number of days in the month
   */
  private int getDaysInMonth(final int year, final int month) {
    return switch (month) {

      //Cases where days are 31
      case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER -> THIRTY_ONE_DAYS;

      //Cases where days are 30
      case APRIL, JUNE, SEPTEMBER, NOVEMBER -> THIRTY_DAYS;

      //Confirm if February is leap year or not and give appropriate days
      case FEBRUARY -> isLeapYear() ? FEBRUARY_LEAP : FEBRUARY_NO_LEAP;

      default -> throw new IllegalArgumentException("Invalid month");
    };
  }

  /**
   * Returns the day of the date.
   *
   * @return the day
   */
  public int getDay() {
    return day;
  }

  /**
   * Returns the month of the date.
   *
   * @return the month
   */
  public int getMonth() {
    return month;
  }

  /**
   * Returns the year of the date.
   *
   * @return the year
   */
  public int getYear() {
    return year;
  }

  /**
   * Returns the date formatted as YYYY-MM-DD.
   *
   * @return the formatted date
   */
  public String getYYYYMMDD() {
    return String.format("%04d-%02d-%02d",year, month, day);
  }

  /**
   * Calculates the day of the week for given date using the following instructions:
   *
   * <p>To get the day of the week, do the following seven steps for dates in the 1900s
   * e.g. October 31 1977:
   * <li>step 1: calculate the number of twelves in 77: 6</li>
   * <li>step 2: calculate the remainder from step 1: 77 - 12*6 = 77 - 72 = 5</li>
   * <li>step 3: calculate the number of fours in step 2: 5/4 = 1.25, so 1</li>
   * <li>step 4: add the day of the month to each step above: 31 + 6 + 5 + 1 = 43</li>
   * <li>step 5: add the month code (for jfmamjjasond: 144025036146): for october it is 1: 43 + 1 = 44</li>
   * <li>step 6: add the previous five numbers: (44) and mod by 7: 44%7 = 2 (44/7 = 6 remainder 2)</li>
   * <li>step 7: sat sun mon tue wed thu fri is 0 1 2 3 4 5 6; our 2 means Oct 31 1977 was monday</li>
   * Extra notes:
   * a) for January/February dates in leap years, add 6 at the start
   * b) for all dates in the 2000s, add 6 at the start
   * c) for all dates in the 1800s, add 2 at the start
   * e.g. March 15 2021:
   * <li>step 0: add 6 for dates in the 2000s: NUMBER IS 6</li>
   * <li>step 1: there is 1 twelve in 21; NUMBER IS 1</li>
   * <li>step 2: 21/12 = 1 remainder 9; NUMBER IS 9</li>
   * <li>step 3: there are 2 fours in 9: NUMBER IS 2</li>
   * <li>step 4: NUMBER IS 15</li>
   * <li>step 5: month code for march is 4: NUMBER IS 4</li>
   * <li>step 6: Add all numbers 6+1+9+2+15+4 = 37 NUMBER is 2: 37 mod 7 is 2</li>
   * <li>step 7: 37%7 = 2; 2 means monday</li>
   *</p>
   *
   * @return the day of the week (0=Saturday,1=Sunday,....,6=Friday)
   */
  public String getDayOfTheWeek() {
    //Set the value to 0
    int calculationNumber;
    calculationNumber = INITIAL;

    //Calculate which step 0 to start with +6 or +2 respectively
    if (year >= TWENTY_CENTURY){
      calculationNumber += TWENTY_CENTURY_COUNT_START;
    } else if ( year < NINETEEN_CENTURY) {
      calculationNumber += EIGHTEEN_CENTURY_COUNT_START;
    }

    //Give current year with regard to last two digits
    int lastTwoDigitsOfYear;
    lastTwoDigitsOfYear = year % TWO_DIGIT_YEAR_DIVISOR;

    //Step 1: Calculate the number of twelves in the year and add it to calculationNumber
    calculationNumber += lastTwoDigitsOfYear / NUMBER_OF_MONTHS;

    //Step 2: Calculate the remainder from Step 1 and add it to calculationNumber
    calculationNumber += lastTwoDigitsOfYear % NUMBER_OF_MONTHS;

    //Step 3: Calculate the number of fours in step 2 and add it to calculationNumber
    calculationNumber += (lastTwoDigitsOfYear % NUMBER_OF_MONTHS) / FOUR;

    //Step 4: Add the day of the month to calculationNumber
    calculationNumber += day;

    //Step 5: Add the month code (for jfmamjjasond: 144025036146)
    calculationNumber += getMonthCode(month);

    int dayOfWeek = calculationNumber % DAYS_IN_WEEK;

    //Convert the day of the week number into a string
    return switch (dayOfWeek) {
      case SATURDAY   -> "Saturday";
      case SUNDAY     -> "Sunday";
      case MONDAY     -> "Monday";
      case TUESDAY    -> "Tuesday";
      case WEDNESDAY  -> "Wednesday";
      case THURSDAY   -> "Thursday";
      case FRIDAY     -> "Friday";
      default -> throw new IllegalArgumentException("Unexpected value for dayOfWeek");
    };
  }

  /**
   * Returns the month code for the given month.
   *
   * @param month the month
   * @return the month code
   */
  private int getMonthCode(final int month) {
    return switch (month) {
      case JANUARY    -> JANUARY_MONTH_CODE;
      case FEBRUARY   -> FEBRUARY_MONTH_CODE;
      case MARCH      -> MARCH_MONTH_CODE;
      case APRIL      -> APRIL_MONTH_CODE;
      case MAY        -> MAY_MONTH_CODE;
      case JUNE       -> JUNE_MONTH_CODE;
      case JULY       -> JULY_MONTH_CODE;
      case AUGUST     -> AUGUST_MONTH_CODE;
      case SEPTEMBER  -> SEPTEMBER_MONTH_CODE;
      case OCTOBER    -> OCTOBER_MONTH_CODE;
      case NOVEMBER   -> NOVEMBER_MONTH_CODE;
      case DECEMBER   -> DECEMBER_MONTH_CODE;
      default -> throw new IllegalArgumentException("Invalid month");

    };
  }

  /**
   * Checks if the given year is a leap year.
   *
   * @return true if the year is a leap year, false otherwise
   */
  public boolean isLeapYear() {
    return (year % LEAP_YEAR_DIVISOR == INITIAL && year % CENTURY_DIVISOR != INITIAL) ||
            (year % FOUR_CENTURY_DIVISOR == INITIAL);
  }

}
