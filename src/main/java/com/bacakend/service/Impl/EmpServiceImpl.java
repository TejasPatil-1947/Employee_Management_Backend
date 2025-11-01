package com.bacakend.service.Impl;

import com.bacakend.Entity.Emp;
import com.bacakend.repository.EmpRepository;
import com.bacakend.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {


    @Autowired
    private EmpRepository empRepository;

    @Override
    public Emp createEmp(Emp emp) {
        return empRepository.save(emp);
    }

    @Override
    public List<Emp> getAllEmp() {
        return empRepository.findAll();
    }

    @Override
    public Emp getEmpById(int id) {
        return empRepository.findById(id).get();
    }

    @Override
    public void deleteEmp(int id) {
        Emp emp = empRepository.findById(id).get();
        empRepository.delete(emp);
    }

    @Override
    public Emp updateEmp(int id, Emp emp) {
        Emp oldEmp = empRepository.findById(id).get();
        if(oldEmp !=null){
            emp.setId(id);
            return empRepository.save(emp);
        }
        return null;
    }
}
