package jp.co.forrentsystem.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestMainUtil {

	@BeforeClass
	public static void setUpBeforeClass() {

	}

	@Test
	/**
	 * 通常送信
	 */
	public void sendMailForTextTest01() {
		try {
			MailUtil.sendMailForText("タイトル",
	                 "本文だよ～",
	                 "kitajima@w-bridge.co.jp",
	                 "akahira@w-bridge.co.jp",
	                 "赤平っす",
	                 null);

		} catch(Exception e) {
			assertTrue(false);
			return;
		}
		assertTrue(true);
	}

	@Test
	/**
	 * 通常送信
	 */
	public void sendMailForHtmlTest01() {
		try {
			MailUtil.sendMailFotHtml("タイトル",
	                 "本文だよ～",
	                 "kitajima@w-bridge.co.jp",
	                 "akahira@w-bridge.co.jp",
	                 "赤平っす",
	                 null);
		} catch(Exception e) {
			assertTrue(false);
			return;
		}
		assertTrue(true);
	}

	@Test
	/**
	 * 添付ファイル送信
	 */
	public void sendMailForHtmlTest02() {
		List<String> atttachMentFileList = new ArrayList<String>();
		atttachMentFileList.add("C:\\Users\\d.kitajima\\Pictures\\サープラ素材\\m-u-g-e-n-31.png");
		try {
			MailUtil.sendMailFotHtml("タイトル",
	                 "本文だよ～",
	                 "kitajima@w-bridge.co.jp",
	                 "akahira@w-bridge.co.jp",
	                 "赤平っす",
	                 atttachMentFileList);
		} catch(Exception e) {
			assertTrue(false);
			return;
		}
		assertTrue(true);
	}


}
