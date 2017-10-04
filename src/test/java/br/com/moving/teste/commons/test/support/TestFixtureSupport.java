package br.com.moving.teste.commons.test.support;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import lombok.NoArgsConstructor;
import org.junit.BeforeClass;

/**
 * Created by ifc.vinicius.saraiva on 04/10/17.
 */
@NoArgsConstructor
public abstract class TestFixtureSupport extends TestSupport {
    @BeforeClass
    public static void beforeTestClass() {
        FixtureFactoryLoader.loadTemplates("br.com.moving.teste.template.loader");
    }
}
