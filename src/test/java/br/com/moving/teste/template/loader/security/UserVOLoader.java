package br.com.moving.teste.template.loader.security;

import br.com.moving.teste.security.vo.UserVO;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

/**
 * Created by ifc.vinicius.saraiva on 04/10/17.
 */
public class UserVOLoader implements TemplateLoader {

    public static final String VALID = "valid";
    public static final String ANOTHER_EMAIL = "another.email";

    @Override
    public void load() {
        Fixture.of(UserVO.class).addTemplate(VALID, new Rule() {{
            add("id", random(999L));
            add("name", random("Jose", "Euclides"));
            add("lastname", random("Bonifacio", "Pereira"));
            add("email", random("jose@yahoo.com.br", "euclides@mail.com"));
            add("password", random(String.class, "123", "321", "456", "654"));
        }});
        Fixture.of(UserVO.class).addTemplate(ANOTHER_EMAIL).inherits(VALID, new Rule() {{
            add("email", "outro@email.com.br");
        }});
    }
}
