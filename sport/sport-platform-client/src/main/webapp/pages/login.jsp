<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>报名俱乐部</title>
    	<!-- bootstrap 3.0.2 -->
        <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="<%=request.getContextPath()%>/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="<%=request.getContextPath()%>/css/AdminLTE.css" rel="stylesheet" type="text/css" />
        <!-- layer -->
        <link href="<%=request.getContextPath()%>/css/layer/layer.css" rel="stylesheet" type="text/css" />
        
        <!-- jQuery 2.0.2 -->
        <script src="<%=request.getContextPath()%>/js/jquery.js" type="text/javascript"></script>
        <!-- Bootstrap -->
        <script src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript"></script>
        <!-- layer -->
        <script src="<%=request.getContextPath()%>/js/plugins/layer/layer.js" type="text/javascript"></script>
        
        <!-- page script -->
        <script type="text/javascript">
        
        	if (window != top) 
			top.location.href = location.href; 
        
            function login(){
            	if($("#username").val() == '' || $("#username").val() == null){
            		layer.tips('登录名不能为空', '#username', {
            		    tips: [1, '#0FA6D8']
            		});
            		return;
            	}
            	if($("#password").val() == '' || $("#password").val() == null){
            		layer.tips('密码不能为空', '#password', {
            		    tips: [1, '#0FA6D8']
            		});
            		return;
            	}
            	$.ajax({
            			type: "post",
                        url: "<%=request.getContextPath()%>/login/tologin.do",
                        data: {
                            "username": $("#username").val(),
                            "password": $("#password").val()
                        }, success: function (data) {
                            data = jQuery.parseJSON(data);
                            if(data.success != true){
                            	layer.msg(data.msg,{offset: 0,shift: 6});
                            }else{
                            	$("#mainform").submit();
                            }
                        }
                    });
            }
            
            function regist(){
            	window.location.href='<%=request.getContextPath()%>/regist/regist.do';
            }
        </script>
        
        <style>
			html,
			body {
			  overflow-x: hidden!important;
			  -webkit-font-smoothing: antialiased;
			  min-height: 100%;
			  background: #c1c1c1;
			}
		</style>
</head>
 <body>
        <div class="form-box" id="login-box">
            <div class="header">平台测试登录</div>
                <div class="body bg-gray">
                    <div class="form-group">
                        <input type="text" id="username" class="form-control" placeholder="用户名"/>
                    </div>
                    <div class="form-group">
                        <input type="password" id="password" class="form-control" placeholder="密码"/>
                    </div>          
                </div>
                <div class="footer">                                                               
                    <button type="submit" class="btn bg-olive btn-block" onclick="login();">登录</button>
                    <button type="submit" class="btn bg-olive btn-block" onclick="regist();">注册</button>
                </div>
            <form action="<%=request.getContextPath()%>/login/main.do" method="post" id="mainform">
            </form>
            <div class="margin text-center"><br></div>
        </div>
    </body>
</html>