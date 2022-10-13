package com.pucpr.backend.resource.service;

import com.pucpr.backend.model.DTO.PositionPermissionDTO;
import com.pucpr.backend.model.repository.PositionRepository;
import com.pucpr.backend.model.tables.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PositionService
        implements CrudInterface<Position>{

    @Autowired
    private PositionRepository positionRepository;

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public Optional<Position> save(Position entity) {
        return Optional.of(positionRepository.save(entity));
    }

    @Override
    public Optional<Position> findById(long id) {
        return Optional.of(positionRepository.findById(id));
    }

    @Override
    public void delete(Position entity) {
        positionRepository.delete(entity);
    }

    @Override
    public void deleteById(long id) {
        positionRepository.deleteById(id);
    }

    @Override
    public long count() {
        return positionRepository.count();
    }

    @Transactional
    @Modifying
    public void updatePermission(PositionPermissionDTO positionPermissionDTO) {
        Optional<Position> optionalPosition = positionRepository.findById(positionPermissionDTO.idCargo);
        if(optionalPosition == null){
            throw new Error("Cargo não Existe");
        }
        Position position = optionalPosition.get();

        System.out.println("Entrou no Update Permissao");
        System.out.println(positionPermissionDTO.idCargo);
        System.out.println(positionPermissionDTO.campo);
        System.out.println(position.isAcesso_modulo_estoque());
        System.out.println(position.isAcesso_modulo_pessoas());
        System.out.println(positionPermissionDTO.newValue);
        if("acesso_modulo_pessoas".equals(positionPermissionDTO.campo)){
            position.setAcesso_modulo_pessoas(positionPermissionDTO.newValue);
        }
        if("acesso_modulo_estoque".equals(positionPermissionDTO.campo)){
            position.setAcesso_modulo_estoque(positionPermissionDTO.newValue);
        }
        this.positionRepository.save(position);
    }
}
