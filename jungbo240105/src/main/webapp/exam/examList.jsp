<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.Random" %>

<c:import url="/include/top.jsp" />

<style>
tr:first-child {
	background: tan;
}

td:last-child {
	text-align: center;
}
</style>



<section>
	<br>
	<div align=center>
		<div id="columnchart_values" style="width: 1000px; height: 500px;"></div>
		<table border=1>
			<tr>
				<td>학번</td>
				<td>이름</td>
				<td>국어</td>
				<td>영어</td>
				<td>수학</td>
				<td>역사</td>
				<td>합계</td>
				<td>평균</td>
				<td>등급</td>
			</tr>
			<c:forEach items="${ li }" var="m" varStatus="status">
				<c:set var="sum" value="${ m.kor+m.eng+m.math+m.hist }" />
				<c:set var="avg" value="${ sum/4 }" />
				<c:set var="avgInt" value="${ Math.round(avg) }" />
				<c:set var="sumKor" value="${ sumKor+m.kor }" />
				<c:set var="sumEng" value="${ sumEng+m.eng }" />
				<c:set var="sumMath" value="${ sumMath+m.math }" />
				<c:set var="sumHist" value="${ sumHist+m.hist }" />
				<c:set var="sumTotal" value="${ sumTotal+sum }" />
				<c:set var="avgTotal" value="${ avgTotal+avg }" />
				<fmt:formatNumber var="formattedAvgKor"
					value="${sumKor/status.count}" pattern="#,##0.00" />
				<c:set var="avgKor" value="${ formattedAvgKor }" />
				<fmt:formatNumber var="formattedAvgEng"
					value="${sumEng/status.count}" pattern="#,##0.00" />
				<c:set var="avgEng" value="${ formattedAvgEng }" />
				<fmt:formatNumber var="formattedAvgMath"
					value="${sumMath/status.count}" pattern="#,##0.00" />
				<c:set var="avgMath" value="${ formattedAvgMath }" />
				<fmt:formatNumber var="formattedAvgHist"
					value="${sumHist/status.count}" pattern="#,##0.00" />
				<c:set var="avgHist" value="${ formattedAvgHist }" />
				<fmt:formatNumber var="formattedSumTotalAvg"
					value="${sumTotal/status.count}" pattern="#,##0.00" />
				<c:set var="sumTotalAvg" value="${ formattedSumTotalAvg }" />
				<fmt:formatNumber var="formattedAvgTotalAvg"
					value="${ avgTotal/status.count }" pattern="#,##0.00" />
				<c:set var="avgTotalAvg" value="${ formattedAvgTotalAvg }" />

				<c:choose>
					<c:when test="${ avg >= 90 }">
						<c:set var="grade" value="수" />
					</c:when>
					<c:when test="${ avg >= 80 }">
						<c:set var="grade" value="우" />
					</c:when>
					<c:when test="${ avg >= 70 }">
						<c:set var="grade" value="미" />
					</c:when>
					<c:otherwise>
						<c:set var="grade" value="재시험" />
					</c:otherwise>
				</c:choose>

				<c:if test="${ status.index % 2 == 0 }">
					<c:set var="bgcolor" value="moccasin" />
				</c:if>
				<c:if test="${ status.index % 2 == 1 }">
					<c:set var="bgcolor" value="lemonchiffon" />
				</c:if>
				<tr bgcolor="${ bgcolor }">
					<td>${ m.sno }</td>
					<td>${ m.sname }</td>
					<td>${ m.kor }</td>
					<td>${ m.eng }</td>
					<td>${ m.math }</td>
					<td>${ m.hist }</td>
					<td>${ sum }</td>
					<td>${ avg }</td>
					<td>${ grade }</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="2">누적합</td>
				<td>${ sumKor }</td>
				<td>${ sumEng }</td>
				<td>${ sumMath }</td>
				<td>${ sumHist }</td>
				<td>${ sumTotal }</td>
				<td>${ avgTotal }</td>
			</tr>
			<tr>
				<td colspan="2">누적평균</td>
				<td>${ avgKor }</td>
				<td>${ avgEng }</td>
				<td>${ avgMath }</td>
				<td>${ avgHist }</td>
				<td>${ sumTotalAvg }</td>
				<td>${ avgTotalAvg }</td>
			</tr>
		</table>
	</div>
	<br>
</section>

<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
    google.charts.load("current", {packages:['corechart']});
    google.charts.setOnLoadCallback(drawChart);
    
    function getRandomColor() {
        var color = ["silver", "gold", "palegoldenrod", "mediumslateblue", "mediumvioletred", "#e5e4e2", "#b87333", "#ffe4e2", "#e5ffe2", "#e5e4ff", "thistle", "honeydew", "cyan"];
        var randomIndex = Math.floor(Math.random() * color.length);
        return color[randomIndex];
    }
    
    function drawChart() {
    	
      var data = google.visualization.arrayToDataTable([
        ["Element", "평균", { role: "style" } ],
        <c:forEach items="${li}" var="m">
			<c:set var="sum" value="${ m.kor+m.eng+m.math+m.hist }" />
			<c:set var="avg" value="${ sum/4 }" />
			<c:set var="avgInt" value="${ Math.round(avg) }" />
	      ["${m.sname}", ${avgInt}, getRandomColor()],
		</c:forEach>
      ]);
      
    var view = new google.visualization.DataView(data);
    view.setColumns([0, 1,
                       { calc: "stringify",
                         sourceColumn: 1,
                         type: "string",
                         role: "annotation" },
                       2]);

      var options = {
        title: " 성적 ",
        width: 1000,
        height: 500,
        bar: {groupWidth: "85%"},
        legend: { position: "none" },
        vAxis: {
            viewWindow: {
                min: 0,
                max: 100
            }
        }
      };
      
      var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
      chart.draw(view, options);
  }
  </script>

<c:import url="/include/bottom.jsp" />