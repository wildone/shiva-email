package nz.co.aetheric.shiva.email;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.MailException;

import static org.hamcrest.CoreMatchers.*;

/**
 * Unit testing for {@link ShivaMailException}.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
 */
@SuppressWarnings("ThrowableResultOfMethodCallIgnored")
public class ShivaMailExceptionTest {

    @Test
    public void testGetCodes() throws Exception {
        final ShivaMailException exception = buildShivaExceptionWithCause();
        final String[] expected = new String[] {
                buildCodeFromException(exception),
                ShivaMailException.ERROR_CODE_BASE
        };
        final String[] result = exception.getCodes();
        Assert.assertThat(result, is(expected));
    }

    @Test
    public void testGetArguments() throws Exception {
        final ShivaMailException exception = buildShivaExceptionWithCause();
        final Object[] result = exception.getArguments();
        Assert.assertThat(result, nullValue());
    }

    @Test
    public void testGetDefaultMessage() throws Exception {
        final ShivaMailException exception = buildShivaExceptionWithCause();
        final String expected = buildCodeFromException(exception);
        final String result = exception.getDefaultMessage();
        Assert.assertThat(result, is(expected));
    }

    @Test
    public void testBuildCode_builds() throws Exception {
        final String suffix = RandomStringUtils.randomAlphabetic(5);
        final String expected = ShivaMailException.ERROR_CODE_BASE + "." + suffix;
        final String result = ShivaMailException.buildCode(suffix);
        Assert.assertThat(result, is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuildCode_blows() throws Exception {
        ShivaMailException.buildCode(null);
    }

    private ShivaMailException buildShivaExceptionWithCause() {
        return new ShivaMailException(buildShivaExceptionCause());
    }

    private Throwable buildShivaExceptionCause() {
        return new MailAuthenticationException("");
    }

    private String buildCodeFromException(ShivaMailException exception) {
        Class<? extends Throwable> causeType = exception.getCause().getClass();
        String suffix = ShivaMailException.ERROR_SUFFIX_MAP.get(causeType);
        return ShivaMailException.buildCode(suffix);
    }

}
