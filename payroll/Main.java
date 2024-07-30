import java.util.ArrayList;

abstract class Employee{
    private String name;
    private int id;
    
    public Employee(String name, int id){
        this.name = name;
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    
    public int getId(){
        return id;
    }

    public abstract double  calculateSalary();

    @Override
    public String toString(){
        return "Employee[Name: " + name + ", ID: " + id + ", salary: " + calculateSalary()+"]";
    }
}
class fullTimeEmlpoyee extends Employee{
    private double monthly_Salary;
    
    public fullTimeEmlpoyee(String name, int id, double monthly_Salary){
        super(name, id);
        this.monthly_Salary = monthly_Salary;
    }
    @Override
    public double calculateSalary(){
        return monthly_Salary;
    }
}
class PartTimeEmployee extends Employee{
    private int hoursworked;
    private double hourly_rate;
    
    public PartTimeEmployee(String name, int id, int hoursworked, double hourly_rate){
        super(name, id);
        this.hoursworked = hoursworked;
        this.hourly_rate = hourly_rate;
    
    }
    @Override
    public double calculateSalary(){
        return hoursworked * hourly_rate;
    }
}

class payrollSystem{
    private ArrayList<Employee> Employeelist;

    public payrollSystem(){
        Employeelist = new ArrayList<>();

    }

    public void addEmployee(Employee employee){
        Employeelist.add(employee);
    }

    public void  removeEmployee(int id){
        Employee employeetoremove = null;
        for(Employee employee : Employeelist){
            if(employee.getId() == id){
                employeetoremove = employee;
                break;
            }
        }
        if(employeetoremove != null){
            Employeelist.remove(employeetoremove);
        }
    

    }
    public void displaydetials(){
        for(Employee employee : Employeelist){
            System.out.println(employee);
        }
    }
}
public class Main{
    public static void main(String[] args) {
        payrollSystem payroll = new payrollSystem();
        fullTimeEmlpoyee emp1 = new fullTimeEmlpoyee("Ali", 1, 20000);
        PartTimeEmployee emp2 = new PartTimeEmployee("ahmed",2,10,1000);
        payroll.addEmployee(emp2);
        payroll.addEmployee(emp1);
        payroll.displaydetials();



        
    }
}