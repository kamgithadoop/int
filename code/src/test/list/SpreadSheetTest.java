package list;

import list.SpreadSheet;

import org.junit.Test;

public class SpreadSheetTest {

	@Test
	public void speardSheet(){
		SpreadSheet<String> sheet = new SpreadSheet<String>();
		sheet.addFirstRow(new String[]{"1","2","3","4","5"});
		sheet.addFirstRow(new String[]{"11","22","33","44","55"});
		sheet.addLastRow(new String[]{"111","222","333","444","555"});
		sheet.addLastRow(new String[]{"1111","2222","3333","4444","5555"});
		sheet.addFirstRow(new String[]{"-1","-2","-3","-4","-5"});
		sheet.display();
	}
}
