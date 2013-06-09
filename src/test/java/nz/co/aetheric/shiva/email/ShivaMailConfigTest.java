package nz.co.aetheric.shiva.email;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * Unit tests for {@link ShivaMailConfig}. Shameless code-coverage grab.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
 */
public class ShivaMailConfigTest {

    @Test
    public void testGetMailSender() throws Exception {
        final String expected = RandomStringUtils.randomAlphabetic(10);
        final ShivaMailConfig config = new ShivaMailConfig() {{
            mailSender = expected;
        }};
        final String result = config.getMailSender();
        Assert.assertThat(result, is(expected));
    }

    @Test
    public void testGetCopyRecipient() throws Exception {
        final String expected = RandomStringUtils.randomAlphabetic(10);
        final ShivaMailConfig config = new ShivaMailConfig() {{
            copyRecipient = expected;
        }};
        final String result = config.getCopyRecipient();
        Assert.assertThat(result, is(expected));
    }

}
