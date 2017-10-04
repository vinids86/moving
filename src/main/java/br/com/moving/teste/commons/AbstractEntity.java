package br.com.moving.teste.commons;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.hateoas.Identifiable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by ifc.vinicius.saraiva on 29/09/17.
 */
@Data
@ToString
@MappedSuperclass
@EqualsAndHashCode
public class AbstractEntity implements Identifiable<Long> {

    private final @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    protected AbstractEntity() {
        this.id = null;
    }
}