package net.itca.dwm.core;

/**
 * Class for creating the correct text to database structure (removing carriage returns with // and back)
 * @author Dylan
 *
 */
public class TextEncoder
{

	public TextEncoder()
	{
		
	}
	
	public String encode(String toEncode)
	{
		String encoded = toEncode.replaceAll("[\n\r]", "~");
		return encoded;
	}
	
	public String decode(String toDecode)
	{
		String decode = toDecode.replaceAll("[~]", "\n");
		return decode;
	}
}
