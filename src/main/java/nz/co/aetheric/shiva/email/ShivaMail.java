package nz.co.aetheric.shiva.email;

import java.util.Collection;
import java.util.Locale;

/**
 * This service provides a no-hassle way of sending pre-configured email to recipients.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
 */
public interface ShivaMail {

    void sendMail(ShivaMailPacket packet) throws ShivaMailException;

    void sendMail(String code, Collection<String> recipients) throws ShivaMailException;

    void sendMail(String code, Locale locale, Collection<String> recipients) throws ShivaMailException;

}
