package test;

import generic.BaseTest;

public class ReceiptPosting_Test extends BaseTest {

	
	
/*	public String receiptPostByReceivables(String receiptTypeName,Date date) 
	
	{
		double receivableBalance = 0;
		String batchAmount = null; 
		int i=0;
		Date gridDate = null;
		DateFormat format= new SimpleDateFormat("mm/dd/yyyy");
		
		do {
			try {
				gridDate=format.parse(driver.findElement(By.id("ctl00xFCxPHxgrdPaymentxgrdList_rc_"+i+"_7")).getText().toString());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String dollarValue=driver.findElement(By.id("ctl00xFCxPHxgrdPaymentxgrdList_rc_"+i+"_11")).getAttribute("uv").toString();

			double amount=Double.parseDouble(dollarValue);
			receivableBalance=receivableBalance+amount;
			driver.findElement(By.id("ctl00xFCxPHxgrdPaymentxgrdList_rc_"+i+"_0")).click();
			i++;
		}while(gridDate.before(date));

		if(receivableBalance!=0) {
			batchAmount=Double.toString(receivableBalance);
			selectReceiptType(receiptTypeName, receiptType);
			dynBatchName=createBatch(receiptTypeName,batchAmount );
			checkAmount.sendKeys(batchAmount);
			distributeBtn.click();
			postBtn.click();
			try {
				driver.switchTo().alert().accept();
			}catch(Exception e) {
				e.getMessage();

			}
			return dynBatchName;

		} else {
			closeBtn.click();
			return  "No due receivable exist till due date:"+ date;
		}


	}
	
	*/
	
	
	
	
	
	
}
