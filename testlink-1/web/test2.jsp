<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
      <script language="javascript" src="/js/json2.js"></script>
      <script language="javascript">

          var Contract = {"UserID":1592,
              "ContractHeader":{
                  "FirstName":{"name":"aa","age":"21"},
                  "LastName":"Liu"
              },
              "Email":"liudong张哲@broadengate.com",
              "flow":[{"compose_user":"张哲","complete_date":"2013-05-20"},{"compose_user":"石亚莎","complete_date":"2013-05-21"}]
          };
          // alert(User1.Name.FirstName.name);
          //alert(User1.flow[0].name1);
          //User1.flow[0].name1="\"sss\"";
          // alert(User1.flow[0].name1);
          //var User2 = {"name":"a","age":"21"};

          //列表
          function xx(){
//          var a= document.getElementById("v1").value;
//          User1.flow[0].name1=a;
//          alert(User1.flow[0].name1);
//          alert(JSON.stringify(User1));
            var  User2 = {"name":[{"a":"a1"},{"a":"a2"}],"age":"21"};
            alert(JSON.stringify(Contract));
            document.getElementById("user_name").value=JSON.stringify(Contract);
              alert(document.getElementById("user_name").value);
          }
      </script>
  </head>
  <body>

  <form  action="/servlet/com.link.servlet.testServlet" method="post">
       <input type="text" id="user_name" name="user_name"><br>
       <input type="text" name="password"><br>
     1 <input type="text" name="email1"><br>
     2 <input type="text" name="email2"><br>
     3 <input type="text" name="email3"><br>
     4 <input type="text" name="email4"><br>
       <input type="submit" value="tijiao">
      <input  type="button" value="xx3" onclick="xx();">
  </form>
  </body>

</html>