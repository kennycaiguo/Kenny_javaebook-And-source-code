# ebooks-javaebook
java 电子书，有一些大的必须要用WinRAR压缩成多个.rar文件分批上传

## 
访问JSP页面报错According to TLD or attribute directive in tag file, attribute value does not accept

fysuccess 2017-10-26 16:31:03  1840  收藏 1
展开
访问JSP页面jstl表达式使用错误，详细错误如下：

org.apache.jasper.JasperException: /WEB-INF/views/show.jsp (line: 46, column: 28) According to TLD or attribute directive in tag file, attribute value does not accept any expressions
    org.apache.jasper.compiler.DefaultErrorHandler.jspError(DefaultErrorHandler.java:42)
    org.apache.jasper.compiler.ErrorDispatcher.dispatch(ErrorDispatcher.java:443)
    org.apache.jasper.compiler.ErrorDispatcher.jspError(ErrorDispatcher.java:149)
    org.apache.jasper.compiler.Validator$ValidateVisitor.checkXmlAttributes(Validator.java:1241)
    org.apache.jasper.compiler.Validator$ValidateVisitor.visit(Validator.java:876)
    org.apache.jasper.compiler.Node$CustomTag.accept(Node.java:1553)
    org.apache.jasper.compiler.Node$Nodes.visit(Node.java:2392)
    org.apache.jasper.compiler.Node$Visitor.visitBody(Node.java:2444)
    org.apache.jasper.compiler.Node$Visitor.visit(Node.java:2450)
    org.apache.jasper.compiler.Node$Root.accept(Node.java:474)
    org.apache.jasper.compiler.Node$Nodes.visit(Node.java:2392)
    org.apache.jasper.compiler.Validator.validateExDirectives(Validator.java:1845)
    org.apache.jasper.compiler.Compiler.generateJava(Compiler.java:218)
    org.apache.jasper.compiler.Compiler.compile(Compiler.java:374)
    org.apache.jasper.compiler.Compiler.compile(Compiler.java:354)
    org.apache.jasper.compiler.Compiler.compile(Compiler.java:341)
    org.apache.jasper.JspCompilationContext.compile(JspCompilationContext.java:657)
    org.apache.jasper.servlet.JspServletWrapper.service(JspServletWrapper.java:357)
    org.apache.jasper.servlet.JspServlet.serviceJspFile(JspServlet.java:395)
    org.apache.jasper.servlet.JspServlet.service(JspServlet.java:339)
    javax.servlet.http.HttpServlet.service(HttpServlet.java:727)
    org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
    org.springframework.web.servlet.view.InternalResourceView.renderMergedOutputModel(InternalResourceView.java:168)
    org.springframework.web.servlet.view.AbstractView.render(AbstractView.java:303)
    org.springframework.web.servlet.DispatcherServlet.render(DispatcherServlet.java:1228)
    org.springframework.web.servlet.DispatcherServlet.processDispatchResult(DispatcherServlet.java:1011)
    org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:955)
    org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:877)
    org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:966)
    org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:857)
    javax.servlet.http.HttpServlet.service(HttpServlet.java:620)
    org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:842)
    javax.servlet.http.HttpServlet.service(HttpServlet.java:727)
    org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
    org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:88)
    org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107)
 
出现上述错误的原因是，在JSP页面使用了fmt标签库
原因：

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
//使用了日期格式化方法
<fmt:formatDate pattern="yyyy-MM-dd" value="${user.birthday}" />
 
出现错误的原因是使用的是jstl1.2,在jstl1.0和jstp1.1、jstl1.2版本在使用标签库的时候存在一定的差别，在jstl1.0以后的版本uri都应该加上/jsp,引用方法如下：
解决方法一：（推荐）

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
//使用了日期格式化方法
<fmt:formatDate pattern="yyyy-MM-dd" value="${user.birthday}" />
 
解决方法二：
修改web.xml和jstl库版本

//修改2.3以上版本为2.3及以下版本版本
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
         id="myweb" version="3.0">
 
