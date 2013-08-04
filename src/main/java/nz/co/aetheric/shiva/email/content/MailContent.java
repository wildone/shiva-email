package nz.co.aetheric.shiva.email.content;

import java.util.Locale;

/**
 * This interface defines the data expected to be present in a content record. Records should be unique on
 * {@link #getKey}, {@link #getLocale}, and {@link #getType}.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
 */
public interface MailContent {

	/**
	 * The key that is used to store and retrieve the email content.
	 * @return The key under which the content is stored.
	 */
	public String getKey();

	/**
	 * The locale targeting for the email content.
	 * @return The locale for which the content is targeted.
	 */
	public Locale getLocale();

	/**
	 * Whether the content is plain, html, markdown, velocity, etc.
	 * @return The type of rendering required for the content.
	 */
	public String getType();

	/**
	 * The content stored in this record.
	 * @return The content itself.
	 */
	public String getBody();

}
