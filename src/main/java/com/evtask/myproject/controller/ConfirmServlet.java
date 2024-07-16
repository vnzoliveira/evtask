package com.evtask.myproject.controller;

import com.evtask.myproject.entities.CreditCard;
import com.evtask.myproject.entities.exception.CVVException;
import com.evtask.myproject.entities.exception.ExpiryDateException;
import com.evtask.myproject.entities.exception.InvalidCardException;
import com.evtask.myproject.util.Util;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//@WebServlet("/confirm")
public class ConfirmServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     * @param request an {@link HttpServletRequest} object that contains the request the client has made of the servlet
     *
     * @param response an {@link HttpServletResponse} object that contains the response the servlet sends to the client
     *
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        cleanSessions(request);
        CreditCard creditCard = new CreditCard();
        Util util = new Util();
        creditCard.setCardNum(request.getParameter("cardNum"));
        creditCard.setCvv(request.getParameter("cvv"));
        creditCard.setExpirationDateString(util.formatExpiryDate(request.getParameter("expiry-date")));
        boolean success;
        boolean cardNumCheck = false;
        boolean lastDigitCheck = false;
        boolean CvvCheck = false;
        boolean ExpiryDateCheck = false;
        try {
            cardNumCheck = creditCard.verifyPanNumber();
            if(cardNumCheck){
                lastDigitCheck = creditCard.CardNumDigitCheck();
            }
        }
        catch (InvalidCardException e){
            request.getSession().setAttribute("InvalidCardMessage", e.getMessage());
        }
        try{
            CvvCheck = creditCard.isCvvCorrect();
        }
        catch (CVVException e){
            request.getSession().setAttribute("cvvErrorMessage", e.getMessage());
        }
        try {
            ExpiryDateCheck = creditCard.isExpiryDateValid();
        }
        catch (ExpiryDateException e){
            request.getSession().setAttribute("InvalidExpiryDateMessage", e.getMessage());
        }
        success = cardNumCheck && CvvCheck && ExpiryDateCheck && lastDigitCheck;
        if (success){
            request.getRequestDispatcher("/success.jsp").forward(request,response);
        }
        else{
            //request.getRequestDispatcher("/index.jsp").forward(request,response);
            response.sendRedirect("index.jsp");
        }
    }

    /**
     *
     * @param request an {@link HttpServletRequest} original request from doPost, to better organize code.
     */
    private void cleanSessions(HttpServletRequest request){
        request.getSession().removeAttribute("InvalidCardMessage");
        request.getSession().removeAttribute("cvvErrorMessage");
        request.getSession().removeAttribute("InvalidExpiryDateMessage");
    }
}
