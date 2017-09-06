package jp.co.forrentsystem.util;

import java.io.File;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;

/**
 * メール送信共通部品用クラス
 * @author d.kitajima
 *
 */
public class MailUtil {

	/** コンフィグファイルから生成されるクラス */
	private static ResourceBundle bundle;

	/** 改行コード(テキスト・画面) */
	public static final String NEW_LINE = "\r\n";

	/** 改行コード(HTML) */
	public static final String HTML_NEW_LINE = "<br>";

	/**
	 * イニシャライザ
	 */
	static {
		// 外部ファイルからパスを取得する
		bundle = ResourceBundle.getBundle("mail_setting");
	}

	/**
	 *
	 * @param subject タイトル
	 * @param message 本文
	 * @param to 送信先アドレス
	 * @param from 送信元アドレス
	 * @param fromName 送信元名前
	 * @param filePathList 添付ファイルがある場合は、パスを指定 不要ならNULL
	 * @throws Exception
	 */
	public static void sendMailForText(String subject,
									   String message,
									   String to,
									   String from,
									   String fromName,
									   List<String> filePathList) throws Exception {

		MultiPartEmail email = new MultiPartEmail();

		// 禁則文字エスケープ
		message = new String(charCodeConvert(message).getBytes("ISO-2022-JP"));
		subject = new String(charCodeConvert(subject).getBytes("ISO-2022-JP"));

		email.setContent(new String(message.getBytes("ISO-2022-JP")), bundle.getString("mail.content.type").concat(bundle.getString("mail.encoding")));

		sendMail(email, subject, to, filePathList, from, fromName);
	}

	/**
	 * メール送信用処理
	 * @param subject タイトル
	 * @param message 本文
	 * @param to 送信先アドレス
	 * @param from 送信元アドレス
	 * @param fromName 送信元名前
	 * @param filePathList 添付ファイルがある場合は、パスを指定 不要ならNULL
	 * @throws Exception
	 */
	public static void sendMailFotHtml(String subject,
									   String message,
									   String to,
									   String from,
									   String fromName,
									   List<String> filePathList) throws Exception {

		HtmlEmail email = new HtmlEmail();

		String convertedMessage = convertNewLineForHtml(message);

		// 禁則文字エスケープ
		convertedMessage = charCodeConvert(convertedMessage);
		subject = charCodeConvert(subject);
		email.setHtmlMsg(convertedMessage);

		sendMail(email, subject, to, filePathList, from, fromName);
	}

	/**
	 * メール送信処理
	 * @param email 本文
	 * @param subject タイトル
	 * @param to 送信先アドレス
	 * @param attachFilePathList 添付ファイルリスト
	 * @param from 送信元アドレス
	 * @param fromName 送信元名
	 * @throws Exception
	 */
	private static void sendMail(MultiPartEmail email, String subject,
			String to, List<String> attachFilePathList, String from, String fromName) throws Exception {

		email.setHostName(bundle.getString("mail.smtp.host"));
		email.setCharset(bundle.getString("mail.encoding"));
		email.setAuthentication(bundle.getString("mail.user.name"), bundle.getString("mail.user.path"));
		email.setSmtpPort(Integer.parseInt(bundle.getString("mail.smtp.port")));
		email.addTo(to);
		email.setSubject(subject);
		email.setFrom(from, fromName);

		// 添付ファイル 存在しない場合はスキップ
		if(attachFilePathList != null){
			for(String attachFilePath : attachFilePathList){
				// ローカルのファイルから添付ファイルの作成
				EmailAttachment attachment = new EmailAttachment();
				attachment.setPath(attachFilePath);
				attachment.setDisposition(EmailAttachment.ATTACHMENT);

				File file = new File(attachFilePath);
				String fileName = file.getName();
				// 日本語を使うためiso-2022-jpに変換してBase64エンコード
				attachment.setName("=?" + bundle.getString("mail.encoding") + "?B?" + new String(Base64.encodeBase64(fileName.getBytes(bundle.getString("mail.encoding")))) + "?=");
				// ファイルを添付
				email.attach(attachment);
			}
		}

		// 送信
		email.send();

	}


	/**
	 * DBの改行コードをHTML改行コードに置換する処理
	 * @param target
	 * @return 改行コード置換後文字列(\r\n → BR)
	 */
	public static String convertNewLineForHtml(String target) {
		String convertedValue = "";
		if (target.contains(NEW_LINE)) {
			convertedValue = target.replace(NEW_LINE, HTML_NEW_LINE);
		} else {
			convertedValue = target.replace("\n", HTML_NEW_LINE);
		}
		return convertedValue;
	}

	 /**
     * メール本文で文字化けする箇所をunicodeにエスケープする。<br>
     * メールの文字コードは、ISO-2022-JPとする。
     * @param str メール本文（MS932）
     * @return エスケープ後の文字列
     */
    private static String charCodeConvert(String str) {
        //　unicodeに変換
        str = str.replace('－','\u2212')
        .replace('―','\u2015')
        .replace('‐','\u2010')
        .replace('～','\u301C')
        .replace('∥','\u2016')
        .replace('￠','\u00A2')
        .replace('￡','\u00A3')
        .replace('￢','\u00AC');
        return str;
    }

	/**
	 * メールアドレスを取得
	 *
	 * @return メールアドレス
	 */
	public static String getMailAddress() {
		return bundle.getString("mail.info.address");
	}
}
