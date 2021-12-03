package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Caixa;
import model.DAO;
import model.Pessoa;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "/Controller", "/main", "/login", "/saque", "/sacar", "/conta", "/sair", "/loginabastecer",
		"/abastecer", "/adicionar", "/abastecimento", "/cadastro", "/cadastrar", "/alteraconta" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Caixa caixa = new Caixa();
	Pessoa login = new Pessoa();
	DAO dao = new DAO();

	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		//System.out.println(action);
		if (action.equals("/main")) {
			response.sendRedirect("login.html");
		} else if (action.equals("/login")) {
			if (login.getNome() == null) {
				login(request, response);
			} else {
				voltar(request, response);
			}
		} else if (action.equals("/saque")) {
			saque(request, response);
		} else if (action.equals("/sacar")) {
			sacar(request, response);
		} else if (action.equals("/sair")) {
			sair(request, response);
		} else if (action.equals("/loginabastecer")) {
			response.sendRedirect("abastecer.html");
		} else if (action.equals("/abastecer")) {
			abastecer(request, response);
		} else if (action.equals("/adicionar")) {
			abastecimento(request, response);
		} else if (action.equals("/abastecimento")) {
			adicionar(request, response);
		} else if (action.equals("/cadastro")) {
			response.sendRedirect("cadastro.html");
		}else if (action.equals("/cadastrar")) {
			cadastrar(request, response);
		}else if (action.equals("/conta")) {
			conta(request, response);
		}else if (action.equals("/alteraconta")) {
			alteraconta(request, response);
		}else {
			response.sendRedirect("index.html");
		}
	}
	protected void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		login.setNome(request.getParameter("nome"));
		login.setConta(request.getParameter("conta"));
		login.setSenha(request.getParameter("senha"));
		dao.cadastraUsuario(login);
		response.sendRedirect("sair");
		}
	protected void alteraconta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		login.setNome(request.getParameter("nome"));
		login.setConta(request.getParameter("conta"));
		login.setSenha(request.getParameter("senha"));
		dao.atualizaUsuario(login);
		response.sendRedirect("sair");
		
	}
	protected void conta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("pessoa", login);
		RequestDispatcher rd = request.getRequestDispatcher("menuConta.jsp");
		rd.forward(request, response);
		response.sendRedirect("menuConta.jsp");
	}
	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		login.setConta(request.getParameter("conta"));
		login.setSenha(request.getParameter("senha"));
		dao.confereLogin(login);
		if (login.getConta() == "" && login.getSenha() == "") {
			response.sendRedirect("senhaIncorreta.html");
		} else {
			request.setAttribute("pessoa", login);
			RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
			rd.forward(request, response);
			response.sendRedirect("menu.jsp");
		}
	}

	protected void abastecer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		login.setConta(request.getParameter("conta"));
		login.setSenha(request.getParameter("senha"));
		dao.confereAbastecer(login);
		dao.setaCaixa(caixa);
		try {
			if (login.getNome().equals("Abastecer")) {
				request.setAttribute("caixa", caixa);
				RequestDispatcher rd = request.getRequestDispatcher("menuAbastecer.jsp");
				rd.forward(request, response);
				response.sendRedirect("menuAbastecer.jsp");
			}
		} catch (Exception e) {
			response.sendRedirect("incorretoAbastecimento.html");
		}
	}

	protected void adicionar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!request.getParameter("notas10").equals("")) {
			int notas10 = Integer.parseInt(request.getParameter("notas10"));
			caixa.setNotas10(caixa.getNotas10() + notas10);
		}
		if (!request.getParameter("notas20").equals("")) {
			int notas20 = Integer.parseInt(request.getParameter("notas20"));
			caixa.setNotas20(caixa.getNotas20() + notas20);
		}
		if (!request.getParameter("notas50").equals("")) {
			int notas50 = Integer.parseInt(request.getParameter("notas50"));
			caixa.setNotas50(caixa.getNotas50() + notas50);
		}
		if (!request.getParameter("notas100").equals("")) {
			int notas100 = Integer.parseInt(request.getParameter("notas100"));
			caixa.setNotas100(caixa.getNotas100() + notas100);
		}
		dao.atualizaCaixa(caixa);
		request.setAttribute("caixa", caixa);
		RequestDispatcher rd = request.getRequestDispatcher("abastecimentoConcluido.jsp");
		rd.forward(request, response);
		response.sendRedirect("abastecimentoConcluido.jsp");
	}

	protected void abastecimento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("caixa", caixa);
		RequestDispatcher rd = request.getRequestDispatcher("abastecimento.jsp");
		rd.forward(request, response);
		response.sendRedirect("abastecimento.jsp");
	}

	protected void saque(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("pessoa", login);
		RequestDispatcher rd = request.getRequestDispatcher("saque.jsp");
		rd.forward(request, response);
		response.sendRedirect("saque.jsp");
	}

	protected void voltar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("pessoa", login);
		RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
		rd.forward(request, response);
		response.sendRedirect("menu.jsp");
	}

	protected void sacar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int saque = Integer.parseInt(request.getParameter("saque"));
		dao.setaCaixa(caixa);
		// System.out.println("saque= " + saque + " Saldo= " + login.getSaldo());
		if (saque > login.getSaldo()) {
			request.setAttribute("pessoa", login);
			RequestDispatcher rd = request.getRequestDispatcher("saqueSaldoInsuficiente.jsp");
			rd.forward(request, response);
			response.sendRedirect("saqueSaldoInsuficiente.jsp");
		} else if (saque > caixa.getTotal()) {
			request.setAttribute("pessoa", login);
			RequestDispatcher rd = request.getRequestDispatcher("TotalCaixaInsuficiente.jsp");
			rd.forward(request, response);
			response.sendRedirect("TotalCaixaInsuficiente.jsp");
		} else {
			int total = caixa.getTotal();
			combinacaoNotas(caixa, saque, login);
			if (total > caixa.getTotal()) {
				// System.out.println(login.getSaldo());
				dao.atualizaCaixa(caixa);
				dao.atualizaSaldo(login);
				request.setAttribute("pessoa", login);
				RequestDispatcher rd = request.getRequestDispatcher("SaqueConcluido.jsp");
				rd.forward(request, response);
				response.sendRedirect("SaqueConcluido.jsp");
			} else {
				request.setAttribute("pessoa", login);
				RequestDispatcher rd = request.getRequestDispatcher("SemCombinacaoNotas.jsp");
				rd.forward(request, response);
				response.sendRedirect("SemCombinacaoNotas.jsp");
			}
		}

	}

	protected void combinacaoNotas(Caixa caixa, int saque, Pessoa pessoa) {
		int valorSaqueaux = saque;
		int liberanotas10 = 0;
		int liberanotas20 = 0;
		int liberanotas50 = 0;
		int liberanotas100 = 0;
		int notas10 = caixa.getNotas10();
		int notas20 = caixa.getNotas20();
		int notas50 = caixa.getNotas50();
		int notas100 = caixa.getNotas100();
		while (saque > 0) {
			if (saque >= 100 && notas100 > 0) {
				liberanotas100++;
				notas100--;
				saque -= 100;
			} else if (saque >= 50 && notas50 > 0) {
				liberanotas50++;
				notas50--;
				saque -= 50;
			} else if (saque >= 20 && notas20 > 0) {
				liberanotas20++;
				notas20--;
				saque -= 20;
			} else if (saque >= 10 && notas10 > 0) {
				liberanotas10++;
				notas10--;
				saque -= 10;
			} else {
				saque = valorSaqueaux;
				break;
			}
		}
		if (saque == 0) {
			caixa.setNotas10(notas10);
			caixa.setNotas20(notas20);
			caixa.setNotas50(notas50);
			caixa.setNotas100(notas100);
			pessoa.setLibera10(liberanotas10);
			pessoa.setLibera20(liberanotas20);
			pessoa.setLibera50(liberanotas50);
			pessoa.setLibera100(liberanotas100);
			pessoa.setSaldo(pessoa.getSaldo() - valorSaqueaux);
		}
		caixa.setTotal();
		saque = valorSaqueaux;
	}

	protected void sair(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		login = new Pessoa();
		response.sendRedirect("index.html");
	}
}
