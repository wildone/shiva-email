package nz.co.aetheric.shiva.email;

import org.apache.commons.lang3.StringUtils;

/**
 * This exception simply acts as a wrapper for other possible exceptions thrown during the mail sending process.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
 */
public class ShivaMailException extends Exception {
	public static final String ERROR_CODE_BASE = "shiva.mail.error";
	public static final String ERROR_SUFFIX_UNKNOWN = "unknown";

	/**
	 * Creates an exception with a suffix, but without any triggering exception.
	 *
	 * @param suffix The suffix to append to {@link #ERROR_CODE_BASE}
	 */
	public ShivaMailException(String suffix) {
		super(buildCode(suffix));
	}

	/**
	 * Creates an exception from a triggering exception, but with an unknown suffix.
	 *
	 * @param reason The triggering exception to wrap.
	 */
	public ShivaMailException(Throwable reason) {
		super(buildCode(ERROR_SUFFIX_UNKNOWN), reason);
	}

	/**
	 * Creates a new exception with the triggering exception and the provided suffix.
	 *
	 * @param reason The internal exception that caused the issue.
	 * @param suffix The triggering exception to wrap.
	 */
	public ShivaMailException(Throwable reason, String suffix) {
		super(buildCode(suffix), reason);
	}

	/**
	 * Adds the provided suffix to the end of {@link #ERROR_CODE_BASE} and returns the result.
	 *
	 * @param suffix The suffix to append.
	 * @return The completed code.
	 */
	protected static String buildCode(String suffix) {
		if (StringUtils.isBlank(suffix)) {
			throw new IllegalArgumentException("Suffix must not be null or blank.");
		}

		StringBuilder builder = new StringBuilder(ERROR_CODE_BASE);

		if (!suffix.startsWith(".")) {
			builder.append('.');
		}

		return builder.append(suffix).toString();
	}

}
