package br.com.moving.teste.template.loader.imoveis;

import br.com.moving.teste.imoveis.models.Type;
import br.com.moving.teste.imoveis.vos.ImovelVO;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

/**
 * Created by ifc.vinicius.saraiva on 04/10/17.
 */
public class ImovelVOLoader implements TemplateLoader {

    public static final String VALID = "valid";

    @Override
    public void load() {
        Fixture.of(ImovelVO.class).addTemplate(VALID, new Rule(){{
            add("id", random(Long.class, range(1L, 200L)));
            add("imobiliariaId", random(Long.class, range(1L, 200L)));
            add("type", random(Type.CASA, Type.APARTAMENTO));
            add("description", "Descrição do Imóvel");
            add("address", random("Avenida Paulista", "Avenida Ibirapuera"));
        }});
    }
}
