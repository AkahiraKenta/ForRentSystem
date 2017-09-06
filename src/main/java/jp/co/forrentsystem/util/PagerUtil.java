package jp.co.forrentsystem.util;
/**
 * ページング情報処理
 * @author webridge
 *
 */
public class PagerUtil {
	// 表示ページ数
	private final static Double TOTAL_PAGE = 5d;

	/**
	 * 取得対象の最初の件数を取得
	 *
	 * @param currentPage 現在のページ
	 * @param viewNumber 表示件数
	 *
	 * @return 表示件数
	 */
	public static Integer getNumberFrom(Integer currentPage, Integer viewNumber) {
		// 現在のページ×表示件数＝最初の件数
		return (currentPage - 1) * viewNumber;
	}

	/**
	 * 表示する最初のページ番号を取得
	 *
	 * @param currentPage 現在のページ
	 * @param pageTotalNumber 全ページ数
	 *
	 * @return 最初のページ番号
	 */
	public static Integer getBeginPage(Integer currentPage, Integer pageTotalNumber) {
		// 初期値設定（初期表示ページ数開始値)
		double beginPage = 1d;
		// 初期値設定（初期表示ページ数MAXの中間値)
		double centerPage = Math.ceil(TOTAL_PAGE / 2);
//		// 差分ページ数
//		int deffencePage = pageTotalNumber - currentPage;

		if (currentPage > centerPage) {
			// 中間値よりも現在ページが大きい場合

			// 全ページ - 表示ページ中間値（切捨）= 規定数後ろページが存在しないページ数
			double markPage = pageTotalNumber - Math.floor(TOTAL_PAGE / 2);

			if (markPage <= currentPage) {
				// markPageより現在ページが大きい場合

				// markPage-中間値=表示ページ開始値となる
				beginPage = markPage - (centerPage-1);

				if (beginPage < 1) {
					// 表示ページ数が1以下になってしまった場合は、1とする
					beginPage = 1;
				}
			}
		}

		return (int)beginPage;
	}

	/**
	 * 表示する最後のページ番号を取得
	 *
	 * @param beginPage 表示ページ開始値
	 * @return 最後のページ番号
	 */
	public static Integer getEndPage(Integer beginPage, Integer pageTotalNumber) {
		double endPage = beginPage + (TOTAL_PAGE-1);
		if (endPage > pageTotalNumber) {
			// 規定表示ページ数よりも最終ページ数が小さい場合は、最終ページをendPageに格納する
			endPage = pageTotalNumber;
		}
		return (int)endPage;
	}

	/**
	 * 全ページ数を取得
	 *
	 * @param totalNumber 全件数
	 * @param viewNumber 表示件数
	 *
	 * @return 全ページ数
	 */
	public static Integer getPageTotalNumber(int totalNumber, int viewNumber) {
		// ページ数計算
		Double pageTotlaNumberDouble = Math.ceil((double)totalNumber/(double)viewNumber);
		int pageTotalNumber = pageTotlaNumberDouble.intValue();
		return pageTotalNumber;
	}
}
