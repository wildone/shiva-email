package nz.co.aetheric.shiva.email;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.MailParseException;
import org.springframework.mail.MailPreparationException;
import org.springframework.mail.MailSendException;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This exception simply acts as a wrapper for other possible exceptions thrown during the mail sending process. Since
 * the exception is {@link MessageSourceResolvable}, it can be fed directly into a
 * {@link org.springframework.context.MessageSource} to retrieve whatever message has been configured.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
 */
public class ShivaMailException extends Exception implements MessageSourceResolvable {
    public static final String ERROR_CODE_BASE = "shiva.mail.error";
    public static final String ERROR_SUFFIX_UNKNOWN = "unknown";
    public static final Map<Class<? extends Throwable>, String> ERROR_SUFFIX_MAP;

    static {
        Map<Class<? extends Throwable>, String> map = new LinkedHashMap<>();

        map.put(MailAuthenticationException.class, "auth");
        map.put(MailParseException.class, "parse");
        map.put(MailPreparationException.class, "prepare");
        map.put(MailSendException.class, "send");

        ERROR_SUFFIX_MAP = Collections.unmodifiableMap(map);
    }

    public ShivaMailException(Throwable reason) {
        this(reason, getSuffix(reason));
    }

    public ShivaMailException(Throwable reason, String suffix) {
        super(buildCode(suffix), reason);
    }

    @Override
    public String[] getCodes() {
        return new String[] {
                getMessage(),
                ERROR_CODE_BASE
        };
    }

    /**
     * No arguments are currently required or supported in this implementation.
     * @return Always a null value.
     */
    @Override
    public Object[] getArguments() {
        return null;
    }

    /**
     * Will always return whatever code is stored in the exception message.
     * @return {@link #getMessage()}.
     */
    @Override
    public String getDefaultMessage() {
        return getMessage();
    }

    protected static String buildCode(String suffix) {
        if (StringUtils.isBlank(suffix)) {
            throw new IllegalArgumentException("Suffix must not be null or blank.");
        }

        return ERROR_CODE_BASE + "." + suffix;
    }

    protected static String getSuffix(Throwable throwable) {
        String suffix = ERROR_SUFFIX_MAP.get(throwable.getClass());
        return suffix == null ? ERROR_SUFFIX_UNKNOWN : suffix;
    }

}
