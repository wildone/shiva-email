package nz.co.aetheric.shiva.email;

import org.springframework.context.MessageSourceResolvable;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.MailParseException;
import org.springframework.mail.MailPreparationException;
import org.springframework.mail.MailSendException;

/**
 * This exception simply acts as a wrapper for other possible exceptions thrown during the mail sending process. Since
 * the exception is {@link MessageSourceResolvable}, it can be fed directly into a
 * {@link org.springframework.context.MessageSource} to retrieve whatever message has been configured.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
 */
public class ShivaMailException extends Exception implements MessageSourceResolvable {

    @Override
    public String[] getCodes() {
        return new String[0];
    }

    @Override
    public Object[] getArguments() {
        return new Object[0];
    }

    @Override
    public String getDefaultMessage() {
        return null;
    }

}
