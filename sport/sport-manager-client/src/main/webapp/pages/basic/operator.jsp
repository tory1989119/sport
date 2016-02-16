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
        <!-- DATA TABLES -->
        <link href="<%=request.getContextPath()%>/css/datatables/dataTables.bootstrap.css" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="<%=request.getContextPath()%>/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="<%=request.getContextPath()%>/css/MyAdminLTE.css" rel="stylesheet" type="text/css" />
        <!-- daterangepicker -->
        <link href="<%=request.getContextPath()%>/css/daterangepicker/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css" />
        <!-- xcConfirm -->
        <link href="<%=request.getContextPath()%>/css/xcConfirm/xcConfirm.css" rel="stylesheet" type="text/css" />
        <!-- bootstrapValidator -->
        <link href="<%=request.getContextPath()%>/css/bootstrapValidator/bootstrapValidator.min.css" rel="stylesheet" type="text/css" />
        
         <!-- jQuery 2.0.2 -->
        <script src="<%=request.getContextPath()%>/js/jquery.js" type="text/javascript"></script>
        <!-- Bootstrap -->
        <script src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript"></script>
        <!-- DATA TABES SCRIPT -->
        <script src="<%=request.getContextPath()%>/js/plugins/datatables/jquery.dataTables.js" type="text/javascript"></script>
        <script src="<%=request.getContextPath()%>/js/plugins/datatables/dataTables.bootstrap.js" type="text/javascript"></script>
    	<!-- daterangepicker -->
    	<script src="<%=request.getContextPath()%>/js/plugins/daterangepicker/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
    	<script src="<%=request.getContextPath()%>/js/plugins/daterangepicker/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
    	<!-- xcConfirm -->
    	<script src="<%=request.getContextPath()%>/js/plugins/xcConfirm/xcConfirm.js" type="text/javascript"></script>
    	<!-- bootstrapValidator -->
    	<script src="<%=request.getContextPath()%>/js/plugins/bootstrapValidator/bootstrapValidator.min.js" type="text/javascript"></script>
    	<script src="<%=request.getContextPath()%>/js/plugins/bootstrapValidator/zh_CN.js" type="text/javascript"></script>
    
        <!-- page script -->
        <script type="text/javascript">
        var table;
        var editFlag = false;
        $(function () {
        	$('#dstart').datetimepicker({
        		minView: "month", //选择日期后，不会再跳转去选择时分秒 
        		format: "yyyy-mm-dd", //选择日期后，文本框显示的日期格式 
        		language: 'zh-CN', //汉化 
        		autoclose:true //选择日期后自动关闭 
            });
        	$('#dend').datetimepicker({
        		minView: "month", //选择日期后，不会再跳转去选择时分秒 
        		format: "yyyy-mm-dd", //选择日期后，文本框显示的日期格式 
        		language: 'zh-CN', //汉化 
        		autoclose:true //选择日期后自动关闭 
            });
        	
            table = $('#example').DataTable({
            	"bLengthChange": false,
            	"bFilter": false,
            	"ordering": false,
                "ajax": {
                	"type": "POST",
                	"data": function ( d ) {
                        //添加额外的参数传给服务器
                        d.name = $("#sname").val();
                        d.phone = $("#sphone").val();
                        d.startdate = $("#startdate").val();
                        d.enddate = $("#enddate").val();
                        $("#showdig").css("display","block");//遮罩层开启
                    },
                	"dataType": "json",
                    "url": '<%=request.getContextPath()%>/operator/getlist.do'
                },
                "serverSide": true,
                "columns": [
                    {"data": "id"},
                    {"data": "name"},
                    {"data": "sex"},
                    {"data": "phone"},
                    {"data": "email"},
                    {"data": "roleid"},
                    {"data": "adate"},
                    {"data": null},
                    {"data": "address"},
                    {"data": "loginname"},
                    {"data": "password"}
                ],
                "columnDefs": [
                    {
                        "targets": 7,
                        "render": function (a, b, c, d) {
                            var html = "<button type=\"button\" class=\"btn btn-primary btn-smg\" onclick=\"edit('"+ c.id +"','"+ c.name +"','"+ c.sex +"','"+ c.phone +"','"+ c.email +"','"+ c.roleid +"','"+ c.address +"','"+ c.loginname +"','"+ c.password +"')\">修改</button>";
                            html = html + " <button type=\"button\" class=\"btn btn-danger btn-smg\" onclick=\"del('"+ c.id +"')\">删除</button>";
                            return html;
                        }
                    },
                    {    
          	          "targets": [ 8,9,10 ],//隐藏8,9,10
	          		  "visible": false    
	          	    },
                    {
          	          "targets": 2, //翻译性别
	          	        "render": function (a, b, c, d) {
	          	        	var name = '';
	          	        	<c:forEach items="${sexlist}" var="sex">
	          	        		var sexid = '${sex.dataid}';	          	        		
	          	        		if(sexid == c.sex){
	          	        			name = '${sex.dataname}';
	          	        		}
	            			</c:forEach>
	                        return name;
	                    }    
	          	    }
                ],
                "language": {
                    "lengthMenu": "_MENU_ 条记录每页",
                    "sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
                    "zeroRecords": "没有找到记录",
                    "info": "第 _PAGE_ 页 ( 总共 _PAGES_ 页 )",
                    "infoEmpty": "无记录",
                    "infoFiltered": "(从 _MAX_ 条记录过滤)",
                    "paginate": {
                        "previous": "上一页",
                        "next": "下一页"
                    }
                },
                "preDrawCallback":function( oSettings ) {
                	$("#showdig").css("display","none");//遮罩层关闭
                } 
            });
            
            
            $('#defaultForm').bootstrapValidator({
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    name: {
                        validators: {
                            notEmpty: {
                                message: '操作员姓名不能为空'
                            }
                        }
                    },
                    sex: {
                        validators: {
                            notEmpty: {
                                message: '性别不能为空'
                            }
                        }
                    },
                    phone: {
                        validators: {
                            notEmpty: {
                                message: '手机不能为空'
                            },
                            regexp: {
                                regexp: /^1[3|4|5|8][0-9]\d{8}$/,
                                message: '手机号码格式错误'
                            }
                        }
                    },
                    email: {
                        validators: {
                            notEmpty: {
                                message: '邮箱不能为空'
                            },
                            emailAddress: {
                                message: '邮箱格式错误'
                            }
                        }
                    },
                    roleid: {
                        validators: {
                            notEmpty: {
                                message: '角色不能为空'
                            }
                        }
                    },
                    loginname: {
                        validators: {
                            notEmpty: {
                                message: '登录名不能为空'
                            },
                            remote: {
                                url: '<%=request.getContextPath()%>/operator/checkloginname.do',
                                type: "post",
                                async: false,
                                data:  {'loginname': $('#loginname').val()},
                                message: '登录名已存在',
                                delay: 2000
                            }
                        }
                    },
                    password: {
                        validators: {
                            notEmpty: {
                                message: '密码不能为空'
                            }
                        }
                    },
                    address: {
                        validators: {
                            notEmpty: {
                                message: '地址不能为空'
                            }
                        }
                    }
                }
            });
            
        });
        
        /**
         * 查找
         */
        function search(){
        	table.ajax.reload();
        }

        /**
         *添加显示
         **/
        function add() {
        	editFlag = false;
        	$("#myModalLabel").text("新增");
        	$("#loginname").attr("disabled",false);
            $("#myModal").modal({backdrop: 'static'});
        }
        
        /**
         *编辑显示
         **/
        function edit(id,name,sex,phone,email,roleid,address,loginname,password) {
            editFlag = true;
            $("#myModalLabel").text("修改");
            $("#id").val(id);
            $("#name").val(name);
            $("#sex").val(sex);
            $("#phone").val(phone);
            $("#email").val(email);
            $("#roleid").val(roleid);
            $("#address").val(address);
            $("#loginname").val(loginname).attr("disabled",true);
            $("#password").val(password);
            $("#myModal").modal({backdrop: 'static'});
        }
        
        /**
         * 添加或修改数据
         **/
        function addoredit() {
            $('#defaultForm').bootstrapValidator('validate');
        	if($('#defaultForm').data('bootstrapValidator').isValid()){
        		var addJson = {
                        "id": $("#id").val(),
                        "name": $("#name").val(),
                        "sex": $("#sex").val(),
                        "phone": $("#phone").val(),
                        "email": $("#email").val(),
                        "roleid": $("#roleid").val(),
                        "address": $("#address").val(),
                        "loginname": $("#loginname").val(),
                        "password": $("#password").val()
                    };
                    ajax(addJson);
                    $('#defaultForm').data('bootstrapValidator').resetForm(true);
        	}
            
        }

        function ajax(obj) {
            var url ="<%=request.getContextPath()%>/operator/add.do" ;
            if(editFlag){
                url = "<%=request.getContextPath()%>/operator/edit.do";
            }
            $.ajax({
            	type: "post",
                url:url ,
                data: {
                    "id": obj.id,
                    "name": obj.name,
                    "sex": obj.sex,
                    "phone": obj.phone,
                    "email": obj.email,
                    "roleid": obj.roleid,
                    "address": obj.address,
                    "loginname": obj.loginname,
                    "password": obj.password
                }, success: function (data) {
                	$("#myModal").modal("hide");
                	data = jQuery.parseJSON(data);
                	var txt=  data.msg;
                    if(data.success != true){
                    	window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.error);
                    }else{
                    	$("#example").dataTable().fnDraw(true);
                    	window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.success);
                    }
                }
            });
        }


        /**
         * 删除数据
         * @param name
         */
        function del(id) {
        	var txt=  "确定要删除么？";
    		var option = {
    			title: "提示",
    			btn: parseInt("0011",2),
    			onOk: function(){
    				$.ajax({
    					type: "post",
                        url: "<%=request.getContextPath()%>/operator/delete.do",
                        data: {
                            "id": id
                        }, success: function (data) {
                            data = jQuery.parseJSON(data);
                            if(data.success != true){
                            	var txt=  data.msg;
                                window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.error);
                            }else{
                            	$("#example").dataTable().fnDraw(true);
                            }
                        }
                    });
    			}
    		}
    		window.wxc.xcConfirm(txt, "custom", option);
        }
        //关闭弹出框
        function closeDiv(){
        	$('#defaultForm').data('bootstrapValidator').resetForm(true);
        	$("#myModal").modal("hide");
        }
        
        </script>
