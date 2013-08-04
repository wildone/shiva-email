package nz.co.aetheric.shiva.email;

import java.util.Collection;
import java.util.Locale;
import java.util.Map;

/**
 * This service provides a no-hassle way of sending pre-configured email to recipients.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
 */
public interface ShivaMail {

	/**
	 * This method will retrieve, render and send a specified email to the provided recipients, throwing an exception
	 * if anything goes wrong during the process.
	 * @param code The code of the email content.
	 * @param locale The locale of the email content.
	 * @param data The data to use while rendering the email.
	 * @param recipients The recipients to send the email to.
	 * @throws ShivaMailException
	 */
	public void send(String code, Locale locale, Map data, Collection<Recipient> recipients) throws ShivaMailException;

}
