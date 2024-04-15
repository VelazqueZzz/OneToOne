package hibernate_test2.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {


    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Employee.class)
            .addAnnotatedClass(Detail.class)
            .buildSessionFactory();
    try {
        //insert!!!

//        Session session = factory.getCurrentSession();
//
//        Employee employee = new Employee("zr","trov","IT",600);
//        Detail detail = new Detail("Bu","4957818512","z123t@yandex.ru");
//        employee.setEmpDetail(detail);
//        session.beginTransaction();
//        session.save(employee);
//        session.getTransaction().commit();
//        System.out.println("Done!");


        //!!read

        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Employee emp = session.get(Employee.class,3);
        System.out.println(emp.getEmpDetail());

        session.getTransaction().commit();
        System.out.println("Done!");
        //
    }
    finally {
        factory.close();
    }


    }
}