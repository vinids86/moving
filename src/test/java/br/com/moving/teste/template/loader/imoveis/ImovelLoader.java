package br.com.moving.teste.template.loader.imoveis;

import br.com.moving.teste.imoveis.models.Imobiliaria;
import br.com.moving.teste.imoveis.models.Imovel;
import br.com.moving.teste.imoveis.models.Type;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

/**
 * Created by ifc.vinicius.saraiva on 04/10/17.
 */
public class ImovelLoader implements TemplateLoader {

    public static final String VALID = "valid";

    @Override
    public void load() {
        Fixture.of(Imovel.class).addTemplate(VALID, new Rule() {{
            add("id", random(Long.class, range(1L, 200L)));
//            add("imobiliaria", has(1).of(Imobiliaria.class, "without.imovel"));
            add("type", random(Type.CASA, Type.APARTAMENTO));
            add("description", "Descrição do Imóvel");
            add("address", random("Avenida Paulista", "Avenida Ibirapuera"));
        }});
//        Fixture.of(Imovel.class).addTemplate("valid", new Rule());
    }
}
