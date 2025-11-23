package tests.K22_TestNG_Framework.D04_pageClassKullanimi;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.Driver;

public class C01_PageClassKullanimi {

    // 3 farkli test methodu olusturup, asagidaki gorevleri yapin
    // 1- testotomasyonu anasayfaya gidip url'in testotomasyonu icerdigini test edin
    // 2- phone icin arama yapip urun bulunabildigini test edin
    // 3- ilk urunu tiklayip, urun isminde case sensitive olmadan "phone" bulundugunu test edin

    @Test
    public void anasayafaTesti(){
        // 1- testotomasyonu anasayfaya gidip
        Driver.getDriver().get("https://ww.testotomasyonu.com");

        // url'in testotomasyonu icerdigini test edin
        String exoectedUrlIcerik = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(exoectedUrlIcerik));
    }

    @Test
    public void phoneAramaTesti(){
        // 2- phone icin arama yapip
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // urun bulunabildigini test edin
        int actualBulunanUrunSayisi = testotomasyonuPage.bulunanUrunElementleriList.size();

        Assert.assertTrue(actualBulunanUrunSayisi >0);
    }

    @Test(dependsOnMethods = "phoneAramaTesti")
    public void IlkUrunIsimTesti(){
        // 3- ilk urunu tiklayip,
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage
                .bulunanUrunElementleriList
                .get(0)
                .click();

        // urun isminde case sensitive olmadan "phone" bulundugunu test edin
        String expectedIsimIcerik = "phone";
        String actualUrunIsmi = testotomasyonuPage
                .ilkUrunSayfasindakiIsimElementi
                .getText()
                .toLowerCase();

        Assert.assertTrue(actualUrunIsmi.contains(expectedIsimIcerik));
    }




}
