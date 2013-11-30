<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link href="ShowList.css" rel="stylesheet" />
<script src="Timers.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<title>Actions en cours</title>
</head>
<body>

	<h2>Actions</h2>
	<script>
		function toTimeString(secs) {
			var days, hours, minutes, seconds;

			if (secs == null)
				return "";

			days = (secs / 86400) >> 0;
			hours = (secs % 86400 / 3600) >> 0;
			minutes = (secs % 3600 / 60) >> 0;
			seconds = (secs % 60);
			seconds = seconds < 10 ? "0" + seconds : seconds;
			minutes = minutes < 10 ? "0" + minutes : minutes;
			hours = hours && hours < 10 ? "0" + hours : hours;

			return "" + (days ? days + "days " : "")
					+ (hours ? hours + "h " : "") + minutes + "min " + seconds
					+ "s";
		};

		function defineTimer(timerId, startDate, duree) {
			var start = new Date(parseInt(startDate));
			setInterval(function() {
				var diffInSeconds = parseInt((new Date() - start) / 1000);
				if (diffInSeconds > duree) {
					$(timerId).html('<div class=ended>Terminé</div>');
				} else {
					$(timerId).text(toTimeString(duree - diffInSeconds));
				}

			}, 1000);

		}
	</script>

	<table id="actions" class="tftable">

		<tr>
			<th>Id</th>
			<th>Durée</th>
			<th>Profondeur</th>
			<th>Ressource</th>
			<th>Temps restant</th>
		</tr>


		<c:forEach var="item" items="${liste_actions}" varStatus="status">
			<tr>
				<td>${item.id}</td>
				<td>${item.duree}</td>
				<td>${item.profondeur}</td>
				<td><img src="img/ressources/${item.ressource}.png"
					alt="${item.ressource}" class="resize"></img></td>
				<td><div id="timer_${status.index}"></div> <script>
					defineTimer("#timer_${status.index}", "${item.start}",
							"${item.duree}");
				</script></td>
			</tr>
		</c:forEach>

	</table>

	<script type="text/javascript">
		$("#actions").ready(function() {
			var tfrow = document.getElementById('actions').rows.length;
			var tbRow = [];
			for (var i = 1; i < tfrow; i++) {
				
				tbRow[i] = document.getElementById('actions').rows[i];
				tbRow[i].onmouseover = function() {
					this.style.backgroundColor = '#ffffff';
				};
				tbRow[i].onmouseout = function() {
					this.style.backgroundColor = '#d4e3e5';
				};
			}
		});
	</script>


</body>
</html>