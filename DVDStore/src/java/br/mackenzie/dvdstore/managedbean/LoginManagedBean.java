package br.mackenzie.dvdstore.managedbean;

import br.mackenzie.dvdstore.services.PessoaService;
import br.mackenzie.dvdstore.entity.PessoaVO;
import java.util.List;
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
        List<PessoaVO> list = bean.consultarLogin(username, password);
        if (list==null || list.isEmpty()){
           addSucessMessage("Login ou senha incorreto(s).");
           return "";
        }
        pessoa = list.get(0);
        return "cadastroGenero.xhtml";
    }
}
