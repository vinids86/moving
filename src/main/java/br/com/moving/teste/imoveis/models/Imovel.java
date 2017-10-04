package br.com.moving.teste.imoveis.models;

import br.com.moving.teste.commons.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

/**
 * Created by ifc.vinicius.saraiva on 29/09/17.
 */
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true, exclude = "imobiliaria")
@Entity
@Table(name = "IMOVEIS")
public class Imovel extends AbstractEntity {

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "IMOBILIARIA_ID")
    private Imobiliaria imobiliaria;

    @Column(name = "TYPE")
    private Type type;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ADDRESS")
    private String address;
}
