package utilities;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class ReusableMethod {


    public static void bekle(int saniye){

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            System.out.println("Thread.sleep komutu calismadi");
        }
    }

    public static void titleIleWindowGecisYap(WebDriver driver ,  String hedefWindowunTitle){
        // 1- acik olan tum window'larin WHD'lerini alip kaydedelim

        Set<String> acikWindowlarinWhdleri = driver.getWindowHandles();

        for (String eachWhd : acikWindowlarinWhdleri){

            driver.switchTo().window(eachWhd);
            // gectigimiz window'un title'ini alip
            // gecmek istedigimiz window'un title'ina esit mi diye kontrol edelim

            if (driver.getTitle().equals(hedefWindowunTitle)){
                //dogru window'dayiz demektir, burada kalabiliriz
                break;
            }
        }
    }

    public static void UrlIleWindowGecisYap(WebDriver driver, String hedefUrl){
        Set<String> acikTumWindowsWhdSeti = driver.getWindowHandles();

        for (String eachWhd:acikTumWindowsWhdSeti){
            driver.switchTo().window(eachWhd);

            if (driver.getCurrentUrl().equals(hedefUrl)){
                // actual url, hedef url'e esit ise
                // dogru yerdeyiz demektir, orada kalalim
                break;
            }
        }



    }




}
