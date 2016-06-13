package com.aula_05_arquidesis.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aula_05_arquidesis.dao.Extrato;
import com.aula_05_arquidesis.model.Conta;
import com.aula_05_arquidesis.model.Movimento;


@WebServlet("/extrato")
public class ExtratoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ExtratoController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Conta conta = (Conta) session.getAttribute("conta");
		
		Extrato extrato = new Extrato();
		
		List<Movimento> movimentos = extrato.consultarExtrato(conta);
		RequestDispatcher rd = request.getRequestDispatcher("/views/atm/extrato.jsp");

		request.setAttribute("movimentos", movimentos);
		
		rd.forward(request, response);
		
	}

}
