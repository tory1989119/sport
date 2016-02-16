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
                        d.categoryname = $("#scategoryname").val();
                        d.categoryid = $("#scategoryid").val();
                        d.grade = $("#sgrade").val();
                        d.fid = $("#sfid").val();
                        $("#showdig").css("display","block");
                    },
                	"dataType": "json",
                    "url": '<%=request.getContextPath()%>/category/getlist.do'
                },
                "serverSide": true,
                "columns": [
                    {"data": "id"},
                    {"data": "categoryid"},
                    {"data": "categoryname"},
                    {"data": "grade"},
                    {"data": "fid"},
                    {"data": null}
                ],
                "columnDefs": [
                    {
                        "targets": 5,
                        "render": function (a, b, c, d) {
                           		var html = "<button type=\"button\" class=\"btn btn-danger btn-smg\" onclick=\"del('"+ c.id +"')\">删除</button>";
                               return html;
                        }
                    },
                    {
            	        "targets": 3, 
  	          	        "render": function (a, b, c, d) {
  	          	        	var name = '';
  	          	        	<c:forEach items="${categoryglist}" var="categoryg">
  	          	        		var categorygid = '${categoryg.dataid}';	          	        		
  	          	        		if(categorygid == c.grade){
  	          	        			name = '${categoryg.dataname}';
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
            
            
            $('#defaultForm1').bootstrapValidator({
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    categoryname1: {
                        validators: {
                            notEmpty: {
                                message: '活动分类名称不能为空'
                            }
                        }
                    }
                }
            });
            
            $('#defaultForm2').bootstrapValidator({
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    categoryname2: {
                        validators: {
                            notEmpty: {
                                message: '活动分类名称不能为空'
                            }
                        }
                    },
                    ocategoryid2: {
                        validators: {
                            notEmpty: {
                                message: '一级不能为空'
                            }
                        }
                    }
                }
            });
            
            $('#defaultForm3').bootstrapValidator({
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    categoryname3: {
                        validators: {
                            notEmpty: {
                                message: '活动分类名称不能为空'
                            }
                        }
                    },
                    ocategoryid3: {
                        validators: {
                            notEmpty: {
                                message: '一级不能为空'
                            }
                        }
                    },
                    tcategoryid3: {
                        validators: {
                            notEmpty: {
                                message: '二级不能为空'
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
        function add(grade) {
        	if(grade == '1'){
        		$("#myModalLabel1").text("新增一级分类");
                $("#myModal1").modal({backdrop: 'static'});
        	}else if(grade == '2'){
        		getonecategory('ocategoryid2');
        		$("#myModalLabel2").text("新增二级分类");
                $("#myModal2").modal({backdrop: 'static'});
        	}else{
        		getonecategory('ocategoryid3');
        		$("#myModalLabel3").text("新增三级分类");
                $("#myModal3").modal({backdrop: 'static'});
        	}
        }
        
        function getonecategory(nextcategory){
        	var url ="<%=request.getContextPath()%>/category/getcategorys.do" ;
            $.ajax({
            	type: "post",
                url:url ,
                data: {
                    "grade": '1',
                    "fid": '0'
                }, success: function (data) {
                	data = jQuery.parseJSON(data);
                	var txt=  data.msg;
                    if(data.success != true){
                    	window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.error);
                    }else{
                   	 $('#' + nextcategory).empty();
                   	 $('#' + nextcategory).append("<option value=''>请选择一级分类</option>");
                   	 for(var i = 0; i < data.data.length; i++) {
                   		 $('#' + nextcategory).append("<option value='" + data.data[i].categoryid + "'>" + data.data[i].categoryname +"</option>");
						}
                    }
                }
            });
        }
        
        /**
         * 添加数据
         **/
        function addcategory(grade) {
        	if(grade == '1'){
        		$('#defaultForm1').bootstrapValidator('validate');
            	if($('#defaultForm1').data('bootstrapValidator').isValid()){
            		var addJson = {
                            "categoryname": $("#categoryname1").val(),
                            "categoryid": '',
                            "grade": grade
                        };
                        ajax(addJson);
                        $('#defaultForm1').data('bootstrapValidator').resetForm(true);
            	}
        	}else if(grade == '2'){
        		$('#defaultForm2').bootstrapValidator('validate');
            	if($('#defaultForm2').data('bootstrapValidator').isValid()){
            		var addJson = {
                            "categoryname": $("#categoryname2").val(),
                            "categoryid": $("#ocategoryid2").val(),
                            "grade": grade
                        };
                        ajax(addJson);
                        $('#defaultForm2').data('bootstrapValidator').resetForm(true);
            	}
        	}else{
        		$('#defaultForm3').bootstrapValidator('validate');
            	if($('#defaultForm3').data('bootstrapValidator').isValid()){
            		var addJson = {
                            "categoryname": $("#categoryname3").val(),
                            "categoryid": $("#tcategoryid3").val(),
                            "grade": grade
                        };
                        ajax(addJson);
                        $('#defaultForm3').data('bootstrapValidator').resetForm(true);
            	}
        	}
        }
		//添加请求
        function ajax(obj) {
            var url ="<%=request.getContextPath()%>/category/add.do" ;
            $.ajax({
            	type: "post",
                url:url ,
                data: {
                    "categoryname": obj.categoryname,
                    "categoryid": obj.categoryid,
                    "grade": obj.grade
                }, success: function (data) {
                	closeDiv(obj.grade);
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
                        url: "<%=request.getContextPath()%>/category/delete.do",
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
        function closeDiv(grade){
        	if(grade == '1'){
        		$('#defaultForm1').data('bootstrapValidator').resetForm(true);
            	$("#myModal1").modal("hide");
        	}else if(grade == '2'){
        		$('#defaultForm2').data('bootstrapValidator').resetForm(true);
            	$("#myModal2").modal("hide");
        	}else{
        		$('#defaultForm3').data('bootstrapValidator').resetForm(true);
            	$("#myModal3").modal("hide");
        	}
        }
        
        
        
        //获取活动分类
        function getcategorys(grade,selectcategory,nextcategory){
        	var fid = $('#' + selectcategory).val();
        	if(fid =='' || fid == null ){
        		$('#' + nextcategory).empty();
	       		$('#' + nextcategory).append("<option value=''>请选择二级分类</option>");
        		return;
        	}
             var url ="<%=request.getContextPath()%>/category/getcategorys.do" ;
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
                    	 $('#' + nextcategory).empty();
         	       		$('#' + nextcategory).append("<option value=''>请选择二级分类</option>");
                    	 for(var i = 0; i < data.data.length; i++) {
                    		 $('#' + nextcategory).append("<option value='" + data.data[i].categoryid + "'>" + data.data[i].categoryname +"</option>");
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
                   <h1>活动分类管理</h1>
                   <ol class="breadcrumb">
                       <li><a href="javascript:void(0)"><i class="fa fa-dashboard"></i> 基础管理</a></li>
                       <li >活动分类管理</li>
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
					                  		<option value="">请选择活动分类级别</option>
			                            	<c:forEach items="${categoryglist}" var="categoryg">
						          	        	<option value="${categoryg.dataid}">${categoryg.dataname}</option>
					            			</c:forEach>
											</select>
										</div>
										<div class="col-xs-2">
					                  		<input type="text" class="form-control" id="scategoryid" name="scategoryid" placeholder="活动分类编号">
										</div>
					                    <div class="col-xs-2">
					                      <input type="text" class="form-control" id="scategoryname" name="scategoryname" placeholder="活动分类名称">
					                    </div>
					                    <div class="col-xs-2">
					                      <input type="text" class="form-control" id="sfid" name="sfid" placeholder="上级分类编号">
					                    </div>
					                 </div>
					                 <br>
					                 <div class="row">
					                    <div class="col-xs-5">
						                   <button type="submit" class="btn btn-primary" onclick="search();">查询</button>
						                   <button type="submit" class="btn btn-primary" onclick="add('1');">新增一级分类</button>
						                   <button type="submit" class="btn btn-primary" onclick="add('2');">新增二级分类</button>
						                   <button type="submit" class="btn btn-primary" onclick="add('3');">新增三级分类</button>
						                </div>
				                  </div>
				                </div>
                               
                               <div class="box-body table-responsive">
                                   <table id="example" class="table table-striped table-bordered">
							        <thead>
							        <tr>
							            <th width="10%">ID</th>
							            <th width="10%">活动分类编号</th>
							            <th width="35%">活动分类名称</th>
							            <th width="20%">等级</th>
							            <th width="10%">上级分类编号</th>
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
            
            <!-- Modal分类1 -->
			<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			    <div class="modal-dialog">
			        <div class="modal-content">
			            <div class="modal-header">
			                <button type="button" class="close" onclick="closeDiv('1');"><span
			                        aria-hidden="true">&times;</span></button>
			                <h4 class="modal-title" id="myModalLabel1">新增</h4>
			            </div>
			            <form id="defaultForm1"  class="form-horizontal">
				            <div class="modal-body">
								 <div class="form-group">
				                	<label class="col-lg-2 control-label">分类名称</label>
		                            <div class="col-lg-5">
				                    	<input type="text" class="form-control" id="categoryname1" name="categoryname1" maxlength="10" >
				                    </div>
					             </div>
				            </div>
				          </form>
				          <div class="modal-footer">
			              	<button type="button" class="btn btn-default" onclick="closeDiv('1');">关闭</button>
			              	<button type="button" class="btn btn-primary" onclick="addcategory('1');">保存</button>
			              </div>
			        </div>
			    </div>
			</div>
			
			<!-- Modal分类2 -->
			<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			    <div class="modal-dialog">
			        <div class="modal-content">
			            <div class="modal-header">
			                <button type="button" class="close" onclick="closeDiv('2');"><span
			                        aria-hidden="true">&times;</span></button>
			                <h4 class="modal-title" id="myModalLabel2">新增</h4>
			            </div>
			            <form id="defaultForm2"  class="form-horizontal">
				            <div class="modal-body">
					             <div class="form-group">
					             	<label class="col-lg-2 control-label">一级分类</label>
			                            <div class="col-lg-5">
					                  		<select class="form-control" id="ocategoryid2" name="ocategoryid2">
					                  		<option value="">请选择一级分类</option>
			                            	
											</select>
										</div>
								 </div>
								 <div class="form-group">
				                	<label class="col-lg-2 control-label">分类名称</label>
		                            <div class="col-lg-5">
				                    	<input type="text" class="form-control" id="categoryname2" name="categoryname2" maxlength="10" >
				                    </div>
					             </div>
				            </div>
				          </form>
				          <div class="modal-footer">
			              	<button type="button" class="btn btn-default" onclick="closeDiv('2');">关闭</button>
			              	<button type="button" class="btn btn-primary" onclick="addcategory('2');">保存</button>
			              </div>
			        </div>
			    </div>
			</div>
			
			<!-- Modal分类3 -->
			<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			    <div class="modal-dialog">
			        <div class="modal-content">
			            <div class="modal-header">
			                <button type="button" class="close" onclick="closeDiv('3');"><span
			                        aria-hidden="true">&times;</span></button>
			                <h4 class="modal-title" id="myModalLabel3">新增</h4>
			            </div>
			            <form id="defaultForm3"  class="form-horizontal">
				            <div class="modal-body">
					             <div class="form-group">
					             	<label class="col-lg-2 control-label">一级分类</label>
			                            <div class="col-lg-5">
					                  		<select class="form-control" id="ocategoryid3" name="ocategoryid3" onchange="getcategorys('2','ocategoryid3','tcategoryid3');">
					                  		<option value="">请选择一级分类</option>
			                            	
											</select>
										</div>
								 </div>
					             <div class="form-group">	
									<label class="col-lg-2 control-label">二级分类</label>
		                            <div class="col-lg-5">
				                  		<select class="form-control" id="tcategoryid3" name="tcategoryid3">
				                  		<option value="">请选择二级分类</option>
		                            	
										</select>
									</div>
								 </div>
								 <div class="form-group">
				                	<label class="col-lg-2 control-label">分类名称</label>
		                            <div class="col-lg-5">
				                    	<input type="text" class="form-control" id="categoryname3" name="categoryname3" maxlength="10" >
				                    </div>
					             </div>
				            </div>
				          </form>
				          <div class="modal-footer">
			              	<button type="button" class="btn btn-default" onclick="closeDiv('3');">关闭</button>
			              	<button type="button" class="btn btn-primary" onclick="addcategory('3');">保存</button>
			              </div>
			        </div>
			    </div>
			</div>
    </body>
</html>