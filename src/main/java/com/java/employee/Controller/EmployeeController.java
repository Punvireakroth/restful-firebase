package com.java.employee.Controller;

import com.java.employee.Model.EmployeeModel;
import com.java.employee.Routes.EmployeeRoute;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class EmployeeController {
    public EmployeeRoute employeeRoute;
    public EmployeeController(EmployeeRoute employeeRoute){
        this.employeeRoute = employeeRoute;
    }

    @PostMapping("/create")
    public String createEmployee(@RequestBody EmployeeModel employeeModel) throws InterruptedException, ExecutionException {
        return employeeRoute.createEmployee(employeeModel);
    }

    @GetMapping("/get")
    public EmployeeModel getEmployee(@RequestParam String documentId) throws InterruptedException, ExecutionException {
        return employeeRoute.getEmployee(documentId);
    }

    @PutMapping("/put")
    public String updateEmployee(@RequestParam EmployeeModel employeeModel) throws InterruptedException, ExecutionException {
        return employeeRoute.updateEmployee(employeeModel);
    }

    @PutMapping("/delete")
    public String deleteEmployee(@RequestBody String documentId) throws InterruptedException, ExecutionException {
        return employeeRoute.deleteEmployee(documentId);
    }

    @GetMapping("/test")
    public ResponseEntity<String> testGetEndpoint() {
        return ResponseEntity.ok("Test Get Endpoint is Working");
    }
}
