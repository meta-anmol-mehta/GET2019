<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleTriangleAreaProxyid" scope="session" class="com.metacube.training.soap.TriangleAreaProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleTriangleAreaProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        String side1_0id=  request.getParameter("side15");
        double side1_0idTemp  = Double.parseDouble(side1_0id);
        String side2_1id=  request.getParameter("side27");
        double side2_1idTemp  = Double.parseDouble(side2_1id);
        String side3_2id=  request.getParameter("side39");
        double side3_2idTemp  = Double.parseDouble(side3_2id);
        double area2mtemp = sampleTriangleAreaProxyid.area(side1_0idTemp,side2_1idTemp,side3_2idTemp);
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(area2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>