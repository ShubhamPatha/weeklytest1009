package com.geekster.springbootannotation;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class CustomizedMailAuhenticator extends Authenticator
{

    protected PasswordAuthentication getPasswordAuthentication()
    {
        return new PasswordAuthentication(MailMetaData.myUserMail,MailMetaData.password);
    }
}
