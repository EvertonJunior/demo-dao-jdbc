package application;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		
		System.out.println("Test 1 - findByiD");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\nTest 2 - findByDepartment");
		Department department = new Department(2,null);
		List<Seller> list = sellerDao.FindByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\nTest 3 - findAll");
		list = sellerDao.findAll();;
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\nTest 4 - insert");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(0), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());

		System.out.println("\nTest 5 - update");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("\n Test 5 - delete ");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");

	}
	
	
	
}
