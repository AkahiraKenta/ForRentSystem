<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8" %>
<div id ="pager" style="text-align: center">
	<%-- ページ送り --%>
	<div class="page_nav">
		<ul>
			<li>
				<a class="callPager" href="#">
					<span id="prev">
						&laquo; 前
					</span>
				</a>
			</li>
			<c:forEach begin="${beginPage}" end="${endPage}" varStatus="status">
				<li>
					<c:if test="${currentPageNumber == status.index}">
						<span id="pager_${status.index}" style="margin-right:5px">
							${status.index}
						</span>
					</c:if>
					<c:if test="${currentPageNumber != status.index}">
						<a class="callPager" href="#">
							<span id="pager_${status.index}" style="margin-right:5px">
								${status.index}
							</span>
						</a>
					</c:if>
				</li>
			</c:forEach>
			<li>
				<a href="#" class="callPager">
					<span id="next">
						次 &raquo;
					</span>
				</a>
			</li>
		</ul>
	</div>
</div>
