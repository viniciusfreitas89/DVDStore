package br.mackenzie.dvdstore.managedbean;

import br.mackenzie.dvdstore.services.PessoaService;
import br.mackenzie.dvdstore.vo.PessoaVO;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@SessionScoped
public class LoginManagedBean extends ManagedBeanDefault{
    @EJB
    private PessoaService bean;
    @Getter @Setter
    private PessoaVO pessoa;
    
    @Getter @Setter
    private String username;
    @Getter @Setter
    private String password;
    
    public LoginManagedBean() {
        pessoa = new PessoaVO();
    }
    
    @Transactional
    public String doLogin(){
//        bean.inserir(pessoa);
//        addSucessMessage("Cadastro realizado com sucesso.");
        return "index.xhtml";
    }
}
