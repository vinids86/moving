package br.com.moving.teste.commons.test.support;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

/**
 * Created by ifc.vinicius.saraiva on 04/10/17.
 */
public abstract class TestSupport {
    @Before
    public void setUpTest() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.setUp();
    }

    public abstract void setUp() throws Exception;

}
