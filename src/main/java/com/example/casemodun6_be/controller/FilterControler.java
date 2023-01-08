//package com.example.casemodun6_be.controller;
//
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//@Order(1)
//public class FilterControler implements Filter {
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response,
//                         FilterChain chain)
//        throws IOException, ServletException{
//        System.out.println("filter controler");
//        HttpServletRequest req = (HttpServletRequest) request;
//        if(req.getMethod().equals("GET")){
//            chain.doFilter(request,response);
//        }else{
//            ((HttpServletResponse) response).setStatus(900);
//            response.getOutputStream().write("ngu vcl luon".getBytes());
//        }
//    }
//}