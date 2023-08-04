<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link href="assets/dist/css/bootstrap.min.css" rel="stylesheet" />
    <style>
      div {
        font-family: system-ui, -apple-system, BlinkMacSystemFont, "Segoe UI",
          Roboto, Oxygen, Ubuntu, Cantarell, "Open Sans", "Helvetica Neue",
          sans-serif;
        color: #202122;
        direction: ltr;
        font-size: calc(1em * 0.875);
        line-height: 1.6;
      }

      table {
        font-family: system-ui, -apple-system, BlinkMacSystemFont, "Segoe UI",
          Roboto, Oxygen, Ubuntu, Cantarell, "Open Sans", "Helvetica Neue",
          sans-serif;
        direction: ltr;
        line-height: 1.6;
        font-size: 100%;
        background-color: #f8f9fa;
        color: #202122;
        margin: 1em 0;
        border: 1px solid #a2a9b1;
        border-collapse: collapse;
        text-align: center;
      }

      tr {
        font-family: system-ui, -apple-system, BlinkMacSystemFont, "Segoe UI",
          Roboto, Oxygen, Ubuntu, Cantarell, "Open Sans", "Helvetica Neue",
          sans-serif;
        direction: ltr;
        line-height: 1.6;
        font-size: 100%;
        color: #202122;
        border-collapse: collapse;
        text-align: center;
      }

      th {
        font-family: system-ui, -apple-system, BlinkMacSystemFont, "Segoe UI",
          Roboto, Oxygen, Ubuntu, Cantarell, "Open Sans", "Helvetica Neue",
          sans-serif;
        direction: ltr;
        line-height: 1.6;
        font-size: 100%;
        color: #202122;
        border-collapse: collapse;
        border: 1px solid #a2a9b1;
        padding: 0.2em 0.4em;
        background-color: #eaecf0;
        text-align: center;
      }

      td {
        font-family: system-ui, -apple-system, BlinkMacSystemFont, "Segoe UI",
          Roboto, Oxygen, Ubuntu, Cantarell, "Open Sans", "Helvetica Neue",
          sans-serif;
        direction: ltr;
        line-height: 1.6;
        font-size: 100%;
        color: #202122;
        border-collapse: collapse;
        text-align: center;
        border: 1px solid #a2a9b1;
        padding: 0.2em 0.4em;
      }

      .p-right {
        font-family: system-ui, -apple-system, BlinkMacSystemFont, "Segoe UI",
          Roboto, Oxygen, Ubuntu, Cantarell, "Open Sans", "Helvetica Neue",
          sans-serif;
        direction: ltr;
        line-height: 1.6;
        font-size: 100%;
        color: #202122;
        border-collapse: collapse;
        text-align: right;
        margin: 0.5em 0;
      }

      .p-left {
        font-family: system-ui, -apple-system, BlinkMacSystemFont, "Segoe UI",
          Roboto, Oxygen, Ubuntu, Cantarell, "Open Sans", "Helvetica Neue",
          sans-serif;
        direction: ltr;
        line-height: 1.6;
        font-size: 100%;
        color: #202122;
        border-collapse: collapse;
        text-align: left;
        margin: 0.5em 0;
      }

      p {
        font-family: system-ui, -apple-system, BlinkMacSystemFont, "Segoe UI",
          Roboto, Oxygen, Ubuntu, Cantarell, "Open Sans", "Helvetica Neue",
          sans-serif;
        direction: ltr;
        line-height: 1.6;
        font-size: 100%;
        color: #202122;
        border-collapse: collapse;
        text-align: center;
        margin: 0.5em 0;
      }

      textarea {
        font-family: system-ui, -apple-system, BlinkMacSystemFont, "Segoe UI",
          Roboto, Oxygen, Ubuntu, Cantarell, "Open Sans", "Helvetica Neue",
          sans-serif;
        width: 95%;
        height: 100px;
        resize: none;
      }
    </style>
  </head>

  <body>
    <div style="width: 100%; margin: auto">
      <form id="theForm">
        <!-- table start -->
        <table style="width: 95%">
          <tr>
            <th colspan="6">
              <p>Step 1 : 2개의 수를 입력 받아 더하기를 하시오.</p>
            </th>
          </tr>
          <tr>
            <td>
              <p>질문</p>
            </td>
            <td>
              <p style="text-align: center">
                <input
                  type="text"
                  class="form-control"
                  maxlength="100"
                  name="first"
                  id="first"
                  onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"
                />
              </p>
            </td>
            <td>
              &nbsp&nbsp
              <select name="op">
                <option value="+" selected>+</option>
                <option value="-">-</option>
                <option value="*">*</option>
                <option value="/">/</option>
                <option value="%">%</option>
              </select>
              &nbsp&nbsp
            </td>
            <td>
              <p style="text-align: center">
                <input
                  type="text"
                  class="form-control"
                  maxlength="100"
                  name="second"
                  id="second" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"
                />
              </p>
            </td>
            <td>
              <p>
                <button type="button" class="btn btn-primary" id="buttonSubmit">
                  POST방식으로 요청 보내기!
                </button>
              </p>
            </td>
          </tr>
        </table>

        <!-- table end -->
      </form>
      <div id="ajaxResult"></div>
    </div>
  </body>
  <script
    src="https://code.jquery.com/jquery-3.6.0.min.js"
    integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
    crossorigin="anonymous"
  ></script>
  <!--jQuery 불러오기-->

  <script>
    $(document).ready(function () {
      $("#buttonSubmit").on("click", function () {
        // 제출 버튼 이벤트 지정
        if (vali($("#first").val())) {
          alert("first null");
          return;
        }
        if (vali($("#second").val())) {
          alert("second null");
          return;
        }
        $.ajax({
          url: "./FourOperations", // 목적지
          type: "POST", // HTTP Method
          data: $("#theForm").serialize(), // 전송 데이터
          dataType: "json", // 전송 데이터 형식
          success: function (res) {
            // 성공 시 실행
            var innerHtml =
              "<table style='width: 95%'><tr><th style='width: 25%'>계산 결과</th><td style='width: 50%'><span id='firstNumber'>" +
              addComma(res.firstNumber) +
              "</span> <span id='op'>" +
              res.op +
              " </span> <span id='secondNumber'>" +
              addComma(res.secondNumber) +
              "</span> <span> =</span> <span id='numPlus'>" +
              addComma(res.numPlus) +
              "</span></td><td style='width: 25%'><span id='code'>" +
              res.code +
              "</span></td></tr></table>";

            $("#ajaxResult").html(innerHtml);
          },
          error: function (er) {
            //실패 시 실행
            alert("실패 원인 : " + er);
          },
        });
      });
    });

    
    function vali(value) {
      if (
        value == "" ||
        value == null ||
        value == undefined ||
        (value != null &&
          typeof value == "object" &&
          !Object.keys(value).length)
      ) {
        return true;
      } else {
        return false;
      }
    }
    
    function addComma(data) {
        return data.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    }
  </script>
</html>
