package com.geekster.springbootannotation;



import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailHandler {

    public void sendMail(String s)
    {
        Properties sysProperties = System.getProperties();
        System.out.println(sysProperties);
        sysProperties.put("mail.smtp.host",MailMetaData.HostServer);
        sysProperties.put("mail.smtp.port",MailMetaData.port);
        sysProperties.put(MailMetaData.sslProperty,"true");
        sysProperties.put(MailMetaData.authPerm,"true");


        Authenticator mailAuhenticator =new CustomizedMailAuhenticator();
        Session mailSession= Session.getInstance(sysProperties,mailAuhenticator);

        //Message
        MimeMessage mailMessage =new MimeMessage(mailSession);
        try{
            mailMessage.setFrom(MailMetaData.myUserMail);
            mailMessage.setText(s);
            mailMessage.setText("Lost host server has been hit ");
            Address receiverEmail =new InternetAddress(MailMetaData.receiverMail);
            mailMessage.setRecipients(Message.RecipientType.TO, String.valueOf(receiverEmail));
            Transport.send(mailMessage);
        }catch(Exception mailExcepion)
        {
            System.out.println(mailExcepion.toString());
        }


    }



}

