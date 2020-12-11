import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class automation_training {

    @Before
    public void chooseCherry() {
        open("http://l2on.net/");
        $(By.cssSelector("option[value$=\"3054\"]")).click();
        //   sleep(60000);
        //   ElementsCollection weeklyChanges = $$("table.values tr th");
    }

    @Test
    public void peopleTab() {
        //open("http://l2on.net/?c=userdata");

        $(By.xpath("//table[@class='main-menu']//td[a='Люди']")).click();
        $(By.xpath("//h1[contains(text(),'Персонажи')]//a[contains(text(),'статистика')]")).click();
        List<SelenideElement> list = $$(By.xpath("//a[contains(text(),'Статистика по серверу Cherry')]"));
        Assert.assertTrue("Статистика по серверу Cherry не найдена :(", list.size() > 0);
        $(By.xpath("//td[a='Владыка Теней']")).click();
        // Assert.assertTrue($(By.xpath("//h1[contains(text(),'Статистика по серверу Cherry')]")).exists());
        // Assert.assertTrue($(By.xpath("//h1[contains(text(),'Статистика по серверу Cherry')]")).text().equals("Статистика по серверу Cherry"));
        sleep(60000);
        //   ElementsCollection weeklyChanges = $$("table.values tr th");
    }

    @Test
    public void returnFreshProductFromMarket() {
        $(By.xpath("//table[@class='main-menu']//td[a='Рынок']")).click();
        String productName = "Свиток: Модифицировать Оружие Ранга A";

        $(By.xpath("//td[contains(text(),'Название:')]//following-sibling::td/input")).setValue(productName).pressEnter();
        // $(By.xpath("//input[@type='submit' and @value='Показать']")).click();
        $(By.xpath("//span[@class='l2item']/a[text()='"+productName+"']")).click();
        ElementsCollection sellFreshProducts = $$(By.xpath("//div[@id='group_sell']//tr[contains(@class,'fresh')]//td[contains(@class,'right')]"));
        ElementsCollection buyFreshProducts = $$(By.xpath("//div[@id='group_buy']//tr[contains(@class,'fresh')]"));
        List lowerPrice = sellFreshProducts.texts();
        HashMap<String, String> twoValuesList = new HashMap<String, String>();
/*        for (int i = 0; i < lowerPrice.size(); i=i+2){
            twoValuesList.put(lowerPrice.get(i).toString(),lowerPrice.get(i+1).toString());
        }
*/

        System.out.println(twoValuesList);
        sleep(60000);
    }
}

//http://l2on.net/?c=userdata