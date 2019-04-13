<%@ page
  contentType="text/html;charset=utf-8"
  pageEncoding="utf-8"
  import="java.sql.*"
%>
<%
    request.setCharacterEncoding("UTF-8");
    String DB_url="jdbc:mariadb://localhost:3306/web?user=&password=";
    Connection conn = null;
    Class.forName("org.mariadb.jdbc.Driver");
    conn =DriverManager.getConnection(DB_url);
    String sql="insert into m_b values(null,?,now(),curtime(),?,?,1)";
    PreparedStatement sql_do=null;
    ResultSet sql_result=null;
    sql_do=conn.prepareStatement(sql);
    String un=request.getParameter("un");
    String st=request.getParameter("st");
    String ip=request.getRemoteAddr();
    if(un!=null&&st!=null){
    sql_do.setString(1,un);
    sql_do.setString(2,st);
    sql_do.setString(3,ip);
    sql_do.execute();
	}
	sql_do=conn.prepareStatement("select * from m_b order by id desc;");
    sql_result=sql_do.executeQuery();
%>
<!DOCTYPE html>
<html>
  <head>
    <title>留言板</title>
  </head>
  <body>
  <jsp:include page="./menu.txt" />
    <div class="box">
		<h1>留言板</h1>
  	    <form method="post" class="s_box">
      你的名字:<br />
	  <input type="text" name="un" >
      <br />
      留言内容:<br>
	  <textarea  name="st"></textarea>
      <br>
      <input type="submit"><br>
      <br>
    </form>
    <div class="ly_box">
        <%for(int i=0;i<10;i++)
		{
			if(sql_result.next()){
			String username=sql_result.getString("un");
			String savetext=sql_result.getString("st");
			String time=sql_result.getDate("dt")+" "+sql_result.getTime("tm");
			%>
			<div class="ly_box1">
				<div class="name"><%=username%>:</div>
				<div class="ly_text"><%=savetext%></div>
				<div class="time"><%=time%></div>
			</div>
			<%}
			else break;
			}%>
    </div>
  </body>
</html>
