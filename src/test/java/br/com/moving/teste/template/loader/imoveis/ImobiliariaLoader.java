package br.com.moving.teste.template.loader.imoveis;

import br.com.moving.teste.imoveis.models.Imobiliaria;
import br.com.moving.teste.imoveis.models.Imovel;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

/**
 * Created by ifc.vinicius.saraiva on 04/10/17.
 */
public class ImobiliariaLoader implements TemplateLoader {

    public static final String VALID = "valid";

    @Override
    public void load() {
        Fixture.of(Imobiliaria.class).addTemplate(VALID, new Rule() {{
            add("id", random(666L));
            add("name", random("Inovação Imobiliária", "Focus Consultoria Imobiliária S/C Ltda", "AG1 Imobiliária"));
            add("description", "Descrição da Imobiliaria");
            add("imoveis", has(2).of(Imovel.class, "valid"));
        }});
        Fixture.of(Imobiliaria.class).addTemplate("without.imovel").inherits(VALID, new Rule(){{
            add("imoveis", has(1).of(Imovel.class, "null"));
        }});
    }
}
