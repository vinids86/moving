package br.com.moving.teste.imoveis.vos;

import br.com.moving.teste.commons.AbstractVO;
import br.com.moving.teste.imoveis.models.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Created by ifc.vinicius.saraiva on 29/09/17.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@EqualsAndHashCode(callSuper = true)
public class ImovelVO extends AbstractVO {

    private Long id;
    private Long imobiliariaId;
    private Type type;
    private String description;
    private String address;
}

