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
        <!-- fileinput -->
        <link href="<%=request.getContextPath()%>/css/fileinput/fileinput.min.css" rel="stylesheet" type="text/css" />
        
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
    	<!-- fileinput -->
    	<script src="<%=request.getContextPath()%>/js/plugins/fileinput/fileinput.min.js" type="text/javascript"></script>
    	<script src="<%=request.getContextPath()%>/js/plugins/fileinput/fileinput_locale_zh.js" type="text/javascript"></script>
    
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
                        d.startdate = $("#startdate").val();
                        d.enddate = $("#enddate").val();
                        $("#showdig").css("display","block");
                    },
                	"dataType": "json",
                    "url": '<%=request.getContextPath()%>/template/getlist.do'
                },
                "serverSide": true,
                "columns": [
                    {"data": "id"},
                    {"data": "name"},
                    {"data": "pagename"},
                    {"data": "url"},
                    {"data": "adate"},
                    {"data": null}
                ],
                "columnDefs": [
                    {
                        "targets": 5,
                        "render": function (a, b, c, d) {
                            var html = "<button type=\"button\" class=\"btn btn-primary btn-smg\" onclick=\"edit('"+ c.id +"','"+ c.name +"')\">修改</button>";
                            html = html + " <button type=\"button\" class=\"btn btn-primary btn-smg\" onclick=\"upload('"+ c.id +"')\">上传模板</button>";
                            html = html + " <button type=\"button\" class=\"btn btn-danger btn-smg\" onclick=\"del('"+ c.id +"')\">删除</button>";
                            return html;
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
                	$("#showdig").css("display","none");//遮罩层开启
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
                                message: '模板名称不能为空'
                            }
                        }
                    }
                }
            });
            
            $("#fileupload").fileinput({
    			showPreview : false,
     	        uploadUrl: '<%=request.getContextPath()%>/template/upload.do',
     	        allowedFileExtensions : ['jsp'],
     	        maxFileCount: 1
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
        	$("#myModalLabel1").text("新增");
            $("#myModal1").modal({backdrop: 'static'});
        }
        
        /**
         *编辑显示
         **/
        function edit(id,name) {
            editFlag = true;
            $("#myModalLabel1").text("修改");
            $("#id").val(id);
            $("#name").val(name);
            $("#myModal1").modal({backdrop: 'static'});
        }
        
        /**
         *上传显示
         **/
        function upload(id) {
            $('#fileupload').fileinput('refresh', {uploadExtraData:{'id': id}});
            $("#myModal2").modal({backdrop: 'static'});
        }
        
        
        /**
         * 添加或修改数据
         **/
        function addoredit() {
        	$('#defaultForm').bootstrapValidator('validate');
        	if($('#defaultForm').data('bootstrapValidator').isValid()){
        		var addJson = {
                        "id": $("#id").val(),
                        "name": $("#name").val()
                    };
                    ajax(addJson);
                    $('#defaultForm').data('bootstrapValidator').resetForm(true);
        	}
        }

        function ajax(obj) {
        	var url ="<%=request.getContextPath()%>/template/add.do" ;
            if(editFlag){
                url = "<%=request.getContextPath()%>/template/edit.do";
            }
            $.ajax({
            	type: "post",
                url:url ,
                data: {
                    "id": obj.id,
                    "name": obj.name
                }, success: function (data) {
                	$("#myModal1").modal("hide");
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
         * @param id
         */
        function del(id) {
        	var txt=  "确定要删除么？";
    		var option = {
    			title: "提示",
    			btn: parseInt("0011",2),
    			onOk: function(){
    				$.ajax({
    					type: "post",
                        url: "<%=request.getContextPath()%>/template/delete.do",
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
        
        function closeDiv1(){
        	$('#defaultForm').data('bootstrapValidator').resetForm(true);
        	$("#myModal1").modal("hide");
        }
        
        function closeDiv2(){
        	$("#example").dataTable().fnDraw(true);
        	$("#myModal2").modal("hide");
        }
        </script>
</head>
<body>
           <aside class="right-side">
               <section class="content-header">
                   <h1>模板管理</h1>
                   <ol class="breadcrumb">
                       <li><a href="javascript:void(0)"><i class="fa fa-dashboard"></i> 基础管理</a></li>
                       <li >模板管理</li>
                   </ol>
               </section>

               <section class="content">
                   <div class="row">
                       <div class="col-xs-12">
                           <div class="box">
                           <div id="showdig" class="overlay" style="display: none"><i class="fa fa-refresh fa-spin"></i></div>
				                <div class="box-body">
				                  <div class="row">
					                  <div class="col-xs-3">
							                <div id="dstart" class="input-group date form_datetime col-md-12">
							                    <input id="startdate" class="form-control" size="16" type="text" value="" readonly placeholder="开始日期">
												<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
												<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
							                </div>
							            </div>
							            <div class="col-xs-3">
							                <div id="dend" class="input-group date form_datetime col-md-12">
							                    <input id="enddate" class="form-control" size="16" type="text" value="" readonly placeholder="结束日期">
												<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
												<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
							                </div>
							            </div>
					                    <div class="col-xs-2">
					                      <input type="text" class="form-control" id="sname" placeholder="模板名称">
					                    </div>
					                    <div class="col-xs-2">
						                   <button type="submit" class="btn btn-primary" onclick="search();">查询</button>
						                	<button type="submit" class="btn btn-primary" onclick="add();">添加模板</button>
						                </div>
				                  </div>
				                </div>
                               
                               <div class="box-body table-responsive">
                                   <table id="example" class="table table-striped table-bordered">
							        <thead>
							        <tr>
							            <th width="10%">模板编号</th>
							            <th width="15%">模板名称</th>
							            <th width="10%">模板文件名</th>
							            <th width="30%">模板地址</th>
							            <th width="15%">添加时间</th>
							            <th width="25%">操作</th>
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
            
            <!-- Modal2 -->
			<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			    <div class="modal-dialog">
			        <div class="modal-content">
			            <div class="modal-header">
			                <button type="button" class="close" onclick="closeDiv1();"><span
			                        aria-hidden="true">&times;</span></button>
			                <h4 class="modal-title" id="myModalLabel1">新增</h4>
			            </div>
			            <form id="defaultForm"  class="form-horizontal">
				            <div class="modal-body">
				                <div class="form-group">
				                	<label class="col-lg-2 control-label">模板名称</label>
		                            <div class="col-lg-5">
		                            	<input type="hidden" id="id" name="id">
				                    	<input type="text" class="form-control" id="name" name="name" maxlength="10" >
				                    </div>
				                </div>
				            </div>
				          </form>
				          <div class="modal-footer">
			              	<button type="button" class="btn btn-default" onclick="closeDiv1();">关闭</button>
			              	<button type="button" class="btn btn-primary" onclick="addoredit();">保存</button>
			              </div>
			        </div>
			    </div>
			</div>
			
			<!-- Modal2 -->
			<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			    <div class="modal-dialog">
			        <div class="modal-content">
			            <div class="modal-header">
			                <button type="button" class="close" onclick="closeDiv2();"><span
			                        aria-hidden="true">&times;</span></button>
			                <h4 class="modal-title" id="myModalLabel2">模板上传</h4>
			            </div>
			            <form class="form-horizontal">
				            <div class="modal-body">
				                <div class="form-group">
				                	<label class="col-lg-2 control-label">模板选择</label>
				                    <div class="col-lg-10">
				                    	<input id="sid" name="sid" type="hidden">
					          			<input id="fileupload" type="file" name="template_data" multiple=true>
					          		</div>
					             </div>
				            </div>
			            </form>
			            <div class="modal-footer">
			              	<button type="button" class="btn btn-default" onclick="closeDiv2();">关闭</button>
			            </div>
			        </div>
			    </div>
			</div>
    </body>
</html>