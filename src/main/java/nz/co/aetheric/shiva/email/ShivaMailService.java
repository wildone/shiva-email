package nz.co.aetheric.shiva.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.mail.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Locale;

/**
 * This is the primary implementation of the {@link ShivaMail} service interface.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
 */
@Service
public class ShivaMailService implements ShivaMail {
    private static final Logger logger = LoggerFactory.getLogger(ShivaMailService.class);
}
