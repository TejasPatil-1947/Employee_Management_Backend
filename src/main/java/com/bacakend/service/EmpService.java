package com.bacakend.service;

import com.bacakend.Entity.Emp;

import java.util.List;

public interface EmpService {

     Emp createEmp(Emp emp);

     List<Emp> getAllEmp();

     Emp getEmpById(int id);

     void deleteEmp(int id);

     Emp updateEmp(int id, Emp emp);

}
