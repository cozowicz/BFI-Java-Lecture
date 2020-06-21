package Bsp05a;

public class URLZerlegen
{
  public static void main(String[] args)
  {
    // Beispiel http://www.orf.at:8080/content/aktuell/news.html soll in
    // http, www.orf.at, 8080, /content/aktuell/news.html und news.html zerlegt

    String url = "http://www.orf.at:8080/content/aktuell/news.html";

    // http
    int colonPos = url.indexOf("://");
    if(colonPos == -1) {
      System.out.println("Could not find protocol");
      return;
    }
    String protocol = url.substring(0, colonPos);

    String port = null;

    // host
    String host = null;

    int secondColonPos = url.indexOf(":", colonPos+3); // skip ://
    int slashPos;
    if(secondColonPos == -1) {
      slashPos = url.indexOf("/", colonPos+3); // skip ://
      if(slashPos == -1) {
        host = url.substring(colonPos + 3);
      }
      else {
        host = url.substring(colonPos + 3, slashPos);
      }
    }
    else { // : found, lets look for port
      slashPos = url.indexOf("/", secondColonPos);
      if(slashPos == -1) { // '/' not found
        if(secondColonPos != url.length()) { // something left before the end
          port = url.substring(secondColonPos);
        }
        slashPos = url.length();
      }
      else { // found '/'
        port = url.substring(secondColonPos+1, slashPos);
      }
      host = url.substring(colonPos + 3, secondColonPos);
    }

    String path = null;
    String file = null;

    int lastSlashPos = url.lastIndexOf("/"); // searches backward
    if(lastSlashPos > slashPos) {
      path = url.substring(slashPos); // , lastSlashPos+1
      file = url.substring(lastSlashPos+1);
    }

    System.out.println(protocol + ", " + host + ", " + port + ", " + path + ", " + file);
  }
}
