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
        $(function () {
            table = $('#example').DataTable({
            	"bLengthChange": false,
            	"bFilter": false,
            	"ordering": false,
                "ajax": {
                	"type": "POST",
                	"data": function ( d ) {
                        //添加额外的参数传给服务器
                        d.areaname = $("#sareaname").val();
                        d.areaid = $("#sareaid").val();
                        d.grade = $("#sgrade").val();
                        $("#showdig").css("display","block");
                    },
                	"dataType": "json",
                    "url": '<%=request.getContextPath()%>/area/getlist.do'
                },
                "serverSide": true,
                "columns": [
                    {"data": "id"},
                    {"data": "areaid"},
                    {"data": "areaname"},
                    {"data": "grade"},
                    {"data": "fid"},
                    {"data": null}
                ],
                "columnDefs": [
                    {
                        "targets": 5,
                        "render": function (a, b, c, d) {
                        	if(c.grade == '5'){
                                var html = "<button type=\"button\" class=\"btn btn-danger btn-smg\" onclick=\"del('"+ c.id +"')\">删除</button>";
                                return html;
                        	}else{
                        		return '';
                        	}
                        	
                        }
                    },
                    {
            	          "targets": 3, //隐藏第六列，从第0列开始   
  	          	        "render": function (a, b, c, d) {
  	          	        	var name = '';
  	          	        	<c:forEach items="${areaglist}" var="areag">
  	          	        		var areagid = '${areag.dataid}';	          	        		
  	          	        		if(areagid == c.grade){
  	          	        			name = '${areag.dataname}';
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
                    areaname: {
                        validators: {
                            notEmpty: {
                                message: '地区名称不能为空'
                            }
                        }
                    },
                    areasf: {
                        validators: {
                            notEmpty: {
                                message: '省份不能为空'
                            }
                        }
                    },
                    areasj: {
                        validators: {
                            notEmpty: {
                                message: '市级不能为空'
                            }
                        }
                    },
                    areaxj: {
                        validators: {
                            notEmpty: {
                                message: '县级或区不能为空'
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
        	$("#myModalLabel").text("新增");
            $("#myModal").modal({backdrop: 'static'});
        }
        
        /**
         * 添加数据
         **/
        function addarea() {
        	$('#defaultForm').bootstrapValidator('validate');
        	if($('#defaultForm').data('bootstrapValidator').isValid()){
        		var addJson = {
                        "areaname": $("#areaname").val(),
                        "areasf":$("#areasf").val(),
                        "areasj":$("#areasj").val(),
                        "areaxj":$("#areaxj").val()
                    };
                    ajax(addJson);
                    $('#defaultForm').data('bootstrapValidator').resetForm(true);
        	}
        }
		//添加请求
        function ajax(obj) {
            var url ="<%=request.getContextPath()%>/area/add.do" ;
            $.ajax({
            	type: "post",
                url:url ,
                data: {
                    "areaname": obj.areaname,
                    "areasf":obj.areasf,
                    "areasj":obj.areasj,
                    "areaxj":obj.areaxj
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
                        url: "<%=request.getContextPath()%>/area/delete.do",
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
        //关闭弹窗
        function closeDiv(){
        	$('#defaultForm').data('bootstrapValidator').resetForm(true);
        	$("#myModal").modal("hide");
        }
        //获取地区
        function getareas(grade,selectarea,nextarea){
        	var fid = $('#' + selectarea).val();
        	if(fid =='' || fid == null ){
        		$('#' + nextarea).empty();
        		if(grade == '3'){
	       			 $('#' + nextarea).append("<option value=''>请选择市级</option>");
	       		 }else{
	       			 $('#' + nextarea).append("<option value=''>请选择县级或区</option>");
	       		 }
        		return;
        	}
             var url ="<%=request.getContextPath()%>/area/getareas.do" ;
             $.ajax({
            	 type: "post",
                 url:url ,
                 data: {
                     "grade": grade,
                     "fid": fid
                 }, success: function (data) {
                 	data = jQuery.parseJSON(data);
                 	var txt=  data.msg;
                     if(data.success != true){
                     	window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.error);
                     }else{
                    	 $('#' + nextarea).empty();
                    	 if(grade == '3'){
                			 $('#' + nextarea).append("<option value=''>请选择市级</option>");
                		 }else{
                			 $('#' + nextarea).append("<option value=''>请选择县级或区</option>");
                		 }
                    	 for(var i = 0; i < data.data.length; i++) {
                    		 $('#' + nextarea).append("<option value='" + data.data[i].areaid + "'>" + data.data[i].areaname +"</option>");
						}
                     }
                 }
             });
        }
        </script>
</head>
<body>
           <aside class="right-side">
               <section class="content-header">
                   <h1>地区管理</h1>
                   <ol class="breadcrumb">
                       <li><a href="javascript:void(0)"><i class="fa fa-dashboard"></i> 基础管理</a></li>
                       <li >地区管理</li>
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
					                  		<select class="form-control" id="sgrade" name="sgrade">
					                  		<option value="">请选择地区级别</option>
			                            	<c:forEach items="${areaglist}" var="areag">
						          	        	<option value="${areag.dataid}">${areag.dataname}</option>
					            			</c:forEach>
											</select>
										</div>
										<div class="col-xs-2">
					                  		<input type="text" class="form-control" id="sareaid" name="sareaid" placeholder="地区编号">
										</div>
					                    <div class="col-xs-2">
					                      <input type="text" class="form-control" id="sareaname" name="sareaname" placeholder="地区名称">
					                    </div>
					                    <div class="col-xs-2">
						                   <button type="submit" class="btn btn-primary" onclick="search();">查询</button>
						                	<button type="submit" class="btn btn-primary" onclick="add();">新增</button>
						                </div>
				                  </div>
				                </div>
                               
                               <div class="box-body table-responsive">
                                   <table id="example" class="table table-striped table-bordered">
							        <thead>
							        <tr>
							            <th width="10%">ID</th>
							            <th width="15%">地区编号</th>
							            <th width="30%">地区名称</th>
							            <th width="10%">等级</th>
							            <th width="20%">上级地区编号</th>
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
			                <button type="button" class="close" onclick="closeDiv();"><span
			                        aria-hidden="true">&times;</span></button>
			                <h4 class="modal-title" id="myModalLabel">新增</h4>
			            </div>
			            <form id="defaultForm"  class="form-horizontal">
				            <div class="modal-body">
					             <div class="form-group">
					             	<label class="col-lg-2 control-label">省份</label>
			                            <div class="col-lg-5">
					                  		<select class="form-control" id="areasf" name="areasf" onchange="getareas('3','areasf','areasj');">
					                  		<option value="">请选择省份</option>
			                            	<c:forEach items="${slist}" var="area">
						          	        	<option value="${area.areaid}">${area.areaname}</option>
					            			</c:forEach>
											</select>
										</div>
								 </div>
					             <div class="form-group">	
									<label class="col-lg-2 control-label">市级</label>
		                            <div class="col-lg-5">
				                  		<select class="form-control" id="areasj" name="areasj" onchange="getareas('4','areasj','areaxj');">
				                  		<option value="">请选择市级</option>
		                            	
										</select>
									</div>
								 </div>
					             <div class="form-group">	
									<label class="col-lg-2 control-label">县级或区</label>
		                            <div class="col-lg-5">
				                  		<select class="form-control" id="areaxj" name="areaxj" >
				                  		<option value="">请选择县级或区</option>
		                            	
										</select>
									</div>
								 </div>
								 <div class="form-group">
				                	<label class="col-lg-2 control-label">地区名称</label>
		                            <div class="col-lg-5">
				                    	<input type="text" class="form-control" id="areaname" name="areaname" maxlength="10" >
				                    </div>
					             </div>
				            </div>
				          </form>
				          <div class="modal-footer">
			              	<button type="button" class="btn btn-default" onclick="closeDiv();">关闭</button>
			              	<button type="button" class="btn btn-primary" onclick="addarea();">保存</button>
			              </div>
			        </div>
			    </div>
			</div>
    </body>
</html>