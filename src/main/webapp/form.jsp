<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="data.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style type="text/css">
        /*Селектор по классу*/
        .mainTable {
            width: 100%;
            text-align: center;
            border: solid;
            table-layout: fixed;
            border-collapse: collapse;
        }
        /*Селектор атрибутов*/
        [colspan] {
            border-bottom: 1px solid gray;
            margin-bottom: 5%;
            background-color: antiquewhite;
            font-size: large;
            color: brown;
            font-family: monospace;
        }
        /*Наследование*/
        body {
            /* Каскадирование */
            background-color: aquamarine;
        }
        form {
            padding-bottom: 5%;
            font-size: 16px;
        }
        .inputRow td {
            /* каскадирование */
            background-color: aliceblue;
            padding-bottom: 9%;
        }
        /*Селектор типу элемента*/
        th {
            background-color: aliceblue;
            padding-top: 5%;
            padding-bottom: 2%;
        }
        /*Дочерний селектор*/
        .bottom > td {
            border-top: 1px solid gray;
            padding-bottom: 0.4%;
            background-color: antiquewhite;
        }
        /*Селектор псевдоэлемента*/
        a::after {
            content: "→";
        }
        /*Селектор псевдокласса*/
        a:hover {
            opacity: .5;
        }

        .input {
            margin-bottom: 5%;
        }
        #canv{
            width: 400px;
            height: 300px;
            border: 1px solid black;
            background-color: white;
        }
        #table1 {
            width: 30%;
            margin-left: auto;
            margin-right: auto;
        }

    </style>
</head>
<body>
<table class="mainTable">
    <!-- Шапка -->
    <tr>
        <td colspan="3">
            <h3>Tuchin Artem<br>Group P32111 <br>Variant 815</h3>
        </td>
    </tr>
    <tr>
        <!-- Заголовки -->
        <th>Graph</th>
        <th>Coordinates</th>
        <th>Table</th>
    </tr>
    <tr class="inputRow">
        <!-- График -->
        <td>
            <canvas id="canv" width="400px" height="300px"></canvas>
        </td>
        <script type="text/javascript">
            <%@include file="/scripts/draw.js"%>
        </script>
        <script type="text/javascript">
            <%@include file="/scripts/checker.js"%>
        </script>
        <!-- Форма -->
        <td><form action="" method="get" onsubmit="return checkForm(this)">
            <!-- Поле ввода координаты Х -->
            <div class="input">
                <label>X: </label>
                <br>
                <input type="radio" id="radio1" name="x"  value="-5" >
                <label for="radio1">-5</label>
                <br>
                <input type="radio" id="radio2" name="x" value="-4">
                <label for="radio2">-4</label>
                <br>
                <input type="radio" id="radio3" name="x" value="-3">
                <label for="radio3">-3</label>
                <br>
                <input type="radio" id="radio4" name="x" value="-2">
                <label for="radio4">-2</label>
                <br>
                <input type="radio" id="radio5" name="x" value="-1">
                <label for="radio5">-1</label>
                <br>
                <input type="radio" id="radio6" name="x" value="0">
                <label for="radio6">0</label>
                <br>
                <input type="radio" id="radio7" name="x" value="1">
                <label for="radio7">1</label>
                <br>
                <input type="radio" id="radio8" name="x" value="2">
                <label for="radio8">2</label>
                <br>
                <input type="radio" id="radio9" name="x" value="3">
                <label for="radio9">3</label>
                <div id="xError"></div>
            </div>

            <br>
            <!-- Поле ввода координаты Y -->
            <div class="input">
                <label for="textY">Y: </label>
                <input type="text" name="y" placeholder="From -3 to 3" id="textY">
                <div id="yError"></div>
            </div>
            <!-- Поле ввода параметра R -->
            <div class="input">
                <label>R: </label>
                <input type="checkbox" id="check1" name="r" value="1" onclick="checkOnlyOne(this.value);" class="param">
                <label for="check1">1</label>
                <input type="checkbox" id="check2" name="r" value="1.5" onclick="checkOnlyOne(this.value);" class="param">
                <label for="check1">1.5</label>
                <input type="checkbox" id="check3" name="r" value="2" onclick="checkOnlyOne(this.value);" class="param">
                <label for="check1">2</label>
                <input type="checkbox" id="check4" name="r" value="2.5" onclick="checkOnlyOne(this.value);" class="param">
                <label for="check1">2.5</label>
                <input type="checkbox" id="check5" name="r" value="3" onclick="checkOnlyOne(this.value);" class="param">
                <label for="check1">3</label>
                <div id="rError"></div>
            </div>
<%--            <input type="text" hidden name="time">--%>
            <!-- Кнопка подтверждения -->
            <input type="submit" value="Submit">
        </form>
        </td>
        <td>
            <table id="table1">
                <tr>
                    <th>X</th>
                    <th>Y</th>
                    <th>R</th>
                    <th>Hit</th>
                </tr>
<%--                <% try {--%>
<%--                    DataConteiner dataConteiner = (DataConteiner) request.getServletContext().getAttribute("table");--%>
<%--                if (dataConteiner.getSize()>0) {%>--%>
                <script>draw()</script>
                <script>getData()</script>
<%--                <%for (int i=0;i<dataConteiner.getSize();i++) { %>--%>
<%--                <script>drawDot(<%=dataConteiner.getData(i).getX()%>,<%=dataConteiner.getData(i).getY()%>,<%=dataConteiner.getData(i).getHit()%>)</script>--%>
<%--                    <tr>--%>
<%--                        <td><%=dataConteiner.getData(i).getX()%></td>--%>
<%--                        <td><%=dataConteiner.getData(i).getY()%></td>--%>
<%--                        <td><%=dataConteiner.getData(i).getR()%></td>--%>
<%--                        <td><%=dataConteiner.getData(i).getHit()%></td>--%>
<%--                    </tr>--%>
<%--                <%--%>
<%--                    }%>--%>
<%--                <%}else {%>--%>
<%--                <script>draw();</script>--%>
<%--                <%}--%>
<%--                    }catch (NullPointerException e) {%>--%>
<%--                <script>draw();</script>--%>
<%--                    <%}%>--%>
            </table>
        </td>
    </tr>
    <!-- Футер -->
    <tr class="bottom">
        <td></td><td>Saint-Petersburg 2022</td><td></td>
    </tr>
</table>
<!-- Подключение скрипта проверки формы -->
<script>addEventListenerToCanvas();</script>

<%--<script>--%>
<%--    draw();--%>
<%--    drawDot();--%>
<%--</script>--%>
</body>
</html>