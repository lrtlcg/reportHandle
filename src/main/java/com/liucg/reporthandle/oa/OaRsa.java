package com.liucg.reporthandle.oa;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class OaRsa {
    /**
     * @originalText  被加密内容
     * @publicKeyBase64 公钥
     * 通过spk(第一步传回)对secret（第一步传回）进行RSA加密后的密文
     * @return
     */
    public static String getSecret(String originalText, String publicKeyBase64) throws Exception{
//         String originalText = "93f0c249-0b3c-441a-90fd-91569cb1befc";
        // 将公钥和私钥的Base64编码字符串转换为PublicKey和PrivateKey对象
//         String publicKeyBase64 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCBoZ0EssJw6Xu1LCawzH8aP5HRF1IfcKWV1cham2aM7IePqDrtWBsRtP38Ujb7pMcLeMAczks9/eAN5eRaP3EfhmJ46JnEglivKPp/Kt+JedYH2mInZyrhZPvi49YokPm7iVcionBLF9+/4+pnbeMVhrKkhLVFC+eDPCy0xAE9vQIDAQAB";

        PublicKey publicKey = KeyFactory.getInstance("RSA")
                .generatePublic(new X509EncodedKeySpec(Base64.getDecoder().decode(publicKeyBase64)));

        // 使用公钥加密数据
        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = encryptCipher.doFinal(originalText.getBytes());

        // 使用私钥解密数据
        Cipher decryptCipher = Cipher.getInstance("RSA");

//        System.out.println("加密后的数据: " + Base64.getEncoder().encodeToString(encryptedBytes));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
}
