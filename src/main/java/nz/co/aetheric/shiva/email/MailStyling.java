package nz.co.aetheric.shiva.email;

/**
 * This interface represents the data required to inject styling into an html email.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
 */
public interface MailStyling {

	/**
	 * Retrieves the code the styling is stored under.
	 * @return The style code.
	 */
	public String getCode();

	/**
	 * Gets the css styling.
	 * @return The css styles.
	 */
	public String getStyles();

}
