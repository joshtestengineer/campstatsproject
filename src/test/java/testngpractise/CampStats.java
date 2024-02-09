package testngpractise;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CampStats {

	@Parameters({"emailid","password"})
	@Test
	public void audienceCount(String emailid, String password) throws InterruptedException, IOException {

		//ChromeDriverService service = new ChromeDriverService.Builder().withLogOutput(System.out).build();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://campstats8x.resulticks.com/BlastStatus/Index");
		driver.findElement(By.name("UserName")).sendKeys(emailid);
		driver.findElement(By.name("Password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//i[@class=\"glyp-icon-campaign\"]")).click();

		driver.findElement(By.xpath("//a[@href=\"/BlastStatus/Index\"]")).click();
		driver.findElement(By.id("ActualTenantName")).click();
		driver.findElement(By.id("camp_00b4e220_6121_4a93_a63f_d0848bd73506")).click();
		driver.findElement(By.id("autoFilterSearch")).sendKeys("229518");
		driver.findElement(By.xpath("//i[@class=\"icon-search-small icon-xs adv-search-icon\"]")).click();
		//driver.findElement(By.xpath("//body/section[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[3]/ul[1]/li[1]/a[1]/i[1]")).click();
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "Resulticks Campaign Statuses";

		if (actualTitle.equalsIgnoreCase(expectedTitle))
			System.out.println("Title Matched");

		else
			System.out.println("Title didn't match");

		Thread.sleep(10000);
		String count = driver.findElement(By.xpath("(//td[@role='gridcell'])[position()=10]")).getText();

		System.out.println("Total Blast count is " + count);

		String table = driver.findElement(By.xpath("//font[contains(text(),'Report Info(Campaign)')]")).getText();
		System.out.println(table);
		String head1 = driver.findElement(By.className("k-header")).getText();
		System.out.println(head1);
		String head2 = driver.findElement(By.xpath("//body[1]/section[1]/div[1]/div[1]/div[6]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/td[2]/div[2]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[4]/table[1]/thead[1]/tr[1]/th[2]/span[1]")).getText();
		System.out.println(head2+ "is");


		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.body.style.zoom='80.0%'");

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("Screenshots/screenshot2.png"));

		/*
		 * String query = "select CampaignID,JobID,
		 * sum(AudienceCount),sum(AudienceSentCount),sum(AudienceFailureCount),sum(
		 * AudienceSentCount) +sum(AudienceFailureCount) as
		 * BlastAudience,sum(AudienceCount) - (sum(AudienceSentCount)
		 * +sum(AudienceFailureCount)) as
		 * NotBlastedAudienceCount,ServerIP,JobType,CreatedDate,max(ModifiedDate),
		 * splitType,JobStatus,TransferStatus from (select
		 * CampaignID,JobID,AudienceCount,AudienceSentCount,AudienceFailureCount,
		 * ServerIP,JobType,CreatedDate,ModifiedDate,splitType,JobStatus,TransferStatus\
		 * r\n" + "from CampaignBlastFileSync where JobID in (17441) group by FileName)
		 * a group by a.JobID,a.splitType";
		 */

	}

}
