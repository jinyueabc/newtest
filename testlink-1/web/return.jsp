<%--
  Created by IntelliJ IDEA.
  User: wpc
  Date: 13-5-23
  Time: 上午1:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
   String result= (String) request.getAttribute("result");

    %>
    <style>
        table,tr,td{
            border: 1px solid #ffe4c4;
        }
    </style>
    <script>
        function xx(){
            //var jsonobj=  document.getElementById("result").value;
            var jsonobj=<%=result%>;
            alert("aa");
            var a=eval(jsonobj);
            var table1= document.getElementById("table1");
            //alert("xx");
            alert(jsonobj.result.length);
            for(var i=0;i<jsonobj.result.length;i++){
              var tr2= table1.insertRow();
               var td1=   tr2.insertCell();
               //var tr1= document.createElement("tr");
               //var td1=  document.createElement("td");
                td1.innerHTML= a.result[i].USERNAME;
               // alert(a.result.USERNAME);
               // var tr2= table1.insertRow();
                var td2=   tr2.insertCell();
                //var tr1= document.createElement("tr");
                //var td1=  document.createElement("td");
                td2.innerHTML= a.result[i].EMPLOYEE_ID;

            }
             alert("wanle");
        }

    </script>
    <title></title>
</head>
<body onload="xx();">
 <input type="hidden" id="result" value="<%=result%>%">
 <table id="table1">

 </table>
</body>

</html>