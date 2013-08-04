package nz.co.aetheric.shiva.email.styling;

import nz.co.aetheric.shiva.email.styling.MailStyling;
import nz.co.aetheric.shiva.email.ShivaMailException;

import java.util.List;

/**
 * This interface is the service definition for providing access to email styling.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
 */
public interface MailStylingProvider {

	/**
	 * Retrieves a single email style, stored under the provided code.
	 * @param code The code the email style is stored under.
	 * @return The style for the provided code, or null if it doesn't exist.
	 * @throws nz.co.aetheric.shiva.email.ShivaMailException
	 */
	public MailStyling getMailStyling(String code) throws ShivaMailException;

	/**
	 * Retrieves a list of email styles, ordered by least specific to most specific for the provided code.
	 * @param code The most specific code to retrieve a style for.
	 * @return A list of styles, ordered by specificity.
	 * @throws ShivaMailException
	 */
	public List<MailStyling> getMailStylings(String code) throws ShivaMailException;

}
