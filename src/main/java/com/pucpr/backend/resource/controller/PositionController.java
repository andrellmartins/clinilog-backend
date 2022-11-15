package com.pucpr.backend.resource.controller;

import com.pucpr.backend.config.MailSender;
import com.pucpr.backend.model.DTO.PositionPermissionDTO;
import com.pucpr.backend.model.tables.Employee;
import com.pucpr.backend.model.tables.Position;
import com.pucpr.backend.resource.service.EmployeeService;
import com.pucpr.backend.resource.service.PositionService;
import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.Email;
import javax.validation.groups.Default;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @Autowired
    private EmployeeService employeeService;

    private MailSender mailSender = new MailSender();

    @GetMapping(value = "/")
    public ResponseEntity<List<Position>> getAll() {
        List<Position> positionsList = positionService.findAll();
        if(positionsList == null || positionsList.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(positionsList);
    }

    @PostMapping("/permissao/")
    public ResponseEntity<Boolean> updatePermissaoCampo(
            @RequestBody PositionPermissionDTO positionPermissionDTO
    ) {
        try{
            this.positionService.updatePermission(positionPermissionDTO);

            List<Employee> employees = this.employeeService.findByCargoId(positionPermissionDTO.idCargo);
            if(employees != null && !employees.isEmpty()){
                List<String> emails = new ArrayList<>();

                for(Employee emp:employees){
                    if(emp.getPessoa() != null && emp.getPessoa().getEmail() != null){
                        System.out.println(emp.getPessoa().getEmail());
                        emails.add(emp.getPessoa().getEmail());
                    }
                }
                String actions = positionPermissionDTO.newValue                  ? "Concedidas" : "Removidas";
                String action  = positionPermissionDTO.newValue                  ? "Concedida"  : "Removida";
                String modulo  = positionPermissionDTO.campo.contains("estoque") ? "Estoque"    : "Pessoas";
                mailSender.sendMail(
                    "Acessos Alterados - Permissões "+actions,
                    "O seu acesso as funcoes do módulo de "+modulo+" foi "+action+".",
                    emails
                );
            }
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(true);
    }

}
