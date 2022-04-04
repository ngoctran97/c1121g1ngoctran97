<%--
  Created by IntelliJ IDEA.
  User: tranvantrong
  Date: 31/03/2022
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>TỜ KHAI Y TẾ</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
          integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
          crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
          integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
          crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
          integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
          crossorigin="anonymous"></script>
</head>
<body>

<div class="container">
  <div class="row">
    <div class="col-12 text-center">
      <h3>TỜ KHAI Y TẾ</h3>
    </div>
    <div class="col-12 text-center">
      <h5>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG
        CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</h5>
    </div>
    <div class="col-12 text-center text-danger">
      <h5>Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể bị xử lý hình sự</h5>
    </div>
    <div class="col-12 mt-4">
      <form:form method="post" action="/save" modelAttribute="medican">
        <form:input type="hidden" path="id" />
        <div class="form-group ">
          <label>Họ tên (ghi chữ IN HOA) <span class="text-danger">(*)</span> </label>
          <form:input type="text" class="form-control" aria-describedby="fullNameError" path="name"/>
          <small id="fullNameError" class="form-text text-danger"></small>
        </div>
        <div class="form-group row">
          <div class="col-4">
            <label>Năm sinh <span class="text-danger">(*)</span> </label>
            <form:input type="date" class="form-control" aria-describedby="birthError" path="dateOFBirth"/>
            <small id="birthError" class="form-text text-danger"></small>
          </div>
          <div class="col-4">
            <label>Giới tính <span class="text-danger">(*)</span> </label>
            <form:select class="custom-select" path="gender" aria-describedby="genderError"
                         items="${genderArray}">
            </form:select>
            <small id="genderError" class="form-text text-danger"></small>
          </div>
          <div class="col-4">
            <label>Quốc tịch <span class="text-danger">(*)</span> </label>
            <form:input type="text" class="form-control" aria-describedby="nationalityError"
                        path="nationality"/>
            <small id="nationalityError" class="form-text text-danger"></small>
          </div>
        </div>
        <div class="form-group ">
          <label>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác
            <span class="text-danger">(*)</span> </label>
          <form:input type="text" class="form-control" aria-describedby="idCardNumberError"
                      path="idCard"/>
          <small id="idCardNumberError" class="form-text text-danger"></small>
        </div>
        <div class="form-group">
          <label>Thông tin đi lại <span class="text-danger">(*)</span> </label>
          <div class="row">
            <div class="form-check form-check-inline">
              <form:radiobuttons class="form-control" aria-describedby="vehicle" path="vehicle"/>
              <label class="form-check-label" path="travelInfo"></label>
            </div>
          </div>
          <small id="travelInfoError" class="form-text text-danger"></small>
        </div>
        <div class="form-group row">
          <div class="col-6">
            <label>Số hiệu phương tiện</label>
            <form:input path="vehicleNumber" type="text" class="form-control"/>
          </div>
          <div class="col-6">
            <label>Số ghế</label>
            <form:input type="text" class="form-control" path="chairNumber"/>
          </div>
        </div>
        <div class="form-group row">
          <div class="col-6">
            <div class="row">
              <div class="col-3">
                <label>Ngày khởi hành <span class="text-danger">(*)</span> </label>
              </div>
              <div class="col-9">
                <form:input type="date" class="form-control" aria-describedby="startDayError"
                            path="departureDay"/>
              </div>
            </div>
            <small id="startDayError" class="form-text text-danger"></small>
          </div>
          <div class="col-6">
            <div class="row">
              <div class="col-3">
                <label>Ngày kết thúc <span class="text-danger">(*)</span> </label>
              </div>
              <div class="col-9">
                <form:input type="date" class="form-control" aria-describedby="endDayError"
                            path="endDay"/>
              </div>
            </div>
            <small id="endDayError" class="form-text text-danger"></small>
          </div>
        </div>
        <div class="form-group ">
          <label>Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào?
            <span class="text-danger">(*)</span> </label>
          <form:input type="text" class="form-control" aria-describedby="cityIn14dayError"
                      path="cityUsedToPass"/>
          <small id="cityIn14dayError" class="form-text text-danger"></small>
        </div>
        <div class="form-group ">
          <label>Địa chỉ liên lạc <span class="text-danger">(*)</span> </label>
          <form:input type="text" class="form-control" aria-describedby="addressError" path="address"/>
          <small id="addressError" class="form-text text-danger"></small>
        </div>
        <div class="form-group row">
          <div class="col-6">
            <label>Điện thoại <span class="text-danger">(*)</span> </label>
            <form:input type="text" class="form-control" aria-describedby="phoneError" path="phoneNumber"/>
            <small id="phoneError" class="form-text text-danger"></small>
          </div>
          <div class="col-6">
            <label path="email">Email</label>
            <form:input type="text" class="form-control" path="email"/>
          </div>
        </div>

        <div class="col-12 text-danger">
          <p>Dữ liệu bạn cung cấp hoàn toàn bảo mật và chỉ phục vụ cho việc phòng chống dịch, thuộc quản lý
            của Ban chỉ đạo quốc gia về phòng chống dịch Covid-19. Khi bạn nhấn nút "Gửi" là bạn đã hiểu và
            đồng ý.</p>
        </div>
        <button type="submit" class="btn btn-primary">Gửi tờ khai</button>
      </form:form>
    </div>
  </div>
</div>
</body>
</html>
