jQuery(document).ready(function() {  
    $('.btnEditar').click(function(){
       $('.btnCancelar:visible').trigger('click');
       
       $(this).hide();
       
       $(this).parent().find('.btnSalvar').show();
       $(this).parent().find('.btnCancelar').show();
       $(this).parent().find('.btnExcluir').hide();
       
       var txtNome = $(this).parents('tr').find('.txt-nome');
       txtNome.removeClass('no-border');
       txtNome.removeClass('no-background');
       txtNome.attr('readonly', false);
       
    });
    
    $('.btnCancelar').click(function(){
       $(this).hide();
       $(this).parent().find('.btnSalvar').hide();
       $(this).parent().find('.btnEditar').show();
       $(this).parent().find('.btnExcluir').show();
       
       var txtNome = $(this).parents('tr').find('.txt-nome');
       txtNome.addClass('no-border');
       txtNome.addClass('no-background');
       txtNome.attr('readonly', true);
    });
});
