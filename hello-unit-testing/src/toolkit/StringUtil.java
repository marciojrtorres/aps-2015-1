package toolkit;

public class StringUtil{

	private static final int DIF_LOWER_UPPER_CASE = 32;
	
	public static String capitalize(String str){
		
		if (str == null)
		 	throw new NullPointerException("String recebida e nula.");
		
		char chars[] = str.toCharArray();
		
		if (chars.length<1) return str;
		
		chars[0] = upCase(chars[0]);
		
		for (int i=1; i<chars.length; i++)
			chars[i] = downCase(chars[i]);
		
		return new String (chars);

	}

	public static char upCase(char c){
		if (isLower(c))
			return (char) (c - DIF_LOWER_UPPER_CASE);
		return c;
	}

	public static char downCase(char c){
		if (isUpper(c))
			return (char) (c + DIF_LOWER_UPPER_CASE);
		return c;
	}

	public static String upCase(String str){
		char[] chars = str.toCharArray();
		for (int i=0; i<chars.length; i++) {
			chars[i] = upCase(chars[i]);
		}
		return new String (chars);
	}

	public static String downCase(String str){
		char[] chars = str.toCharArray();
		for (int i=0; i<chars.length; i++) {
			chars[i] = downCase(chars[i]);
		}
		return new String (chars);

	}

	private static boolean isLower(char caractere){
		return (caractere >= 'a' && caractere <= 'z');
	}

	private static boolean isUpper(char caractere){
		return (caractere >= 'A' && caractere <= 'Z');
	}

	public static String strip (String str, char caractere){
		 
		 if (str == null)
		 	throw new NullPointerException("String recebida e nula.");

		char[] caracteres = str.toCharArray();
		int cont = 0;
		for (int i=0; i<caracteres.length; i++){
			if (caracteres[i]==caractere) cont++;
		}
		char[] strip = new char[caracteres.length-cont];
		for (int i=0, j=0; i<caracteres.length; i++){
			if (caracteres[i]!= caractere){
				strip[j]=caracteres[i];
				j++;
			}
		}
		return new String(strip);
	}

	public static boolean eq(String str1, String str2){
		
		if (str1 == null || str2 == null)
		 	throw new NullPointerException("String recebida e nula.");
		
		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();
		

		if (chars1.length != chars2.length) return false;
		
		if (chars1.length==0) return true;

		for (int i=0; i<chars1.length; i++){
			if (chars1[i] != chars2[i]) return false;
		}

		return true;
	
	}

	public static String trimLeft(String str){
		char[] chars = str.toCharArray();

		if (chars.length==0 || chars.length==1)
			return str;
				
		if (chars[0]!=' ')
			return str;

		int j=0, cont=0; 

		while (chars[j]==' '){
			cont++;
			j++;
		}
		
		char [] trimleft = new char [chars.length-cont];
		for (int l=0, i=cont; i<chars.length; i++, l++)
			trimleft[l] = chars[i];

		return new String(trimleft);
	}

	public static String trimRight(String str){
		char[] chars = str.toCharArray();

		if (chars.length==0 || chars.length==1)
			return str;
				
		if (chars[chars.length-1]!=' ')
			return str;

		int j=chars.length-1, cont=0; 

		while (chars[j]==' '){
			cont++;
			j--;
		}

		char [] trimright = new char [chars.length-cont];
		for (int i=0; i<trimright.length; i++)
			trimright[i] = chars[i];

		return new String(trimright);
	}
	
	
	public static String trim(String str){
		return (trimRight(trimLeft(str)));
	}

	public static String titleize(String str){
		
		String[] strings = split(str, ' ');
		
		for (int i=0; i<strings.length; i++){
			strings[i] = capitalize(strings[i]);
			char [] temp = strings[i].toCharArray();
			temp = concat(temp, ' ');
			strings[i] = new String(temp);
		}
		String titleize = concatString(strings);
		titleize = trim(titleize);
		return titleize;
		
	}

	public static String concatString(String... strs){
		if (strs.length < 2) return strs[0];

		String stringConcat="";
		for (int i=0; i<strs.length; i++) 
			stringConcat = concatString(stringConcat, strs[i]);
		return stringConcat;
	}
	
	public static String concatString(String str1, String str2){
		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();
		char[] stringConcat = new char [chars1.length+chars2.length];
		
		for (int i=0; i<chars1.length; i++) stringConcat[i] = chars1[i];
		
		for (int i=0, j=chars1.length; j<stringConcat.length; i++, j++) stringConcat[j] = chars2[i];

		return new String (stringConcat);

	}

	public static char[] concat (char[] chars, char c){
		char[] concatChar = new char[chars.length+1];
		for (int i=0; i<chars.length; i++) concatChar[i]=chars[i];
		concatChar[chars.length] = c;
		return concatChar;
	}

	public static String[] split (String str, char separator){

		char[] chars = str.toCharArray();
		chars = concat(chars, ' ');
		int cont = 0;

		// for (char i: chars)
		// 	System.out.println(i);
		
		for (char i: chars)
			if (i==' ')
				cont++;
		
		int [] positionSep = new int[cont];
		
		int j=0;
		for (int i=0; i<chars.length; i++)
			if (chars[i]==' '){
				positionSep[j]=i;
				j++;
			}

		int[] inicio = new int[cont];
		inicio[0] = 0;
		j=1;
		for (int i=0; i<cont-1; i++){ 
			inicio[j] = positionSep[i]+1;
			j++;
		}
		
		String[] strings = new String[cont];
	
		int index=0, l=0;

		while (index < strings.length){
			strings[index] = getString(str, inicio[l], positionSep[l]);		
			l++;
			index ++;
		}
		
		return strings;			
	}

	public static String getString (String str, int inicio, int fim){
		char[] chars = str.toCharArray();
		char[] string = new char[fim-inicio];

		for (int j=0, i=inicio; i<fim; i++, j++)
			string[j]=chars[i];
		return new String (string);
	}

	
	public static String inverteString(String str){
		char[] chars = str.toCharArray();
		char[] invertido = new char[chars.length];
		for (int i=0, j=chars.length-1; i<chars.length; i++, j--) invertido[i] = chars[j];
		return new String (invertido);	
	}


	

}
