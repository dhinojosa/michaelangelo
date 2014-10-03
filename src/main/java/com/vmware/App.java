package com.vmware;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) throws IOException {
    	
    	Pattern pattern = Pattern.compile("\\d{3}-\\d{2}-\\d{4}");
    	
    	
    	Employee employee1 = new Employee(pattern);
		employee1.setName("Ram");
		employee1.addTask(new Task("Fix Bug",        4, 4)); //0
		employee1.addTask(new Task("Changed Header", 1, 3)); //2
		employee1.addTask(new Task("Fix Major Bug",  5, 1)); //-4
		employee1.addTask(new Task("Fixed DE10203",  2, 3)); //1
		                                                     //avg: -.25
		
		Employee employee2 = new Employee(pattern);
		employee2.setName("Nipuna");
		employee2.addTask(new Task("Fix Major Bug",  2,  2)); //0
		employee2.addTask(new Task("Changed Header", 10, 1)); //-9
		employee2.addTask(new Task("Fix Major Bug",  4,  2)); //-2
		employee2.addTask(new Task("Fixed DE10204",  2,  2)); //0
		                                                      //avg -2.75
		
		Employee employee3 = new Employee(pattern);
		employee3.setName("Korak");
		employee3.addTask(new Task("Fix Major Bug", 4, 6)); //2
		employee3.addTask(new Task("Fixed DE10203", 4, 9)); //5
		                                                    //avg: 3.5
		
		Employee employee4 = new Employee(pattern);
		employee4.setName("Tim");
		employee4.addTask(new Task("Fix Major Bug 5", 4, 2));  //-2
		employee4.addTask(new Task("Fixed DE10209", 4, 4));    //0
		employee4.addTask(new Task("Fix Major Bug 1", 1, 1));  //0
		employee4.addTask(new Task("Fixed DE10210", 9, 2));    //-7
		employee4.addTask(new Task("Fix Major Bug 5", 10, 6)); //-4
		employee4.addTask(new Task("Fixed DE10211", 2, 1));    //-1

		EmployeePerformanceService service = new EmployeePerformanceService();
		EmployeeReporter employeeReporter = new EmployeeReporter();

		
		service.addEmployee(employee1);
		service.addEmployee(employee2);
		service.addEmployee(employee3);
		service.addEmployee(employee4);
		
		PrintWriter writer = new PrintWriter("/home/danno/raises.txt", "UTF-8");
		employeeReporter.printEmployees(service.getTop2Performers(), writer);
    	writer.close();    
		
		
		// Previous example
    	InputStream is = null;
        InputStreamReader reader = null;
        BufferedReader buffRead = null;

        try {
            is = App.class.getResourceAsStream("/db.properties");
            reader = new InputStreamReader(is);
            buffRead = new BufferedReader(reader);
            String word = null;
            while ((word = buffRead.readLine()) != null) {
                System.out.println(word);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (buffRead != null) buffRead.close();
                if (reader != null) reader.close();
                if (is != null) is.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}