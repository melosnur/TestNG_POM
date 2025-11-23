package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TestotomasyonuPage {

    @FindBy(id ="global-search")
    public WebElement aramaKutusu;

    @FindBy(xpath = "//*[@*='prod-img']")
    public List<WebElement> bulunanUrunElementleriList;

    @FindBy(xpath = "//div[@class=' heading-sm mb-4']")
    public WebElement ilkUrunSayfasindakiIsimElementi;



}
