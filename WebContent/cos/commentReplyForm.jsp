<%--
  Created by IntelliJ IDEA.
  User: byeon
  Date: 2021-10-21
  Time: 오후 8:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title> 댓글 답변 </title>

    <style type="text/css">
        #wrap {
            width: 550px;
            margin: 0 auto 0 auto;
            text-align :center;
        }

        #commentReplyForm{
            text-align :center;
        }
    </style>
    <script src="comment.js"></script>

</head>
<body>
<div id="wrap">
    <br>
    <b><font size="5" color="gray">댓글 답변</font></b>
    <hr size="1" width="550">
    <br>

    <div id="commentReplyForm">
        <form name="replyInfo" target="parentForm">
            <textarea rows="7" cols="70" name="comment_content"></textarea>
            <br><br>
            <input type="button" value="등록" onclick="checkValue()">
            <input type="button" value="창닫기" onclick="window.close()">
        </form>
    </div>
</div>
</body>
</html>


