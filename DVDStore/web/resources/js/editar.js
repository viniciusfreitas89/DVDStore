jQuery(document).ready(function() {  
    $('.btnEditar').click(function(){
       $(this).hide();
       $('.btnSalvar').hide();
       $('.btnCancelar').hide();
       $(this).parent().find('.btnSalvar').show();
       $(this).parent().find('.btnCancelar').show();
       $(this).parent().find('.btnExcluir').hide();
    });
    
    $('.btnCancelar').click(function(){
       $(this).hide();
       $('.btnSalvar').hide();
       $(this).parent().find('.btnEditar').show();
       $(this).parent().find('.btnExcluir').show();
    });
});
