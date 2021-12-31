<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="../css/all_style.css?ver=2" rel="stylesheet">
<link rel="stylesheet"
   href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
   type="text/css" />
<script
   src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link href="../css/all_style.css?ver=10" rel="stylesheet">
<div class="all">

   <%@ include file="../include/header.jsp"%>

   <div class="navigation_pro">
      <div class="navi">
         <ul>
            <li><a href="/Turkey/pro_view">정보 조회</a></li>
            <li style="background-color: #FFF;"><a href="/Turkey/pro_class" style="color: #CC3D3D;">강의 관리</a></li>
            <li><a href="/Turkey/pro_student">학생 관리</a></li>
            <li><a href="/Turkey/illjung_list2">학사일정</a></li>
         </ul>
      </div>
   </div>

   <div class="contents">
         <div class="contents_inform_view">
            <div class="contents_inform_view_detail">
               <div class="pro_detail_search">
                  
               </div>
               <div class="pro_detail_forth">
                  <input type="hidden" name="majorcode" value="${sub.major_code}">
         <input type="hidden" name="subcode" value="${sub.sub_code}">
         <table>
            <tr align="center">
               <th colspan="18">${sub.year}년${sub.semester}학기 | ${sub.major_code}-${sub.sub_code} | ${sub.sub_name} | ${day } | C=출석, L=지각, A=결석</th>
            </tr>
            <tr>
               <th>학번</th>
               <th>이름</th>
               <th>1</th>
               <th>2</th>
               <th>3</th>
               <th>4</th>
               <th>5</th>
               <th>6</th>
               <th>7</th>
               <th>8</th>
               <th>9</th>
               <th>10</th>
               <th>11</th>
               <th>12</th>
               <th>13</th>
               <th>14</th>
               <th>15</th>
               <th>확인</th>
            </tr>
            <c:forEach var="stuAtt" items="${list }">
               <tr>
                  <td>${stuAtt.stu_code }</td>
                  <td style="width:100px;">${stuAtt.stu_name }</td>
                  <td><input type="text" size="1" name="${stuAtt.stu_code}w1"
                     value="${stuAtt.week1 }" style="width:15px;"></td>
                  <td><input type="text" size="1" name="${stuAtt.stu_code}w2"
                     value="${stuAtt.week2 }" style="width:15px;"></td>
                  <td><input type="text" size="1" name="${stuAtt.stu_code}w3"
                     value="${stuAtt.week3 }" style="width:15px;"></td>
                  <td><input type="text" size="1" name="${stuAtt.stu_code}w4"
                     value="${stuAtt.week4 }" style="width:15px;"></td>
                  <td><input type="text" size="1" name="${stuAtt.stu_code}w5"
                     value="${stuAtt.week5 }" style="width:15px;"></td>
                  <td><input type="text" size="1" name="${stuAtt.stu_code}w6"
                     value="${stuAtt.week6 }" style="width:15px;"></td>
                  <td><input type="text" size="1" name="${stuAtt.stu_code}w7"
                     value="${stuAtt.week7 }" style="width:15px;"></td>
                  <td><input type="text" size="1" name="${stuAtt.stu_code}w8"
                     value="${stuAtt.week8 }" style="width:15px;"></td>
                  <td><input type="text" size="1" name="${stuAtt.stu_code}w9"
                     value="${stuAtt.week9 }" style="width:15px;"></td>
                  <td><input type="text" size="1" name="${stuAtt.stu_code}w10"
                     value="${stuAtt.week10 }" style="width:15px;"></td>
                  <td><input type="text" size="1" name="${stuAtt.stu_code}w11"
                     value="${stuAtt.week11 }" style="width:15px;"></td>
                  <td><input type="text" size="1" name="${stuAtt.stu_code}w12"
                     value="${stuAtt.week12 }" style="width:15px;"></td>
                  <td><input type="text" size="1" name="${stuAtt.stu_code}w13"
                     value="${stuAtt.week13 }" style="width:15px;"></td>
                  <td><input type="text" size="1" name="${stuAtt.stu_code}w14"
                     value="${stuAtt.week14 }" style="width:15px;"></td>
                  <td><input type="text" size="1" name="${stuAtt.stu_code}w15"
                     value="${stuAtt.week15 }" style="width:15px;"></td>
                  <td><input type="button" value="확인"
                     onclick="attCheck('${stuAtt.stu_code}','${stuAtt.att_time}');"></td>
               </tr>
            </c:forEach>
         </table>
               </div>
            </div>
         </div>
      </div>
      
   <%@ include file="../include/footer.jsp"%>
</div>

<script>
   function attCheck(stucode, attTime) {
      var obj = new Object();
      obj.stu_code = stucode;
      obj.att_time = attTime;
      obj.year = ${sub.year};
      obj.semester = ${sub.semester};
      obj.major_code = $('input[name=majorcode]').val();
      obj.sub_code = $('input[name=subcode]').val();
      obj.week1 = $('input[name=' + stucode + 'w1]').val();
      obj.week2 = $('input[name=' + stucode + 'w2]').val();
      obj.week3 = $('input[name=' + stucode + 'w3]').val();
      obj.week4 = $('input[name=' + stucode + 'w4]').val();
      obj.week5 = $('input[name=' + stucode + 'w5]').val();
      obj.week6 = $('input[name=' + stucode + 'w6]').val();
      obj.week7 = $('input[name=' + stucode + 'w7]').val();
      obj.week8 = $('input[name=' + stucode + 'w8]').val();
      obj.week9 = $('input[name=' + stucode + 'w9]').val();
      obj.week10 = $('input[name=' + stucode + 'w10]').val();
      obj.week11 = $('input[name=' + stucode + 'w11]').val();
      obj.week12 = $('input[name=' + stucode + 'w12]').val();
      obj.week13 = $('input[name=' + stucode + 'w13]').val();
      obj.week14 = $('input[name=' + stucode + 'w14]').val();
      obj.week15 = $('input[name=' + stucode + 'w15]').val();
      $.ajax({
         url : "attCheck",
         type : "POST",
         dataType : "json",
         contentType : "application/json",
         data : JSON.stringify(obj),
         success : function(data) {
         }
      })
   };
</script>