package com.ksimeo.arsu.admin.helpers;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;

/**
 * Created by @author Ksimeo on 29.03.2016 at 18:28. For project: marsexpress-space.
 */
public class PasswCoder {
    public static String String2Hash(String str)
            throws NoSuchProviderException, NoSuchAlgorithmException {
        Security.addProvider(new BouncyCastleProvider());
        MessageDigest mda = MessageDigest.getInstance("SHA-512", "BC");
        return new String(Base64.encode(mda.digest(str.getBytes())));
    }
}
