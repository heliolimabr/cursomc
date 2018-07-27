
package com.heliolima.cursomc.services;


import com.heliolima.cursomc.domain.Categoria;
import com.heliolima.cursomc.domain.Cliente;
import com.heliolima.cursomc.domain.ItemPedido;
import com.heliolima.cursomc.domain.PagamentoComBoleto;
import com.heliolima.cursomc.domain.Pedido;
import com.heliolima.cursomc.domain.enums.EstadoPagamento;
import com.heliolima.cursomc.repositories.ItemPedidoRepository;
import com.heliolima.cursomc.repositories.PagamentoRepository;
import com.heliolima.cursomc.repositories.PedidoRepository;
import com.heliolima.cursomc.security.UserSS;
import com.heliolima.cursomc.services.exceptions.AuthorizationException;
import com.heliolima.cursomc.services.exceptions.ObjectNotFoundException;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Helio Lima
 */
@Repository
public class PedidoService {

    @Autowired
    private PedidoRepository repo;
    
    @Autowired
    private BoletoService boletoService;
    
    @Autowired
    private PagamentoRepository pagamentoRepository;
    
    @Autowired
    private ProdutoService produtoService;
    
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;
    
    @Autowired
    private ClienteService clienteService;
    
    @Autowired
    private EmailService emailService;
    
    @Autowired
    private Environment env;
    
    public Pedido find(Integer id){
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não "
                + "encontrado! Id: " + id + ", Tipo: " + 
                Pedido.class.getName())
        );
    }
    
    @Transactional
    public Pedido insert(Pedido obj){
        obj.setId(null);
        obj.setInstante(new Date());
        obj.setCliente(clienteService.find(obj.getCliente().getId()));
        obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
        obj.getPagamento().setPedido(obj);
        if(obj.getPagamento() instanceof PagamentoComBoleto){
            PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
            boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
        }
        obj = repo.save(obj);
        pagamentoRepository.save(obj.getPagamento());
        
        for (ItemPedido ip : obj.getItens()) {
            ip.setDesconto(0.0);
            ip.setProduto(produtoService.find(ip.getProduto().getId()));
            ip.setPreco(ip.getProduto().getPreco());
            ip.setPedido(obj);
        }
        
        itemPedidoRepository.saveAll(obj.getItens());
        if(Arrays.asList(env.getActiveProfiles()).contains("test"))
            emailService.sendOrderConfirmationEmail(obj);
        else
            emailService.sendOrderConfirmationHtmlEmail(obj);
        return obj;
    }
    
    public Page<Pedido> findPage(Integer page, Integer linesPerPage, String orderBy, String direction)
    {
        UserSS user = UserService.authenticated();
        if(user == null)
            throw new AuthorizationException("Acesso negado");
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        Cliente cliente = clienteService.find(user.getId());
        
        return repo.findByCliente(cliente, pageRequest);
    }
}
