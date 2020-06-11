package com.lxchannel.api.util;

import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

/**
 * 使用AES算法的加密工具类
 *
 * @author: zeki
 * @date: 2019/07/31 15:36
 **/
public class AESUtil {

    /**
     * @param content  需要加密的字符串
     * @param password 加密密钥，必须为长度32的字符串（请使用partner_key）
     * @return 加密字符串
     */
    public static String stringEncrypt(String content, String password) {
        byte[] encryptByteData = encrypt(content, password);
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(encryptByteData);
    }

    /**
     * 基于password生成密钥加密
     *
     * @param content  需要加密的内容
     * @param password 加密密码，用于作为密钥的seed
     * @return AES 加密后的2进制字节码
     */
    public static byte[] encrypt(String content, String password) {
        try {
            // 生成密钥
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(password.getBytes());
            keyGen.init(128, secureRandom);
            SecretKey secretKey = keyGen.generateKey();
            // 创建密码器
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            byte[] byteContent = content.getBytes(StandardCharsets.UTF_8);
            // 初始化
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            // 加密
            return cipher.doFinal(byteContent);
        } catch (Exception e) {
            System.out.println("加密错误：" + e);
        }
        return null;
    }

}