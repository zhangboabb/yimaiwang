
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="menu_bg">
    <div class="menu">
        <!--Begin 商品分类详情 Begin-->
        <div class="nav">
            <div class="nav_t">全部商品分类</div>
            <div class="leftNav ">
             <%@include file="/front/pages_common/productBars.jsp"%>
            </div>
        </div>
        <!--End 商品分类详情 End-->
        <ul class="menu_r">
            <li><a href="Index.html">首页</a></li>
            <c:forEach var="category" items="${categoryList}">
                <li>
                    <a href="${ctx}/product?action=queryProducts&categoryId=${category.productCategory.id}">${category.productCategory.name}</a>
                </li>
            </c:forEach>
        </ul>
        <div class="m_ad">中秋送好礼！</div>
    </div>
</div>