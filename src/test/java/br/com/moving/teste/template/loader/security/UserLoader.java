package br.com.moving.teste.template.loader.security;

import br.com.moving.teste.security.models.User;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

/**
 * Created by ifc.vinicius.saraiva on 04/10/17.
 */
public class UserLoader implements TemplateLoader {

    public static final String VALID = "valid";

    @Override
    public void load() {
        Fixture.of(User.class).addTemplate(VALID, new Rule() {{
            add("id", random(999L));
            add("name", random("Jose", "Euclides"));
            add("lastname", random("Bonifacio", "Pereira"));
            add("email", random("euclides@mail.com"));
            add("password", random(String.class, "123", "321", "456", "654"));
            add("resetToken", regex("[\\d\\w]{8}-[\\d\\w]{4}-[\\d\\w]{4}-[\\d\\w]{4}-[\\d\\w]{8}"));
        }});
    }
}
