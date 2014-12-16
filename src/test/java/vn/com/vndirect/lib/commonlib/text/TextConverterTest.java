package vn.com.vndirect.lib.commonlib.text;

import org.junit.Assert;
import org.junit.Test;

public class TextConverterTest {
	
	@Test
	public void testUtfToAcsiiSimple(){
		String utf = "a ă â ô ư ơ đ ợ ố ê ế A Ă Â Ô Ư Ơ Đ Ợ Ố Ê Ê";
		
		String expected = "a a a o u o d o o e e A A A O U O D O O E E";
		
		Assert.assertEquals(expected, TextConverter.utfToAcsii(utf));
	}

	@Test
	public void testUtfToAcsii() {
		String utf = "Anh ơi, em đang ở trường, anh đến nhanh nha, muộn lắm rồi, ah... "
				+ "mà nhà em hết báo rồi, anh mua báo luôn nha, uhm... mà thôi, "
				+ "em mất kính rồi, anh không cần mua báo nữa,... em thêm 1 chút trong "
				+ "lúc nhắn tin thôi à, nhanh nha anh, em chờ đó... ";

		String expected = "Anh oi, em dang o truong, anh den nhanh nha, muon lam roi, ah... "
				+ "ma nha em het bao roi, anh mua bao luon nha, uhm... ma thoi, "
				+ "em mat kinh roi, anh khong can mua bao nua,... em them 1 chut trong "
				+ "luc nhan tin thoi a, nhanh nha anh, em cho do... ";

		Assert.assertEquals(expected, TextConverter.utfToAcsii(utf));
	}
}
