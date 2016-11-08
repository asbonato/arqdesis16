package com.aula_05_arquidesis.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aula_05_arquidesis.model.Acesso;
import com.aula_05_arquidesis.model.Cliente;
import com.aula_05_arquidesis.model.Conta;


@WebServlet("/authentication")
public class AuthenticationController extends HttpServlet {
	private static final long serialVersionUID = -63429846343629L;
	
	private final String ERROR = "/views/atm/error.jsp";
	private final String LOGIN_FAILED = "/views/atm/authentication/loginFailed.jsp";
	private final String OPTIONS = "/views/atm/options.jsp";


	public AuthenticationController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Cliente cliente = null;
		String nextJSP;
		try {
			final int AGENCIA = Integer.parseInt(request.getParameter("agencia"));
			final int CONTA = Integer.parseInt(request.getParameter("conta"));
			final int SENHA = Integer.parseInt(request.getParameter("senha"));
			
			Acesso acesso = new Acesso();
			Conta conta = new Conta(AGENCIA, CONTA, SENHA);
			if (acesso.validarAcesso(conta)) {
				cliente = acesso.consultarCliente(conta);
				
				if(cliente != null){
					HttpSession session = request.getSession(true);
					session.setAttribute("cliente", cliente);
					session.setAttribute("conta", conta);
				}
				
				request.setAttribute("cliente", cliente);
				request.setAttribute("conta", conta);
				nextJSP = OPTIONS;
				
			}else{
				nextJSP = LOGIN_FAILED;
			}

		} catch (Exception e) {
			nextJSP = ERROR;
		}

		

		getServletContext().getRequestDispatcher(nextJSP).forward(request, response);
	}

}
