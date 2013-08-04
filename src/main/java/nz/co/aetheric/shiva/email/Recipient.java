package nz.co.aetheric.shiva.email;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import lombok.Data;

import java.util.Collection;

/**
 * This class represents a single email recipient, and contains a number of static utility functions for quickly
 * creating instances of itself.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
 *
 * @see #recipientTo
 * @see #recipientsTo
 * @see #recipientCopy
 * @see #recipientsCopy
 * @see #recipientBlind
 * @see #recipientsBlind
 */
@Data
public class Recipient {

	private final String address;
	private final RecipientType type;

	/**
	 * Creates a recipient with a default type of {@link RecipientType#TO}.
	 *
	 * @param address The address to send the email to.
	 */
	public Recipient(String address) {
		this.address = address;
		this.type = RecipientType.TO;
	}

	/**
	 * Creates a recipient with the provided type.
	 *
	 * @param address The address to send the email to.
	 * @param type    The type of recipient this is.
	 */
	public Recipient(String address, RecipientType type) {
		this.address = address;
		this.type = type;
	}

	/**
	 * Creates a recipient with a default type of {@link RecipientType#TO}.
	 *
	 * @param address The address to send the email to.
	 * @return A new recipient with a type of {@link RecipientType#TO}.
	 */
	public static Recipient recipientTo(String address) {
		return new Recipient(address, RecipientType.TO);
	}

	/**
	 * Transforms the provided collection of addresses into a collection of Recipients. Uses {@link #recipientTo} as
	 * the transform function.
	 *
	 * @param addresses The addresses to send the email to.
	 * @return A collection of Recipients of type {@link RecipientType#TO}.
	 */
	public static Collection<Recipient> recipientsTo(Collection<String> addresses) {
		return Collections2.transform(addresses, new Function<String, Recipient>() {
			@Override
			public Recipient apply(String address) {
				return recipientTo(address);
			}
		});
	}

	/**
	 * Creates a recipient with a default type of {@link RecipientType#COPY}.
	 *
	 * @param address The address to send the email to.
	 * @return A new recipient with a type of {@link RecipientType#COPY}.
	 */
	public static Recipient recipientCopy(String address) {
		return new Recipient(address, RecipientType.COPY);
	}

	/**
	 * Transforms the provided collection of addresses into a collection of Recipients. Uses {@link #recipientCopy} as
	 * the transform function.
	 *
	 * @param addresses The addresses to send the email to.
	 * @return A collection of Recipients of type {@link RecipientType#COPY}.
	 */
	public static Collection<Recipient> recipientsCopy(Collection<String> addresses) {
		return Collections2.transform(addresses, new Function<String, Recipient>() {
			@Override
			public Recipient apply(String address) {
				return recipientCopy(address);
			}
		});
	}

	/**
	 * Creates a recipient with a default type of {@link RecipientType#BLIND}.
	 *
	 * @param address The address to send the email to.
	 * @return A new recipient with a type of {@link RecipientType#BLIND}.
	 */
	public static Recipient recipientBlind(String address) {
		return new Recipient(address, RecipientType.BLIND);
	}

	/**
	 * Transforms the provided collection of addresses into a collection of Recipients. Uses {@link #recipientBlind} as
	 * the transform function.
	 *
	 * @param addresses The addresses to send the email to.
	 * @return A collection of Recipients of type {@link RecipientType#BLIND}.
	 */
	public static Collection<Recipient> recipientsBlind(Collection<String> addresses) {
		return Collections2.transform(addresses, new Function<String, Recipient>() {
			@Override
			public Recipient apply(String address) {
				return recipientBlind(address);
			}
		});
	}

}
