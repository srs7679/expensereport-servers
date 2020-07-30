package com.rubix.expense_tracker.controller;




import java.util.List;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubix.expense_tracker.exception.ResourceNotFoundException;
import com.rubix.expense_tracker.model.ExpenseCurrency;
import com.rubix.expense_tracker.repository.EmployeeRepository;
import com.rubix.expense_tracker.repository.ExpenseCurrencyRepository;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ExpenseCurrencyController {

    @Autowired
    private ExpenseCurrencyRepository expensecurrencyRepository;

    @Autowired
    private EmployeeRepository employeeRepository;
    
    
    
    @GetMapping("/currency")
	public List<ExpenseCurrency> getAllEmployees() {
		return expensecurrencyRepository.findAll();
	}

   /* @GetMapping("/currency/{employeeId}")
    public Page<ExpenseCurrency> getAllExpenseCurrencyByEmployeeId(@PathVariable (value = "employeeId") Long employeeId,
                                                Pageable pageable) {
    	
    	
        return expensecurrencyRepository.findByEmployeeId(employeeId, pageable);
    }*/
    
    @GetMapping("/currency/{id}")
    public List <ExpenseCurrency> getExpenseById(@PathVariable(value = "id") Long employeeId) {
        return expensecurrencyRepository.findByEmployeeId(employeeId);
    }

   /* @PostMapping("/currency/{employeeId}")
    public ExpenseCurrency createExpenseCurrency(@PathVariable (value = "employeeId") Long employeeId,
                                 @Valid @RequestBody ExpenseCurrency expensecurrency) throws ResourceNotFoundException,Exception {
    	
    	System.out.println(expensecurrency.getCode() + "\t" + expensecurrency.getCurrency());
    	//String tempname=expensecurrency.getCurrency(); 
		
    	//ExpenseCurrency expen= expensecurrencyRepository.findByCurrencyAndEmployeeId(tempname,employeeId) ;
	
		
		//if(expen!=null){throw new Exception("Currency already exists");}
        return employeeRepository.findById(employeeId).map(employee -> {
        	expensecurrency.setEmployee(employee);
        	
            return expensecurrencyRepository.save(expensecurrency);
        }).orElseThrow(() -> new ResourceNotFoundException("EmployeeId " + employeeId + " not found"));
    } */

 /*   @PostMapping("/currency/{employeeId}/{currency}/{currencycode}")
	public ExpenseCurrency createExpenseCurrency(@PathVariable(value = "employeeId") Long employeeId,@PathVariable(value = "currency") String currency,@PathVariable(value = "currencycode") String currencycode) throws ResourceNotFoundException {
		System.out.println("expensecurrency.getCode()" + currencycode);
		System.out.println("expensecurrency.getCurrency()" + currency);
		System.out.println("expensecurrency.getEmployeeId" + employeeId);
		
		ExpenseCurrency expensecurrency = new ExpenseCurrency();
		expensecurrency.setCode(currencycode);
		expensecurrency.setCurrency(currency);
		
		//expensecurrency.setEmployee(employeeId);
		return employeeRepository.findById(employeeId).map(employee -> {
        	
			expensecurrency.setEmployee(employee);
           
            
            return expensecurrencyRepository.save(expensecurrency);
            
       }).orElseThrow(() -> new ResourceNotFoundException("detail not found"));
    }*/
    
    @PostMapping("/currency/{id}")
    public ExpenseCurrency createExpenseCurrency(@PathVariable(value = "id") long EmployeeId,
        /*@Valid*/ @RequestBody ExpenseCurrency expense) throws ResourceNotFoundException,Exception{
	  //Code to restrict the count of EmployeeId
	  /*List<Expense> exp = expenseRepo. findByUserId(UserId);
	 
	  long count = exp.size();
	  	if(count > 2  ){
	  		
	  		throw new Exception("EmployeeId cant exceed");
	  	}*/
    	
    	
      String tempname=expense.getCode(); 
		
    	ExpenseCurrency expen= expensecurrencyRepository.findByCurrencyAndEmployeeId(tempname,EmployeeId) ;
	
		
		if(expen!=null){throw new Exception("Currency already exists");}
		
	    if(tempname.equals("usd")) {
	    	expense.setCurrency("US Dollar");
	    }else  if(tempname.equals("aud")) {
	    	expense.setCurrency("Australian Dollar");
	    }else  if(tempname.equals("inr")) {
	    	expense.setCurrency("Indian Rupees");
	    }
	    
	  
        return employeeRepository.findById(EmployeeId).map(employee -> {
        	
        		expense.setEmployee(employee);
           
            
        		return expensecurrencyRepository.save(expense);
            
        }).orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
     
		
    }
		 
    @PutMapping("/currency/{id}/{exp}")
    public ExpenseCurrency updateExpense(@PathVariable(value = "id")  long EmployeeId,
        @PathVariable(value = "exp") long currencyId,/*@Valid*/ @RequestBody ExpenseCurrency expense)
    throws ResourceNotFoundException{
        if (!employeeRepository.existsById( EmployeeId)) {
            throw new ResourceNotFoundException("EmployeeId not found");
        }

        return expensecurrencyRepository.findById(currencyId).map(expens -> {
        	 expense.setCurrency(expense.getCurrency());
        	 expense.setCode(expense.getCode());
        	 
            return expensecurrencyRepository.save(expense);
        }).orElseThrow(() -> new ResourceNotFoundException("expense id not found"));
    }
    
    /*@PutMapping("/currency/{employeeId}/{expensecurrencyId}")
    public ExpenseCurrency updateExpenseCurrency(@PathVariable (value = "employeeId") Long employeeId,
                                 @PathVariable (value = "expensecurrencyId") Long expensecurrencyId,
                                 @Valid @RequestBody ExpenseCurrency expensecurrencyRequest) throws ResourceNotFoundException {
        if(!employeeRepository.existsById(employeeId)) {
            throw new ResourceNotFoundException("EmployeeId " + employeeId + " not found");
        }

        return expensecurrencyRepository.findById(expensecurrencyId).map(expensecurrency -> {
        	expensecurrency.setCurrency(expensecurrencyRequest.getCurrency());
        	expensecurrency.setCode(expensecurrencyRequest.getCode());
            return expensecurrencyRepository.save(expensecurrency);
        }).orElseThrow(() -> new ResourceNotFoundException("ExpenseCurrencyId " + expensecurrencyId + "not found"));
    }*/

    @DeleteMapping("/currency/{employeeId}/{expensecurrencyId}")
    public ResponseEntity<?> deleteExpenseCurrency(@PathVariable (value = "employeeId") Long employeeId,
                              @PathVariable (value = "expensecurrencyId") Long expensecurrencyId) throws ResourceNotFoundException {
        return expensecurrencyRepository.findByIdAndEmployeeId(expensecurrencyId, employeeId).map(expensecurrency -> {
        	expensecurrencyRepository.delete(expensecurrency);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("ExpenseCurrency not found with id " + expensecurrencyId + " and employeeId " + employeeId));
    }
}