package main;

import entities.Employees;
import entities.Project;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.Date;

public class App {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Project project1 = new Project(3, "Hologram projector", 5000000L, new Date());

        Project project2 = new Project(4, "Tele Transport", 8000000L, new Date());

        Employees employee1 = new Employees();
        employee1.setEmployeeId(94);
        employee1.setFirstName("Woody");
        employee1.setLastName("Woodpecker");
        employee1.setEmail("ww@cartoons.com");
        employee1.setPhoneNumber("(123) 456-7890");
        employee1.setHireDate(new Date());
        employee1.setJobId("HR_REP");
        employee1.setSalary(5000.00);
        employee1.setCommissionPct(0.08);
        employee1.setManagerId(101);
        employee1.setDepartmentId(40);

        Employees employee2 = new Employees();
        employee2.setEmployeeId(95);
        employee2.setFirstName("Richie");
        employee2.setLastName("Rich");
        employee2.setEmail("rr@cartoons.com");
        employee2.setPhoneNumber("(987) 654-3210");
        employee2.setHireDate(new Date());
        employee2.setJobId("HR_REP");
        employee2.setSalary(5000.00);
        employee2.setCommissionPct(0.10);
        employee2.setManagerId(101);
        employee2.setDepartmentId(40);

        employee1.getProjects().add(project1);
        employee1.getProjects().add(project2);
        employee2.getProjects().add(project1);
        employee2.getProjects().add(project2);

        session.save(employee1);
        session.save(employee2);

        session.getTransaction().commit();
        session.close();
    }
}