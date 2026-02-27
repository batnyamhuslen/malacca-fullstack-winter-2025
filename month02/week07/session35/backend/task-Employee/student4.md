/**
 * =====================================================
 *  STUDENT 4 - Exercise: Employee Payroll
 *  Topic: Method Overriding, @Override
 * =====================================================
 *
 * TASK:
 * Build a payroll system with a parent Employee class
 * and two child classes that override getSalary().
 */
 /**
* ===============================================================================================================* *
* ДААЛГАВАР:
* ажилтны класстай цалингийн системийг бүтээх * болон getSalary()-г дардаг хоёр хүүхэд класс.
*/

public class Employee {

    // TODO 1: Declare the following protected fields:
    //   - name (String)
    //   - baseSalary (double)


    // TODO 2: Create a constructor that takes name and baseSalary.


    // TODO 3: Create getters for both fields.


    // TODO 4: Create a method getSalary() that returns baseSalary.


    // TODO 5: Create a method getInfo() that returns a String like:
    //         "Employee: Alice | Salary: 2000.0"

}

 * =====================================================
 *  STUDENT 4 - Manager.java
 *  Extends Employee
 * =====================================================
 

// TODO 6: Make Manager extend Employee.

public class Manager {

    // TODO 7: Add a private field: bonus (double)


    // TODO 8: Create a constructor that takes name, baseSalary, and bonus.
    //         Use super() to call the Employee constructor.