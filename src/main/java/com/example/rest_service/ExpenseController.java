package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import java.util.List;
import java.util.ArrayList;

@RestController
public class ExpenseController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	//Create a mapping for /balance
	//Call a method from service layer to get the balance
	private BalanceService balanceService = new BalanceService();
	private TransactionService transactionService = new TransactionService();
	private UserService userService = new UserService();

	@GetMapping("/login")
	@CrossOrigin(origins = "http://localhost:3000")
	public boolean login(@RequestParam int id, @RequestParam String password) {
		return userService.login(id,password);
	}

	@GetMapping("/getUser")
	@CrossOrigin(origins = "http://localhost:3000")
	public User getUser(@RequestParam int id) {
		User user = userService.getUser(id);
		return user;
	}

	@GetMapping("/getBalance")
	@CrossOrigin(origins = "http://localhost:3000")
	public Balance balanceService(@RequestParam int id) {
		return balanceService.getBalance(id);
	}

	@GetMapping("/getTransactions")
	@CrossOrigin(origins = "http://localhost:3000")
	public ArrayList<Transaction> transactionService(@RequestParam int id) {
		return transactionService.getTransactions(id);
	}

	@PostMapping("/addTransaction")
	@CrossOrigin(origins = "http://localhost:3000")
	public void addTransaction(@RequestParam int id,@RequestBody Transaction newTransaction) {
		//add a new transaction for the first user
		transactionService.addTransaction(newTransaction,balanceService.getBalance(id)); 
	}
	@DeleteMapping("/deleteTransaction/{transactionId}")
	@CrossOrigin(origins = "http://localhost:3000")
	public void deleteTransaction(@RequestParam int id,@PathVariable int transactionId) {
		//add a new transaction for the first user
		transactionService.deleteTransaction(transactionId,balanceService.getBalance(id)); 
	}

}