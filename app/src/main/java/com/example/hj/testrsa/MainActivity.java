package com.example.hj.testrsa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        HashMap<String, Object> map = RSAUtils.getKeys();
        //生成公钥和私钥
        RSAPublicKey publicKey = (RSAPublicKey) map.get("public");
        RSAPrivateKey privateKey = (RSAPrivateKey) map.get("private");

        //模
        String modulus = publicKey.getModulus().toString();
        System.out.println("公钥："+publicKey.getEncoded().toString());
        System.out.println("私钥："+privateKey.getEncoded().toString());
        System.out.println(modulus);
        //公钥指数
        String public_exponent = publicKey.getPublicExponent().toString();
        //私钥指数
        String private_exponent = privateKey.getPrivateExponent().toString();

        System.out.println("公钥指数:"+public_exponent);

        System.out.println("私钥指数:"+private_exponent);


        //明文
        String ming = "123456789 Hello 小笨蛋";
        //使用模和指数生成公钥和私钥
        RSAPublicKey pubKey = RSAUtils.getPublicKey(modulus, public_exponent);
        RSAPrivateKey priKey = RSAUtils.getPrivateKey(modulus, private_exponent);
        //加密后的密文
        String mi = RSAUtils.encryptByPublicKey(ming, pubKey);
        System.out.println("加密后的密文"+mi);
        //解密后的明文
        String mingn = RSAUtils.decryptByPrivateKey(mi, priKey);
        System.out.println("解密后的明文"+mingn);
    }

}
