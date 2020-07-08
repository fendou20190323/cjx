/**
 * @Project:     lssplatform
 * @Title:       CryptoUtil.java
 */
package com.lss.common.util;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName:  CryptoUtil
 * @Description: 加解密工具类
 * <p>AES密钥的长度支持128位、192位、256位（192和256需替换local_policy.jar和US_export_policy.jar）</p>
 * @Author:        wangyg
 * @Version        1.0.0
 */
public class CryptoUtil {
    public static final int BUFFER_SIZE = 4096*4;
    
    /**
     * 使用AES加密
     * @param plaintext 明文
     * @param password 密码
     * @return 密文
     * @throws NoSuchPaddingException 
     * @throws NoSuchAlgorithmException 
     * @throws BadPaddingException 
     * @throws IllegalBlockSizeException 
     * @throws InvalidKeyException 
     */
    public static byte[] encryptAes(final byte[] plaintext,final byte[] password) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException{
        Cipher cipher=Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(password,"AES"));
        return cipher.doFinal(plaintext);
    }

    /**
     * 使用AES解密
     * @param ciphertext 密文
     * @param password 密码
     * @return 明文
     * @throws NoSuchPaddingException 
     * @throws NoSuchAlgorithmException 
     * @throws BadPaddingException 
     * @throws IllegalBlockSizeException 
     * @throws InvalidKeyException  
     */
    public static byte[] decryptAes(final byte[] ciphertext,final byte[] password) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException{
        Cipher cipher=Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(password,"AES"));
        return cipher.doFinal(ciphertext);
    }
    
    /**
     * 使用AES加密文件
     * @param plainFile 明文文件
     * @param cipherFile 密文文件
     * @param password 密码
     * @throws FileNotFoundException
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     */
    public static void encryptFileAes(final File plainFile,final File cipherFile,final byte[] password) throws FileNotFoundException, IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException{
        try(FileInputStream is= new FileInputStream(plainFile);
                FileOutputStream os = new FileOutputStream(cipherFile);){
            encryptStreamAes(is,os,password);
        }
    }
    
    /**
     * 使用AES加密流
     * @param is 输入流
     * @param os 输出流
     * @param password 密码
     * @throws FileNotFoundException
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     */
    public static void encryptStreamAes(final InputStream is,final OutputStream os,final byte[] password) throws FileNotFoundException, IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException{
        int length=0;
        byte[] buffer=new byte[BUFFER_SIZE];
        Cipher cipher=Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(password,"AES"));
        try(CipherOutputStream cos=new CipherOutputStream(os,cipher)){
            while((length=is.read(buffer))>0){
                cos.write(buffer,0,length);
            }
            cos.flush();
        }
    }    
    
    /**
     * 使用AES解密文件
     * @param cipherFile 密文文件
     * @param plainFile 明文文件
     * @param password 密码
     * @throws FileNotFoundException
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     */
    public static void decryptFileAes(final File cipherFile,final File plainFile,final byte[] password) throws FileNotFoundException, IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException{
        try(FileInputStream is= new FileInputStream(cipherFile);
                FileOutputStream os = new FileOutputStream(plainFile);){
            decryptStreamAes(is,os,password);
        }
    }
    
    /**
     * 使用AES解密流
     * @param is 输入流
     * @param os 输出流
     * @param password 密码
     * @throws FileNotFoundException
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     */
    public static void decryptStreamAes(final InputStream is,final OutputStream os,final byte[] password) throws FileNotFoundException, IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException{
        int length=0;
        byte[] buffer=new byte[BUFFER_SIZE];
        Cipher cipher=Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(password,"AES"));
        try(CipherOutputStream cos=new CipherOutputStream(os,cipher)){
            while((length=is.read(buffer))>0){
                cos.write(buffer,0,length);
            }
            cos.flush();
        }
    }    
    
    /**
     * 获取字符串的MD5消息摘要
     * @param input 字符串
     * @return 十六进制的消息摘要字符串
     * @throws NoSuchAlgorithmException
     */ 
    public static String getStringMd5(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        return ConvertUtil.bytes2HexString(CryptoUtil.getMessageDigest(input.getBytes("UTF-8"),"MD5"));
    }
    
    /**
     * 获取文件的MD5消息摘要
     * @param file 文件名
     * @return 十六进制的消息摘要字符串
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */ 
    public static String getFileMd5(File file) throws NoSuchAlgorithmException, IOException{
        return ConvertUtil.bytes2HexString(CryptoUtil.getMessageDigest(file,"MD5"));
    }
    
    /**
     * 获取字符串的SHA-256消息摘要
     * @param input 字符串
     * @return 十六进制的消息摘要字符串
     * @throws NoSuchAlgorithmException
     */ 
    public static String getStringSha256(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        return ConvertUtil.bytes2HexString(CryptoUtil.getMessageDigest(input.getBytes("UTF-8"),"SHA-256"));
    }
    
    /**
     * 获取文件的SHA-256消息摘要
     * @param file 文件名
     * @return 十六进制的消息摘要字符串
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */ 
    public static String getFileSha256(File file) throws NoSuchAlgorithmException, IOException{
        return ConvertUtil.bytes2HexString(CryptoUtil.getMessageDigest(file,"SHA-256"));
    }
    
    /**
     * 获取字符串的SHA-512消息摘要
     * @param input 字符串
     * @return 十六进制的消息摘要字符串
     * @throws NoSuchAlgorithmException
     */ 
    public static String getStringSha512(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        return ConvertUtil.bytes2HexString(CryptoUtil.getMessageDigest(input.getBytes("UTF-8"),"SHA-512"));
    }
    
    /**
     * 获取文件的SHA-512消息摘要
     * @param file 文件名
     * @return 十六进制的消息摘要字符串
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */ 
    public static String getFileSha512(File file) throws NoSuchAlgorithmException, IOException{
        return ConvertUtil.bytes2HexString(CryptoUtil.getMessageDigest(file,"SHA-512"));
    }
    
    /**
     * 获取消息字节流的消息摘要
     * @param input 输入字节数组
     * @param algorithm 摘要算法（MD2、MD5、SHA-1、SHA-224、SHA-256、SHA-384、SHA-512）
     * @return 消息摘要
     * @throws NoSuchAlgorithmException
     */
    public static byte[] getMessageDigest(byte[] input,String algorithm) throws NoSuchAlgorithmException{
        return MessageDigest.getInstance(algorithm).digest(input);
    }
    
    /**
     * 获取文件的消息摘要
     * @param file 文件名
     * @param algorithm 摘要算法（MD2、MD5、SHA-1、SHA-224、SHA-256、SHA-384、SHA-512）
     * @return 消息摘要
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public static byte[] getMessageDigest(File file,String algorithm) throws NoSuchAlgorithmException, IOException{
        try(FileInputStream fis = new FileInputStream(file)){
            return getMessageDigest(fis,algorithm);
        }
    }
    /**
     * 获取文件的消息摘要
     * @param is 输入流
     * @param algorithm 摘要算法（MD2、MD5、SHA-1、SHA-224、SHA-256、SHA-384、SHA-512）
     * @return 消息摘要
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public static byte[] getMessageDigest(InputStream is,String algorithm) throws NoSuchAlgorithmException, IOException{
        int length = 0;
        byte[] buffer = new byte[BUFFER_SIZE];
        
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        while ((length = is.read(buffer)) != -1) {
            messageDigest.update(buffer, 0, length);
        }
        return messageDigest.digest();
    }
    

    public static void main(String[] args) throws Exception{
        String plaintext = "abcde12345中国",filename = "E:/test.PNG",password="0123456789ABCDEF";
        
        long now = System.currentTimeMillis();
        System.out.println("plaintText=               "+plaintext);
        byte[] ciphertext=CryptoUtil.encryptAes(plaintext.getBytes(), password.getBytes());
        System.out.println("Hex.encodeHex="+String.valueOf(Hex.encodeHex(ciphertext)));
        System.out.println("ciphertextHexString="+ConvertUtil.bytes2HexString(ciphertext));
        String plaintext1=new String(CryptoUtil.decryptAes(ciphertext, password.getBytes()));
        System.out.println("decryptedText=         "+plaintext1);
        
        CryptoUtil.encryptFileAes(new File("E:/test.PNG"), new File("E:/test_EncByJava.PNG"), password.getBytes());
        CryptoUtil.decryptFileAes(new File("E:/test_EncByJava.PNG"), new File("E:/test_DecByJavaFromJava.PNG"), password.getBytes());
        if(new File("E:/test_EncByC#.PNG").exists()){
            CryptoUtil.decryptFileAes(new File("E:/test_EncByC#.PNG"), new File("E:/test_DecByJavaFromC#.PNG"), password.getBytes());
        }
        
        System.out.println("StringMd5="+CryptoUtil.getStringMd5(plaintext));
        System.out.println("FileMd5=    "+CryptoUtil.getFileMd5(new File(filename)));
        
        System.out.println("StringSHA-256="+CryptoUtil.getStringSha256(plaintext));
        System.out.println("FileSHA-256=    "+CryptoUtil.getFileSha256(new File(filename)));
        System.out.println("StringSHA-512="+CryptoUtil.getStringSha512(plaintext));
        System.out.println("FileSHA-512=    "+CryptoUtil.getFileSha512(new File(filename)));

        System.out.println(System.currentTimeMillis()-now);
    }
}
