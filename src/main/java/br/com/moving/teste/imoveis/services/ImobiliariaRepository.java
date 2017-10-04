package br.com.moving.teste.imoveis.services;

import br.com.moving.teste.imoveis.models.Imobiliaria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ifc.vinicius.saraiva on 29/09/17.
 */
public interface ImobiliariaRepository extends JpaRepository<Imobiliaria, Long> {
}
