<%@ page
  contentType="text/html;charset=utf-8"
  pageEncoding="utf-8"
  import="java.sql.*"
%>
<% request.setCharacterEncoding("UTF-8");
String DB_url="jdbc:mariadb://localhost:3306/web?user=&password=";
Connection conn = null;
Class.forName("org.mariadb.jdbc.Driver");
conn =DriverManager.getConnection(DB_url);
String sql="insert into v_ip values(null,?,now(),curtime())";
PreparedStatement sql_do=null;
ResultSet sql_result=null;
sql_do=conn.prepareStatement(sql);
String ip=request.getRemoteAddr();
sql_do.setString(1,ip);
sql_do.execute();%>
<!DOCTYPE html>
<html>
<head>
	<title>cym2018.xyz</title>
</head>
<body>
	<jsp:include page="./menu.txt" />
	<div class="box">
		<h1>Android</h1>
		<p><a href="./file/read.apk">阅读</a></p>
		<p><a href="./file/OneDrive.apk">OneDrive</a></p>
		<p><a href="./file/Outlook.apk">Outlook</a></p>
		<p><a href="./file/XL.ver.1.1.81.build.23.apk">笑联</a></p>
		<p><a href="./file/SSDX.apk">宿舍电信</a></p>
		<p><a href="./file/YS.apk">影梭</a></p>
		<h1>Windows</h1>
		<p><a href="./file/7-zip.exe">7z</a></p>
		<p><a href="./file/Chrome.exe">Chrome</a></p>
		<p><a href="./file/Chrome.exe">Notepad++</a></p>
		<p><a href="./file/Office365.exe">Office365</a></p>
		<p><a href="./file/OneDrive.exe">OneDrive</a></p>
		<p><a href="./file/OneNote.exe">OneNote</a></p>
		<p><a href="./file/rdial.exe">rdial</a></p>
		<p><a href="./file/uiso9.zip">软碟通</a></p>
		<p><a href="./file/Shadowsocks.exe">影梭</a></p>
	</div>
</body>
</html>
