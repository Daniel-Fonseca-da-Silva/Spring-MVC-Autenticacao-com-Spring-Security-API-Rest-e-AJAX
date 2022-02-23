package com.empresa.projeto.controller;

import com.empresa.projeto.model.Pedido;
import com.empresa.projeto.model.StatusPedido;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Cacheable("pedidos")
    List<Pedido> findByStatus(StatusPedido status, Pageable sort);

    @Query("SELECT p FROM Pedido p JOIN p.user u WHERE u.username = :username")
    List<Pedido> findAllByUsuario(@Param("username") String username);

    @Query("SELECT p FROM Pedido p JOIN p.user u WHERE u.username = :username AND p.status = :status")
    List<Pedido> findByStatusEUsuario(@Param("status") StatusPedido status, @Param("username") String username);
}
