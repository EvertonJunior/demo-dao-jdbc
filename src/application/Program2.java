package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.CreateDepartmentDao();
		
		System.out.println("Test 1 - insert");
		
		Department newDepartment = new Department(null, "Hardware");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id: " + newDepartment.getId());
		
		System.out.println("\ntest 2 - findById");
		Department dep = departmentDao.findById(2);
		System.out.println(dep);
		
		
		System.out.println("\ntest 3 - update");
		Department dep1 = departmentDao.findById(6);
		dep1.setName("tools");
		departmentDao.update(dep1);
		System.out.println("update completed");
		
		System.out.println("\ntest 4 - delete");
		departmentDao.deleteById(12);
		System.out.println("deleted");
		
		System.out.println("\ntest 5 - findAll");
		
		List<Department> departments = departmentDao.findAll();
		
		departments.forEach(System.out::print);
		
	}

}
