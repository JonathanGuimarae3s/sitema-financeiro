package com.algaworks.cursojsf2.financeiro.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.algaworks.cursojsf2.financeiro.util.FacesUtil;

@ManagedBean
public class SegurancaBean implements Serializable {
	private String usuario;
	private String senha;

	public String logar() {

		try {
			this.getRequest().login(this.usuario, this.senha);
			return "Home?faces-redirect=true";
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO,
					FacesUtil.getMensagemI18n("username_password_does_not_match"));
			return null;
		}
	}

	public String sair() throws ServletException {

		this.getRequest().logout();
		return "Login?faces-redirect=true";

	}

	private HttpServletRequest getRequest() {
		FacesContext context = FacesContext.getCurrentInstance();
		return (HttpServletRequest) context.getExternalContext().getRequest();

	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
