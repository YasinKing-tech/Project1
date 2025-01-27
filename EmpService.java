package com.example.mvc.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvc.Entity.EmpEntity;
import com.example.mvc.Model.EmpModel;
import com.example.mvc.Repository.EmpRepository;

@Service
public class EmpService {
  @Autowired
   EmpRepository empRepository;
  
	public void SendForm(EmpModel empModel) {
		EmpEntity empEntity=new EmpEntity();
		 empEntity.setEmpAddress(empModel.getEmpAddress());
		 empEntity.setEmpName(empModel.getEmpName());
		 empEntity.setEmpDesignation(empModel.getEmpDesignation());
		 empEntity.setEmpSalary(empModel.getEmpSalary());
		 empEntity.setEmpEmail(empModel.getEmpEmail());
		 empEntity.setEmpPas(empModel.getEmpPas());
		 empRepository.save(empEntity);
	}
    public List<EmpEntity> GetDetails() {
    	List<EmpEntity>details=empRepository.findAll();
    	  return details;
    }
	public void Delete(long empId) {
		empRepository.deleteById(empId);
		
	}
	public EmpModel Edit(long empId) {
		EmpEntity empEntity=empRepository.findById(empId).get();
		EmpModel empModel=new EmpModel();
		 empModel.setEmpAddress(empEntity.getEmpAddress());
		 empModel.setEmpName(empEntity.getEmpName());
		 empModel.setEmpDesignation(empEntity.getEmpDesignation());
		 empModel.setEmpSalary(empEntity.getEmpSalary());
		 empModel.setEmpPas(empEntity.getEmpPas());
		 empModel.setEmpEmail(empEntity.getEmpEmail());
		 return empModel;
		
	}
	public void UpdateById(long EmpId, EmpModel empModel) {
		EmpEntity empEntity=empRepository.findById(EmpId).get();
		   
		empEntity.setEmpAddress(empModel.getEmpAddress());
		empEntity.setEmpName(empModel.getEmpName());
		empEntity.setEmpDesignation(empModel.getEmpDesignation());
		empEntity.setEmpSalary(empModel.getEmpSalary());
		empEntity.setEmpPas(empModel.getEmpPas());
		empEntity.setEmpEmail(empModel.getEmpEmail());
		empRepository.save(empEntity);
	
	}
	public EmpEntity SearchById(long EmpId) {
		 return empRepository.findById(EmpId).orElse(null);
	}   
	 public void saveEmployee(EmpModel empModel) {
	        EmpEntity empEntity = new EmpEntity();
	        
	        // Set the fields from the model to the entity
	        empEntity.setEmpName(empModel.getEmpName());
	        empEntity.setEmpAddress(empModel.getEmpAddress());
	        empEntity.setEmpEmail(empModel.getEmpEmail());
	        empEntity.setEmpPas(empModel.getEmpPas());
	        empEntity.setEmpDesignation(empModel.getEmpDesignation());
	        empEntity.setEmpSalary(empModel.getEmpSalary());

	        // Save to the database
	        empRepository.save(empEntity);
	    }
}
