<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"
	import="java.sql.*" import="java.text.*" import="java.util.*"%>
<%!String inputForm() {
		return "<form class=\"s_box\" action=\"\">学号:<br><input type=\"text\" name=\"acc\"><br>"
				+ " 密码:<br><input type=\"text\" name=\"pas\"><br>" + "阅览室编号:<br><input type=\"text\" name=\"room\"><br>"
				+ " 座号:<br><input type=\"text\" name=\"chair\"><br>" + "开始时间:<br><input type=\"text\" name=\"start\"><br>"
				+ "结束时间:<br><input type=\"text\" name=\"end\"><br><br>" + "<input type=\"submit\"></form>";
	}

	String useInfomation() {
		return "使用说明:<br>1.预约日期为第三天,请注意时间(周一输入信息,程序将在周二预约周三的座位)<br>" + "2.阅览室不分方向(九阅览室北和九阅览室南都输入\"9\")<br>"
				+ "3.开始时间与结束时间计算方式:小时*60+分(8:15-12:00,请输入\"495\",\"720\")<br>"
				+ "4.预约时间应符合阅览室规定(有4小时限制的阅览室,结束时间-开始时间＞240会预约失败)<br>" + "5.预约时间为早上4:59:30,5:00:30,不保证程序运行效果,使用本程序的一切后果自负<br>"
				+ "6.<a href=\"mailto:cym2018@outlook.com\">提交bug</a>";
	}

	String INFO0319() {
		return "<br>八阅览室的349,350号座位查不到id,请避免预约上述两个位置";
	}

	Connection dbConnect(String strDbname, String strUsername, String strPassword) {
		//连接数据库
		try {
			String sql = "jdbc:mariadb://localhost:3306/" + strDbname + "?user=" + strUsername + "&password="
					+ strPassword;
			Class.forName("org.mariadb.jdbc.Driver");//加载驱动
			return DriverManager.getConnection(sql);
		} catch (SQLException e) {

		} catch (ClassNotFoundException e) {
		}
		return null;
	}

	String getDate(int i) {
		//函数功能:获取第二天的日期
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date now = new java.util.Date(), next = null;
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(now);
		calendar.add(Calendar.DATE, 1);
		next = calendar.getTime();
		if (i == 0)
			return df.format(now).toString();
		return df.format(next).toString();
	}

	String update(Connection conn, String s1) {
		//数据库更新
		try {
			conn.prepareStatement(s1).execute();
			return "success";
		} catch (SQLException e) {
			return e.toString();
		}
	}

	public ResultSet que(Connection conn, String s1) {
		//数据库查询
		try {
			ResultSet rs = conn.prepareStatement(s1).executeQuery();
			System.out.println(s1);
			return rs;
		} catch (SQLException e) {
			System.out.println("查询失败:" + s1);
			return null;
		}
	}

	public String getChairId(Connection conn, String room, String chair) {
		//座位id获取
		String sql1 = "select * from chairlist1 where room = " + room + " && chair = " + chair + ";";
		try {
			ResultSet rs = que(conn, sql1);
			rs.next();
				return rs.getString("chairid");
		} catch (SQLException e) {
			return e.toString();
		}
	}%>
<%
	request.setCharacterEncoding("UTF-8");
	Connection conn = dbConnect("web", "username", "password");
	ResultSet rs = null;
	String read = request.getParameter("read");
	if (read != null) {
		//读取
		rs = que(conn, "select * from library where day='" + getDate(0) + "'");
		while (rs.next()) {
			out.println(rs.getString("acc") + "#" + rs.getString("pas") + "#" + rs.getString("chair") + "#"
					+ rs.getString("start") + "#" + rs.getString("end") + "##");
		}
		return;
	}
%>
<!DOCTYPE html>
<html>
<head>
<title>图书馆预约</title>
</head>
<body>
	<%
		//写入
		String acc = request.getParameter("acc"), pas = request.getParameter("pas");
		String room = request.getParameter("room"), chair = request.getParameter("chair");
		String start = request.getParameter("start"), end = request.getParameter("end");
		if (acc != null && pas != null && room != null && chair != null && start != null && end != null) {
			try {
				int iRoom = Integer.parseInt(room);
				int iChair = Integer.parseInt(chair);
				int istart = Integer.parseInt(start);
				int iend = Integer.parseInt(end);
				out.println("学号:"+acc + "<br>密码:" + pas +"<br>阅览室:"+room+"<br>座号:"+chair+ "<br>座位id:" + getChairId(conn, room, chair) + "<br>日期:" + getDate(1) + "<br>开始时间" + istart/60+":"+istart%60
						+ "<br>结束时间:" + iend/60+":"+iend%60);
				//写入数据库
				out.println("<br>写入数据库:"+update(conn, "insert into library values(null,'" + acc + "','" + pas + "','"
						+ getChairId(conn, room, chair) + "','" + getDate(1) + "','" + start + "','" + end + "')"));
			} catch (NumberFormatException e) {
				out.println("输入格式不正确");
			}
		} else {
			//输入数据%>
			<jsp:include page="menu.txt" />
<div class="box">
<h1>图书馆座位预约</h1>
			<%
			out.println(inputForm());
			out.println(useInfomation() + "<br><br><br>" + INFO0319());
%></div><%
		}
	%>
</body>
</html>
