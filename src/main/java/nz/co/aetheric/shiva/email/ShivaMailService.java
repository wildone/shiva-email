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

    @Resource
    protected MailSender mailSender;

    @Resource
    protected MessageSource mailMessages;

    @Resource
    protected ShivaMailConfig config;

    @Override
    public void sendMail(String code, Collection<String> recipients) throws ShivaMailException {
        sendMail(new ShivaMailPacket(code, recipients));
    }

    @Override
    public void sendMail(String code, Locale locale, Collection<String> recipients) throws ShivaMailException {
        sendMail(new ShivaMailPacket(code, locale, recipients));
    }

    @Override
    public void sendMail(ShivaMailPacket packet) throws ShivaMailException {
        try {
            sendMessage(transform(packet));
        } catch (MailException ex) {
            throw new ShivaMailException(ex);
        }
    }

    protected void sendMessage(SimpleMailMessage message) throws MailException {
        mailSender.send(message);
    }

    protected SimpleMailMessage transform(ShivaMailPacket packet) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(getSender());
        message.setCc(getCopyTo());

        message.setSubject(getSubject(packet));
        message.setTo(getRecipients(packet));
        message.setText(getMessage(packet));

        return message;
    }

    protected String getSender() {
        return config.getMailSender();
    }

    protected String getCopyTo() {
        return config.getCopyRecipient();
    }

    protected String getSubject(ShivaMailPacket packet) {
        return mailMessages.getMessage(packet.getSubject(), packet.getLocale());
    }

    protected String getMessage(ShivaMailPacket packet) {
        String template = mailMessages.getMessage(packet.getMessage(), packet.getLocale());

        //! transform message using velocity and botocss;

        return template;
    }

    protected String[] getRecipients(ShivaMailPacket packet) {
        Collection<String> recipients = packet.getRecipients();
        return recipients.toArray(new String[recipients.size()]);
    }

}
