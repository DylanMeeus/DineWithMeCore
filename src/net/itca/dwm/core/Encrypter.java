package net.itca.dwm.core;

import java.security.MessageDigest;

/**
 * Class to support encryption for sensitive data
 * @author Dylan
 *
 */
public class Encrypter
{
	/**
	 */
	public Encrypter()
	{

	}
	

	/**
	 * SHA-1 encryption.
	 * 
	 * @param toEncrypt
	 * @return
	 */
	public String encrypt(String toEncrypt)
	{
		MessageDigest messageDigest;
		try
		{
			messageDigest = MessageDigest.getInstance("SHA-1");
			byte[] encoded = messageDigest.digest(toEncrypt.getBytes());
			return byteArrayToHexString(encoded);
		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally
		{
			messageDigest = null;
		}

		return "";
	}

	/**
	 * Convert to HEX string (base 16)
	 * 
	 * @param b
	 * @return
	 */
	private String byteArrayToHexString(byte[] b)
	{
		String result = "";
		for (int i = 0; i < b.length; i++)
		{
			result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
		}
		return result;
	}
}