</head>
<body class="skin-blue">
           <aside class="right-side">
               <section class="content-header">
                   <h1>操作员管理</h1>
                   <ol class="breadcrumb">
                       <li><a href="javascript:void(0)"><i class="fa fa-dashboard"></i> 基础管理</a></li>
                       <li >操作员管理</li>
                   </ol>
               </section>
               
               <section class="content">
                   <div class="row">
                       <div class="col-xs-12">
                           <div class="box">
	                           <div id="showdig" class="overlay" style="display: none">
								  <i class="fa fa-refresh fa-spin"></i>
								</div>
				                <div class="box-body">
				                <form action="<%=request.getContextPath()%>/operator/export.do" method="post" target="_blank">
				                  	<div class="row">
					                  	<div class="col-xs-3">
							                <div id="dstart" class="input-group date form_datetime col-md-12">
							                    <input id="startdate" name="startdate" class="form-control" size="16" type="text" value="" readonly placeholder="开始日期">
												<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
												<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
							                </div>
							            </div>
							            <div class="col-xs-3">
							                <div id="dend" class="input-group date form_datetime col-md-12">
							                    <input id="enddate" name="enddate" class="form-control" size="16" type="text" value="" readonly placeholder="结束日期">
												<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
												<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
							                </div>
							            </div>
					                    <div class="col-xs-2">
					                      <input type="text" class="form-control" id="sname" name="sname" placeholder="姓名">
					                    </div>
					                    <div class="col-xs-2">
					                      <input type="text" class="form-control" id="sphone" name="sphone" placeholder="手机">
					                    </div>
				                  	</div>
				                  	<br>
				                  	<div class="row">
					                    <div class="col-xs-3">
						                   <button type="button" class="btn btn-primary" onclick="search();">查询</button>
						                   <button type="button" class="btn btn-primary" onclick="add();">新增</button>
						                   <button type="submit" class="btn btn-primary" onclick="export();">导出</button>
						                </div>
				                  	</div>
				                  </form>
				                </div><!-- /.box-body -->
                               
                               <div class="box-body table-responsive">
                                   <table id="example" class="table table-striped table-bordered">
							        <thead>
							        <tr>
							            <th width="10%">管理员编号</th>
							            <th width="10%">姓名</th>
							            <th width="5%">性别</th>
							            <th width="15%">手机</th>
							            <th width="15%">邮箱</th>
							            <th width="10%">角色编号</th>
							            <th width="15%">添加时间</th>
							            <th width="15%">操作</th>
							        </tr>
							        </thead>
							        <tbody></tbody>
							        <!-- tbody是必须的 -->
							    </table>
                               </div>
                           </div>
                       </div>
                   </div>
               </section>
           </aside>
            
            <!-- Modal -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			    <div class="modal-dialog">
			        <div class="modal-content">
			            <div class="modal-header">
			                <button type="button" class="close" onclick="closeDiv();"><span aria-hidden="true">&times;</span></button>
			                <h4 class="modal-title" id="myModalLabel">新增</h4>
			            </div>
			            <form id="defaultForm"  class="form-horizontal">
				            <div class="modal-body">
				            	<input type="hidden" class="form-control" id="id">
		                        <div class="form-group">
		                            <label class="col-lg-2 control-label">姓名</label>
		                            <div class="col-lg-5">
		                                <input type="text" class="form-control" id="name" name="name" maxlength="10">
		                            </div>
		                        </div>
		                        <div class="form-group">
		                            <label class="col-lg-2 control-label">性别</label>
		                            <div class="col-lg-5">
		                            	<select class="form-control" id="sex" name="sex">
		                            	<c:forEach items="${sexlist}" var="sex">
					          	        	<option value="${sex.dataid}">${sex.dataname}</option>
				            			</c:forEach>
										</select>
		                            </div>
		                        </div>
		                        <div class="form-group">
		                            <label class="col-lg-2 control-label">手机</label>
		                            <div class="col-lg-5">
			                    		<input type="text" class="form-control" id="phone" name="phone" maxlength="11">
		                            </div>
		                        </div>
		                        <div class="form-group">
		                            <label class="col-lg-2 control-label">邮箱</label>
		                            <div class="col-lg-5">
			                    		<input type="text" class="form-control" id="email" name="email" maxlength="64">
		                            </div>
		                        </div>
		                        <div class="form-group">
				                	<label class="col-lg-2 control-label">角色编号</label>
		                            <div class="col-lg-5">
				                    	<input type="text" class="form-control" id="roleid" name="roleid" maxlength="20">
				                    </div>
				                </div>
				                <div class="form-group">
				                	<label class="col-lg-2 control-label">登录名</label>
		                            <div class="col-lg-5">
				                    	<input type="text" class="form-control" id="loginname" name="loginname" maxlength="20" >
				                    </div>
				                </div>
				                <div class="form-group">
				                	<label class="col-lg-2 control-label">密码</label>
		                            <div class="col-lg-5">
				                    	<input type="password" class="form-control" id="password" name="password" maxlength="12" >
				                    </div>
				                </div>
				                <div class="form-group">
				                	<label class="col-lg-2 control-label">地址</label>
		                            <div class="col-lg-8">
				                    	<input type="text" class="form-control" id="address" name="address" maxlength="100">
				                    </div>
				                </div>
				            </div>
			            </form>
			            <div class="modal-footer">
			                <button type="button" class="btn btn-default" onclick="closeDiv();">关闭</button>
			                <button type="button" class="btn btn-primary" onclick="addoredit();">保存</button>
			            </div>
			        </div>
			    </div>
			</div>
    </body>
</html>