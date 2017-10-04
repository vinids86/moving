package br.com.moving.teste.imoveis.models;

import br.com.moving.teste.commons.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ifc.vinicius.saraiva on 29/09/17.
 */
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Entity
@Table(name = "IMOBILIARIA")
public class Imobiliaria extends AbstractEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @JsonManagedReference
    @OneToMany(mappedBy = "imobiliaria", cascade = CascadeType.ALL)
    List<Imovel> imoveis;
}
