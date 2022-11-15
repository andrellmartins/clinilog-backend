package com.pucpr.backend.resource.controller;

import com.pucpr.backend.config.MailSender;
import com.pucpr.backend.model.DTO.PositionPermissionDTO;
import com.pucpr.backend.model.tables.Employee;
import com.pucpr.backend.model.tables.Position;
import com.pucpr.backend.model.tables.User;
import com.pucpr.backend.resource.service.EmployeeService;
import com.pucpr.backend.resource.service.PositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(
        value = "Cargos",
        description = "Gerenciar os cargos dos funcionários no sistema.",
        tags = "Cargos"
)
@RequestMapping("/position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @Autowired
    private EmployeeService employeeService;

    private MailSender mailSender = new MailSender();

    @GetMapping(value = "/")
    @ApiOperation(
            value = "Consultar todos os cargos no sistema",
            tags = {"Cargos"}
    )
    @ApiResponses(value = {
            @ApiResponse( code = 200, message= "Sucesso", response = Position[].class),
            @ApiResponse( code = 500, message= "Erro", response = ResponseEntity.class)
    })
    public ResponseEntity<List<Position>> getAll() {
        try{
            List<Position> positionsList = positionService.findAll();
            if(positionsList == null || positionsList.isEmpty()){
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
            return ResponseEntity.ok(positionsList);
        }catch(Exception e){
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/permissao/")
    @ApiOperation(
            value = "Alterar as permissões de acesso de um cargo no sistema e informar aos usuários com o cargo alterado sobre as permissões",
            tags = {"Cargos"}
    )
    @ApiResponses(value = {
            @ApiResponse( code = 200, message= "Sucesso", response = Boolean.class),
            @ApiResponse( code = 500, message= "Erro", response = ResponseEntity.class)
    })
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
