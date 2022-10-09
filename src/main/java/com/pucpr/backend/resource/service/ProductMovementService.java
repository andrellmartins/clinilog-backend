package com.pucpr.backend.resource.service;

import com.pucpr.backend.config.MailSender;
import com.pucpr.backend.model.DTO.ReportProductMovementDTO;
import com.pucpr.backend.model.repository.ProductMovementRepository;
import com.pucpr.backend.model.tables.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProductMovementService
        implements CrudInterface<ProductMovement>{

    @Autowired
    private ProductMovementRepository productMovementRepository;
    @Autowired
    private PersonService personService;
    private MailSender mailSender;
    private Person currentUser;

    public ProductMovementService(){
        if(SecurityContextHolder.getContext().getAuthentication() != null){
            this.currentUser = (Person) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }
        this.mailSender = new MailSender();
    }


    @Override
    public List<ProductMovement> findAll() {
        return productMovementRepository.findAll();
    }

    @Override
    public Optional<ProductMovement> save(ProductMovement entity) {
        this.currentUser = personService.findByUserLogin(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        if(entity.getQtd_movimentada() < 0){
            Product p = entity.getLote().getProduto();
            if(p != null && p.getQtd_disponivel() < p.getQtd_minima()){
                try{
                    List<String> destinatarios = new ArrayList<>();
                    destinatarios.add(currentUser.getEmail());
                    mailSender.sendMail(
                        "Estoque Baixo - Produto "+p.getDescricao() + " - Lote "+entity.getLote().getLote(),
                        String.format(
                            "<p>Quantidade de Itens do Produto %s ficou abaixo do esperado. Você pode configurar o valor mínimo ao alterar o produto<p>" +
                            "Quantidade Atual: %s" +
                            "Quantidade Mínima: %s",
                            p.getDescricao(),
                            p.getQtd_disponivel() + entity.getQtd_movimentada(),
                            p.getQtd_minima()
                        ),
                        destinatarios
                    );
                }catch(Exception e){
                    throw new Error("Não foi possível enviar e-mail de estoque mínimo",e);
                }
            }
        }
        return Optional.of(productMovementRepository.save(entity));
    }

    @Override
    public Optional<ProductMovement> findById(long id) {
        return productMovementRepository.findById(id);
    }

    @Override
    public void delete(ProductMovement entity) {
        productMovementRepository.delete(entity);
    }

    @Override
    public void deleteById(long id) {
        productMovementRepository.deleteById(id);
    }

    @Override
    public long count() {
        return productMovementRepository.count();
    }

    public List<ProductMovement> filterReportProductMovement(ReportProductMovementDTO reportProductMovementDTO) {
        return productMovementRepository.filterReportProductMovement(
              reportProductMovementDTO.getProdutos(),
            reportProductMovementDTO.getLotes(),
            reportProductMovementDTO.getData_inicio(),
            reportProductMovementDTO.getData_fim()
        );
    }
}
