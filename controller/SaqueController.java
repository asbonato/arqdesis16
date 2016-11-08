package com.aula_05_arquidesis.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aula_05_arquidesis.model.Cliente;
import com.aula_05_arquidesis.model.Conta;
import com.aula_05_arquidesis.model.Movimento;
import com.aula_05_arquidesis.model.Saque;


@WebServlet("/saque")
public class SaqueController extends HttpServlet {
	private static final long serialVersionUID = -693643946391L;
	private final String OPTIONS = "/views/atm/options.jsp";
	private final String ERROR = "/views/atm/error.jsp";
	private final String SAQUE = "SAQUE";

	public SaqueController() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean sucesso = false;
		String nextJSP = null;
		try {
			double valor = Double.parseDouble(request.getParameter("valor"));
			HttpSession session = request.getSession(true);
			Conta conta = (Conta) session.getAttribute("conta");
			Cliente cliente = (Cliente) session.getAttribute("cliente");
			Movimento movimento = new Movimento(valor,SAQUE);
			Saque saque = new Saque(valor,SAQUE);
			double saldo = conta.consultarSaldo();
			
			if (saldo >= saque.getValorOperacao()) {
				sucesso = saque.fazerSaque();
				conta.setSaldo(saldo - saque.getValorOperacao());
				int b = conta.atualizarSaldo();
				if (b > 0) {
					movimento.incluirMovimento(movimento, conta, cliente);
				}
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("sucesso", sucesso);
		
		getServletContext().getRequestDispatcher((null == nextJSP) ? OPTIONS : nextJSP).forward(request, response);
	}

}
