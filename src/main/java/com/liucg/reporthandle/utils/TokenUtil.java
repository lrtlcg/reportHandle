package com.liucg.reporthandle.utils;

import com.liucg.reporthandle.sys.entity.User;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Date;
import java.util.Objects;
@Slf4j
@Component
public class TokenUtil {
    /**
     * 创建秘钥
     */
    private static final byte[] SECRET = "qngChengBoYa-realtimeWuIngWangJiaQiZhangYv".getBytes();
    @Resource
    RedisUtils redisUtil;

    /**
     * 生成token
     *
     * @param user
     * @return {@link String}
     */
    public String buildToken(User user) {

        try {
            /**
             * 1.创建一个32-byte的密匙
             */
            MACSigner macSigner = new MACSigner(SECRET);
            /**
             * 2. 建立payload 载体
             */
            JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                    .subject("login")
                    .claim("ACCOUNT", user.getuName())
                    .issueTime(new Date())
                    .build();

            /**
             * 3. 建立签名
             */
            SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
            signedJWT.sign(macSigner);

            /**
             * 4. 生成token
             */
            String token = signedJWT.serialize();
            redisUtil.set(user.getuName(), token, 600L); //存600s
            return token;
        } catch (KeyLengthException e) {
            log.error("创建token错误"+e);
            e.printStackTrace();
        } catch (JOSEException e) {
            log.error("创建token错误"+e);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 检验token
     *
     * @param token
     * @return
     */
    public boolean verifyToken(String token) {

        try {
            SignedJWT jwt = SignedJWT.parse(token);
            JWSVerifier verifier = new MACVerifier(SECRET);

            /**
             * 校验是否有效
             */
            if (!jwt.verify(verifier)) {
                return false;
            }
            /**
             * 获取载体中的数据
             */
            String account = (String) jwt.getJWTClaimsSet().getClaim("ACCOUNT");
            //是否有
            if (Objects.isNull(account)) {
                return false;
            }
            /**
             * 判断redis里是否有account为key的值，如果有
             * 判断token是否和redis里存的是是否一样，
             * 如果不一样说明已经有其他账号登录了，则回到登录页面
             * 如果一样，则给token续期
             */
            if (redisUtil.exists(account)) {
                String s = redisUtil.get(account);
                if (s.equals(token)) {
                    redisUtil.set(account, token, 600L);
                    return true;
                }
//                throw new ServiceException("422","有其他设备登录");
//                log.info("422,有其他设备登录");
            }
        } catch (ParseException e) {
            log.error("token解析失败"+e);
            e.printStackTrace();
        } catch (JOSEException e) {
            log.error("token解析失败"+e);
            e.printStackTrace();
        }
        return false;
    }
}