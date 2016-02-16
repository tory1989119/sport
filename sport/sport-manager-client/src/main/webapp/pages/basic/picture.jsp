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
        <!-- Theme style -->
        <link href="<%=request.getContextPath()%>/css/MyAdminLTE.css" rel="stylesheet" type="text/css" />
        <!-- fileinput -->
        <link href="<%=request.getContextPath()%>/css/fileinput/fileinput.min.css" rel="stylesheet" type="text/css" />
        
         <!-- jQuery 2.0.2 -->
        <script src="<%=request.getContextPath()%>/js/jquery.js" type="text/javascript"></script>
        <!-- Bootstrap -->
        <script src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript"></script>
    	<!-- AdminLTE App -->
        <script src="<%=request.getContextPath()%>/js/AdminLTE/app.js" type="text/javascript"></script>
    	<!-- fileinput -->
    	<script src="<%=request.getContextPath()%>/js/plugins/fileinput/fileinput.min.js" type="text/javascript"></script>
    	<script src="<%=request.getContextPath()%>/js/plugins/fileinput/fileinput_locale_zh.js" type="text/javascript"></script>
    
        <!-- page script -->
        <script type="text/javascript">
        	$(function () {
        		
        		
        		
        		
        		
        		
        		
        		
        		$("#fileupload").fileinput({
        			showPreview : true,
         	        uploadUrl: '<%=request.getContextPath()%>/picture/upload.do',
         	        allowedFileExtensions : ['jpg', 'png','gif'],
         	        maxFileCount: 1,
         	        allowedFileTypes: ['image'],
         	        
         	        previewFileType: "image",
         	        browseClass: "btn btn-success",
         	        browseLabel: "选择图片",
         	        browseIcon: "<i class=\"glyphicon glyphicon-picture\"></i> ",
         	        removeClass: "btn btn-danger",
         	        removeLabel: "删除",
         	        removeIcon: "<i class=\"glyphicon glyphicon-trash\"></i> ",
         	        uploadClass: "btn btn-info",
         	        uploadLabel: "上传",
         	        uploadIcon: "<i class=\"glyphicon glyphicon-upload\"></i> "
        		});
        	});
        	
        	function seturl(url){
        		$('#showpic').attr('src',url);
        	}
        </script>
</head>
<body class="skin-blue">
           <aside class="right-side">
               <section class="content-header">
                   <h1>首页图片管理</h1>
                   <ol class="breadcrumb">
                       <li><a href="javascript:void(0)"><i class="fa fa-dashboard"></i> 基础管理</a></li>
                       <li >首页图片管理</li>
                   </ol>
               </section>

               <section class="content">
                   <div class="row">
                       <div class="col-xs-12">
                           <div class="box">
				                <div class="box-body">
						          <div class="row" align="center">
						          	<div class="col-xs-6">
					                    	<img src="${picture.url}" class="img-thumbnail" width="100%" height="100%" id="showpic">
			                            </div>
						          	<div class="col-xs-6">
						          		<input id="fileupload" type="file" name="picture_data" multiple=true>
						          	</div>
				                  </div>
				                </div>
                           </div>
                       </div>
                   </div>
               </section>
           </aside>
    </body>
</html>