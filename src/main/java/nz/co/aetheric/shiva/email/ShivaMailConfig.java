package nz.co.aetheric.shiva.email;

/**
 * This class aggregates all the configuration information needed for running Shiva mail.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
 */
public interface ShivaMailConfig {

    public String getDefaultSender();

    public String getDefaultCopyRecipient();

	public String getDefaultSubject();

}
