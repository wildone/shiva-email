package nz.co.aetheric.shiva.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * This class aggregates all the configuration information needed for running Shiva mail.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
 */
@Service
public class ShivaMailConfig {
    private static final Logger logger = LoggerFactory.getLogger(ShivaMailConfig.class);

    @Value("${shiva.mail.sender}")
    String mailSender;

    @Value("${shiva.mail.copyto:}")
    String copyRecipient;

    public String getMailSender() {
        return mailSender;
    }

    public String getCopyRecipient() {
        return copyRecipient;
    }

}
