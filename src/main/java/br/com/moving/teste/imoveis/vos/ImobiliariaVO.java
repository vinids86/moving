package br.com.moving.teste.imoveis.vos;

import br.com.moving.teste.commons.AbstractVO;
import br.com.moving.teste.imoveis.models.Imovel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by ifc.vinicius.saraiva on 29/09/17.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@EqualsAndHashCode(callSuper = true)
public class ImobiliariaVO extends AbstractVO {
    private Long imobiliariaId;
    private String name;
    private String description;
    private List<Imovel> imoveis;
}
