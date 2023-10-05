package com.example.Employee.Managment.System.service;

import com.example.Employee.Managment.System.model.Employee;
import com.example.Employee.Managment.System.repository.EmpRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

    private final EmpRepository empRepository;

    public EmpService(EmpRepository empRepository) {
        this.empRepository = empRepository;
    }

    public void addEmployee(Employee employee){
        empRepository.save(employee);
    }

    public List<Employee> getAllEmployee(){
        return empRepository.findAll();
    }

    public Employee getEmployeeById(long id){
        Optional<Employee> employee=empRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        return null;
    }
    public void deleteById(long id){
        empRepository.deleteById(id);
    }
}
