<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="true"%>
<%@ page import="java.util.LinkedList"%>
<%@ page import= "model.Reservation" %>
<%@ page import= "model.User" %>
<%@ page import= "model.Room" %>

<%
LinkedList<Reservation> reservations =(LinkedList<Reservation>)request.getAttribute("reservations");

%>

<HTML>
  <HEAD>
  </HEAD>
  <HR>

  <table align= "center" border="1">
  <tr>
  <td align="center" width="130">場所</td>
  <td align="center" width="200">利用開始時間</td>
  <td align="center" width="200">利用時間</td>
  <td align="center" width="200">予約者名</td>
  <td></td>
  </tr>

  <%
  for(int i= 0; i<reservations.size();i++){
	  out.println("<tr>");

	  Room room = reservations.get(i).getRoom();
	  User user = reservations.get(i).getUser();
	  out.println("<td>"+ room.getName()+"</td>");

	  out.println("<td>"+ reservations.get(i).getStartYear() +"年"+
			  reservations.get(i).getStartMonth() +"月"+
			  reservations.get(i).getStartDay() +"日"+
			  reservations.get(i).getStartHour() +"時"+
			  reservations.get(i).getStartMinute() +"分"+ "</td>");

	  int bookedMinute = 0;
	  int bookedStart = 0;
	  int bookedPeriod = 0;
	  bookedStart = reservations.get(i).getStartHour() * 60 + reservations.get(i).getStartMinute();
	  bookedPeriod = reservations.get(i).getPeriodHour()  * 60 + reservations.get(i).getPeriodMinute();
	  bookedMinute = bookedPeriod -bookedStart;

	  out.println("<td>" + bookedMinute/60 + "時間" + bookedMinute%60 + "分</td>");

	  out.println("<td>"+ user.getName() + "</td>");

	  out.println("<td><form method=post action=ReservationDetailsServlet><input type=submit value=詳細>");
	  out.println("<input type = hidden name = RID value = " + reservations.get(i).getRid() + ">");
	  out.println("</form></td></tr>");
  }

  %>

  <HR>
</HTML>