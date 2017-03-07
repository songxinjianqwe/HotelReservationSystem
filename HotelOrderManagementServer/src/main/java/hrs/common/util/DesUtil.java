package hrs.common.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 * 加密解密工具包
 * 单例模式
 */
public class DesUtil implements Serializable{
	
	/**
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 3564434080477033001L;
	private static volatile DesUtil instance;
	public static DesUtil getInstance(){
		if(instance == null){
			synchronized (DesUtil.class) {
				if(instance == null){
					instance = new DesUtil();
				}
			}
		}
		return instance;
	}
	private DesUtil(){
		
	}
	private static final String ALGORITHM_DES = "DES/CBC/PKCS5Padding";
	private static String key;
	static{
		BufferedReader br = null;
		try {
			br =  new BufferedReader(new InputStreamReader(DesUtil.class.getClassLoader().getResourceAsStream("key.txt")));
			key = br.readLine();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * DES算法，加密
	 *
	 * @param data
	 *            待加密字符串
	 * @param key
	 *            加密私钥，长度不能够小于8位
	 * @return 加密后的字节数组，一般结合Base64编码使用
	 * @throws InvalidAlgorithmParameterException
	 * @throws Exception
	 */
	public String encode(String data) {
		if (data == null)
			return null;
		try {
			DESKeySpec dks = new DESKeySpec(key.getBytes());
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			// key的长度不能够小于8位字节
			Key secretKey = keyFactory.generateSecret(dks);
			Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
			IvParameterSpec iv = new IvParameterSpec("12345678".getBytes());
			AlgorithmParameterSpec paramSpec = iv;
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, paramSpec);
			byte[] bytes = cipher.doFinal(data.getBytes());
			return byte2hex(bytes);
		} catch (Exception e) {
			e.printStackTrace();
			return data;
		}
	}

	/**
	 * DES算法，解密
	 *
	 * @param data
	 *            待解密字符串
	 * @param key
	 *            解密私钥，长度不能够小于8位
	 * @return 解密后的字节数组
	 * @throws Exception
	 *             异常
	 */
	public String decode(String data) {
		if (data == null)
			return null;
		try {
			DESKeySpec dks = new DESKeySpec(key.getBytes());
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			// key的长度不能够小于8位字节
			Key secretKey = keyFactory.generateSecret(dks);
			Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
			IvParameterSpec iv = new IvParameterSpec("12345678".getBytes());
			AlgorithmParameterSpec paramSpec = iv;
			cipher.init(Cipher.DECRYPT_MODE, secretKey, paramSpec);
			return new String(cipher.doFinal(hex2byte(data.getBytes())));
		} catch (Exception e) {
			e.printStackTrace();
			return data;
		}
	}

	/**
	 * 二行制转字符串
	 * 
	 * @param b
	 * @return
	 */
	private String byte2hex(byte[] b) {
		StringBuilder hs = new StringBuilder();
		String stmp;
		for (int n = 0; b != null && n < b.length; n++) {
			stmp = Integer.toHexString(b[n] & 0XFF);
			if (stmp.length() == 1)
				hs.append('0');
			hs.append(stmp);
		}
		return hs.toString().toUpperCase();
	}

	private byte[] hex2byte(byte[] b) {
		if ((b.length % 2) != 0)
			throw new IllegalArgumentException();
		byte[] b2 = new byte[b.length / 2];
		for (int n = 0; n < b.length; n += 2) {
			String item = new String(b, n, 2);
			b2[n / 2] = (byte) Integer.parseInt(item, 16);
		}
		return b2;
	}
	public static void main(String[] args) {
		DesUtil util = DesUtil.getInstance();
		System.out.println(util.decode("BB3FDC628A6D0E98"));
		System.out.println(util.decode("064759957B54D637"));
//		System.out.println(util.decode("747324D30D4BAE90"));
		System.out.println(util.decode("96549445707634D85E8920270D3F0548"));
		System.out.println(util.decode("2FCA6CBD3C63E1F8"));
		System.out.println(util.encode("songxinjian"));
		System.out.println(util.encode("hotelstaff"));
		System.out.println(util.encode("123456"));
		System.out.println(util.encode("admin"));
	}
}
