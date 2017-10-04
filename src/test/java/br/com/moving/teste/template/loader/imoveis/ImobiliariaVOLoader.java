package br.com.moving.teste.template.loader.imoveis;

import br.com.moving.teste.imoveis.vos.ImobiliariaVO;
import br.com.moving.teste.imoveis.vos.ImovelVO;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

/**
 * Created by ifc.vinicius.saraiva on 04/10/17.
 */
public class ImobiliariaVOLoader implements TemplateLoader {

    public static final String VALID = "valid";

    @Override
    public void load() {
        Fixture.of(ImobiliariaVO.class).addTemplate(VALID, new Rule() {{
            add("imobiliariaId", random(Long.class, range(1L, 200L)));
            add("name", random("Inovação Imobiliária", "Focus Consultoria Imobiliária S/C Ltda", "AG1 Imobiliária"));
            add("description", "Descrição da Imobiliaria");
            add("imoveisVO", has(1).of(ImovelVO.class, "valid"));
        }});
    }
}
