package com.java.streams;

import com.java.streams.service.StreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StreamApiDemo implements CommandLineRunner {

    @Autowired
    private StreamService streams;

    public void setStreams(StreamService streams) {
        this.streams = streams;
    }

    public static void main(String[] args) {
        SpringApplication.run(StreamApiDemo.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("**********************************************");
        System.out.println(streams.greet());
        System.out.println("**********************************************");
        System.out.println("== forLoopOfStream ==");
        streams.forLoopOfStream().forEach(i -> System.out.println(i));
        System.out.println("**********************************************");
        System.out.println("== forLoopToDemoOnStreamLimit ==");
        streams.forLoopToDemoOnStreamLimit().forEach(i -> System.out.println(i));
        System.out.println("**********************************************");
        System.out.println("== forLoopWithIntStreamRangeDemo ==");
        streams.forLoopWithIntStreamRangeDemo().forEach(System.out::println);
        System.out.println("**********************************************");
        System.out.println("== forLoopWithIntStreamRangeClosedDemo ==");
        streams.forLoopWithIntStreamRangeClosedDemo().forEach(System.out::println);
        System.out.println("**********************************************");
        System.out.println("== getSummeryStats ==");
        System.out.println(" Count : " + streams.getSummeryStats().getCount());
        System.out.println(" Max : " + streams.getSummeryStats().getMax());
        System.out.println(" Min : " + streams.getSummeryStats().getMin());
        System.out.println(" Sum : " + streams.getSummeryStats().getSum());
        System.out.println(" Avg : " + streams.getSummeryStats().getAverage());
        System.out.println("**********************************************");
        System.out.println("== forLoopOfStreamOnCollection ==");
        streams.forLoopOfStreamOnCollection().forEach(emp -> System.out.println(emp));
        System.out.println("**********************************************");
        System.out.println("== filterAndCollectorsDemo ==");
        streams.filterAndCollectorsDemo().forEach(name -> System.out.println(name));
        System.out.println("**********************************************");
        System.out.println("== mapAndCollectorsDemo ==");
        streams.mapAndCollectorsDemo().forEach(country -> System.out.println(country));
        System.out.println("**********************************************");
        System.out.println("== displayMaleAndFemaleEmployees ==");
        streams.displayMaleAndFemaleEmployees().forEach((key, val) -> System.out.println(key + " " + val));
        System.out.println("**********************************************");
        System.out.println("== displayAllDepartments ==");
        streams.displayAllDepartments().forEach(System.out::println);
        System.out.println("**********************************************");
        System.out.println("== displayAvgAgeOfMaleAndFemale ==");
        streams.displayAvgAgeOfMaleAndFemale().forEach((key, val) -> System.out.println(key + " " + val));
        System.out.println("**********************************************");
        System.out.println("== displayHighestPaidEmployeeDetails ==");
        System.out.println(streams.displayHighestPaidEmployeeDetails().get());
        System.out.println("**********************************************");
        System.out.println("== displayEmployeesJoinedAfter2015 ==");
        streams.displayEmployeesJoinedAfter2015().forEach(System.out::println);
        System.out.println("**********************************************");
        System.out.println("== displayNumberOfEmpInEachDept ==");
        streams.displayNumberOfEmpInEachDept().forEach((key, val) -> System.out.println(key + " " + val));
        System.out.println("**********************************************");
        System.out.println("== displayAvgSalaryOfEachDept ==");
        streams.displayAvgSalaryOfEachDept().forEach((key, val) -> System.out.println(key + " " + val));
        System.out.println("**********************************************");
        System.out.println("== displayYongestEmpInProdDevDept ==");
        System.out.println(streams.displayYongestEmpInProdDevDept().get());
        System.out.println("**********************************************");
        System.out.println("== displayMostExperiancedEmpInOrganisation ==");
        System.out.println(streams.displayMostExperiancedEmpInOrganisation().get());
        System.out.println("**********************************************");
        System.out.println("== displayNumberOfMaleAndFemaleEmpInSalesDept ==");
        streams.displayNumberOfMaleAndFemaleEmpInSalesDept().forEach((key, val) -> System.out.println(key + " " + val));
        System.out.println("**********************************************");
        System.out.println("== displayAvgSalOfMaleAndFemaleEmployees ==");
        streams.displayAvgSalOfMaleAndFemaleEmployees().forEach((key, val) -> System.out.println(key + " " + val));
        System.out.println("**********************************************");
        System.out.println("== displayEmployeesInEachDept ==");
        streams.displayEmployeesInEachDept().forEach((key, val) -> System.out.println(key + " " + val));
        System.out.println("**********************************************");
        System.out.println("== displayAvgAndTotalSalaryOfOrganisation ==");
        System.out.println("Average Salary = " + streams.displayAvgAndTotalSalaryOfOrganisation().getAverage());
        System.out.println("Total Salary = " + streams.displayAvgAndTotalSalaryOfOrganisation().getSum());
        System.out.println("**********************************************");
        System.out.println("== displayOldestEmpDetailsInOrganisation ==");
        System.out.println("Oldest Employee Details : " + streams.displayOldestEmpDetailsInOrganisation().get());
        System.out.println("**********************************************");
    }

}
