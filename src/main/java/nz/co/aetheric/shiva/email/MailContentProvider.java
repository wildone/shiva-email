package nz.co.aetheric.shiva.email;

import java.util.Collection;
import java.util.Locale;

/**
 * Provides a service definition for implementations that retrieve email content from some kind of persistent storage.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
 */
public interface MailContentProvider {

	public static String TYPE_PLAIN = "plain";
	public static String TYPE_HTML = "html";

	/**
	 * Retrieve the mail content stored under the provided key, locale and rendering type.
	 * @param key The under which the content is stored under.
	 * @param locale The locale for which the content is targeted.
	 * @param type The rendering type of the content.
	 * @return An instance of the mail content data.
	 * @throws ShivaMailException
	 */
	public MailContent getMailContent(String key, Locale locale, String type) throws ShivaMailException;

	/**
	 * Retrieves a collection of all the content stored under the provided key and locale.
	 * @param key The key under which the content is stored.
	 * @param locale The locale for which the content is targeted.
	 * @return All matching instances of the mail content data.
	 * @throws ShivaMailException
	 */
	public Collection<MailContent> getMailContent(String key, Locale locale) throws ShivaMailException;

}
