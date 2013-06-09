package nz.co.aetheric.shiva.email;

import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.Locale;

import static org.hamcrest.CoreMatchers.*;

/**
 * Unit tests for {@link ShivaMailPacket}. Mostly just coverage.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
 */
public class ShivaMailPacketTest {

    @Test
    public void initialisesProperlyWithoutLocale() throws Exception {
        final Locale expectedLocale = Locale.getDefault();
        final String expectedCode = RandomStringUtils.randomAlphabetic(10);
        final String expectedRecipient = RandomStringUtils.randomAlphabetic(10);
        final Collection<String> expectedRecipients = Collections.singletonList(expectedRecipient);

        ShivaMailPacket result = new ShivaMailPacket(expectedCode, expectedRecipients);

        Assert.assertThat("Sets the code properly", result.code, is(expectedCode));
        Assert.assertThat("Sets the locale properly", result.locale, is(expectedLocale));
        Assert.assertThat("Dereferences the recipients", result.recipients, allOf(
                not(expectedRecipients),
                notNullValue()
        ));
        Assert.assertThat("New recipients same size", result.recipients.size(), is(1));
        Assert.assertThat("Contains same item", result.recipients.iterator().next(), is(expectedRecipient));
    }

    @Test
    public void initialisesProperlyWithLocale() throws Exception {
        final Locale expectedLocale = Locale.getDefault();
        final String expectedCode = RandomStringUtils.randomAlphabetic(10);
        final String expectedRecipient = RandomStringUtils.randomAlphabetic(10);
        final Collection<String> expectedRecipients = Collections.singletonList(expectedRecipient);

        ShivaMailPacket result = new ShivaMailPacket(expectedCode, expectedLocale, expectedRecipients);

        Assert.assertThat("Sets the code properly", result.code, is(expectedCode));
        Assert.assertThat("Sets the locale properly", result.locale, is(expectedLocale));
        Assert.assertThat("Dereferences the recipients", result.recipients, allOf(
                not(expectedRecipients),
                notNullValue()
        ));
        Assert.assertThat("New recipients same size", result.recipients.size(), is(1));
        Assert.assertThat("Contains same item", result.recipients.iterator().next(), is(expectedRecipient));
    }

}
