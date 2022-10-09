package com.pucpr.backend.model.repository;

import com.pucpr.backend.model.DTO.ReportProductMovementDTO;
import com.pucpr.backend.model.tables.Batch;
import com.pucpr.backend.model.tables.Medicine;
import com.pucpr.backend.model.tables.Product;
import com.pucpr.backend.model.tables.ProductMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface ProductMovementRepository extends JpaRepository<ProductMovement, Long> {

    @Query( value =
            "SELECT p " +
            "FROM ProductMovement p " +
            "WHERE ( COALESCE( :produtos ) is null or p.lote.produto  in  (:produtos)      ) " +
            "   AND ( COALESCE( :lotes )   is null or p.lote          in  :lotes         ) " +
            "   AND (:data_inicio is null or p.data_cadastro >=  :data_inicio   ) " +
            "   AND (:data_fim    is null or p.data_cadastro <=  :data_fim      ) "
    )
    List<ProductMovement> filterReportProductMovement(
        @Param("produtos"     ) Collection<Product> produtos    ,
        @Param("lotes"        ) Collection<Batch>   lotes       ,
        @Param("data_inicio"  ) Date                data_inicio ,
        @Param("data_fim"     ) Date                data_fim
    );
}
