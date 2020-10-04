package com.java.streams.service;

import com.java.streams.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class StreamService {

    public String greet() {
        return "!! Hello Stream API !!";
    }

    public Stream<Integer> forLoopOfStream() {
        // Stream API way of FOR LOOP (Printing numbers 1 to 10)
        // LIMIT = number of elements to be printed, NOt the values till the digit 10.
        Stream<Integer> numbers =
                Stream.iterate(1, i -> i + 1)
                        .limit(10);
        return numbers;
    }

    public Stream<Integer> forLoopToDemoOnStreamLimit() {
        // Stream API way of FOR LOOP (Printing numbers 1 to 10)
        // LIMIT = number of elements to be printed, NOt the values till the digit 10.
        Stream<Integer> numbers = Stream.iterate(2, i -> i + 2)
                .limit(10);
        return numbers;
    }

    public IntStream forLoopWithIntStreamRangeDemo() {
        // range(1, 10)  Prints 1 to 9 numbers
        // ( Start index is INCLUSIVE, END Index EXCLUSIVE )
        IntStream intStream = IntStream.range(1, 10);
        return intStream;
    }

    public IntStream forLoopWithIntStreamRangeClosedDemo() {
        // rangeClosed(1, 10)  Prints 1 to 10 numbers
        // ( START and END Index BOTH are INCLUSIVE )
        IntStream intStream = IntStream.rangeClosed(1, 10);
        return intStream;
    }

    public IntSummaryStatistics getSummeryStats() {
        List<Integer> numbers = Arrays.asList(3, 19, 5, 13, 29, 17, 23, 7, 2, 11);
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        return stats;
    }

    public Stream<String> forLoopOfStreamOnCollection() {
        // Create a List with strings.
        List<String> list = Arrays.asList("Rajesh", "Ram", "Shravan", "Ranjeeth", "Suman", "Praveen", "Pawan", "Naveen", "Prem");
        // Create a stream with taking 5 Employees from the list (this.getEmployees)
        Stream<String> names = list
                .stream().limit(5);
        return names;
    }

    public List<String> filterAndCollectorsDemo() {
        // Create a List with String more than 5 characters
        List<String> names = Arrays.asList("Rajesh", "Ram", "Shravan", "Ranjeeth", "Suman", "Praveen", "Pawan", "Naveen", "Prem");

        List<String> filteredNames = names
                .stream()
                .filter(name -> name.length() < 6)
                .collect(Collectors.toList());
        return filteredNames;
    }

    public List<String> mapAndCollectorsDemo() {
        // Convert String to Uppercase and join them using coma
        List<String> countries = Arrays.asList("India", "USA", "Japan", "CHINA", "France", "Germany",
                "Italy", "U.K.", "Canada");
        List<String> countriesList = countries
                .stream()
                .map(country -> country.toUpperCase())
                .collect(Collectors.toList());
        return countriesList;
    }

    // From this method onwards ,
    // we use Employee model class defined in package - com.java.streams.model
    public Map<String, Long> displayMaleAndFemaleEmployees() {
        Map<String, Long> maleAndFemaleEmployees =
                this.getEmployees()
                        .stream()
                        .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        return maleAndFemaleEmployees;
    }

    public List<String> displayAllDepartments() {
        return this.getEmployees()
                .stream()
                .map(Employee::getDepartment).distinct().collect(Collectors.toList());
    }

    public Map<String, Double> displayAvgAgeOfMaleAndFemale() {
        Map<String, Double> avgAgeOfMaleAndFemale =
                this.getEmployees()
                        .stream()
                        .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
        return avgAgeOfMaleAndFemale;
    }

    public Optional<Employee> displayHighestPaidEmployeeDetails() {
        Optional<Employee> highestPaidEmployeeDetails =
                this.getEmployees()
                        .stream()
                        .max(Comparator.comparingDouble(Employee::getSalary));
        return highestPaidEmployeeDetails;
    }

    public List<String> displayEmployeesJoinedAfter2015() {
        return this.getEmployees()
                .stream()
                .filter(employee -> employee.getYearOfJoining() > 2015)
                .map(Employee::getName)
                .collect(Collectors.toList());
    }

    public Map<String, Long> displayNumberOfEmpInEachDept() {
        Map<String, Long> numberOfEmpInEachDept =
                this.getEmployees()
                        .stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        return numberOfEmpInEachDept;
    }

    public Map<String, Double> displayAvgSalaryOfEachDept() {
        Map<String, Double> avgSalaryOfEachDept = this.getEmployees()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        return avgSalaryOfEachDept;
    }

    public Optional<Employee> displayYongestEmpInProdDevDept() {
        Optional<Employee> yongestEmpInProdDevDept = this.getEmployees()
                .stream()
                .filter(emp -> emp.getGender().equalsIgnoreCase("male")
                        && emp.getDepartment().equalsIgnoreCase("Product Development"))
                .min(Comparator.comparingDouble(Employee::getAge));
        return yongestEmpInProdDevDept;
    }

    public Optional<Employee> displayMostExperiancedEmpInOrganisation() {
        Optional<Employee> MostExperiancedEmpInOrg = this.getEmployees()
                .stream()
                .sorted(Comparator.comparingLong(Employee::getYearOfJoining))
                .findFirst();
        return MostExperiancedEmpInOrg;
    }

    public Map<String, Long> displayNumberOfMaleAndFemaleEmpInSalesDept() {
        Map<String, Long> numberOfMaleAndFemaleEmpInSalesDept = this.getEmployees()
                .stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase("Sales And Marketing"))
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        return numberOfMaleAndFemaleEmpInSalesDept;
    }

    public Map<String, Double> displayAvgSalOfMaleAndFemaleEmployees() {
        Map<String, Double> avgSalOfMaleAndFemaleEmployees = this.getEmployees()
                .stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        return avgSalOfMaleAndFemaleEmployees;
    }

    public Map<String, List<Employee>> displayEmployeesInEachDept() {
        Map<String, List<Employee>> employeesInEachDept =
                this.getEmployees()
                        .stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment));
        return employeesInEachDept;
    }


    public DoubleSummaryStatistics displayAvgAndTotalSalaryOfOrganisation() {
        DoubleSummaryStatistics avgAndTotalSalaryOfOrganisation = this.getEmployees()
                .stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        return avgAndTotalSalaryOfOrganisation;
    }

    public Optional<Employee> displayOldestEmpDetailsInOrganisation() {
        Optional<Employee> employee = this.getEmployees()
                .stream()
                .max(Comparator.comparingInt(Employee::getAge));
        return employee;
    }

    /**
     * @return
     */
    private List<Employee> getEmployees() {

        List<Employee> employees = Arrays.asList(
                new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0),
                new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0),
                new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0),
                new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0),
                new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0),
                new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0),
                new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0),
                new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0),
                new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0),
                new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5),
                new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0),
                new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0),
                new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0),
                new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5),
                new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0),
                new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0),
                new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0)
        );
        return employees;
    }
}
