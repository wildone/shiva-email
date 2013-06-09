package nz.co.aetheric.shiva.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.support.DefaultMessageSourceResolvable;

import java.util.Collection;
import java.util.Collections;
import java.util.Locale;

/**
 * This class encapsulates all that is required for sending a message using shiva mail.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
 */
public class ShivaMailPacket {
    private static final Logger logger = LoggerFactory.getLogger(ShivaMailPacket.class);

    protected String code;
    protected Locale locale;
    protected Collection<String> recipients;

    protected ShivaMailPacket(String code, Locale locale) {
        this.code = code;
        this.locale = locale;
    }

    public ShivaMailPacket(String code, Collection<String> recipients) {
        this(code, Locale.getDefault());
        this.setRecipients(recipients);
    }

    public ShivaMailPacket(String code, Locale locale, Collection<String> recipients) {
        this(code, locale);
        this.setRecipients(recipients);
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public Collection<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(Collection<String> recipients) {
        this.recipients = Collections.unmodifiableCollection(recipients);
    }

    public MessageSourceResolvable getSubject() {
        return new DefaultMessageSourceResolvable(code + ".subject");
    }

    public MessageSourceResolvable getMessage() {
        return new DefaultMessageSourceResolvable(code + ".message");
    }

}
