package nz.co.aetheric.shiva.email;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.hamcrest.CoreMatchers.notNullValue;

/**
 * This test makes sure spring wires everything up properly.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:shiva-email-test-context.xml" })
public class SpringContextTest {

    @Resource
    ShivaMail shivaMail;

    @Test
    public void ensureTheServiceWiresUp() throws Exception {
        Assert.assertThat(shivaMail, notNullValue());
    }
}
