/**
 * 
 */
package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.print.attribute.standard.Media;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.net.MediaType;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author hp
 *
 */
@ApiOperation(value = "/profile/v1/employee", tags = "Employee profile Controller")
@RestController
@RequestMapping("/profile/v1/employee")
public class EmployeeProfileController {

	List<Employee> employeeLov = Arrays.asList(new Employee(1, "Ali", "admin", "0311"),
			new Employee(1, "Khan", "Hr", "03112"), new Employee(1, "Fatima", "GF", "03113"),
			new Employee(1, "Ritaba", "Lov", "03114"), new Employee(1, "Yawar", "admin", "03115"),
			new Employee(1, "Mudassar", "admin", "03115"), new Employee(1, "Malik", "admin", "03117"));

	@ApiOperation(value = "Fetch all employees", response = Iterable.class)
	@ApiResponses( value= {   @ApiResponse(code=200,message="Success",response=Employee.class),
			@ApiResponse(code=401,message="UNAUTHORIZES!",response=ErrorResponse.class),
			@ApiResponse(code=402,message="FORBIDDEN",response=ErrorResponse.class),
			@ApiResponse(code=403,message="NOT FOUND")
	})
	public List<Employee> fetchAllEmployees() {
		return employeeLov;
	}

//	@GetMapping(value = "/fetch/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Fetch by name employees", response = Employee.class)
	@GetMapping(value = "/fetch/{name}", produces = "application/json; charset=UTF-8")
	public Employee fetchEmployeeByName(@ApiParam(value = "Employee Name") @PathVariable(value = "name") String name) {
		return employeeLov.stream().filter(x -> x.getName().equalsIgnoreCase(name)).findFirst().get();
	}

	@ApiOperation(value = "fetchEmployeeByDepartment", response = Employee.class)
	@GetMapping(value = "/fetch/{department}")
	public List<Employee> fetchEmployeeByDepartment(
			@ApiParam(value = "Department Name", required = true) @PathVariable(value = "department") String department) {
		return employeeLov.stream().filter(x -> x.getDepartment().equalsIgnoreCase(department))
				.collect(Collectors.toList());
	}

	@ApiOperation(value = "insertEmployee", response = Employee.class)
	@PostMapping
	public Employee insertEmployee(@ApiParam(value = "Employee") @RequestBody Employee emp) {
		return emp;
	}

	@ApiOperation(value = "updateEmployee", response = Employee.class)
	@PutMapping
	public Employee updateEmployee(@ApiParam(value = "Employee") @RequestBody Employee emp) {
		return emp;
	}

	@ApiOperation(value = "deleteEmployee", response = Employee.class)	
	@DeleteMapping
	public Employee deleteEmployee(@ApiParam(value = "Employee") @RequestBody Employee emp) {
		return emp;
	}

	@ApiOperation(value = "patchEmployee", response = Employee.class)	
	@PatchMapping
	public Object patchEmployee(@ApiParam(value = "Employee") @RequestBody Map<String, Object> partialUpdate) {
		return partialUpdate;
	}
}
