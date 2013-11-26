package br.mackenzie.dvdstore.managedbean;

import br.mackenzie.dvdstore.services.PessoaService;
import br.mackenzie.dvdstore.entity.PessoaVO;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@RequestScoped
public class PessoaManagedBean extends ManagedBeanDefault{
    @EJB
    private PessoaService bean;
    @Getter @Setter
    private PessoaVO pessoa;
    
    public PessoaManagedBean() {
        pessoa = new PessoaVO();
    }
    
    @Transactional
    public void cadastrar(){
        List<PessoaVO> list = bean.consultarLogin(pessoa.getEmail());
        if (list!=null && !list.isEmpty()){
            addErrorMessage("Esse e-mail já existe em nossa base de dados");
            return;
        }
        bean.inserir(pessoa);
        addSucessMessage("Cadastro realizado com sucesso.");
    }
}