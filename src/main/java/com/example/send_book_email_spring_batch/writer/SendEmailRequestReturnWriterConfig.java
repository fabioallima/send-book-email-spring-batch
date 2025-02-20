package com.example.send_book_email_spring_batch.writer;

import com.example.send_book_email_spring_batch.entities.UserBookLoan;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SendEmailRequestReturnWriterConfig {

    private static final Logger LOG = LoggerFactory.getLogger(SendEmailRequestReturnWriterConfig.class);

    @Autowired
    private SendGrid sendGrid;

    @Bean
    public ItemWriter<Mail> sendEmailRequestReturnWriter() {
        return items -> {
            //items.forEach(System.out::println);
            items.forEach((item) -> sendEmail(item));
        };
    }

    private void sendEmail(Mail email) {
        LOG.info("Sending mail");
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(email.build());
            LOG.info("[WRITER STEP] Send email to: " + email.build());
            Response response = sendGrid.api(request);
            if (response.getStatusCode() >= 400 && response.getStatusCode() <= 500) {
                LOG.error("Error sending email: " + response.getBody());
                throw new Exception(response.getBody());
            }
            LOG.info("Email sent! Status = " + response.getStatusCode());
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
