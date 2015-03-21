package toolkit;

public class StringUtil {

  public static String strip(String string, char caractere) {
    // refatoração: renomear chars para caracteres
    // considerar testes para facilitar refatoração
    if (string == null) {
      throw new NullPointerException("recebida string nula");
      //return null;
    }

    char[] caracteres = string.toCharArray();
    int cont = 0;
    for (int i = 0; i < caracteres.length; i++) {
      if (caracteres[i] == caractere) {
        cont++;
      }
    }
    char[] strip = new char[caracteres.length - cont];
    for (int i = 0, j = 0; i < caracteres.length; i++) {
      if (caracteres[i] != caractere) {
        strip[j] = caracteres[i];
        j++;
      }
    }
    return new String(strip);
  }

  public static boolean eq(String str1, String str2) {
    char[] chars1 = str1.toCharArray();
    char[] chars2 = str2.toCharArray();
    // técnica: return early (retornar cedo)
    if (chars1.length != chars2.length) {
      return false;
    }

    for (int i = 0; i < chars1.length; i++) {
      if (chars1[i] != chars2[i]) {
        return false;
      }
    }

    return true;
  }
  // refatorações documentadas
  // renomear
  // extrair método (introduzir método)
  public static String upcase(String string) {

    char[] chars = string.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (isLower(chars[i])) { // numeros mágicos
        chars[i] = (char) (chars[i] - 32);
      }
    }
    return new String(chars);
  }

  private static boolean isLower(char c) {
    return c >= 97 && c <= 122;
  }

  public static String downcase(String string) {
    char[] chars = string.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (isUpper(chars[i])) { // numeros mágicos
        chars[i] = (char) (chars[i] + 32);
      }
    }
    return new String(chars);
  }

  private static boolean isUpper(char c) {
    return c >= 65 && c <= 90;
  }

  public static String capitalize(String string) {
    // BUG lidar com string vazia
    char[] chars = downcase(string).toCharArray();
    if (isLower(chars[0])) {
      chars[0] = (char) (chars[0] - 32);
    }
    return new String(chars);
  }

  public static void main(String[] args) {
    System.out.println(StringUtil.eq("abc", "abc") == true);
    System.out.println(StringUtil.eq("abc", "abc ") == false);
    System.out.println(StringUtil.eq("xyz", "qqq") == false);
    System.out.println(StringUtil.eq("xyzmno", "") == false);
    System.out.println(StringUtil.eq("", "") == true);
    /*
    System.out.println(StringUtil.eq("txt", null) == false);
    System.out.println(StringUtil.eq(null, "txt") == false);
    System.out.println(StringUtil.eq(null, null) == false); // true/false/NullPointerException
    */
  }
}