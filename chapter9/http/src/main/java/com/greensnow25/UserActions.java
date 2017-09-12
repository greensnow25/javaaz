//package com.greensnow25;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Public class UserActions.
// *
// * @author greensnow25.
// * @version 1.
// * @since 11.09.2017.
// */
//@WebServlet(
//        urlPatterns = "/userAction"
//)
//public class UserActions extends HttpServlet {
//    private List<HttpServlet> list;
//
////    @Override
////    public void init() throws ServletException {
////        super.init();
////        this.list = new ArrayList<>();
////    }
////    public void addUsersOper(HttpServlet servlet){
////
////    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        this.queryAnalysis(req,resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//
//    }
//    public void queryAnalysis(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String crud = req.getParameter("operation");
//        if(crud.equals("add")){
//            req.getRequestDispatcher("/user").forward(req,resp);
//        }
//    }
//}
