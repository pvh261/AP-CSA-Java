public class APCalendar {
    private static boolean isLeapYear(int year) {

    }

    public static int numberOfLeapYears(int year, int year2) {
        int count = 0;
        for(int i = year; i <= year2; i++) {
            if(isLeapYear(i)) {
                count++;
            }
        }
        return count;
    }

    private static int firstDayOfYear(int year) {

    }

    private static int dayOfYear(int month, int day, int year) {

    }

    public static int dayOfWeek(int month, int day, int year) {
        return (firstDayOfYear(year) + dayOfYear(month, day, year) - 1) % 7;
    }
}