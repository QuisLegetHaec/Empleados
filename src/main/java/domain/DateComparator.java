package domain;

import java.util.Comparator;

/**
 * DateComparator class used to compare instances of Employee according to date
 */
public class DateComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.getStartDate().isBefore(o2.getStartDate())) {
            return -1;
        }
        if (o1.getStartDate().isAfter(o2.getStartDate())) {
            return 1;
        }
        return 0;
    }
}
